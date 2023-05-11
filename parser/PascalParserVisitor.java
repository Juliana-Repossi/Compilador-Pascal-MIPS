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
	 * Visit a parse tree produced by {@link PascalParser#const_var_section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConst_var_section(PascalParser.Const_var_sectionContext ctx);
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
	 * Visit a parse tree produced by {@link PascalParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(PascalParser.ExprContext ctx);
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
	 * Visit a parse tree produced by {@link PascalParser#param_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam_call(PascalParser.Param_callContext ctx);
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
	 * Visit a parse tree produced by {@link PascalParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(PascalParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PascalParser#type_simple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_simple(PascalParser.Type_simpleContext ctx);
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
	 * Visit a parse tree produced by the {@code int_val}
	 * labeled alternative in {@link PascalParser#val}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt_val(PascalParser.Int_valContext ctx);
	/**
	 * Visit a parse tree produced by the {@code real_val}
	 * labeled alternative in {@link PascalParser#val}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReal_val(PascalParser.Real_valContext ctx);
	/**
	 * Visit a parse tree produced by the {@code string_val}
	 * labeled alternative in {@link PascalParser#val}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString_val(PascalParser.String_valContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolean_val}
	 * labeled alternative in {@link PascalParser#val}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean_val(PascalParser.Boolean_valContext ctx);
	/**
	 * Visit a parse tree produced by the {@code accessarray}
	 * labeled alternative in {@link PascalParser#val}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccessarray(PascalParser.AccessarrayContext ctx);
}