// Generated from java-escape by ANTLR 4.11.1

    package parser;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PascalParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PascalParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PascalParser#begin}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBegin(PascalParser.BeginContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(PascalParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalParser#program_pascal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram_pascal(PascalParser.Program_pascalContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalParser#procedure_function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedure_function(PascalParser.Procedure_functionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalParser#const_section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConst_section(PascalParser.Const_sectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalParser#var_section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_section(PascalParser.Var_sectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalParser#var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(PascalParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalParser#procedure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedure(PascalParser.ProcedureContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(PascalParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalParser#parameter_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter_list(PascalParser.Parameter_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(PascalParser.ParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalParser#var_parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_parameter(PascalParser.Var_parameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(PascalParser.ConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(PascalParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(PascalParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(PascalParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalParser#atribution}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtribution(PascalParser.AtributionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expr_call}
	 * labeled alternative in {@link PascalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_call(PascalParser.Expr_callContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expr_equal}
	 * labeled alternative in {@link PascalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_equal(PascalParser.Expr_equalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expr_par}
	 * labeled alternative in {@link PascalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_par(PascalParser.Expr_parContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expr_minus}
	 * labeled alternative in {@link PascalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_minus(PascalParser.Expr_minusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expr_div}
	 * labeled alternative in {@link PascalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_div(PascalParser.Expr_divContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expr_or}
	 * labeled alternative in {@link PascalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_or(PascalParser.Expr_orContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expr_and}
	 * labeled alternative in {@link PascalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_and(PascalParser.Expr_andContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expr_plus}
	 * labeled alternative in {@link PascalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_plus(PascalParser.Expr_plusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expr_not}
	 * labeled alternative in {@link PascalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_not(PascalParser.Expr_notContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expr_id}
	 * labeled alternative in {@link PascalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_id(PascalParser.Expr_idContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expr_array}
	 * labeled alternative in {@link PascalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_array(PascalParser.Expr_arrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalParser#while_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_block(PascalParser.While_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalParser#if_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_block(PascalParser.If_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalParser#call_function_procedure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall_function_procedure(PascalParser.Call_function_procedureContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalParser#write_io}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWrite_io(PascalParser.Write_ioContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalParser#read_io}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRead_io(PascalParser.Read_ioContext ctx);
	/**
	 * Visit a parse tree produced by the {@code type_simple_array_integer}
	 * labeled alternative in {@link PascalParser#type_simple_array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_simple_array_integer(PascalParser.Type_simple_array_integerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code type_simple_array_real}
	 * labeled alternative in {@link PascalParser#type_simple_array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_simple_array_real(PascalParser.Type_simple_array_realContext ctx);
	/**
	 * Visit a parse tree produced by the {@code type_simple_array_boolean}
	 * labeled alternative in {@link PascalParser#type_simple_array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_simple_array_boolean(PascalParser.Type_simple_array_booleanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code type_simple_integer}
	 * labeled alternative in {@link PascalParser#type_simple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_simple_integer(PascalParser.Type_simple_integerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code type_simple_real}
	 * labeled alternative in {@link PascalParser#type_simple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_simple_real(PascalParser.Type_simple_realContext ctx);
	/**
	 * Visit a parse tree produced by the {@code type_simple_boolean}
	 * labeled alternative in {@link PascalParser#type_simple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_simple_boolean(PascalParser.Type_simple_booleanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code type_simple_string}
	 * labeled alternative in {@link PascalParser#type_simple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_simple_string(PascalParser.Type_simple_stringContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalParser#array_type_range}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray_type_range(PascalParser.Array_type_rangeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalParser#array_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray_type(PascalParser.Array_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalParser#acess_array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAcess_array(PascalParser.Acess_arrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalParser#val_simple_array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVal_simple_array(PascalParser.Val_simple_arrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code int_val}
	 * labeled alternative in {@link PascalParser#val_simple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt_val(PascalParser.Int_valContext ctx);
	/**
	 * Visit a parse tree produced by the {@code real_val}
	 * labeled alternative in {@link PascalParser#val_simple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReal_val(PascalParser.Real_valContext ctx);
	/**
	 * Visit a parse tree produced by the {@code string_val}
	 * labeled alternative in {@link PascalParser#val_simple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString_val(PascalParser.String_valContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolean_val}
	 * labeled alternative in {@link PascalParser#val_simple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean_val(PascalParser.Boolean_valContext ctx);
}