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
		emit(WIDf,register,register_int);
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
				emit(STWf, regAddres, register);
                
			} else {
				emit(STWi, regAddres, register);
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
		

		return null;
	}

	// TODO
	@Override
	protected Void visit_equal_node(AST node){
		
		return null;
	}

	// TODO
	@Override
	protected Void visit_less_than_node(AST node){
		
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