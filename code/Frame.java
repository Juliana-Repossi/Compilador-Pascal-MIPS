package code;

import tables.ArrayTable;
import tables.IdTable;
import ast.AST;

public class Frame {

    protected AST node;
    protected Memory idMemory;
    protected Memory arrayMemory;
    protected DataStack stack;
    private final IdTable it;
	private final ArrayTable at;

	public Frame(AST node, IdTable it, ArrayTable at){
      this.idMemory = new Memory(it.getSize());
	  this.arrayMemory = new Memory(at.calculateMemory());
      this.node = node;
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
