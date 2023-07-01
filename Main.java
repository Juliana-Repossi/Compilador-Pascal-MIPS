import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import ast.AST;
// import Visitor;
import parser.PascalLexer;
import parser.PascalParser;
import visitor.Visitor;


import ast.AST;
import code.Interpreter;



public class Main {
    public static void main(String[] args) throws IOException {
		// Cria um CharStream que lê os caracteres de stdin.
		CharStream input = CharStreams.fromFileName(args[0]);

		// Cria um lexer que consome a entrada do CharStream.
		PascalLexer lexer = new PascalLexer(input);

		// Cria um buffer de tokens vindos do lexer.
		CommonTokenStream tokens = new CommonTokenStream(lexer);

		// Cria um parser que consome os tokens do buffer.
		PascalParser parser = new PascalParser(tokens);

		// Começa o processo de parsing na regra 'line'.
		ParseTree tree = parser.program();

		if (parser.getNumberOfSyntaxErrors() != 0) {
				// Houve algum erro sintático. Termina a compilação aqui.
				System.out.println("Erro sintático");
				System.exit(2);
		}

		// Cria o visitor e percorre a ParseTree para 
		// a análise semântica e geração da AST.
		Visitor visitor = new Visitor();
		AST ast = visitor.visit(tree);

		System.out.println("PARSE SUCCESSFUL!");
		//System.out.println("\n\n");
		//System.out.println(visitor.getStrTable().toString());
		//System.out.println(visitor.getIdTable().toString());
		//System.out.println(visitor.getArrayTable().toString());
		//System.out.println(visitor.getFuncTable().toString());
		//System.out.println(visitor.getProcTable().toString());
		//AST.printDot(ast, visitor.getArrayTable(), visitor.getIdTable(), visitor.getFuncTable(), visitor.getProcTable());
	
		Interpreter interpreter = new Interpreter(visitor.getStrTable(), visitor.getIdTable(), visitor.getArrayTable(), visitor.getFuncTable(), visitor.getProcTable());
		interpreter.execute(ast);
	}
}