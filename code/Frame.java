package code;

import tables.ArrayTable;
import tables.IdTable;
import ast.AST;

public class Frame {

    protected Frame frameDad;
    protected Memory idMemory;
    protected Memory arrayMemory;
    protected DataStack stack;
    private final IdTable it;
	private final ArrayTable at;

	public Frame(Frame frameDad, IdTable it, ArrayTable at){
      this.idMemory = new Memory(it.getSize());
	  this.arrayMemory = new Memory(at.calculateMemory());
      this.frameDad = frameDad;
      this.stack = new DataStack();
      this.it = it;
	  this.at = at;
    }

    public ArrayTable getArrayTable(){
        return this.at;
    }

    public IdTable getIdTable(){
        return this.it;
    }

    public void pushiDataStack(int valueInt){
        stack.pushi(valueInt);     
    }

    public void pushfDataStack(float valueFloat){
        stack.pushf(valueFloat);
    }

    public int popiDataStack(){
        return stack.popi();
    }

    public float popfDataStack(){
        return stack.popf();
    }

    public boolean isEmptyDataStack() {
        return stack.isEmpty();
    }

    public Frame getFrameDad() {
        return this.frameDad;
    }

    public void storeiDataStackIdMemory(int addr, int value) {
		idMemory.storei(addr, value);

	}

    public void storefDataStackIdMemory(int addr, float value) {
		idMemory.storef(addr, value);
	}

    public void storeiDataStackArrayMemory(int addr, int value) {
		arrayMemory.storei(addr, value);
	}

    public void storefDataStackArrayMemory(int addr, float value) {
		arrayMemory.storef(addr, value);
	}

    public int loadiDataStackIdMemory(int addr) {
		return idMemory.loadi(addr);
	}

    public float loadfDataStackIdMemory(int addr) {
		return idMemory.loadf(addr);
	}

    public int loadiDataStackArrayMemory(int addr) {
		return arrayMemory.loadi(addr);
	}

    public float loadfDataStackArrayMemory(int addr) {
		return arrayMemory.loadf(addr);
	}

    public Void imprime(){
        this.idMemory.imprime();
        return null;
    }

    public Void imprimeStack() {
        System.out.println(this.stack.toString());
        return null;
    }
	
	

    // public String toString() {
	// 	StringBuilder sb = new StringBuilder();
	//  	Formatter f = new Formatter(sb);
	//  	f.format("*** FRAME: ");
	//  	for (int i = 0; i < this.size(); i++) {
	//  		f.format("%d ", this.get(i).stack.toString());
    //         //print stackf.format("%d ", this.get(i).toString());
            
	// 	}
	// 	f.format("\n");
	// 	f.close();
	// 	return sb.toString();
	// }
}
