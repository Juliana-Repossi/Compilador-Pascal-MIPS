package tables;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

import types.Type;

public final class ArrayTable {

	// No mundo real isto certamente deveria ser um hash...
	// Implementação da classe não é exatamente Javanesca porque
	// tentei deixar o mais parecido possível com a original em C.
	private List<EntryArray> table = new ArrayList<EntryArray>();

	public int lookupArray(String s) {
		for (int i = 0; i < table.size(); i++) {
			if (table.get(i).name.equals(s)) {
				return i;
			}
		}
		return -1;
	}

	public int addArray(String s, int line, Type type, int size) {
		EntryArray entryArray = new EntryArray(s, line, type,size);
		int idxAdded = table.size();
		table.add(entryArray);
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

	public int getSize(int i) {
		return table.get(i).size;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		Formatter f = new Formatter(sb);
		f.format("Array table:\n");
		for (int i = 0; i < table.size(); i++) {
			f.format("Entry %d -- name: %s, line: %d, type: %s, size: %d\n", i,
	                 getName(i), getLine(i), getType(i).toString(),getSize(i));
		}
		f.close();
		return sb.toString();
	}

	private static final class EntryArray {
		private final String name;
		private final int line;
		private final Type type;
		private final int size;

		EntryArray(String name, int line, Type type, int size) {
			this.name = name;
			this.line = line;
			this.type = type;
			this.size = size;
		}
	}
}