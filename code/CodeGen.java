package code;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.Scanner;

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

/*
 * Visitador da AST para geração básica de código. Funciona de
 * forma muito similar ao interpretador do laboratório anterior,
 * mas agora estamos trabalhando com um ambiente de execução
 * com código de 3 endereços. Isto quer dizer que não existe mais
 * pilha e todas as operações são realizadas via registradores.
 *
 * Note que não há uma área de memória de dados no código abaixo.
 * Esta área fica agora na TM, que é a "arquitetura" de execução.
 */
public final class CodeGen extends ASTBaseVisitor<Integer> {

	private final Instruction code[]; // Code memory
	private final StrTable st;
	private final IdTable it;
    private final ArrayTable at;
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
	private static int intRegsCount;
	private static int floatRegsCount;

	public CodeGen(StrTable st, VarTable vt) {
		this.code = new Instruction[INSTR_MEM_SIZE];
		this.st = st;
		this.vt = vt;
	}

	// Função principal para geração de código.
	@Override
	public void execute(AST root) {
		nextInstr = 0;
		intRegsCount = 0;
		floatRegsCount = 0;
	    dumpStrTable();
	    visit(root);
	    emit(HALT);
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

	private void emit(OpCode op, int o1, int o2, int o3) {
		Instruction instr = new Instruction(op, o1, o2, o3);
		// Em um código para o produção deveria haver uma verificação aqui...
	    code[nextInstr] = instr;
	    nextInstr++;
	}

	private void emit(OpCode op) {
		emit(op, 0, 0, 0);
	}

	private void emit(OpCode op, int o1) {
		emit(op, o1, 0, 0);
	}

	// private void emit(OpCode op, int o1, int o2) {
	// 	emit(op, o1, o2, 0);
	// }

	// private void backpatchJump(int instrAddr, int jumpAddr) {
	//     code[instrAddr].o1 = jumpAddr;
	// }

	// private void backpatchBranch(int instrAddr, int offset) {
	//     code[instrAddr].o2 = offset;
	// }


	private int newFloatReg() {
		return floatRegsCount++;
	}

    private int newIntReg() {
		return intRegsCount++;
	}

	@Override
	protected Void visit_I2R_node(AST node){
        int register_int = visit(node.getChild(0));
		int register = newFloatReg();
		emit(OpCode.WIDf,register,register_int);
		return register;
	}

	@Override
	protected Void visit_assign_node(AST node){
        int register = visit(node.getChild(1)); // expr
        
        
        
        
        
        int positionMemory;
        
		if(node.getChild(0).kind == NodeKind.ACCESS_ARRAY_USE_NODE) {
			int line = node.getChild(0).intData;
            String arrayName = at.getName(line);

            int regPos = visit(node.getChild(0).getChild(0));

			if(node.getChild(0).type == Type.REAL) {
				emit(OpCode.STWf, regAddres, register);
                
			} else {
				emit(OpCode.STWi, regAddres, register);
            }
			
		}else if (node.getChild(0).kind == NodeKind.VAR_USE_NODE){
			positionMemory = node.getChild(0).intData;
			
			if(node.getChild(0).type == Type.INTEGER) {
				resultInt = currentFrame.popiDataStack();
				currentFrame.storeiDataStackIdMemory(positionMemory, resultInt);
			
			} else if(node.getChild(0).type == Type.REAL) {
				resultFloat = currentFrame.popfDataStack();
				currentFrame.storefDataStackIdMemory(positionMemory, resultFloat);

			} else if(node.getChild(0).type == Type.STRING) {
				resultInt = currentFrame.popiDataStack();
				currentFrame.storeiDataStackIdMemory(positionMemory, resultInt);
				
			}else if(node.getChild(0).type == Type.BOOLEAN) {
				resultInt = currentFrame.popiDataStack();
				currentFrame.storeiDataStackIdMemory(positionMemory, resultInt);
			}
		}
		
	    return -1; // This is not an expression, hence no value to return.

        
		
		
		return null;
	}

	// TODO
	@Override
	protected Void visit_var_use_node(AST node){

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
		
	}

	// TODO
	@Override
	protected Integer visit_equal_node(AST node){
		
		int reg1 = visit(node.getChild(1)); // expr
		int reg2 = visit(node.getChild(0)); // expr

		if(node.getChild(1).type == Type.REAL) {
			int resul_register = newIntReg();
			emit(OpCode.EQUf,resul_register,reg1,reg2 );
			return resul_register;

		}else if(node.getChild(1).type == Type.STRING) {
			int resul_register = newIntReg();
			emit(OpCode.EQUs,resul_register,reg1,reg2);
			return resul_register;

		}else { //BOOLEAN, INT
			int resul_register = newIntReg();
			emit(OpCode.EQUi,resul_register,reg1,reg2);
			return resul_register;
		}
        return -1; 
	}

	@Override
	protected Integer visit_less_than_node(AST node){
		int register1 = visit(node.getChild(0)); // expr0
		int register2 = visit(node.getChild(1)); // expr1

		if(node.getChild(1).type == Type.STRING) {
			int resul_register = newIntReg();
			emit(OpCode.LTHs,resul_register,register1,register2); //see command slt for strings*****
			return resul_register;

		}
		else if(node.getChild(1).type  == Type.REAL) {
			int resul_register = newFloatReg();
			emit(OpCode.SLT,resul_register,register1,register2);
			return resul_register;

		}else { //Integer or Boolena
			int resul_register = newIntReg();
			emit(OpCode.SLT,resul_register,register1,register2);
			return resul_register;
		} 
        return -1;
	}

	// TODO
	@Override
	protected Void visit_greater_than_node(AST node){
		// int register1 = visit(node.getChild(0)); // expr0
		// int register2 = visit(node.getChild(1)); // expr1

		// if(node.getChild(1).type == Type.STRING) {
		// 	int resul_register = newIntReg();
		// 	emit(OpCode.LTHs, resul_register,register1,register2);
		// 	return resul_register;

		// }
		// else if(node.getChild(1).type  == Type.REAL) {
		// 	int resul_register = newIntReg();
		// 	emit(OpCode.LTHf,resul_register,register1,register2);
		// 	return resul_register;

		// }else { //Integer or Boolena
		// 	int resul_register = newIntReg();
		// 	emit(OpCode.LTHi,resul_register,register1,register2);
		// 	return resul_register;
		// } 
        // return -1;
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

	@Override
	protected Integer visit_bool_val_node(AST node){
		int reg_int = newIntReg();
		emit(OpCode.LDIi, reg_int , node.intData);
	    return reg_int;
		
	}

	// TODO
	@Override
	protected Void visit_if_node(AST node){
		
		return null;
	}

	// TODO
	@Override
	protected Integer visit_int_val_node(AST node){
		int reg_int = newIntReg();
		emit(OpCode.LDIi, reg_int , node.intData);
	    return reg_int;
	}

	// TODO
	@Override
	protected Integer visit_plus_node(AST node){
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
	protected Integer visit_minus_node(AST node){

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
	protected Integer visit_asterisk_node(AST node){

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
	protected Integer visit_slash_node(AST node){
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
	
	}

	// TODO
	@Override
	protected Void visit_write_node(AST node){
	
		
	}

	// TODO
	@Override
	protected Void visit_writeln_node(AST node){
        int register_value = visit(node.getChild(0));
        // String new_line = "\n" ;
        //fazer registrador de nova linha

		if(node.getChild(0).type == Type.INT_TYPE) {
			emit(OpCode.CALL, 1 ,register_value); //1 : Write Integer
			return -1;

		} else if(node.getChild(0).type == Type.REAL_TYPE) {
			emit(OpCode.CALL, 2 ,register_value); //2: Write Real
			return -1;

		} else if(node.getChild(0).type == Type.BOOL_TYPE) {
			emit(OpCode.CALL, 1 ,register_value); //1 : Write Integer
			return -1;

		} else if(node.getChild(0).type == Type.STR_TYPE) {
			emit(OpCode.CALL, 4,register_value);  //  4   Write String
			return -1;
		}
		// emit(CALL, 4, reg_new_line);
		return -1;
	}

	
	@Override
	protected Integer visit_real_val_node(AST node){
		int reg_float = newFloatReg();
		emit(OpCode.LDIf, reg_float , node.floatData);
	    return reg_float;
	}

	// TODO
	@Override	
	protected Void visit_while_node(AST node){
		
		return null;
	}
		
	// TODO
	@Override	
	protected Void visit_str_val_node(AST node){
		
	}
		
	// TODO
	@Override	
	protected Void visit_var_decl_node(AST node){
		
		return null;
	}

	
	@Override	
	protected Integer visit_not_node(AST node){
		int reg0 = visit(node.getChild(0)); 
		int reg_result = newIntReg();

		int zero = newIntReg();
		OpCode.LDIi(zero, 0);
		
		emit(OpCode.NOR, reg_result, reg0, zero);

		return -1;
	}
		
	
	@Override	
	protected Integer visit_and_node(AST node){
		int reg1 = visit(node.getChild(1)); //rightChild
		int reg0 = visit(node.getChild(0)); //leftChild
		int reg_result = newIntReg();
		
		emit(OpCode.AND, reg_result, reg1, reg0);
		return -1;
	}
		
	
	@Override	
	protected Integer visit_or_node(AST node){
		
		int reg1 = visit(node.getChild(1)); //rightChild
		int reg0 = visit(node.getChild(0)); //leftChild
		int reg_result = newIntReg();
		
		emit(OpCode.OR, reg_result, reg1, reg0);
		return -1;
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