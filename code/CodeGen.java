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
import error.MsgErros;


public final class CodeGen extends ASTBaseVisitor<Integer> {

	private final Instruction code[]; // Code memory
	private final IdTable it;
    private final ArrayTable at;
	private final StrTable st;
    private final FuncTable ft;
    private final ProcTable pt;
	private OpCode BOTb;

	// Contadores para geração de código.
	// Próxima posição na memória de código para emit.
	private static int nextInstr;
	// Número de registradores temporários já utilizados.
	// Usamos um valor arbitrário, mas depois seria necessário
	// fazer o processo de alocação de registradores. Isto está
	// fora do escopo da disciplina.
	private static int tempRegisterCount;
	private static int floatRegisterCount;

	private static int saveRegisterCount;

	public CodeGen(IdTable it, ArrayTable at,StrTable st,FuncTable ft, ProcTable pt) {
		this.code = new Instruction[INSTR_MEM_SIZE];
		this.it = it;
		this.at = at;
		this.st = st;
		this.ft = ft;
		this.pt = pt;
	}

	// Função principal para geração de código.
	@Override
	public void execute(AST root) {
		nextInstr = 0;
		intRegsCount = 0;
		floatRegsCount = 0;
	    dumpStrTable();
	    visit(root);
	    emit(OpCode.HALT);
	    dumpProgram();
	}

	// ----------------------------------------------------------------------------
	// Prints ---------------------------------------------------------------------

	void dumpProgram() {
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

	private void emit(OpCode op, int o1, int o2, int o3) {
		emit(op, o1, o2, o3, "");
	}


	// private void backpatchJump(int instrAddr, int jumpAddr) {
	//     code[instrAddr].o1 = jumpAddr;
	// }

	// private void backpatchBranch(int instrAddr, int offset) {
	//     code[instrAddr].o2 = offset;
	// }


	private int newTempRegister() {
		return tempRegisterCount++;
	}

	private int newIntReg() {
		return intRegsCount++;
	}

	private int adressToArrayLine(int line){

        String arrayName = at.getName(line);

		//carrega o endereço da variavel
		int addr_base = newIntReg();
		emit(OpCode.LA,addr_base,arrayName);

		return addr_base;
	}

	private int atualizaAddrBaseToPosition(int register_addr_base, int position){
		//calcula o offset do endereço
		int register_int = newIntReg();
		emit(OpCode.LDIi,register_int,4);

		int register_position = newIntReg();
		emit(OpCode.LDIi,register_position,position);

		emit(OpCode.MULi,register_position,register_position,register_int);
		
		//soma com o registrador base
		emit(OpCode.ADDi,register_addr_base,register_addr_base,register_position);

		//libera registradores 
		intRegsCount -=2;

		return register_addr_base;
	}

	private int adressToIdLine(int line){

        String var_name = it.getName(line);

		//carrega o endereço da variavel
		int addr_base = newIntReg();
		emit(OpCode.LA,addr_base,var_name);

		return addr_base;
	}

	private int adressToStringLine(int line){

        String string_name = "_" + Integer.toString(line);

		//carrega o endereço da variavel
		int addr_base = newIntReg();
		emit(OpCode.LA,addr_base,string_name);

		return addr_base;
	}

	

	@Override
	protected Integer visit_I2R_node(AST node){
		int register = newFloatReg();
        int register_int = visit(node.getChild(0));
		emit(OpCode.WIDf,register,register_int);
		intRegsCount --;
		return register;
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
            int position = visit(node.getChild(0).getChild(0));

			register_addr_base = atualizaAddrBaseToPosition(register_addr_base,position);
			
			if(node.getChild(0).type == Type.REAL) {
				emit(OpCode.STWf, register_addr_base,register_expr);	
				//libera registradores
				floatRegsCount --; //expr
				intRegsCount --;   //endereço       
			} else {
				emit(OpCode.STWi, register_addr_base,register_expr);	
				//libera registradores
				intRegsCount -=2;   //endereço  e expr  
            }
			
		}else if (node.getChild(0).kind == NodeKind.VAR_USE_NODE){
			
			//linha que a variável esta declarada na tabela de id
			int line = node.getChild(0).intData;
			int register_addr_base = adressToIdLine(line);
			
    			
			if(node.getChild(0).type == Type.REAL) {
				emit(OpCode.STWf, register_addr_base,register_expr);
				//libera registradores
				floatRegsCount --; //expr
				intRegsCount --;   //endereço  
			} else{
				emit(OpCode.STWi, register_addr_base,register_expr);
				//libera registradores
				intRegsCount -=2;   //endereço  e expr  
			}
		}
	    return -1; // This is not an expression, hence no value to return.
	}

	@Override
	protected Integer visit_var_use_node(AST node){

		int line = node.intData;
		adressToIdLine(line);

		return null;
	}


	// TODO
	@Override
	protected Void visit_var_use_array_node(AST node){
		
		

		return null;
	}

	//PILHA:	
	//valor da memoria nessa posição
	//indice no array na tabela
	//exp - indice

	// TODO
	@Override
	protected Void visit_access_array_use_node(AST node){
		
		return null;
	}

	// TODO
	@Override
	protected Void visit_not_equal_node(AST node){
		

		return null;
	}

	// TODO
	@Override
	protected Void visit_equal_node(AST node){
		
		return null;
	}

	// TODO
	@Override
	protected Integer visit_less_than_node(AST node){
		int regResult = newIntReg();
		int regExpr0 = visit(node.getChild(0));
		int regExpr1 = visit(node.getChild(1));

		if(node.type == Type.STRING) {
			
		} else if(node.type == Type.REAL) {
			emit(OpCode.CLTS, regExpr0, regExpr1);
			emit(OpCode.MOVf, regResult, "$fcsr");

		} else if(node.type == Type.INTEGER) {
			emit(OpCode.SLT, regResult, regExpr0, regExpr1);
			return regResult;
			
		} else if(node.type == Type.BOOLEAN) {
			emit(OpCode.SLT, regResult, regExpr0, regExpr1);
			return regResult;
		}
		
		return null;
	}

	// TODO
	@Override
	protected Void visit_greater_than_node(AST node){
		
		return null;
	}

	// TODO
	@Override
	protected Void visit_LEQ_node(AST node){
		
		return null;
	}

	// TODO
	@Override
	protected Void visit_BEQ_node(AST node){
		
		return null;
	}

	// TODO
	@Override
	protected Void visit_block_node(AST node){
		
		return null;
	}

	// TODO
	@Override
	protected Void visit_bool_val_node(AST node){
		
		return null;
	}

	// TODO
	@Override
	protected Void visit_if_node(AST node){
		
		return null;
	}

	// TODO
	@Override
	protected Void visit_int_val_node(AST node){
		return null;
	}

	// TODO
	@Override
	protected Void visit_plus_node(AST node){
        int reg0 = visit(node.getChild(0));
        int reg1 = visit(node.getChild(1));
        
        if(node.type == Type.INTEGER) {
            int regResult = newIntReg();
            emit(OpCode.ADDi, regResult, reg0, reg1);

        } else if(node.type == Type.REAL) {
            int regResult = newFloatReg();
            emit(OpCode.ADDf, regResult, reg0, reg1);

        } else if(node.type == Type.BOOLEAN) {
            int regResult = newIntReg();
            emit(OpCode.ADDi, regResult, reg0, reg1);
            
        } else if(node.type == Type.STRING) {
            
        }
        
        
        int resultReg = newIntReg();

		return null;
	}

	// TODO
	@Override
	protected Void visit_minus_node(AST node){

		int reg0 = visit(node.getChild(0)); //expr
		int reg1 = visit(node.getChild(1)); //expr
     
		if(node.type == Type.INTEGER) {
            int regResult = newIntReg();
            emit(OpCode.SUBi, regResult, reg0, reg1);
        }else if(node.type == Type.REAL) {
            int regResult = newFloatReg();
            emit(OpCode.SUBf, regResult, reg0, reg1);
        }
		
		return -1;
	}

	// TODO
	@Override
	protected Void visit_asterisk_node(AST node){

        int reg0 = visit(node.getChild(0)); //expr
		int reg1 = visit(node.getChild(1)); //expr
     
		if(node.type == Type.INTEGER) {
            int regResult = newIntReg();
            emit(OpCode.MULi, regResult, reg0, reg1);
        }else if(node.type == Type.REAL) {
            int regResult = newFloatReg();
            emit(OpCode.MULf, regResult, reg0, reg1);
        }
		
		return -1;
	}

	// TODO
	@Override
	protected Void visit_slash_node(AST node){
		int reg0 = visit(node.getChild(0)); //expr
		int reg1 = visit(node.getChild(1)); //expr
     
		if(node.type == Type.INTEGER) {
            int regResult = newIntReg();
            emit(OpCode.DIVi, regResult, reg0, reg1);
        }else if(node.type == Type.REAL) {
            int regResult = newFloatReg();
            emit(OpCode.DIVf, regResult, reg0, reg1);
        }
		
		return -1;
	}

	// TODO
	@Override
	protected Void visit_mod_node(AST node){
		
		return null;
	}

	// TODO
	@Override
	protected Void visit_one_minus_node(AST node){
		
		return null;
	}

	// TODO
	@Override
	protected Void visit_program_node(AST node){
	
		return null;
	}

	// TODO
	@Override
	protected Void visit_var_list_node(AST node){
		
		
		return null;
	}

	// TODO
	@Override
	protected Void visit_read_node(AST node) {
		
		return null;
	}

	// TODO
	@Override
	protected Void visit_write_node(AST node){
		int register_value = visit(node.getChild(0));
	
		if(node.getChild(0).type == Type.INT_TYPE) {
			emit(CALL, 1 ,register_value); //1 : Write Integer
			return -1;

		} else if(node.getChild(0).type == Type.REAL_TYPE) {
			emit(CALL, 2 ,register_value); //2: Write Real
			return -1;

		} else if(node.getChild(0).type == Type.BOOL_TYPE) {
			emit(CALL, 1 ,register_value); //1 : Write Integer
			return -1;

		} else if(node.getChild(0).type == Type.STR_TYPE) {
			emit(CALL, 4,register_value);  //  4   Write String
			return -1;
		}
		
		return -1;
	}

	// TODO
	@Override
	protected Void visit_writeln_node(AST node){
        int register_value = visit(node.getChild(0));
        String new_line = "\n" ;
        //fazer registrador de nova linha

		if(node.getChild(0).type == Type.INT_TYPE) {
			emit(CALL, 1 ,register_value); //1 : Write Integer
			return -1;

		} else if(node.getChild(0).type == Type.REAL_TYPE) {
			emit(CALL, 2 ,register_value); //2: Write Real
			return -1;

		} else if(node.getChild(0).type == Type.BOOL_TYPE) {
			emit(CALL, 1 ,register_value); //1 : Write Integer
			return -1;

		} else if(node.getChild(0).type == Type.STR_TYPE) {
			emit(CALL, 4,register_value);  //  4   Write String
			return -1;
		}
		emit(CALL, 4, "\n");
		return -1;
	}

	// TODO
	@Override
	protected Void visit_real_val_node(AST node){
		
		return null;
	}

	// TODO
	@Override	
	protected Void visit_while_node(AST node){
		
		return null;
	}
		
	// TODO
	@Override	
	protected Void visit_str_val_node(AST node){
		
		return null;
	}
		
	// TODO
	@Override	
	protected Void visit_var_decl_node(AST node){
		
		return null;
	}

	// TODO
	@Override	
	protected Void visit_not_node(AST node){
		
		return null;
	}
		
	// TODO
	@Override	
	protected Void visit_and_node(AST node){
		
		
		return null;
	}
		
	// TODO
	@Override	
	protected Void visit_or_node(AST node){
		
		return null;
	}
		
	// TODO
	@Override	
	protected Void visit_provisory_node(AST node){
		// Nothing to do.
		return null;
	}
		
	// TODO
	@Override	
	protected Void visit_array_parameter_node(AST node){
		// Nothing to do.
		return null;
	}
		
	// TODO
	@Override	
	protected Void visit_var_pararameter_node(AST node){
		// Nothing to do.
		return null;
	}
		
	// TODO
	@Override	
	protected Void visit_parameters_node(AST node){
		// Nothing to do.
		return null;
	}

	private Void initiliaze_memory_function_procedure(AST node){
		
		return null;
	}
		
	// TODO
	@Override	
	protected Void visit_function_node(AST node){
		
		return null;
	}
		
	// TODO
	@Override	
	protected Void visit_procedure_node(AST node){
		
		

		return null;
	}
		
	// TODO
	@Override	
	protected Void visit_call_procedure_node(AST node){		

		
		return null;
	}
		
	// TODO
	@Override	
	protected Void visit_call_function_node(AST node){
		return null;
	}
		
	// TODO
	@Override	
	protected Void visit_array_decl_node(AST node){
		// Nothing to do.
		return null;
	}

	// Funções auxiliares para implementar visit_write_node e visit_writeln_node

	private Void writeInt() {

		return null;
	}

	private Void writeReal() {

		return null;
	}

	private Void writeBool() {
		
		return null;
	}

	private Void writeStr() {
		
		return null;
	}

}