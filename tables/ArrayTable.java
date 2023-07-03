package tables;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

import types.Type;

import code.Frame;

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
	public int searchPositionArgument(int positionArgument) {
		for (int i = 0; i < table.size(); i++) {
			if (table.get(i).positionArgument == positionArgument) {
				return i;
			}
		}
		return -1;
	}

	public int addArray(String s, int line, Type type, Type typeElement, int size, int positionArgument) {
		
		EntryArray entryArray = new EntryArray(s, line, type, typeElement, size, positionArgument);
		int idxAdded = table.size();

		table.add(entryArray);

		if(positionArgument == -1){
			if(idxAdded == 0){
				setMemoryPosition(idxAdded,0);
			}else{
				setMemoryPosition(idxAdded, getMemoryPosition(idxAdded-1) + getSize(idxAdded-1));
			}
		}

		return idxAdded;
	}

	public int getMemoryPosition(int index){ 
		return table.get(index).positionMemory;
	}

	public void setMemoryPosition(int index, int value){ //value is position memory
		table.get(index).positionMemory = value;
	}

	public Frame getFrame(int index) {
		return table.get(index).frame;
	}

	public void setFrame(int index, Frame frame){
		table.get(index).frame = frame;
	}
	
	public int getSizeArrayTable() {
		return table.size();
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

	public Type getTypeElement(int i) {
		return table.get(i).typeElement;
	}

	public int getSize(int i) {
		return table.get(i).size;
	}

	public Type getTypeByName(String name) {
		int i = lookupArray(name); // Pegando índice do nome na tabela;
		return getType(i);
	}

	public Type getTypeElementByName(String name) {
		int i = lookupArray(name); // Pegando índice do nome na tabela;
		return getTypeElement(i);
	}

	public int getPositionArgument(int i){
		return table.get(i).positionArgument;
	}

	public Type getTypeByPositionArgument(int position) {
		for(int i = 0; i < table.size(); i++) {
			if(getPositionArgument(i) == position) {
				//atualiza o tamanho do array
				return getType(i);
			}
		}
		return null;
	}
	

	public int getSizeArray(int i) {
		return table.get(i).size;
	}

	public void setSizeArrayByLine(int line, int size) {
		table.get(line).size = size ;
	}

	public void setSizeArray(int size, String name_array){
		int index = lookupArray(name_array);
		table.get(index).size  = size;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		Formatter f = new Formatter(sb);
		f.format("Array table:\n");
		for (int i = 0; i < table.size(); i++) {
			f.format("Entry %d -- name: %s, line: %d, type: %s, typeElement: %s, size: %d, positionArgument: %d positionMemory: %d\n", i,
	                 getName(i), getLine(i), getType(i).toString(), getTypeElement(i).toString(), getSize(i), getPositionArgument(i), getMemoryPosition(i));
		}
		f.close();
		return sb.toString();
	}

	public int calculateMemory(){
		int sum_memory = 0;
		for (int i = 0; i< this.getSizeArrayTable(); i++){
			if(this.getPositionArgument(i) == -1) // alocando memória apenas para arrays locais
			{
				sum_memory += this.getSize(i);
			}
		}
		return sum_memory;
	}



	private static final class EntryArray {
		private final String name;
		private final int line;
		private final Type type;
		private final Type typeElement;
		private int size;
		// -1 - não é um argumento
		// > -1 - posição do argumento na lista de arg da função
		private final int positionArgument;
		private int positionMemory;
		private Frame frame;

		EntryArray(String name, int line, Type type, Type typeElement, int size, int positionArgument) {
			this.name = name;
			this.line = line;
			this.type = type;
			this.typeElement = typeElement;
			this.size = size;
			this.positionArgument = positionArgument;
			this.positionMemory = -1;
			this.frame = null;
		}
	}
}