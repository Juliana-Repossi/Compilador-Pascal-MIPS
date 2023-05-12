package tables;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

import types.Type;
import tables.StrTable;
import tables.IdTable;

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

	public int addFunc(String name,Type typeReturn, int line) {
	
		EntryFunc entry = new EntryFunc(name, typeReturn, line);
		int idxAdded = table.size();
		table.add(entry);
		return idxAdded;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		Formatter f = new Formatter(sb);
		f.format("Functions table:\n");
		for (int i = 0; i < table.size(); i++) {
			f.format("Entry %d -- name: %s, typeReturn: %s, line: %d \n", i,
	                 getName(i), getTypeReturn(i).toString(), getLine(i));
			System.out.println("    Tabela de String");
			System.out.println("    " + getStrTable(i).toString());
			System.out.println("    Tabela de Id");
			System.out.println("    " +  getIdTable(i).toString());

		}
		f.close();
		return sb.toString();
	}

	public String getName(int i) {
		return table.get(i).name;
	}

	public Type getTypeReturn(int i) {
		return table.get(i).typeReturn;
	}

	public int getLine(int i) {
		return table.get(i).line;
	}

	public StrTable getStrTable(int i) {
		return table.get(i).strTable;
	}

	public IdTable getIdTable(int i) {
		return table.get(i).idTable;
	}



	private static final class EntryFunc {
        private final String name;
        private final Type typeReturn;
		private final int line;
        private final StrTable strTable;
        private final IdTable idTable;
		
		EntryFunc(String name,Type typeReturn, int line) {
			this.name = name;
			this.typeReturn = typeReturn;
			this.line = line;
			this.strTable = new StrTable();
			this.idTable = new IdTable();
		}
	}
}