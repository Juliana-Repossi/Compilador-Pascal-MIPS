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

/*
 * Interpretador de código para EZLang, implementado como
 * um visitador da AST gerada pelo front-end. Tipo genérico
 * foi instanciado para Void porque a gente não precisa de
 * um valor de retorno na visitação. Para o gerador de código
 * do próximo laboratório isso vai mudar.
 *
 * Para rodar, chame o método 'execute' da superclasse.
 */
public class Interpreter extends ASTBaseVisitor<Void> {

	// Tudo privado e final para simplificar.
	private final FrameStack frameStack;
	private Frame currentFrame;
	private final StrTable st;
	private final FuncTable ft;
	private final ProcTable pt;
	private final Scanner in;  // Para leitura de stdin

	// Construtor basicão.
	public Interpreter(StrTable st, IdTable it, ArrayTable at, FuncTable ft, ProcTable pt) {
		this.frameStack = new FrameStack();
		this.currentFrame = frameStack.pushFrame(null, it, at);
		this.st = st;
		this.ft = ft;
		this.pt = pt;
		this.in = new Scanner(System.in);
	}

	// TODO
	@Override
	protected Void visit_I2R_node(AST node){
		visit(node.getChild(0)); 
		float floatVal = (float) currentFrame.popiDataStack();
		currentFrame.pushfDataStack(floatVal);
		return null;
	}

	// TODO
	@Override
	protected Void visit_assign_node(AST node){

		visit(node.getChild(1)); // expr
		float resultFloat;
		int resultInt;
		int positionMemory;

		if(node.kind == NodeKind.ACCESS_ARRAY_USE_NODE) {
			visit(node.getChild(0));
			int arrayIndex = currentFrame.popiDataStack();
			int accessArray = currentFrame.popiDataStack();
			positionMemory = currentFrame.getArrayTable().getMemoryPosition(arrayIndex) + accessArray;

			if(node.getChild(0).type == Type.ARRAY_INTEGER) {
				resultInt = currentFrame.popiDataStack();
				currentFrame.storeiDataStackArrayMemory(positionMemory, resultInt);
			
			} else if(node.getChild(0).type == Type.ARRAY_REAL) {
				resultFloat = currentFrame.popfDataStack();
				currentFrame.storefDataStackArrayMemory(positionMemory, resultFloat);
		
			} else if(node.getChild(0).type == Type.ARRAY_BOOLEAN) {
				resultInt = currentFrame.popiDataStack();
				currentFrame.storeiDataStackArrayMemory(positionMemory, resultInt);
			}
			
		}else if (node.kind == NodeKind.VAR_USE_NODE){
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
		
		return null;
	}

	// TODO
	@Override
	protected Void visit_var_use_node(AST node){
		Type type = node.type;
		int intValue;
		float floatValue;

		if(type == Type.INTEGER){
			intValue = currentFrame.loadiDataStackIdMemory(node.intData);
			currentFrame.pushiDataStack(intValue);

		}else if(type == Type.REAL){
			floatValue = currentFrame.loadfDataStackIdMemory(node.intData);
			currentFrame.pushfDataStack(floatValue);

		}else if(type == Type.BOOLEAN){
			intValue = currentFrame.loadiDataStackIdMemory(node.intData);
			currentFrame.pushiDataStack(intValue);

		}else if(type == Type.STRING){
			currentFrame.pushiDataStack(node.intData);

		}else if(type == Type.ARRAY_BOOLEAN){
			intValue = currentFrame.loadiDataStackArrayMemory(node.intData);
			currentFrame.pushiDataStack(intValue);

		}else if(type == Type.ARRAY_REAL){
			floatValue = currentFrame.loadfDataStackArrayMemory(node.intData);
			currentFrame.pushfDataStack(floatValue);

		}else if(type == Type.ARRAY_BOOLEAN){
			intValue = currentFrame.loadiDataStackArrayMemory(node.intData);
			currentFrame.pushiDataStack(intValue);
		}

		return null;
	}

	// TODO
	@Override
	protected Void visit_access_array_use_node(AST node){
		visit(node.getChild(0)); // expr
		currentFrame.pushiDataStack(node.intData);
		return null;
	}

	// TODO
	@Override
	protected Void visit_not_equal_node(AST node){
		visit(node.getChild(1)); // expr
		visit(node.getChild(0)); // expr

		boolean bool_result;

		if(node.getChild(1).type == Type.STRING) {
			int index1 = currentFrame.popiDataStack();
			int index2 = currentFrame.popiDataStack();
			String str1 = st.get(index1);
			String str2 = st.get(index2);
			bool_result = !str1.equals(str2);

		} else if(node.getChild(1).type == Type.REAL) {
			bool_result = currentFrame.popfDataStack() != currentFrame.popfDataStack();
		}else{ // boolean ou int
			bool_result = currentFrame.popiDataStack() != currentFrame.popiDataStack();
		}
		
		if(bool_result == true) {
			currentFrame.pushiDataStack(1);

		} else if(bool_result == false) {
			currentFrame.pushiDataStack(0);	
		}
		return null;
	}

	// TODO
	@Override
	protected Void visit_equal_node(AST node){
		visit(node.getChild(1)); // expr
		visit(node.getChild(0)); // expr

		boolean bool_result;

		if(node.getChild(1).type == Type.STRING) {
			int index1 = currentFrame.popiDataStack();
			int index2 = currentFrame.popiDataStack();
			String str1 = st.get(index1);
			String str2 = st.get(index2);
			bool_result = str1.equals(str2);

		} else if(node.getChild(1).type == Type.REAL) {
			bool_result = currentFrame.popfDataStack() == currentFrame.popfDataStack();
		}else{ // boolean ou int
			bool_result = currentFrame.popiDataStack() == currentFrame.popiDataStack();
		}
		
		if(bool_result == true) {
				currentFrame.pushiDataStack(1);

		} else if(bool_result == false) {
			currentFrame.pushiDataStack(0);	
		}
		return null;
	}

	// TODO
	@Override
	protected Void visit_less_than_node(AST node){
		visit(node.getChild(1)); // expr
		visit(node.getChild(0)); // expr

		boolean bool_result;

		if(node.getChild(1).type == Type.STRING) {
			int index1 = currentFrame.popiDataStack();
			int index2 = currentFrame.popiDataStack();
			String str1 = st.get(index1);
			String str2 = st.get(index2);
			int int_result = str1.compareTo(str2);

			if(int_result == -1) {
				bool_result = true;
			
			} else {
				bool_result = false;
			}

		} else if(node.getChild(1).type == Type.REAL) {
			bool_result = currentFrame.popfDataStack() < currentFrame.popfDataStack();
		}else{ // integer ou boolean
			bool_result = currentFrame.popiDataStack() < currentFrame.popiDataStack();
		}
		
		if(bool_result == true) {
			currentFrame.pushiDataStack(1);

		} else if(bool_result == false) {
			currentFrame.pushiDataStack(0);	
		}
		return null;
	}

	// TODO
	@Override
	protected Void visit_greater_than_node(AST node){
		visit(node.getChild(1)); // expr
		visit(node.getChild(0)); // expr

		boolean bool_result;

		if(node.getChild(1).type == Type.STRING) {
			int index1 = currentFrame.popiDataStack();
			int index2 = currentFrame.popiDataStack();
			String str1 = st.get(index1);
			String str2 = st.get(index2);
			int int_result = str1.compareTo(str2);

			if(int_result == 1) {
				bool_result = true;
			
			} else {
				bool_result = false;
			}

		} else if(node.getChild(1).type == Type.REAL) {
			bool_result = currentFrame.popfDataStack() > currentFrame.popfDataStack();
		}else{ // integer ou boolean
			bool_result = currentFrame.popiDataStack() > currentFrame.popiDataStack();
		}
		
		if(bool_result == true) {
			currentFrame.pushiDataStack(1);

		} else if(bool_result == false) {
			currentFrame.pushiDataStack(0);	
		}
		return null;
	}

	// TODO
	@Override
	protected Void visit_LEQ_node(AST node){
		visit(node.getChild(1)); // expr
		visit(node.getChild(0)); // expr

		boolean bool_result;

		if(node.getChild(1).type == Type.STRING) {
			int index1 = currentFrame.popiDataStack();
			int index2 = currentFrame.popiDataStack();
			String str1 = st.get(index1);
			String str2 = st.get(index2);
			int int_result = str1.compareTo(str2);

			if(int_result == 0 || int_result == -1) {
				bool_result = true;
			
			} else {
				bool_result = false;
			}

		} else if(node.getChild(1).type == Type.REAL) {
			bool_result = currentFrame.popfDataStack() <= currentFrame.popfDataStack();
		}else{ // integer ou boolean
			bool_result = currentFrame.popiDataStack() <= currentFrame.popiDataStack();
		}
		
		if(bool_result == true) {
			currentFrame.pushiDataStack(1);

		} else if(bool_result == false) {
			currentFrame.pushiDataStack(0);	
		}
		return null;
	}

	// TODO
	@Override
	protected Void visit_BEQ_node(AST node){
		visit(node.getChild(1)); // expr
		visit(node.getChild(0)); // expr

		boolean bool_result;

		if(node.getChild(1).type == Type.STRING) {
			int index1 = currentFrame.popiDataStack();
			int index2 = currentFrame.popiDataStack();
			String str1 = st.get(index1);
			String str2 = st.get(index2);
			int int_result = str1.compareTo(str2);

			if(int_result == 0 || int_result == 1) {
				bool_result = true;
			
			} else {
				bool_result = false;
			}

		} else if(node.getChild(1).type == Type.REAL) {
			bool_result = currentFrame.popfDataStack() >= currentFrame.popfDataStack();
		}else{ // integer ou boolean
			bool_result = currentFrame.popiDataStack() >= currentFrame.popiDataStack();
		}
		
		if(bool_result == true) {
			currentFrame.pushiDataStack(1);

		} else if(bool_result == false) {
			currentFrame.pushiDataStack(0);	
		}
		return null;
	}

	// TODO
	@Override
	protected Void visit_block_node(AST node){
		for (int i = 0; i < node.getChildrenSize(); i++) {
			visit(node.getChild(i));
		}
		return null;
	}

	// TODO
	@Override
	protected Void visit_bool_val_node(AST node){
		currentFrame.pushiDataStack(node.intData);
		return null;
	}

	// TODO
	@Override
	protected Void visit_if_node(AST node){
		visit(node.getChild(0));
		int result = currentFrame.popiDataStack();

		if(result == 1) {
			visit(node.getChild(1));

		} else if(result == 0 && node.getChildrenSize() == 3) {
			visit(node.getChild(2));
		}
		return null;
	}

	// TODO
	@Override
	protected Void visit_int_val_node(AST node){
		currentFrame.pushiDataStack(node.intData);
		return null;
	}

	// TODO
	@Override
	protected Void visit_plus_node(AST node){

		visit(node.getChild(1));
		visit(node.getChild(0));

		if(node.type == Type.INTEGER) {		

			int plusResult = currentFrame.popiDataStack() + currentFrame.popiDataStack();
			currentFrame.pushiDataStack(plusResult);
		
		} else if(node.type == Type.REAL) {
			float plusResult = currentFrame.popfDataStack() + currentFrame.popfDataStack();
			currentFrame.pushfDataStack(plusResult);
		
		} else if(node.type == Type.STRING) {
			int indexStr1 = currentFrame.popiDataStack();
			int indexStr2 = currentFrame.popiDataStack();

			String str1 = st.get(indexStr1);
			String str2 = st.get(indexStr2);

			str1 = str1.substring(1, str1.length() - 1);
			str2 = str2.substring(1, str2.length() - 1);

			String concatResult = str1.concat(str2);
			int indexConcat = st.addStr("\"" + concatResult + "\"");
			currentFrame.pushiDataStack(indexConcat); 

		} else if(node.type == Type.BOOLEAN) {

			if(currentFrame.popiDataStack() == 1 || currentFrame.popiDataStack() == 1){
				currentFrame.pushiDataStack(1);
			}else{
				currentFrame.pushiDataStack(0);
			}
		}
		return null;
	}

	// TODO
	@Override
	protected Void visit_minus_node(AST node){
		visit(node.getChild(1));
		visit(node.getChild(0));

		if(node.type == Type.INTEGER) {
			int overResult = currentFrame.popiDataStack()  - currentFrame.popiDataStack();
			currentFrame.pushiDataStack(overResult);
		
		} else if(node.type == Type.REAL) {
			float overResult = currentFrame.popfDataStack() - currentFrame.popfDataStack();
			currentFrame.pushfDataStack(overResult);
		}
		return null;
	}

	// TODO
	@Override
	protected Void visit_asterisk_node(AST node){
		visit(node.getChild(1));
		visit(node.getChild(0));

		if(node.type == Type.INTEGER) {
			int overResult =  currentFrame.popiDataStack() * currentFrame.popiDataStack();
			currentFrame.pushiDataStack(overResult);
		} else if(node.type == Type.REAL) {
			float overResult = currentFrame.popfDataStack() * currentFrame.popfDataStack();
			currentFrame.pushfDataStack(overResult);
		}

		return null;
	}

	// TODO
	@Override
	protected Void visit_slash_node(AST node){

		visit(node.getChild(1));
		visit(node.getChild(0));

		if(node.type == Type.INTEGER) {
			int overResult =  currentFrame.popiDataStack() / currentFrame.popiDataStack();
			currentFrame.pushiDataStack(overResult);
		} else if(node.type == Type.REAL) {
			float overResult = currentFrame.popfDataStack() / currentFrame.popfDataStack();
			currentFrame.pushfDataStack(overResult);
		}
		return null;
	}

	// TODO
	@Override
	protected Void visit_mod_node(AST node){

		visit(node.getChild(1));
		visit(node.getChild(0));

		// Só pode inteiro
		int overResult =  currentFrame.popiDataStack() % currentFrame.popiDataStack();
		currentFrame.pushiDataStack(overResult);
		
		return null;
	}

	// TODO
	@Override
	protected Void visit_one_minus_node(AST node){

		visit(node.getChild(0));

		if(node.type == Type.INTEGER) {
			int overResult =  (-1) * currentFrame.popiDataStack();
			currentFrame.pushiDataStack(overResult);
		} else if(node.type == Type.REAL) {
			float overResult = (-1) * currentFrame.popfDataStack();
			currentFrame.pushfDataStack(overResult);
		}
		return null;
	}

	// TODO
	@Override
	protected Void visit_program_node(AST node){
		visit(node.getChild(0)); // run var_list
		visit(node.getChild(node.getChildrenSize() - 1)); // run block main
		in.close(); // Fim do programa, não precisa mais de ler de stdin.
		return null;
	}

	// TODO
	@Override
	protected Void visit_var_list_node(AST node){
		// Nothing to do.
		return null;
	}

	// TODO
	@Override
	protected Void visit_read_node(AST node) {
		int positionMemory;
		int resultInt;
		float resultFloat;

		if(node.getChild(0).kind == NodeKind.ACCESS_ARRAY_USE_NODE) {
			visit(node.getChild(0));
			int arrayIndex = currentFrame.popiDataStack();
			int accessArray = currentFrame.popiDataStack();
			positionMemory = currentFrame.getArrayTable().getMemoryPosition(arrayIndex) + accessArray;

			if(node.getChild(0).type == Type.ARRAY_INTEGER) {
				System.out.printf("read (access array integer): ");
				resultInt = in.nextInt();
				currentFrame.storeiDataStackArrayMemory(positionMemory, resultInt);
			
			} else if(node.getChild(0).type == Type.ARRAY_REAL) {
				System.out.printf("read (access array real): ");
				resultFloat = in.nextFloat();
				currentFrame.storefDataStackArrayMemory(positionMemory, resultFloat);
			} 

		} else if(node.getChild(0).kind == NodeKind.VAR_USE_NODE) {
			positionMemory = node.getChild(0).intData;

			if(node.getChild(0).type == Type.INTEGER){
				System.out.printf("read (integer): ");
				resultInt = in.nextInt();
				currentFrame.storeiDataStackIdMemory(positionMemory, resultInt);

			} else if(node.getChild(0).type  == Type.REAL){
				System.out.printf("read (real): ");
				resultFloat = in.nextFloat();
				currentFrame.storefDataStackIdMemory(positionMemory, resultFloat);

			} else if(node.getChild(0).type  == Type.STRING){
				System.out.printf("read (string): ");
				String str = in.next();
				int strIdx = st.addStr(str);
				currentFrame.storeiDataStackIdMemory(positionMemory,strIdx);
			}
		}
		
		return null;
	}

	// TODO
	@Override
	protected Void visit_write_node(AST node){
		visit(node.getChild(0)); // expr
	
		if(node.getChild(0).type == Type.INTEGER) {
			writeInt();

		} else if(node.getChild(0).type == Type.REAL) {
			writeReal();

		} else if(node.getChild(0).type == Type.BOOLEAN) {
			writeBool();

		} else if(node.getChild(0).type == Type.STRING) {
			writeStr();
		}
		
		return null;
	}

	// TODO
	@Override
	protected Void visit_writeln_node(AST node){
		visit(node.getChild(0)); // expr
	
		if(node.getChild(0).type == Type.INTEGER) {
			writeInt();

		} else if(node.getChild(0).type == Type.REAL) {
			writeReal();

		} else if(node.getChild(0).type == Type.BOOLEAN) {
			writeBool();


		} else if(node.getChild(0).type == Type.STRING) {
			writeStr();
		}
		
		System.out.println();
		return null;
	}

	// TODO
	@Override
	protected Void visit_real_val_node(AST node){
		currentFrame.pushfDataStack(node.floatData);
		return null;
	}

	// TODO
	@Override	
	protected Void visit_while_node(AST node){
		while(true) {
			visit(node.getChild(0)); // expr
			int bool_result = currentFrame.popiDataStack();
			if(bool_result == 0) {
				break;
			}

			visit(node.getChild(1)); // block
		}
		
		return null;
	}
		
	// TODO
	@Override	
	protected Void visit_str_val_node(AST node){
		currentFrame.pushiDataStack(node.intData);
		return null;
	}
		
	// TODO
	@Override	
	protected Void visit_var_decl_node(AST node){
		// Nothing to do.
		return null;
	}

	// TODO
	@Override	
	protected Void visit_not_node(AST node){
		visit(node.getChild(0)); 

		int bool_val = currentFrame.popiDataStack();
		
		if(bool_val == 1) {
			currentFrame.pushiDataStack(0);
		} else if(bool_val == 0){
			currentFrame.pushiDataStack(1);
		}
		
		return null;
	}
		
	// TODO
	@Override	
	protected Void visit_and_node(AST node){
		visit(node.getChild(1)); //rightChild
		visit(node.getChild(0)); //leftChild
		
		int bool_val1 = currentFrame.popiDataStack();
		int bool_val2 = currentFrame.popiDataStack();
		
		if(bool_val1 == 1 && bool_val2 == 1) {
			currentFrame.pushiDataStack(1);
		} else {
			currentFrame.pushiDataStack(0);
		}
		
		return null;
	}
		
	// TODO
	@Override	
	protected Void visit_or_node(AST node){
		visit(node.getChild(1)); //rightChild
		visit(node.getChild(0)); //leftChild
		
		int bool_val1 = currentFrame.popiDataStack();
		int bool_val2 = currentFrame.popiDataStack();
		
		if(bool_val1 == 1 || bool_val2 == 1) {
			currentFrame.pushiDataStack(1);
		} else {
			currentFrame.pushiDataStack(0);
		}
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
		return null;
	}
		
	// TODO
	@Override	
	protected Void visit_var_pararameter_node(AST node){
		return null;
	}
		
	// TODO
	@Override	
	protected Void visit_parameters_node(AST node){
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
		System.out.print(currentFrame.popiDataStack());
		return null;
	}

	private Void writeReal() {
		System.out.print(currentFrame.popfDataStack());
		return null;
	}

	private Void writeBool() {
		if (currentFrame.popiDataStack() == 0) {
			System.out.print("false");
		} else {
			System.out.print("true");
		}
		return null;
	}

	private Void writeStr() {
		int strIdx = currentFrame.popiDataStack(); // String pointer
		String originalStr = st.get(strIdx);
		System.out.print(originalStr);
		return null;
	}

	private String unescapeStr(String originalStr) {
		StreamTokenizer parser = new StreamTokenizer(new StringReader(originalStr));
		String unescapedStr = "";
		try {
		    parser.nextToken();
		    if (parser.ttype == '"') {
			    unescapedStr = parser.sval;
		    } else {
			  unescapedStr = "ERROR at string conversion!";
		    }
		}
		catch (IOException e) {
		    e.printStackTrace();
		}
		return unescapedStr;
	}
}
