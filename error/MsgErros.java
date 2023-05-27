package error;
import types.Type;

public final class MsgErros {

    public static void idJaDeclarado(String s, int line){
        System.out.println("(" + line + ") - O Id \'" + s + "\' já foi declarado" );
        System.exit(3);
    }

    public static void idNaoDeclarado(String s, int line){
        System.out.println("(" + line + ") - O Id \'"+ s + "\' não foi declarado previamente");
        System.exit(4);
    }


    public static void  erroInesperado(int line){
        System.out.println("(" + line + ") - Erro inesperado!!!");
        System.exit(5);
    }

    public static void metodoNaoDeclarado(String s, int line){
        System.out.println("(" + line + ") - A função \'" + s + "\' não foi previamente declarada!");
        System.exit(6);
    }

    public static void tamArrayInvalido(int line){
        System.out.println("(" + line + ") - O tamanho do array é inválido");
        System.exit(7);
    }

    public static void operadorInvalido(String op){
        System.out.println("O operador " + op + " é inválido");
        System.exit(8);
    }

    public static void typeIndexError(int line){
        System.out.println("(" + line + ") - O índice do array deve ser do tipo Integer");
        System.exit(9);
    }

    public static void incompatibleTypesAtribution(int line, Type typeId, Type typeExpr ){
        System.out.println("(" + line + ") - O tipo " + typeExpr + " não pode ser atribuído ao tipo " + typeId + ".");
        System.exit(10);
    }

    public static void exprIsNotBoolean(int line, Type typeExpr){
        System.out.println("(" + line + ") - A expressão é do tipo " + typeExpr + " , deveria ser booleana.");
        System.exit(11);
    }

    public static void incompatibleTypesOperation(int line, Type typeExpr1, Type typeExpr2, String op){
        System.out.println("(" + line + ") - Operação '"+ op + "' inválida entre os tipos " + typeExpr1 + " e " + typeExpr2 + ".");
        System.exit(12);
    }

    public static void incompatibleTypesParameters(int line, Type typeParam1, Type typeParam2){
        System.out.println("(" + line + ") - Método esperava " + typeParam1 + " e foi passado " + typeParam2 + ".");
        System.exit(12);
    }

     public static void incompatibleQtdParameters(int line, int qtdEsperado, int qtdRecebido){
        System.out.println("(" + line + ") - Método esperava " + qtdEsperado + "parâmetro(s) e foi(ram) passado(s) " + qtdRecebido + ".");
        System.exit(12);
    }

}