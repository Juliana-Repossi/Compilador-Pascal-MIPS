package error;

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
}