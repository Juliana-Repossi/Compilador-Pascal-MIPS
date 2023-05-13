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

	public int addProc(String name, int line) {
	
		EntryProc entry = new EntryProc(name, line);
		int idxAdded = table.size();
		table.add(entry);
		return idxAdded;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		Formatter f = new Formatter(sb);
		f.format("Procedure table:\n");
		for (int i = 0; i < table.size(); i++) {
			f.format("Entry %d -- name: %s, line: %d \n", i, getName(i), getLine(i));
			System.out.println("    Tabela de String");
			System.out.println("    " + getStrTable(i).toString());
			System.out.println("    Tabela de Id");
			System.out.println("    " +  getIdTable(i).toString());
			System.out.println("    Tabela de Array");
			System.out.println("    " +  getArrayTable(i).toString());
		}
		f.close();
		return sb.toString();
	}

	public String getName(int i) {
		return table.get(i).name;
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

	public ArrayTable getArrayTable(int i) {
		return table.get(i).arrayTable;
	}


	private static final class EntryProc {
        private final String name;
		private final int line;
        private final StrTable strTable;
        private final IdTable idTable;
		private final ArrayTable arrayTable;
		
		EntryProc(String name, int line) {
			this.name = name;
			this.line = line;
			this.strTable = new StrTable();
			this.idTable = new IdTable();
			this.arrayTable = new ArrayTable();
		}
	}
}