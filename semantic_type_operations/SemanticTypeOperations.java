package semantic_type_operations;

import types.Type;
import error.MsgErros;

public final class SemanticTypeOperations {

    public static Type getTypeReturnByOperation(Type type1, Type type2, String op){
        switch(op){
            case "+":
                return typesSum(type1, type2);
            case "-":
                return typesMinus(type1,type2);
            case "*":
                return typesTimes(type1, type2);
            case "/":
                return typesOver(type1, type2);
            case "<":
            case ">":
            case "<=":
            case ">=":
            case "=":
            case "<>":
                return typesComparation(type1, type2);
            case "mod":
                return typesMod(type1, type2);
            default:
                System.out.println("OPERADOR: (" + op + ")");
                MsgErros.operadorInvalido(op);
        }

        return null;
    }

    public static Boolean  typesAtribution(Type type1, Type type2){

        if (type1 == type2 ){
            return true;
        }
        else if (type1 == Type.REAL && type2 == Type.INTEGER){
            return true;
        }
        else{
            return null;
        }
    }

    private static Type typesSum(Type type1, Type type2){

        if(type1 == Type.STRING && type2 == Type.STRING){
            return Type.STRING;
        }
        else if (type1 == Type.INTEGER && type2 == Type.INTEGER){
            return Type.INTEGER;
        }
        else if (type1 == Type.REAL && type2 == Type.REAL){
            return Type.REAL;
        }
        else if (type1 == Type.INTEGER && type2 == Type.REAL || type1 == Type.REAL && type2 == Type.INTEGER){
            return Type.REAL;
        }
        else{
            return null;
        }
    }

    private static Type  typesMinus(Type type1, Type type2){

        if (type1 == Type.INTEGER && type2 == Type.INTEGER){
            return Type.INTEGER;
        }
        else if (type1 == Type.REAL && type2 == Type.REAL){
            return Type.REAL;
        }
        else if (type1 == Type.INTEGER && type2 == Type.REAL || type1 == Type.REAL && type2 == Type.INTEGER){
            return Type.REAL;
        }
        else{
            return null;
        }

    }

    private static Type  typesTimes(Type type1, Type type2){

        if (type1 == Type.INTEGER && type2 == Type.INTEGER){
            return Type.INTEGER;
        }
        else if (type1 == Type.REAL && type2 == Type.REAL){
            return Type.REAL;
        }
        else if (type1 == Type.INTEGER && type2 == Type.REAL || type1 == Type.REAL && type2 == Type.INTEGER){
            return Type.REAL;
        }
        else{
            return null;
        }

    }

    private static Type  typesOver(Type type1, Type type2){

        if (type1 == Type.INTEGER && type2 == Type.INTEGER){
            return Type.REAL;
        }
        else if (type1 == Type.REAL && type2 == Type.REAL){
            return Type.REAL;
        }
        else if (type1 == Type.INTEGER && type2 == Type.REAL || type1 == Type.REAL && type2 == Type.INTEGER){
            return Type.REAL;
        }
        else{
            return null;
        }
    }

    private static Type typesComparation(Type type1, Type type2){

        if (type1 == type2 ){
            return Type.BOOLEAN;
        }
        else if (type1 == Type.INTEGER && type2 == Type.REAL || type1 == Type.REAL && type2 == Type.INTEGER){
            return Type.BOOLEAN;
        }
        else{
            return null;
        }
    }


    private static Type typesMod(Type type1, Type type2) {
        if(type1 == type2 && type1 == Type.INTEGER) {
            return Type.INTEGER;
        }

        return null;
    }
}