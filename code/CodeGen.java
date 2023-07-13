package code;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.Scanner;

import static code.Instruction.INSTR_MEM_SIZE;
import ast.AST;
import ast.ASTBaseVisitor;
import ast.NodeKind;
import tables.ArrayTable;
import tables.FuncTable;
import tables.IdTable;
import tables.ProcTable;
import tables.StrTable;
import types.Type;
import types.TypeData;
import error.MsgErros;
import registers.Registers;
import registers.TypeRegister;
import tables.DataTable;


public final class CodeGen extends ASTBaseVisitor<Integer> {

	private final Instruction code[]; // Code memory
	private final DataTable data;
	private final IdTable it;
    private final ArrayTable at;
	private final StrTable st;
    private final FuncTable ft;
    private final ProcTable pt;
	private final Registers registers;

	private static int nextInstr;


	public CodeGen(IdTable it, ArrayTable at,StrTable st,FuncTable ft, ProcTable pt) {
		
		this.code = new Instruction[INSTR_MEM_SIZE];
		this.data = new DataTable();
		this.it = it;
		this.at = at;
		this.st = st;
		this.ft = ft;
		this.pt = pt;
		registers = new Registers();
	}

	// Função principal para geração de código.
	@Override
	public void execute(AST root) {
		nextInstr = 0;
	    //dumpStrTable();
	    visit(root);
	    emit(OpCode.HALT);
	    dumpProgram();
	}

	// ----------------------------------------------------------------------------
	// Prints ---------------------------------------------------------------------

	void dumpProgram() {
		//.data
		System.out.printf(data.toString());
		//.text
		System.out.printf(".text\n");
		//.globl main
		System.out.printf(".globl main\n\n");
		//instruction
	    for (int addr = 0; addr < nextInstr; addr++) {
	    	System.out.printf("%s\n", code[addr].toString());
	    }
	}

	void dumpStrTable() {
	    for (int i = 0; i < st.size(); i++) {
	        System.out.printf("SSTR %s\n", st.get(i));
	    }
	}

	// ----------------------------------------------------------------------------
	// Emits ----------------------------------------------------------------------

	private void emit(OpCode op, int o1, int o2, int o3, String name) {
		Instruction instr = new Instruction(op, o1, o2, o3, name);
		// Em um código para o produção deveria haver uma verificação aqui...
	    code[nextInstr] = instr;
	    nextInstr++;
	}

	private void emit(String label) {
		emit(null, 0, 0, 0, label);
	}

	private void emit(OpCode op) {
		emit(op, 0, 0, 0, "");
	}

	private void emit(OpCode op, String name) {
		emit(op, 0, 0, 0,name);
	}

	private void emit(OpCode op, int o1) {
		emit(op, o1, 0, 0, "");
	}

	private void emit(OpCode op, int o1, String name) {
		emit(op, o1, 0, 0, name);
	}

	private void emit(OpCode op, int o1, int o2) {
		emit(op, o1, o2, 0, "");
	}

	private void emit(OpCode op, int o1, int o2, String name) {
		emit(op, o1, o2, 0, name);

	}

	private void emit(OpCode op, int o1, int o2, int o3) {
		emit(op, o1, o2, o3, "");
	}

	private int adressToArrayLine(int line){

        String arrayName = at.getName(line);

		//carrega o endereço da variavel
		int register_addr = registers.alocTypeRegister(TypeRegister.t);
		emit(OpCode.LA,register_addr,arrayName);

		return register_addr;
	}

	private void updateAddrBaseToPosition(int register_addr_base, int register_position){
		
		//calcula o offset do endereço
		int register_int = registers.alocTypeRegister(TypeRegister.t);
		emit(OpCode.LDIi,register_int,4);

		emit(OpCode.MULi,register_position,register_position,register_int);

		//desaloca o register_int 
		registers.freeTypeRegister(TypeRegister.t);
		
		//soma com o registrador base
		emit(OpCode.ADDi,register_addr_base,register_addr_base,register_position);
	}

	private int adressToIdLine(int line){

        String var_name = it.getName(line);

		//carrega o endereço da variavel
		int addr_base = registers.alocTypeRegister(TypeRegister.t);
		emit(OpCode.LA,addr_base,var_name);

		return addr_base;
	}

	@Override
	protected Integer visit_I2R_node(AST node){

		//valor int no registrador(t)
		int register_int = visit(node.getChild(0));

		//move o valor de um registrador int(t) para um float no cop1
		int float_register = registers.alocTypeRegister(TypeRegister.f);
		emit(OpCode.MCP,register_int,float_register);
		
		registers.freeTypeRegister(TypeRegister.t);

		emit(OpCode.WIDf,float_register,float_register);

		return float_register;
	}

	@Override
	protected Integer visit_assign_node(AST node){
	
        int register_expr = visit(node.getChild(1)); // expr                                       	
        
		if(node.getChild(0).kind == NodeKind.ACCESS_ARRAY_USE_NODE) {
			//linha que o array esta declarado na tabela de arrays
			int line = node.getChild(0).intData;

			//carrega o endereço base do array							 
			int register_addr_base = adressToArrayLine(line);							
            
			//expressão de acesso a posição do array
            int register_position = visit(node.getChild(0).getChild(0));  			

			updateAddrBaseToPosition(register_addr_base,register_position);

			//desaloca register_position
			registers.freeTypeRegister(TypeRegister.t);
			
			if(node.getChild(0).type == Type.REAL) {
				emit(OpCode.STWf, register_addr_base,register_expr);	
				//libera registradores
				registers.freeTypeRegister(TypeRegister.f); //expr
				registers.freeTypeRegister(TypeRegister.t);   //endereço       
			} else {
				emit(OpCode.STWi, register_addr_base,register_expr);	
				//libera registradores
				registers.freeTypeRegister(TypeRegister.t); //expr
				registers.freeTypeRegister(TypeRegister.t);   //endereço 
            }
			
		}else if (node.getChild(0).kind == NodeKind.VAR_USE_NODE){
			
			//linha que a variável esta declarada na tabela de id
			int line = node.getChild(0).intData;
			int register_addr_base = adressToIdLine(line);						
    			
			if(node.getChild(0).type == Type.REAL) {
				emit(OpCode.STWf, register_addr_base,register_expr);
				//libera registradores
				registers.freeTypeRegister(TypeRegister.f); //expr
				registers.freeTypeRegister(TypeRegister.t);   //endereço    
			} else{
				emit(OpCode.STWi, register_addr_base,register_expr);
				//libera registradores
				registers.freeTypeRegister(TypeRegister.t); //expr
				registers.freeTypeRegister(TypeRegister.t);   //endereço 
			}
		}
	    return -1; // This is not an expression, hence no value to return.
	}

	@Override
	protected Integer visit_var_use_node(AST node){

		int line = node.intData;
		Type type = node.type;
		int register_value = -1;

		if(type == Type.INTEGER){
			register_value = registers.alocTypeRegister(TypeRegister.t); 
			int register_addr = adressToIdLine(line);
			emit(OpCode.LDWi,register_value,register_addr);

		}else if(type == Type.REAL){
			register_value = registers.alocTypeRegister(TypeRegister.f); 
			int register_addr = adressToIdLine(line);
			emit(OpCode.LDWf,register_value,register_addr);

		}else if(type == Type.BOOLEAN){
			register_value = registers.alocTypeRegister(TypeRegister.t); 
			int register_addr = adressToIdLine(line);
			emit(OpCode.LDWi,register_value,register_addr);

		}else if(type == Type.STRING){
			register_value = registers.alocTypeRegister(TypeRegister.t); 
			int register_addr = adressToIdLine(line);
			//aqui o valor recebido é o endereço da string na memoria
			emit(OpCode.LDWi,register_value,register_addr);
		}

		//desaloca o de addr
		registers.freeTypeRegister(TypeRegister.t);

		return register_value;
	}

	@Override
	protected Integer visit_var_use_array_node(AST node){

		//retorna o addr da base do array na memoria
		return adressToArrayLine(node.intData);
	}

	@Override
	protected Integer visit_access_array_use_node(AST node){

		//expr de acesso do array
		int register_addr = adressToArrayLine(node.intData);
		int register_position = visit(node.getChild(0));
		updateAddrBaseToPosition(register_addr, register_position);
		
		//desaloca o register de posição do array
		registers.freeTypeRegister(TypeRegister.t);
			
		return register_addr;
	}

	@Override
	protected Integer visit_not_equal_node(AST node){
		int regResult = registers.alocTypeRegister(TypeRegister.t);
		int regExpr0 = visit(node.getChild(0));
		int regExpr1 = visit(node.getChild(1));

		int regChar0 = registers.alocTypeRegister(TypeRegister.t);
		int regChar1 = registers.alocTypeRegister(TypeRegister.t);

		int regComp = registers.alocTypeRegister(TypeRegister.t);

		if(node.type == Type.STRING) {
			emit("compare_not_eq_loop");
			emit(OpCode.LB, regChar0, regExpr0); // deve ter parênteses no toSring no segundo operando
			emit(OpCode.LB, regChar1, regExpr1); // deve ter parênteses no toSring no segundo operando
			emit(OpCode.BEQZ, regChar0, "not_eq_check_eq"); // Se chegou ao final da primeira string, verifica igualdade
			emit(OpCode.BNE, regChar0, regChar1, "not_eq_not_equal"); // Se os caracteres forem diferentes, as strings não são iguais

			emit(OpCode.ADDiu, regChar0, regChar0, "1"); // Avança para o próximo caractere da primeira string
			emit(OpCode.ADDiu, regChar1, regChar1, "1"); // Avança para o próximo caractere da segunda string
			emit(OpCode.J, "compare_not_eq_loop");

			emit("not_eq_check_eq"); // é menor, true
			emit(OpCode.BEQZ, regChar1, "not_equal_str_equal"); // Se chegou ao final da segunda string, as strings são iguais
			emit(OpCode.J, "not_eq_not_equal"); // Se a primeira string terminou antes da segunda, as strings são diferentes

			emit("not_equal_str_equal");
			emit(OpCode.LDIi, regResult, "0");
			emit(OpCode.J, "end_compare_not_eq");
			
			emit("not_eq_not_equal");
			emit(OpCode.LDIi, regResult, "1");
			emit(OpCode.J, "end_compare_not_eq");
			emit("end_compare_not_eq");

		} else if(node.type == Type.REAL) {
			emit(OpCode.CEQS, regExpr0, regExpr1);
			emit(OpCode.BC1T, "not_equal_eq_floats");
			emit(OpCode.LDIi, regResult, "0");
			emit(OpCode.J, "end_compare_not_equal_floats");
			emit("not_equal_eq_floats");
			emit(OpCode.LDIi, regResult, "1");
			emit("end_compare_not_equal_floats");

		} else if(node.type == Type.INTEGER) {
			emit(OpCode.SEQ, regResult, regExpr0, regExpr1);
			
		} else if(node.type == Type.BOOLEAN) {
			emit(OpCode.SEQ, regResult, regExpr0, regExpr1);
		}
		
		registers.freeTypeRegister(TypeRegister.t);
		registers.freeTypeRegister(TypeRegister.t);
		registers.freeTypeRegister(TypeRegister.t);
		registers.freeTypeRegister(TypeRegister.t);
		registers.freeTypeRegister(TypeRegister.t);
		return regResult;


	}


	@Override
	protected Integer visit_equal_node(AST node){
		int regResult = registers.alocTypeRegister(TypeRegister.t);
		int regExpr0 = visit(node.getChild(0));
		int regExpr1 = visit(node.getChild(1));

		int regChar0 = registers.alocTypeRegister(TypeRegister.t);
		int regChar1 = registers.alocTypeRegister(TypeRegister.t);

		int regComp = registers.alocTypeRegister(TypeRegister.t);

		if(node.type == Type.STRING) {
			emit("compare_eq_loop");
			emit(OpCode.LB, regChar0, regExpr0); // deve ter parênteses no toSring no segundo operando
			emit(OpCode.LB, regChar1, regExpr1); // deve ter parênteses no toSring no segundo operando
			emit(OpCode.BEQZ, regChar0, "check_eq"); // Se chegou ao final da primeira string, verifica igualdade
			emit(OpCode.BNE, regChar0, regChar1, "not_equal"); // Se os caracteres forem diferentes, as strings não são iguais

			emit(OpCode.ADDiu, regChar0, regChar0, "1"); // Avança para o próximo caractere da primeira string
			emit(OpCode.ADDiu, regChar1, regChar1, "1"); // Avança para o próximo caractere da segunda string
			emit(OpCode.J, "compare_eq_loop");

			emit("check_eq"); // é menor, true
			emit(OpCode.BEQZ, regChar1, "str_equal"); // Se chegou ao final da segunda string, as strings são iguais
			emit(OpCode.J, "not_equal"); // Se a primeira string terminou antes da segunda, as strings são diferentes

			emit("str_equal");
			emit(OpCode.LDIi, regResult, "1");
			emit(OpCode.J, "end_compare_eq");
			
			emit("not_equal");
			emit(OpCode.LDIi, regResult, "0");
			emit(OpCode.J, "end_compare_eq");
			emit("end_compare_eq");

		} else if(node.type == Type.REAL) {
			emit(OpCode.CEQS, regExpr0, regExpr1);
			emit(OpCode.BC1T, "eq_floats");
			emit(OpCode.LDIi, regResult, "0");
			emit(OpCode.J, "end_compare_floats");
			emit("eq_floats");
			emit(OpCode.LDIi, regResult, "1");
			emit("end_compare_floats");

		} else if(node.type == Type.INTEGER) {
			emit(OpCode.SEQ, regResult, regExpr0, regExpr1);
			
		} else if(node.type == Type.BOOLEAN) {
			emit(OpCode.SEQ, regResult, regExpr0, regExpr1);
		}
		
		registers.freeTypeRegister(TypeRegister.t);
		registers.freeTypeRegister(TypeRegister.t);
		registers.freeTypeRegister(TypeRegister.t);
		registers.freeTypeRegister(TypeRegister.t);
		registers.freeTypeRegister(TypeRegister.t);
		return regResult;
	}

	@Override
	protected Integer visit_less_than_node(AST node){
		int regResult = registers.alocTypeRegister(TypeRegister.t);
		int regExpr0 = visit(node.getChild(0));
		int regExpr1 = visit(node.getChild(1));

		int regChar0 = registers.alocTypeRegister(TypeRegister.t);
		int regChar1 = registers.alocTypeRegister(TypeRegister.t);

		int regComp = registers.alocTypeRegister(TypeRegister.t);

		if(node.type == Type.STRING) {
			emit("compare_lt_loop");
			emit(OpCode.LB, regChar0, regExpr0); // deve ter parênteses no toSring no segundo operando
			emit(OpCode.LB, regChar1, regExpr1); // deve ter parênteses no toSring no segundo operando
			emit(OpCode.BEQZ, regChar0, "str0_smaller"); // Se chegou ao final da primeira string, a primeira é menor
			emit(OpCode.BEQZ, regChar1, "end_compare_lt_str"); // Se chegou ao final da segunda string, finaliza a comparação
			emit(OpCode.SLT, regComp, regChar0, regChar1); // Compara os caracteres
			emit(OpCode.BGTZ, regComp, "str0_smaller"); // Se o caractere da primeira string for menor, a primeira é menor
			emit(OpCode.ADDiu, regExpr0, regExpr0, "1"); // Avança para o próximo caractere da primeira string
			emit(OpCode.ADDiu, regExpr1, regExpr1, "1"); // Avança para o próximo caractere da segunda string
			emit(OpCode.J, "compare_lt_loop");
			emit("str0_smaller"); // é menor, true
			emit(OpCode.LDIi, regResult, "1");
			emit(OpCode.J, "end_compare_lt_str");
			emit(OpCode.LDIi, regResult, "0"); // não é menor, false
			emit(OpCode.J, "end_compare_lt_str");
			emit("end_compare_lt_str");
		} else if(node.type == Type.REAL) {
			emit(OpCode.CLTS, regExpr0, regExpr1);
			emit(OpCode.BC1T, "lt_floats");
			emit(OpCode.LDIi, regResult, "0");
			emit(OpCode.J, "end_compare_lt_floats");
			emit("lt_floats");
			emit(OpCode.LDIi, regResult, "1");
			emit("end_compare_lt_floats");

		} else if(node.type == Type.INTEGER) {
			emit(OpCode.SLT, regResult, regExpr0, regExpr1);
			
		} else if(node.type == Type.BOOLEAN) {
			emit(OpCode.SLT, regResult, regExpr0, regExpr1);
		}
		
		registers.freeTypeRegister(TypeRegister.t);
		registers.freeTypeRegister(TypeRegister.t);
		registers.freeTypeRegister(TypeRegister.t);
		registers.freeTypeRegister(TypeRegister.t);
		registers.freeTypeRegister(TypeRegister.t);
		return regResult;
	}

	@Override
	protected Integer visit_greater_than_node(AST node){
		int regResult = registers.alocTypeRegister(TypeRegister.t);
		int regExpr0 = visit(node.getChild(0));
		int regExpr1 = visit(node.getChild(1));

		int regChar0 = registers.alocTypeRegister(TypeRegister.t);
		int regChar1 = registers.alocTypeRegister(TypeRegister.t);

		int regComp = registers.alocTypeRegister(TypeRegister.t);

		if(node.type == Type.STRING) {
			emit("compare_gt_loop");
			emit(OpCode.LB, regChar0, regExpr0); // deve ter parênteses no toSring no segundo operando
			emit(OpCode.LB, regChar1, regExpr1); // deve ter parênteses no toSring no segundo operando
			emit(OpCode.BEQZ, regChar1, "str1_smaller"); // Se chegou ao final da primeira string, a primeira é menor
			emit(OpCode.BEQZ, regChar0, "end_compare_gt_str"); // Se chegou ao final da segunda string, finaliza a comparação
			emit(OpCode.SLT, regComp, regChar1, regChar0); // Compara os caracteres
			emit(OpCode.BGTZ, regComp, "str1_smaller"); // Se o caractere da primeira string for menor, a primeira é menor
			emit(OpCode.ADDiu, regExpr0, regExpr0, "1"); // Avança para o próximo caractere da primeira string
			emit(OpCode.ADDiu, regExpr1, regExpr1, "1"); // Avança para o próximo caractere da segunda string
			emit(OpCode.J, "compare_gt_loop");
			emit("str1_smaller"); // é menor, true
			emit(OpCode.LDIi, regResult, "1");
			emit(OpCode.J, "end_compare_gt_str");
			emit(OpCode.LDIi, regResult, "0"); // não é menor, false
			emit(OpCode.J, "end_compare_gt_str");
			emit("end_compare_gt_str");
			
		} else if(node.type == Type.REAL) {
			emit(OpCode.CLTS, regExpr1, regExpr0);
			emit(OpCode.BC1T, "gt_floats");
			emit(OpCode.LDIi, regResult, "0");
			emit(OpCode.J, "end_compare_gt_floats");
			emit("gt_floats");
			emit(OpCode.LDIi, regResult, "1");
			emit("end_compare_gt_floats");

		} else if(node.type == Type.INTEGER) {
			emit(OpCode.SLT, regResult, regExpr1, regExpr0); // invertendo a desigualdade
			
		} else if(node.type == Type.BOOLEAN) {
			emit(OpCode.SLT, regResult, regExpr1, regExpr0); // invertendo a desigualdade
		}
		
		registers.freeTypeRegister(TypeRegister.t);
		registers.freeTypeRegister(TypeRegister.t);
		registers.freeTypeRegister(TypeRegister.t);
		registers.freeTypeRegister(TypeRegister.t);
		registers.freeTypeRegister(TypeRegister.t);
		return regResult;
	}

	// DOING RIGHT NOW  //LESS OR EQUAL
	@Override
	protected Integer visit_LEQ_node(AST node){
		// int regResult = registers.alocTypeRegister(TypeRegister.t);

		// int regExpr0 = visit(node.getChild(0));
		// int regExpr1 = visit(node.getChild(1));

		// if(node.type == Type.INTEGER || node.type == Type.BOOLEAN) { //INTEGER OR BOOLEAN
		// 	int regComp1 = registers.alocTypeRegister(TypeRegister.t);
		// 	int regComp1 = registers.alocTypeRegister(TypeRegister.t);

		// 	emit(OpCode.SLT, regComp1, regExpr0, regExpr1);
		// 	emit(OpCode.SEQ, regComp2, regExpr0, regExpr1 );
		// 	emit(OpCode.OR, regResult, regComp1, regComp2 );	

		// 	registers.freeTypeRegister(TypeRegister.t);
		// 	registers.freeTypeRegister(TypeRegister.t);
			
		// } else if(node.type == Type.REAL){
		// 	int regComp1 = registers.alocTypeRegister(TypeRegister.f);
		// 	int regComp1 = registers.alocTypeRegister(TypeRegister.f);

		// 	emit(OpCode.SLT, regComp1, regExpr0, regExpr1);
		// 	emit(OpCode.SEQ, regComp2, regExpr0, regExpr1 );
		// 	emit(OpCode.OR, regResult, regComp1, regComp2 );

		// 	registers.freeTypeRegister(TypeRegister.f);
		// 	registers.freeTypeRegister(TypeRegister.f);
			
		// }else if(node.type == Type.STRING){
		// 	emit("compare_leq_loop");
		// 	emit(OpCode.LB, regChar0, regExpr0); // deve ter parênteses no toSring no segundo operando
		// 	emit(OpCode.LB, regChar1, regExpr1); // deve ter parênteses no toSring no segundo operando
		// 	emit(OpCode.BEQZ, regChar0, "str0_smaller"); // Se chegou ao final da primeira string, a primeira é menor
		// 	emit(OpCode.BEQZ, regChar1, "end_compare_lt_str"); // Se chegou ao final da segunda string, finaliza a comparação
		// 	emit(OpCode.SLT, regComp, regChar0, regChar1); // Compara os caracteres
		// 	emit(OpCode.BGTZ, regComp, "str0_smaller"); // Se o caractere da primeira string for menor, a primeira é menor
		// 	emit(OpCode.ADDiu, regExpr0, regExpr0, "1"); // Avança para o próximo caractere da primeira string
		// 	emit(OpCode.ADDiu, regExpr1, regExpr1, "1"); // Avança para o próximo caractere da segunda string
		// 	emit(OpCode.J, "compare_lt_loop");
		// 	emit("str0_smaller"); // é menor, true
		// 	emit(OpCode.LDIi, regResult, "1");
		// 	emit(OpCode.J, "end_compare_lt_str");
		// 	emit(OpCode.LDIi, regResult, "0"); // não é menor, false
		// 	emit(OpCode.J, "end_compare_lt_str");
		// 	emit("end_compare_lt_str");
		// }

		// registers.freeTypeRegister(TypeRegister.t); //expr1
		// registers.freeTypeRegister(TypeRegister.t); //expr0
		// return regResult;
		return -1;
	}

	// TODO
	@Override
	protected Integer visit_BEQ_node(AST node){
		
		return -1;
	}

	@Override
	protected Integer visit_block_node(AST node){
		for (int i = 0; i < node.getChildrenSize(); i++) {
			visit(node.getChild(i));
		}
		return -1;
	}

	@Override
	protected Integer visit_bool_val_node(AST node){

		//retona o valor do bool num registrador
		int register_value = registers.alocTypeRegister(TypeRegister.t);
		emit(OpCode.LDIi,register_value,node.intData);
	
		return register_value;
	}

	@Override
	protected Integer visit_if_node(AST node){
		int regExpr = visit(node.getChild(0));
		int regTrue = registers.alocTypeRegister(TypeRegister.t);
		emit(OpCode.LDIi, regTrue, 1);
		emit(OpCode.BEQ, regExpr, regTrue, "then");

		if(node.getChildrenSize() == 3) { // tem else
			visit(node.getChild(2));
		}
		emit(OpCode.J, "end_if");

		emit("then");
		visit(node.getChild(1));

		emit("end_if");
		return -1;
	}

	@Override
	protected Integer visit_int_val_node(AST node){

		//retona o valor do int num registrador
		int register_value = registers.alocTypeRegister(TypeRegister.t);
		emit(OpCode.LDIi,register_value,node.intData);
	
		return register_value;
	}

	// TODO
	@Override
	protected Integer visit_plus_node(AST node){
        // int reg0 = visit(node.getChild(0));
        // int reg1 = visit(node.getChild(1));
        
        // if(node.type == Type.INTEGER) {
        //     int regResult = newIntReg();
        //     emit(OpCode.ADDi, regResult, reg0, reg1);

        // } else if(node.type == Type.REAL) {
        //     int regResult = newFloatReg();
        //     emit(OpCode.ADDf, regResult, reg0, reg1);

        // } else if(node.type == Type.BOOLEAN) {
        //     int regResult = newIntReg();
        //     emit(OpCode.ADDi, regResult, reg0, reg1);
            
        // } else if(node.type == Type.STRING) {
            
        // }
        
        
        // int resultReg = newIntReg();

		return -1;
	}

	
	@Override  
	protected Integer visit_minus_node(AST node){
		if(node.type == Type.INTEGER) {
			int regResult = registers.alocTypeRegister(TypeRegister.t);
			int reg0 = visit(node.getChild(0)); //expr
			int reg1 = visit(node.getChild(1)); //expr

            emit(OpCode.SUBi, regResult, reg0, reg1);

			registers.freeTypeRegister(TypeRegister.t);
			registers.freeTypeRegister(TypeRegister.t);
			return regResult ;
			
        }else if(node.type == Type.REAL) {
            int regResult = registers.alocTypeRegister(TypeRegister.f);
			int reg0 = visit(node.getChild(0)); //expr
			int reg1 = visit(node.getChild(1)); //expr
			
            emit(OpCode.SUBf, regResult, reg0, reg1);
			
			registers.freeTypeRegister(TypeRegister.t);
			registers.freeTypeRegister(TypeRegister.t);
			return regResult ;
        }

	
		return -1;
	}

	
	@Override
	protected Integer visit_asterisk_node(AST node){
      
     
		if(node.type == Type.INTEGER) {
            int regResult = registers.alocTypeRegister(TypeRegister.t);
			int reg0 = visit(node.getChild(0)); //expr
			int reg1 = visit(node.getChild(1)); //expr

            emit(OpCode.MULi, regResult, reg0, reg1);

			registers.freeTypeRegister(TypeRegister.t);
			registers.freeTypeRegister(TypeRegister.t);
			return regResult ;

        }else if(node.type == Type.REAL) {
            int regResult = registers.alocTypeRegister(TypeRegister.f);
			int reg0 = visit(node.getChild(0)); //expr
			int reg1 = visit(node.getChild(1)); //expr

            emit(OpCode.MULf, regResult, reg0, reg1);
			
			registers.freeTypeRegister(TypeRegister.t);
			registers.freeTypeRegister(TypeRegister.t);
			return regResult ;

        }
		
		return -1;
	}


	@Override
	protected Integer visit_slash_node(AST node){
		if(node.type == Type.INTEGER) {
            int regResult = registers.alocTypeRegister(TypeRegister.t);
			int reg0 = visit(node.getChild(0)); //expr
			int reg1 = visit(node.getChild(1)); //expr

            emit(OpCode.DIVi, regResult, reg0, reg1);

			registers.freeTypeRegister(TypeRegister.t);
			registers.freeTypeRegister(TypeRegister.t);
			return regResult ;

        }else if(node.type == Type.REAL) {
            int regResult = registers.alocTypeRegister(TypeRegister.f);
			int reg0 = visit(node.getChild(0)); //expr
			int reg1 = visit(node.getChild(1)); //expr

            emit(OpCode.DIVf, regResult, reg0, reg1);

			registers.freeTypeRegister(TypeRegister.t);
			registers.freeTypeRegister(TypeRegister.t);
			return regResult ;
        }
		return -1;
	}

	@Override
	protected Integer visit_mod_node(AST node){
		int reg_t = registers.alocTypeRegister(TypeRegister.t);

		int reg0 = visit(node.getChild(1));
		int reg1  = visit(node.getChild(0));

		emit(OpCode.DIVi,reg_t , reg0, reg1);
		emit(OpCode.MFHi, reg_t);

		registers.freeTypeRegister(TypeRegister.t);
		registers.freeTypeRegister(TypeRegister.t);

		return reg_t;
	}

	
	@Override
	protected Integer visit_one_minus_node(AST node){
		if(node.type == Type.INTEGER) {
			int reg0 = visit(node.getChild(0)); //expr
			int minus_one = registers.alocTypeRegister(TypeRegister.t); 

			emit(OpCode.LDIi, minus_one, -1);
            emit(OpCode.MULi, reg0, reg0,  minus_one);

			registers.freeTypeRegister(TypeRegister.t);
			
			return reg0;

        }else if(node.type == Type.REAL) {
			int minus_one = registers.alocTypeRegister(TypeRegister.f);
			int reg0 = visit(node.getChild(0)); //expr

			emit(OpCode.LDIf, minus_one, -1);
            emit(OpCode.MULf, reg0, reg0,  minus_one);

			registers.freeTypeRegister(TypeRegister.f);
			
			return reg0;
        }
		
		return -1;
	}

	@Override
	protected Integer visit_program_node(AST node){
		 
		// 0 var list
		visit(node.getChild(0)); 

		// 1 -  n-2 - functions and procedures - tratar no final
		
		// n-1 - main
		//label main
		emit("main:");
		//visit block main
		visit(node.getChild(node.getChildrenSize()-1));
	
		if(node.getChildrenSize() > 2){
			// tem função
			for(int i=1; i< node.getChildrenSize()-1; i++){
			visit(node.getChild(i));
			}
		}

		return -1;
	}

	@Override
	protected Integer visit_var_list_node(AST node){
		
		// Percorre todas as declarações 
		for(int i = 0; i < node.getChildrenSize(); i++) {
			visit(node.getChild(i));
		}

		return -1;
	}

	@Override
	protected Integer visit_read_node(AST node) {
		Type type = node.getChild(0).type;
		int  addr = node.getChild(0).intData;

		if (type == Type.INTEGER){
			int register = registers.alocTypeRegister(TypeRegister.t);
			emit(OpCode.CALL,5,register);
			emit(OpCode.STWi,addr,register);
			registers.freeTypeRegister(TypeRegister.t);
			return -1; 

		}else if(type == Type.REAL){
			int register = registers.alocTypeRegister(TypeRegister.f);
			emit(OpCode.CALL,6,register);
			emit(OpCode.STWf,addr,register);
			registers.freeTypeRegister(TypeRegister.f);
			return -1; 
			
		}else if(type == Type.STRING){
			int register = registers.alocTypeRegister(TypeRegister.t);
			emit(OpCode.CALL,8,register);
			emit(OpCode.STWi,addr,register);
			registers.freeTypeRegister(TypeRegister.t);
			return -1; 

		}else if(type == Type.BOOLEAN){
			int register = registers.alocTypeRegister(TypeRegister.t);
			emit(OpCode.CALL,5,register);
			emit(OpCode.STWi,addr,register);
			registers.freeTypeRegister(TypeRegister.t);
			return -1; 
		}
	    return -1;  
	}

	@Override
	protected Integer visit_write_node(AST node){
		int register_value = visit(node.getChild(0));
	
		if(node.getChild(0).type == Type.INTEGER) {
			emit(OpCode.CALL, 1 ,register_value); //1 : Write Integer
			registers.freeTypeRegister(TypeRegister.t);
			return -1;

		} else if(node.getChild(0).type == Type.REAL) {
			emit(OpCode.CALL, 2 ,register_value); //2: Write Real
			registers.freeTypeRegister(TypeRegister.t);
			return -1;

		} else if(node.getChild(0).type == Type.BOOLEAN) {
			emit(OpCode.CALL, 1 ,register_value); //1 : Write Integer
			registers.freeTypeRegister(TypeRegister.t);
			return -1;

		} else if(node.getChild(0).type == Type.STRING) {
			emit(OpCode.CALL, 4,register_value);  //  4   Write String
			registers.freeTypeRegister(TypeRegister.t);
			return -1;
		}
		
		return -1;
	}

	@Override
	protected Integer visit_writeln_node(AST node){
		int reg_newline = registers.alocTypeRegister(TypeRegister.t);
		emit(OpCode.LA, reg_newline, "\n"); //reg_newline = "\n"

		int register_value = visit(node.getChild(0));
		
		if(node.getChild(0).type == Type.INTEGER) {
			emit(OpCode.CALL, 1 ,register_value); 			//1 : Write Integer
			
		} else if(node.getChild(0).type == Type.REAL) {
			emit(OpCode.CALL, 2 ,register_value); 			//2: Write Real
		
		} else if(node.getChild(0).type == Type.BOOLEAN) {
			emit(OpCode.CALL, 1 ,register_value); 			//1 : Write Integer
			
		} else if(node.getChild(0).type == Type.STRING) {
			emit(OpCode.CALL, 4,register_value);  			//4 : Write String
		
		}
		
		emit(OpCode.CALL, 4 ,reg_newline); 
		registers.freeTypeRegister(TypeRegister.t);
		registers.freeTypeRegister(TypeRegister.t);
		return -1;
       
	}

	@Override
	protected Integer visit_real_val_node(AST node){
		//retona o valor do bool num registrador
		int register_value = registers.alocTypeRegister(TypeRegister.f);
		emit(OpCode.LDIf,register_value,node.intData);
	
		return register_value;
	}

	// TODO
	@Override	
	protected Integer visit_while_node(AST node){
		
		return -1;
	}
		

	@Override	
	protected Integer visit_str_val_node(AST node){
		//retona o valor do bool num registrador
		int register_value = registers.alocTypeRegister(TypeRegister.t);
		emit(OpCode.LDIi,register_value,node.intData);
	
		return register_value;
	}
		
	@Override	
	protected Integer visit_var_decl_node(AST node){
		Boolean ehConst = it.getConst(node.intData); 
		
		if(node.type == Type.INTEGER || node.type == Type.BOOLEAN){
			if(ehConst){
				//pegar o valor da const
				int value = node.getChild(0).intData;
				data.addData(it.getName(node.intData),TypeData.WORD,Integer.toString(value));
			}else{	
				data.addData(it.getName(node.intData),TypeData.WORD,"0");
			}
		}else if(node.type == Type.REAL) {
			if(ehConst){
				//pegar o valor da const
				float value = node.getChild(0).floatData;
				data.addData(it.getName(node.intData),TypeData.FLOAT,Float.toString(value));
			}else{
				data.addData(it.getName(node.intData),TypeData.FLOAT,"0.0");				
			}
		}else if(node.type == Type.STRING){
			if(ehConst){
				//pegar linha da string na tabela de strings
				int line = node.getChild(0).intData;
				data.addData(it.getName(node.intData),TypeData.ASCIIZ,st.get(line));
			}else{
				//pegar linha da string na tabela de strings
				data.addData(it.getName(node.intData),TypeData.ASCIIZ,"");
			}
		}

		return -1;
	}
	
	@Override	
	protected Integer visit_not_node(AST node){
		int reg0 = visit(node.getChild(0)); 
		
		int reg_t = registers.alocTypeRegister(TypeRegister.t);
		emit(OpCode.LDIi, reg_t, 0); //ZERO

		emit(OpCode.NOR, reg0, reg0, reg_t);

		registers.freeTypeRegister(TypeRegister.t);

		return reg0 ;
	}
		
	
	@Override	
	protected Integer visit_and_node(AST node){
		int reg_bool = registers.alocTypeRegister(TypeRegister.t);

		int reg0 = visit(node.getChild(1)); //rightChild
		int reg1 = visit(node.getChild(0)); //leftChild
		
		emit(OpCode.AND, reg_bool, reg0, reg1);

		registers.freeTypeRegister(TypeRegister.t);
		registers.freeTypeRegister(TypeRegister.t);

		return reg_bool;
	}
		
	
	@Override	
	protected Integer visit_or_node(AST node){
		int reg_bool = registers.alocTypeRegister(TypeRegister.t);

		int reg0 = visit(node.getChild(1)); //rightChild
		int reg1 = visit(node.getChild(0)); //leftChild
		
		emit(OpCode.OR, reg_bool, reg0, reg1);

		registers.freeTypeRegister(TypeRegister.t);
		registers.freeTypeRegister(TypeRegister.t);

		return reg_bool;
	}
	

	@Override	
	protected Integer visit_provisory_node(AST node){
		// Nothing to do.
		return -1;
	}
		
	// TODO
	@Override	
	protected Integer visit_array_parameter_node(AST node){
		// Nothing to do.
		return -1;
	}
		
	// TODO
	@Override	
	protected Integer visit_var_pararameter_node(AST node){
		// Nothing to do.
		return -1;
	}
		
	// TODO
	@Override	
	protected Integer visit_parameters_node(AST node){
		// Nothing to do.
		return -1;
	}
		
	// TODO
	@Override	
	protected Integer visit_function_node(AST node){
		
		return -1;
	}
		
	// TODO
	@Override	
	protected Integer visit_procedure_node(AST node){
		
		

		return -1;
	}
		
	// TODO
	@Override	
	protected Integer visit_call_procedure_node(AST node){		

		
		return -1;
	}
		
	// TODO
	@Override	
	protected Integer visit_call_function_node(AST node){
		return -1;
	}
		
	// TODO
	@Override	
	protected Integer visit_array_decl_node(AST node){
		//tamanho do array
		int size = at.getSize(node.intData) * 4; // tipos primitivos de array possuem 4 bytes
			
		data.addData(at.getName(node.intData),TypeData.SPACE,Integer.toString(size));
		return -1;
	}

}