package ast;

// Enumeração dos tipos de nós de uma AST.
// Adaptado da versão original em C.
// Algumas pessoas podem preferir criar uma hierarquia de herança para os
// nós para deixar o código "mais OO". Particularmente eu não sou muito
// fã, acho que só complica mais as coisas. Imagine uma classe abstrata AST
// com mais de 20 classes herdando dela, uma classe para cada tipo de nó...
public enum NodeKind {

    I2R_NODE, 
    ASSIGN_NODE, 
    VAR_USE_NODE,
    VAR_USE_ARRAY_NODE, 
    ACCESS_ARRAY_USE_NODE, 
    NOTEQUAL_NODE, 
    EQUAL_NODE, 
    LESSTHAN_NODE, 
    GREATERTHAN_NODE, 
    LEQ_NODE, 
    BEQ_NODE, 
    BLOCK_NODE, 
    BOOL_VAL_NODE, 
    IF_NODE, 
    INT_VAL_NODE, 
    PLUS_NODE, 
    MINUS_NODE, 
    ASTERISK_NODE, 
    SLASH_NODE, 
    MOD_NODE, 
    ONE_MINUS_NODE, 
    PROGRAM_NODE, 
    VAR_LIST_NODE, 
    READ_NODE, 
    WRITE_NODE, 
    WRITELN_NODE, 
    REAL_VAL_NODE, 
    WHILE_NODE, 
    STR_VAL_NODE, 
    VAR_DECL_NODE, 
    ARRAY_DECL_NODE,  
    CALL_FUNCTION_NODE,
    CALL_PROCEDURE_NODE,
    PROCEDURE_NODE, //
    FUNCTION_NODE,//
    PARAMETERS_NODE,
    VAR_PARAMETER_NODE,
    ARRAY_PARAMETER_NODE,
    PROVISORY_NODE, 
    OR_NODE, 
    AND_NODE, 
    NOT_NODE; 
        
	public String toString() {
		switch(this) {
            case I2R_NODE: return "i2r";
            case ASSIGN_NODE : return "assign";
            case VAR_USE_NODE : return "var_use";
            case NOTEQUAL_NODE : return "!=";
            case EQUAL_NODE : return "=";
            case LESSTHAN_NODE : return "<";
            case GREATERTHAN_NODE : return ">";
            case LEQ_NODE : return "<=";
            case BEQ_NODE : return ">=";
            case PLUS_NODE : return "+";
            case MINUS_NODE : return "-";
            case BLOCK_NODE : return "block";
            case BOOL_VAL_NODE : return "bool_val";
            case IF_NODE: return "if";
            case INT_VAL_NODE: return "int_val";
            case ONE_MINUS_NODE:    return "-()";
            case ASTERISK_NODE:    return "*";
            case SLASH_NODE:    return "/";
            case MOD_NODE:    return "%";
            case PROGRAM_NODE:    return "program";
            case VAR_LIST_NODE:    return "var_list";
            case READ_NODE:    return "read";
            case WRITE_NODE:    return "write";
            case WRITELN_NODE: return "writeln";
            case REAL_VAL_NODE:    return "real_val";
            case WHILE_NODE:    return "while";
            case STR_VAL_NODE:    return "str_val";
            case VAR_DECL_NODE:    return "var_decl";
            case CALL_FUNCTION_NODE:    return "call_function";
            case CALL_PROCEDURE_NODE:    return "call_procedure";
            case PROCEDURE_NODE:    return "procedure";
            case FUNCTION_NODE:    return "function";
            case PARAMETERS_NODE:    return "parameters";
            case VAR_PARAMETER_NODE:    return "var_parameter";
            case ARRAY_PARAMETER_NODE:  return "array_parameter";
            case ACCESS_ARRAY_USE_NODE : return "access_array_use_node";
            case ARRAY_DECL_NODE : return "array_decl";
            case PROVISORY_NODE:    return "provisory_node";
            case OR_NODE:    return "or";
            case AND_NODE:    return "and";
            case NOT_NODE:    return "not";

			default:
				System.err.println("ERROR: Fall through in NodeKind enumeration!");
				System.exit(1);
				return ""; // Never reached.
		}
	}

	public static boolean hasData(NodeKind kind) {
		switch(kind) {
	        case BOOL_VAL_NODE:
	        case INT_VAL_NODE:
	        case REAL_VAL_NODE:
	        case STR_VAL_NODE:
	        case VAR_DECL_NODE:
	        case VAR_USE_NODE:
            case ARRAY_DECL_NODE:
            case ACCESS_ARRAY_USE_NODE:
            case PROCEDURE_NODE:
            case FUNCTION_NODE:
            case VAR_PARAMETER_NODE:
            case ARRAY_PARAMETER_NODE:
            case CALL_FUNCTION_NODE:
            case CALL_PROCEDURE_NODE:
	            return true;
	        default:
	            return false;
		}
	}
}
