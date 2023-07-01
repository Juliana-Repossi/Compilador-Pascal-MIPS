package tables;

import java.util.ArrayList;
import java.util.Formatter;

@SuppressWarnings("serial")
public final class StrTable extends ArrayList<String>{
    // No mundo real isto certamente deveria ser um hash...

    @Override
    public boolean add(String s) {
		for (int i = 0; i < this.size(); i++) {
			if (this.get(i).equals(s)) {
				return false;
			}
		}
		return super.add(s);
	}

	public int addStr(String s) {
    	int i;
		for (i = 0; i < this.size(); i++) {
			if (this.get(i).equals(s)) {
				return i;
			}
		}
		super.add(s);
		return i;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		Formatter f = new Formatter(sb);
		f.format("Strings table:\n");
		for (int i = 0; i < this.size(); i++) {
			f.format("Entry %d -- %s\n", i, this.get(i));
		}
		f.close();
		return sb.toString();
	}

}