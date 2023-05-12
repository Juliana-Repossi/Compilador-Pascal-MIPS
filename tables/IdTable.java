package tables;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

import types.Type;

public final class IdTable {

	// No mundo real isto certamente deveria ser um hash...
	// Implementação da classe não é exatamente Javanesca porque
	// tentei deixar o mais parecido possível com a original em C.
	private List<Entry> table = new ArrayList<Entry>();

	public int lookupVar(String s) {
		for (int i = 0; i < table.size(); i++) {
			if (table.get(i).name.equals(s)) {
				return i;
			}
		}
		return -1;
	}

	public int addId(String s, int line, Type type, Boolean ehConst) {
		Entry entry = new Entry(s, line, type,ehConst);
		int idxAdded = table.size();
		table.add(entry);
		return idxAdded;
	}

	public String getName(int i) {
		return table.get(i).name;
	}

	public int getLine(int i) {
		return table.get(i).line;
	}

	public Type getType(int i) {
		return table.get(i).type;
	}

	public Boolean getConst(int i) {
		return table.get(i).ehConst;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		Formatter f = new Formatter(sb);
		f.format("Variables table:\n");
		for (int i = 0; i < table.size(); i++) {
			f.format("Entry %d -- name: %s, line: %d, type: %s, Const: %b\n", i,
	                 getName(i), getLine(i), getType(i).toString(),getConst(i));
		}
		f.close();
		return sb.toString();
	}

	private static final class Entry {
		private final String name;
		private final int line;
		private final Type type;
		private final Boolean ehConst;

		Entry(String name, int line, Type type, Boolean ehConst) {
			this.name = name;
			this.line = line;
			this.type = type;
			this.ehConst = ehConst;
		}
	}
}