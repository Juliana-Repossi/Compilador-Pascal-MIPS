package tables;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

import types.Type;
import tables.StrTable;
import tables.IdTable;
import tables.ArrayTable;

import ast.AST;

public final class FuncTable {

	// No mundo real isto certamente deveria ser um hash...
	// Implementação da classe não é exatamente Javanesca porque
	// tentei deixar o mais parecido possível com a original em C.
	private List<EntryFunc> table = new ArrayList<EntryFunc>();

	public int lookupVar(String s) {
		for (int i = 0; i < table.size(); i++) {
			if (table.get(i).name.equals(s)) {
				return i;
			}
		}
		return -1;
	}

	public int addFunc(String name, Type typeReturn, int line) {
	
		//por default a qtd de parameters é 0
		EntryFunc entry = new EntryFunc(name, 0, typeReturn, line);
		int idxAdded = table.size();
		table.add(entry);
		return idxAdded;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		Formatter f = new Formatter(sb);
		f.format("\n------------------------------------------------------------\n");
		f.format("Functions table:\n");

		for (int i = 0; i < table.size(); i++) {
			f.format("\n------------------------------------------------------------\n");
			f.format("    Entry %d -- name: %s, typeReturn: %s, qtdParameters: %d, line: %d \n", i,
	                 getName(i), getTypeReturn(i).toString(), getQtdParameters(i), getLine(i));
			f.format("    %s\n", getIdTable(i).toString());
			f.format("    %s\n", getArrayTable(i).toString());

		}
		f.format("\n------------------------------------------------------------\n");
		f.close();
		return sb.toString();
	}

	public int getTableSize() {
		return table.size();
	}
	
	public String getName(int i) {
		return table.get(i).name;
	}

	public int getQtdParameters(int i) {
		return table.get(i).qtdParameters;
	}

	public Type getTypeReturn(int i) {
		return table.get(i).typeReturn;
	}

	public int getLine(int i) {
		return table.get(i).line;
	}

	public IdTable getIdTable(int i) {
		return table.get(i).idTable;
	}

	public ArrayTable getArrayTable(int i) {
		return table.get(i).arrayTable;
	}

	public void incrementQtdParameters(int increment, int i){
		table.get(i).qtdParameters += increment;
	}

	public Type getTypeByArgument(int position, String name) {
		int index = lookupVar(name);
		Type type = getIdTable(index).getTypeByPositionArgument(position);

		if(type == null){
			type = getArrayTable(index).getTypeByPositionArgument(position);
		}

		return type;
	}

	public void setArraySize(int index,String array_name, int size){
		getArrayTable(index).setSizeArray(size,array_name);
	}
	
	private static final class EntryFunc {
    	private final String name;
		private int qtdParameters;
    	private final Type typeReturn;
		private final int line;
    	private final IdTable idTable;
		private final ArrayTable arrayTable;
		private AST node;
		
		EntryFunc(String name, int qtdParameters, Type typeReturn, int line) {
			this.name = name;
			this.qtdParameters = qtdParameters;
			this.typeReturn = typeReturn;
			this.line = line;
			this.idTable = new IdTable();
			this.arrayTable = new ArrayTable();
			this.node = null;
		}
	}
}