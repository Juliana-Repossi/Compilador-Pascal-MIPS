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



public class Main {
    public static void main(String[] args) throws IOException {
		// Cria um CharStream que lê os caracteres de stdin.
		CharStream input = CharStreams.fromStream(System.in);

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

		// Cria a calculadora e visita a ParseTree para computar.
		Visitor visitor = new Visitor();
		AST ast = visitor.visit(tree);
		System.out.println("tentando imprimir a tree");

		System.out.println(tree);

		System.out.println("---------------------");


		// // Saída final.
		System.out.println("PARSE SUCCESSFUL!");
		System.out.println("\n\n");
		// System.out.println(visitor.getStrTable().toString());
		// System.out.println(visitor.getIdTable().toString());
		// System.out.println(visitor.getArrayTable().toString());
		// System.out.println(visitor.getFuncTable().toString());
		// System.out.println(visitor.getProcTable().toString());

		
		// System.out.println("-----------------------");
		// System.out.println(ast);

		System.out.println(tree);
		System.out.println(ast);
		AST.printDot(ast, visitor.getArrayTable(), visitor.getIdTable());

		
		
	}
}