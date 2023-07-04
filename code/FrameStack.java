package code;

import java.util.Formatter;
import java.util.Stack;

import tables.ArrayTable;
import tables.IdTable;

import ast.AST;

/*
 * Implementação de uma pilha de frames, com os métodos
 * que facilitam empilhar ou desempilhar um frame
 */
@SuppressWarnings("serial")
public final class FrameStack extends Stack<Frame> {
	// No mundo real esses métodos precisam de verificações de erros.
	
	public Frame pushFrame(Frame frameDad, IdTable it, ArrayTable at) {
        Frame frame = new Frame(frameDad,it,at);
		super.push(frame);
        return frame;
	}

	public Frame popFrame() {
		return super.pop();
	}
	
	public Frame getTopFrame() {
		return super.peek();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
	 	Formatter f = new Formatter(sb);
	 	f.format("*** STACK-FRAME: ");
	 	for (int i = 0; i < this.size(); i++) {
	 		f.format("%d ", this.get(i).toString());
		}
		f.format("\n");
		f.close();
		return sb.toString();
	}
}
