package ast;

/*
 * Classe abstrata que define a interface do visitor para a AST.
 * Implementa o despacho do método 'visit' conforme o 'kind' do nó.
 * Com isso, basta herdar desta classe para criar um interpretador
 * ou gerador de código.
 */
public abstract class ASTBaseVisitor<T> {
	// Único método público. Começa a visita a partir do nó raiz
	// passado. Precisa ter outro nome porque tem a mesma assinatura
	// que o método "genérico" 'visit'.
	public void execute(AST root) {
		visit(root);
	}
	
	// Método "genérico" que despacha a visitação para os métodos
	// especializados conforme o 'kind' do nó atual. Igual ao código
	// em C. Novamente fica o argumento sobre usar OO ou não aqui.
	// Se tivéssemos trocentas classes especializando o nó da AST
	// esse despacho seria feito pela JVM. Aqui precisa fazer na mão.
	// Por outro lado, assim não precisa de trocentas classes com o
	// código todo espalhado entre elas...
	protected T visit(AST node) {
		switch(node.kind) {
			case I2R_NODE: return visit_I2R_node(node);
			case ASSIGN_NODE: return visit_assign_node(node);
			case VAR_USE_NODE: return visit_var_list_node(node);
			case ACCESS_ARRAY_USE_NODE: return visit_access_array_use_node(node);
			case NOTEQUAL_NODE: return visit_not_equal_node(node);
			case EQUAL_NODE: return visit_equal_node(node);
			case LESSTHAN_NODE: return visit_less_than_node(node);
			case GREATERTHAN_NODE: return visit_greater_than_node(node);
			case LEQ_NODE: return visit_LEQ_node(node);
			case BEQ_NODE: return visit_BEQ_node(node);
			case BLOCK_NODE: return visit_block_node(node);
			case BOOL_VAL_NODE: return visit_bool_val_node(node);
			case IF_NODE: return visit_if_node(node);
			case INT_VAL_NODE: return visit_int_val_node(node);
			case PLUS_NODE: return visit_plus_node(node);
			case MINUS_NODE: return visit_minus_node(node);
			case ASTERISK_NODE: return visit_asterisk_node(node);
			case SLASH_NODE: return visit_slash_node(node);
			case MOD_NODE: return visit_mod_node(node);
			case ONE_MINUS_NODE: return visit_one_minus_node(node);
			case PROGRAM_NODE: return visit_program_node(node);
			case VAR_LIST_NODE: return visit_var_list_node(node);
			case READ_NODE: return visit_read_node(node);
			case WRITE_NODE: return visit_write_node(node);
			case WRITELN_NODE: return visit_writeln_node(node);
			case REAL_VAL_NODE: return visit_real_val_node(node);
			case WHILE_NODE: return visit_while_node(node);
			case STR_VAL_NODE: return visit_str_val_node(node);
			case VAR_DECL_NODE: return visit_var_decl_node(node);
			case ARRAY_DECL_NODE: return visit_array_decl_node(node);
			case CALL_FUNCTION_NODE: return visit_call_function_node(node);
			case CALL_PROCEDURE_NODE: return visit_call_procedure_node(node);
			case PROCEDURE_NODE: return visit_procedure_node(node);
			case FUNCTION_NODE: return visit_function_node(node);
			case PARAMETERS_NODE: return visit_parameters_node(node);
			case VAR_PARAMETER_NODE: return visit_var_pararameter_node(node);
			case ARRAY_PARAMETER_NODE: return visit_array_parameter_node(node);
			case PROVISORY_NODE: return visit_provisory_node(node);
			case OR_NODE: return visit_or_node(node);
			case AND_NODE : return visit_and_node(node);
			case NOT_NODE : return visit_not_node(node);
	
			default:
				System.err.printf("Invalid kind: %s!\n", node.kind.toString());
				System.exit(1);
				return null;
		}
	}
	
	// Métodos especializados para visitar um nó com um certo 'kind'.
	protected abstract T visit_I2R_node(AST node);
	protected abstract T visit_assign_node(AST node);
	protected abstract T visit_var_use_node(AST node);
	protected abstract T visit_access_array_use_node(AST node);
	protected abstract T visit_not_equal_node(AST node);
	protected abstract T visit_equal_node(AST node);
	protected abstract T visit_less_than_node(AST node);
	protected abstract T visit_greater_than_node(AST node);
	protected abstract T visit_LEQ_node(AST node);
	protected abstract T visit_BEQ_node(AST node);
	protected abstract T visit_block_node(AST node);
	protected abstract T visit_bool_val_node(AST node);
	protected abstract T visit_if_node(AST node);
	protected abstract T visit_int_val_node(AST node);
	protected abstract T visit_plus_node(AST node);
	protected abstract T visit_minus_node(AST node);
	protected abstract T visit_asterisk_node(AST node);
	protected abstract T visit_slash_node(AST node);
	protected abstract T visit_mod_node(AST node);
	protected abstract T visit_one_minus_node(AST node);
	protected abstract T visit_program_node(AST node);
	protected abstract T visit_var_list_node(AST node);
	protected abstract T visit_read_node(AST node);
	protected abstract T visit_write_node(AST node);
	protected abstract T visit_writeln_node(AST node);
	protected abstract T visit_real_val_node(AST node);
	protected abstract T visit_while_node(AST node);
	protected abstract T visit_str_val_node(AST node);
	protected abstract T visit_var_decl_node(AST node);
	protected abstract T visit_not_node(AST node);
	protected abstract T visit_and_node(AST node);
	protected abstract T visit_or_node(AST node);
	protected abstract T visit_provisory_node(AST node);
	protected abstract T visit_array_parameter_node(AST node);
	protected abstract T visit_var_pararameter_node(AST node);
	protected abstract T visit_parameters_node(AST node);
	protected abstract T visit_function_node(AST node);
	protected abstract T visit_procedure_node(AST node);
	protected abstract T visit_call_procedure_node(AST node);
	protected abstract T visit_call_function_node(AST node);
	protected abstract T visit_array_decl_node(AST node);
}
	