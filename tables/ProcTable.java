package tables;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

import types.Type;
import tables.StrTable;
import tables.IdTable;

public final class ProcTable {

	// No mundo real isto certamente deveria ser um hash...
	// Implementação da classe não é exatamente Javanesca porque
	// tentei deixar o mais parecido possível com a original em C.
	private List<EntryProc> table = new ArrayList<EntryProc>();

	public int lookupVar(String s) {
		for (int i = 0; i < table.size(); i++) {
			if (table.get(i).name.equals(s)) {
				return i;
			}
		}
		return -1;
	}

	public int addProc(String name, int qtdParameters, int line) {
	
		EntryProc entry = new EntryProc(name,qtdParameters, line);
		int idxAdded = table.size();
		table.add(entry);
		return idxAdded;
	}

	public void setArraySize(int index,String array_name, int size){
		getArrayTable(index).setSizeArray(size,array_name);
	}

	public Type getTypeByArgument(int position, String name) {
		int index = lookupVar(name);
		Type type = getIdTable(index).getTypeByPositionArgument(position);

		if(type == null){
			type = getArrayTable(index).getTypeByPositionArgument(position);
		}

		return type;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		Formatter f = new Formatter(sb);
		f.format("\n------------------------------------------------------------\n");
		f.format("Procedure table:\n");

		for (int i = 0; i < table.size(); i++) {
			f.format("\n------------------------------------------------------------\n");
			f.format("Entry %d -- name: %s, qtdParameters: %d, line: %d \n", i, getName(i), getQtdParameters(i), getLine(i));
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

	public int getQtdParameters(int i){
		return table.get(i).qtdParameters;
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

	private static final class EntryProc {
        private final String name;
		private final int line;
		private int qtdParameters;
        private final IdTable idTable;
		private final ArrayTable arrayTable;
		
		EntryProc(String name, int qtdParameters, int line) {
			this.name = name;
			this.line = line;
			this.qtdParameters = qtdParameters;
			this.idTable = new IdTable();
			this.arrayTable = new ArrayTable();
		}
	}
}