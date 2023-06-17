// Generated from /home/filipe/git/Compilador-Pascal-MIPS/PascalParser.g by ANTLR 4.9.2

    package parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PascalParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, COMMENT=2, PROGRAM=3, CONST=4, VAR=5, BEGIN=6, END=7, FUNCTION=8, 
		PROCEDURE=9, INTEGER=10, REAL=11, BOOLEAN=12, STRING=13, ARRAY=14, RANGE=15, 
		OF=16, IF=17, THEN=18, ELSE=19, WHILE=20, DO=21, AND=22, OR=23, NOT=24, 
		PLUS=25, MINUS=26, ASTERISK=27, SLASH=28, EQUAL=29, LESSTHAN=30, GREATERTHAN=31, 
		LBRACK=32, RBRACK=33, PERIOD=34, COMMA=35, COLON=36, SEMICOLON=37, LPAR=38, 
		RPAR=39, NOTEQUAL=40, LEQ=41, BEQ=42, BECOMES=43, MOD=44, READ=45, WRITE=46, 
		WRITELN=47, INT_VAL=48, REAL_VAL=49, BOOLEAN_VAL=50, STRING_VAL=51, ID=52, 
		UNKNOWN=53;
	public static final int
		RULE_begin = 0, RULE_program = 1, RULE_program_pascal = 2, RULE_procedure_function = 3, 
		RULE_const_section = 4, RULE_var_section = 5, RULE_var = 6, RULE_procedure = 7, 
		RULE_function = 8, RULE_parameter_list = 9, RULE_parameters = 10, RULE_var_parameter = 11, 
		RULE_constant = 12, RULE_parameter = 13, RULE_block = 14, RULE_statement = 15, 
		RULE_atribution = 16, RULE_expr = 17, RULE_while_block = 18, RULE_if_block = 19, 
		RULE_call_function_procedure = 20, RULE_write_io = 21, RULE_read_io = 22, 
		RULE_type_simple_array = 23, RULE_type_simple = 24, RULE_array_type_range = 25, 
		RULE_array_type = 26, RULE_acess_array = 27, RULE_val_simple_array = 28, 
		RULE_val_simple = 29;
	private static String[] makeRuleNames() {
		return new String[] {
			"begin", "program", "program_pascal", "procedure_function", "const_section", 
			"var_section", "var", "procedure", "function", "parameter_list", "parameters", 
			"var_parameter", "constant", "parameter", "block", "statement", "atribution", 
			"expr", "while_block", "if_block", "call_function_procedure", "write_io", 
			"read_io", "type_simple_array", "type_simple", "array_type_range", "array_type", 
			"acess_array", "val_simple_array", "val_simple"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'program'", "'const'", "'var'", "'begin'", "'end'", 
			"'function'", "'procedure'", "'integer'", "'real'", "'boolean'", "'string'", 
			"'array'", "'..'", "'of'", "'if'", "'then'", "'else'", "'while'", "'do'", 
			"'and'", "'or'", "'not'", "'+'", "'-'", "'*'", "'/'", "'='", "'<'", "'>'", 
			"'['", "']'", "'.'", "','", "':'", "';'", "'('", "')'", "'<>'", "'<='", 
			"'>='", "':='", "'mod'", "'read'", "'write'", "'writeln'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WS", "COMMENT", "PROGRAM", "CONST", "VAR", "BEGIN", "END", "FUNCTION", 
			"PROCEDURE", "INTEGER", "REAL", "BOOLEAN", "STRING", "ARRAY", "RANGE", 
			"OF", "IF", "THEN", "ELSE", "WHILE", "DO", "AND", "OR", "NOT", "PLUS", 
			"MINUS", "ASTERISK", "SLASH", "EQUAL", "LESSTHAN", "GREATERTHAN", "LBRACK", 
			"RBRACK", "PERIOD", "COMMA", "COLON", "SEMICOLON", "LPAR", "RPAR", "NOTEQUAL", 
			"LEQ", "BEQ", "BECOMES", "MOD", "READ", "WRITE", "WRITELN", "INT_VAL", 
			"REAL_VAL", "BOOLEAN_VAL", "STRING_VAL", "ID", "UNKNOWN"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "PascalParser.g"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PascalParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class BeginContext extends ParserRuleContext {
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public BeginContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_begin; }
	}

	public final BeginContext begin() throws RecognitionException {
		BeginContext _localctx = new BeginContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_begin);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			program();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode PROGRAM() { return getToken(PascalParser.PROGRAM, 0); }
		public TerminalNode ID() { return getToken(PascalParser.ID, 0); }
		public TerminalNode SEMICOLON() { return getToken(PascalParser.SEMICOLON, 0); }
		public Program_pascalContext program_pascal() {
			return getRuleContext(Program_pascalContext.class,0);
		}
		public TerminalNode PERIOD() { return getToken(PascalParser.PERIOD, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(PROGRAM);
			setState(63);
			match(ID);
			setState(64);
			match(SEMICOLON);
			setState(65);
			program_pascal();
			setState(66);
			match(PERIOD);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Program_pascalContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Var_sectionContext var_section() {
			return getRuleContext(Var_sectionContext.class,0);
		}
		public Const_sectionContext const_section() {
			return getRuleContext(Const_sectionContext.class,0);
		}
		public List<Procedure_functionContext> procedure_function() {
			return getRuleContexts(Procedure_functionContext.class);
		}
		public Procedure_functionContext procedure_function(int i) {
			return getRuleContext(Procedure_functionContext.class,i);
		}
		public Program_pascalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program_pascal; }
	}

	public final Program_pascalContext program_pascal() throws RecognitionException {
		Program_pascalContext _localctx = new Program_pascalContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_program_pascal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VAR) {
				{
				setState(68);
				var_section();
				}
			}

			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONST) {
				{
				setState(71);
				const_section();
				}
			}

			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FUNCTION || _la==PROCEDURE) {
				{
				{
				setState(74);
				procedure_function();
				}
				}
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(80);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Procedure_functionContext extends ParserRuleContext {
		public ProcedureContext procedure() {
			return getRuleContext(ProcedureContext.class,0);
		}
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public Procedure_functionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procedure_function; }
	}

	public final Procedure_functionContext procedure_function() throws RecognitionException {
		Procedure_functionContext _localctx = new Procedure_functionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_procedure_function);
		try {
			setState(84);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PROCEDURE:
				enterOuterAlt(_localctx, 1);
				{
				setState(82);
				procedure();
				}
				break;
			case FUNCTION:
				enterOuterAlt(_localctx, 2);
				{
				setState(83);
				function();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Const_sectionContext extends ParserRuleContext {
		public TerminalNode CONST() { return getToken(PascalParser.CONST, 0); }
		public List<TerminalNode> ID() { return getTokens(PascalParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PascalParser.ID, i);
		}
		public List<TerminalNode> EQUAL() { return getTokens(PascalParser.EQUAL); }
		public TerminalNode EQUAL(int i) {
			return getToken(PascalParser.EQUAL, i);
		}
		public List<Val_simpleContext> val_simple() {
			return getRuleContexts(Val_simpleContext.class);
		}
		public Val_simpleContext val_simple(int i) {
			return getRuleContext(Val_simpleContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(PascalParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(PascalParser.SEMICOLON, i);
		}
		public Const_sectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_const_section; }
	}

	public final Const_sectionContext const_section() throws RecognitionException {
		Const_sectionContext _localctx = new Const_sectionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_const_section);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(CONST);
			setState(92); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(87);
				match(ID);
				setState(88);
				match(EQUAL);
				setState(89);
				val_simple();
				setState(90);
				match(SEMICOLON);
				}
				}
				setState(94); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Var_sectionContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(PascalParser.VAR, 0); }
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(PascalParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(PascalParser.SEMICOLON, i);
		}
		public Var_sectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_section; }
	}

	public final Var_sectionContext var_section() throws RecognitionException {
		Var_sectionContext _localctx = new Var_sectionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_var_section);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(VAR);
			setState(100); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(97);
				var();
				setState(98);
				match(SEMICOLON);
				}
				}
				setState(102); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(PascalParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PascalParser.ID, i);
		}
		public TerminalNode COLON() { return getToken(PascalParser.COLON, 0); }
		public Type_simpleContext type_simple() {
			return getRuleContext(Type_simpleContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(PascalParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PascalParser.COMMA, i);
		}
		public Array_type_rangeContext array_type_range() {
			return getRuleContext(Array_type_rangeContext.class,0);
		}
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_var);
		int _la;
		try {
			setState(124);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(104);
				match(ID);
				setState(109);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(105);
					match(COMMA);
					setState(106);
					match(ID);
					}
					}
					setState(111);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(112);
				match(COLON);
				setState(113);
				type_simple();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(114);
				match(ID);
				setState(119);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(115);
					match(COMMA);
					setState(116);
					match(ID);
					}
					}
					setState(121);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(122);
				match(COLON);
				setState(123);
				array_type_range();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProcedureContext extends ParserRuleContext {
		public TerminalNode PROCEDURE() { return getToken(PascalParser.PROCEDURE, 0); }
		public TerminalNode ID() { return getToken(PascalParser.ID, 0); }
		public Parameter_listContext parameter_list() {
			return getRuleContext(Parameter_listContext.class,0);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(PascalParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(PascalParser.SEMICOLON, i);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Var_sectionContext var_section() {
			return getRuleContext(Var_sectionContext.class,0);
		}
		public Const_sectionContext const_section() {
			return getRuleContext(Const_sectionContext.class,0);
		}
		public ProcedureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procedure; }
	}

	public final ProcedureContext procedure() throws RecognitionException {
		ProcedureContext _localctx = new ProcedureContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_procedure);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(PROCEDURE);
			setState(127);
			match(ID);
			setState(128);
			parameter_list();
			setState(129);
			match(SEMICOLON);
			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VAR) {
				{
				setState(130);
				var_section();
				}
			}

			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONST) {
				{
				setState(133);
				const_section();
				}
			}

			setState(136);
			block();
			setState(137);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionContext extends ParserRuleContext {
		public TerminalNode FUNCTION() { return getToken(PascalParser.FUNCTION, 0); }
		public TerminalNode ID() { return getToken(PascalParser.ID, 0); }
		public Parameter_listContext parameter_list() {
			return getRuleContext(Parameter_listContext.class,0);
		}
		public TerminalNode COLON() { return getToken(PascalParser.COLON, 0); }
		public Type_simpleContext type_simple() {
			return getRuleContext(Type_simpleContext.class,0);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(PascalParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(PascalParser.SEMICOLON, i);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Var_sectionContext var_section() {
			return getRuleContext(Var_sectionContext.class,0);
		}
		public Const_sectionContext const_section() {
			return getRuleContext(Const_sectionContext.class,0);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			match(FUNCTION);
			setState(140);
			match(ID);
			setState(141);
			parameter_list();
			setState(142);
			match(COLON);
			setState(143);
			type_simple();
			setState(144);
			match(SEMICOLON);
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VAR) {
				{
				setState(145);
				var_section();
				}
			}

			setState(149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONST) {
				{
				setState(148);
				const_section();
				}
			}

			setState(151);
			block();
			setState(152);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Parameter_listContext extends ParserRuleContext {
		public TerminalNode LPAR() { return getToken(PascalParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(PascalParser.RPAR, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public Parameter_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter_list; }
	}

	public final Parameter_listContext parameter_list() throws RecognitionException {
		Parameter_listContext _localctx = new Parameter_listContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_parameter_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			match(LPAR);
			setState(156);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONST || _la==ID) {
				{
				setState(155);
				parameters();
				}
			}

			setState(158);
			match(RPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParametersContext extends ParserRuleContext {
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(PascalParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(PascalParser.SEMICOLON, i);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			parameter();
			setState(165);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEMICOLON) {
				{
				{
				setState(161);
				match(SEMICOLON);
				setState(162);
				parameter();
				}
				}
				setState(167);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Var_parameterContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(PascalParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PascalParser.ID, i);
		}
		public TerminalNode COLON() { return getToken(PascalParser.COLON, 0); }
		public Type_simpleContext type_simple() {
			return getRuleContext(Type_simpleContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(PascalParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PascalParser.COMMA, i);
		}
		public Array_typeContext array_type() {
			return getRuleContext(Array_typeContext.class,0);
		}
		public Var_parameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_parameter; }
	}

	public final Var_parameterContext var_parameter() throws RecognitionException {
		Var_parameterContext _localctx = new Var_parameterContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_var_parameter);
		int _la;
		try {
			setState(188);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(168);
				match(ID);
				setState(173);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(169);
					match(COMMA);
					setState(170);
					match(ID);
					}
					}
					setState(175);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(176);
				match(COLON);
				setState(177);
				type_simple();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(178);
				match(ID);
				setState(183);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(179);
					match(COMMA);
					setState(180);
					match(ID);
					}
					}
					setState(185);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(186);
				match(COLON);
				setState(187);
				array_type();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantContext extends ParserRuleContext {
		public TerminalNode CONST() { return getToken(PascalParser.CONST, 0); }
		public TerminalNode ID() { return getToken(PascalParser.ID, 0); }
		public TerminalNode COLON() { return getToken(PascalParser.COLON, 0); }
		public Type_simpleContext type_simple() {
			return getRuleContext(Type_simpleContext.class,0);
		}
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_constant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			match(CONST);
			setState(191);
			match(ID);
			setState(192);
			match(COLON);
			setState(193);
			type_simple();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterContext extends ParserRuleContext {
		public Var_parameterContext var_parameter() {
			return getRuleContext(Var_parameterContext.class,0);
		}
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_parameter);
		try {
			setState(197);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(195);
				var_parameter();
				}
				break;
			case CONST:
				enterOuterAlt(_localctx, 2);
				{
				setState(196);
				constant();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode BEGIN() { return getToken(PascalParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(PascalParser.END, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(PascalParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(PascalParser.SEMICOLON, i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			match(BEGIN);
			setState(205);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << READ) | (1L << WRITE) | (1L << WRITELN) | (1L << ID))) != 0)) {
				{
				{
				setState(200);
				statement();
				setState(201);
				match(SEMICOLON);
				}
				}
				setState(207);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(208);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public AtributionContext atribution() {
			return getRuleContext(AtributionContext.class,0);
		}
		public While_blockContext while_block() {
			return getRuleContext(While_blockContext.class,0);
		}
		public If_blockContext if_block() {
			return getRuleContext(If_blockContext.class,0);
		}
		public Call_function_procedureContext call_function_procedure() {
			return getRuleContext(Call_function_procedureContext.class,0);
		}
		public Read_ioContext read_io() {
			return getRuleContext(Read_ioContext.class,0);
		}
		public Write_ioContext write_io() {
			return getRuleContext(Write_ioContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_statement);
		try {
			setState(216);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(210);
				atribution();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(211);
				while_block();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(212);
				if_block();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(213);
				call_function_procedure();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(214);
				read_io();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(215);
				write_io();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtributionContext extends ParserRuleContext {
		public TerminalNode BECOMES() { return getToken(PascalParser.BECOMES, 0); }
		public TerminalNode ID() { return getToken(PascalParser.ID, 0); }
		public Acess_arrayContext acess_array() {
			return getRuleContext(Acess_arrayContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AtributionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atribution; }
	}

	public final AtributionContext atribution() throws RecognitionException {
		AtributionContext _localctx = new AtributionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_atribution);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(218);
				match(ID);
				}
				break;
			case 2:
				{
				setState(219);
				acess_array();
				}
				break;
			}
			setState(222);
			match(BECOMES);
			{
			setState(223);
			expr(0);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Expr_callContext extends ExprContext {
		public Call_function_procedureContext call_function_procedure() {
			return getRuleContext(Call_function_procedureContext.class,0);
		}
		public Expr_callContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Expr_equalContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode NOTEQUAL() { return getToken(PascalParser.NOTEQUAL, 0); }
		public TerminalNode EQUAL() { return getToken(PascalParser.EQUAL, 0); }
		public TerminalNode LESSTHAN() { return getToken(PascalParser.LESSTHAN, 0); }
		public TerminalNode GREATERTHAN() { return getToken(PascalParser.GREATERTHAN, 0); }
		public TerminalNode LEQ() { return getToken(PascalParser.LEQ, 0); }
		public TerminalNode BEQ() { return getToken(PascalParser.BEQ, 0); }
		public Expr_equalContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Expr_parContext extends ExprContext {
		public TerminalNode LPAR() { return getToken(PascalParser.LPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(PascalParser.RPAR, 0); }
		public Expr_parContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Expr_minusContext extends ExprContext {
		public TerminalNode MINUS() { return getToken(PascalParser.MINUS, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Expr_minusContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Expr_divContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode ASTERISK() { return getToken(PascalParser.ASTERISK, 0); }
		public TerminalNode SLASH() { return getToken(PascalParser.SLASH, 0); }
		public TerminalNode MOD() { return getToken(PascalParser.MOD, 0); }
		public Expr_divContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Expr_orContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OR() { return getToken(PascalParser.OR, 0); }
		public Expr_orContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Expr_andContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode AND() { return getToken(PascalParser.AND, 0); }
		public Expr_andContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Expr_plusContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(PascalParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(PascalParser.MINUS, 0); }
		public Expr_plusContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Expr_notContext extends ExprContext {
		public TerminalNode NOT() { return getToken(PascalParser.NOT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Expr_notContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Expr_idContext extends ExprContext {
		public TerminalNode ID() { return getToken(PascalParser.ID, 0); }
		public Expr_idContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Expr_arrayContext extends ExprContext {
		public Val_simple_arrayContext val_simple_array() {
			return getRuleContext(Val_simple_arrayContext.class,0);
		}
		public Expr_arrayContext(ExprContext ctx) { copyFrom(ctx); }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				_localctx = new Expr_parContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(226);
				match(LPAR);
				setState(227);
				expr(0);
				setState(228);
				match(RPAR);
				}
				break;
			case 2:
				{
				_localctx = new Expr_notContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(230);
				match(NOT);
				setState(231);
				expr(10);
				}
				break;
			case 3:
				{
				_localctx = new Expr_minusContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(232);
				match(MINUS);
				setState(233);
				expr(9);
				}
				break;
			case 4:
				{
				_localctx = new Expr_idContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(234);
				match(ID);
				}
				break;
			case 5:
				{
				_localctx = new Expr_callContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(235);
				call_function_procedure();
				}
				break;
			case 6:
				{
				_localctx = new Expr_arrayContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(236);
				val_simple_array();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(256);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(254);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
					case 1:
						{
						_localctx = new Expr_divContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(239);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(240);
						((Expr_divContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ASTERISK) | (1L << SLASH) | (1L << MOD))) != 0)) ) {
							((Expr_divContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(241);
						expr(9);
						}
						break;
					case 2:
						{
						_localctx = new Expr_andContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(242);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(243);
						match(AND);
						setState(244);
						expr(8);
						}
						break;
					case 3:
						{
						_localctx = new Expr_plusContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(245);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(246);
						((Expr_plusContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
							((Expr_plusContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(247);
						expr(7);
						}
						break;
					case 4:
						{
						_localctx = new Expr_orContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(248);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(249);
						match(OR);
						setState(250);
						expr(6);
						}
						break;
					case 5:
						{
						_localctx = new Expr_equalContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(251);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(252);
						((Expr_equalContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQUAL) | (1L << LESSTHAN) | (1L << GREATERTHAN) | (1L << NOTEQUAL) | (1L << LEQ) | (1L << BEQ))) != 0)) ) {
							((Expr_equalContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(253);
						expr(5);
						}
						break;
					}
					} 
				}
				setState(258);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class While_blockContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(PascalParser.WHILE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode DO() { return getToken(PascalParser.DO, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public While_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_block; }
	}

	public final While_blockContext while_block() throws RecognitionException {
		While_blockContext _localctx = new While_blockContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_while_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			match(WHILE);
			setState(260);
			expr(0);
			setState(261);
			match(DO);
			setState(262);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class If_blockContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(PascalParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode THEN() { return getToken(PascalParser.THEN, 0); }
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(PascalParser.ELSE, 0); }
		public If_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_block; }
	}

	public final If_blockContext if_block() throws RecognitionException {
		If_blockContext _localctx = new If_blockContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_if_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			match(IF);
			setState(265);
			expr(0);
			setState(266);
			match(THEN);
			setState(267);
			block();
			setState(270);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(268);
				match(ELSE);
				setState(269);
				block();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Call_function_procedureContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PascalParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(PascalParser.LPAR, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RPAR() { return getToken(PascalParser.RPAR, 0); }
		public List<TerminalNode> COMMA() { return getTokens(PascalParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PascalParser.COMMA, i);
		}
		public Call_function_procedureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call_function_procedure; }
	}

	public final Call_function_procedureContext call_function_procedure() throws RecognitionException {
		Call_function_procedureContext _localctx = new Call_function_procedureContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_call_function_procedure);
		int _la;
		try {
			setState(287);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(272);
				match(ID);
				setState(273);
				match(LPAR);
				setState(274);
				expr(0);
				setState(279);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(275);
					match(COMMA);
					setState(276);
					expr(0);
					}
					}
					setState(281);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(282);
				match(RPAR);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(284);
				match(ID);
				setState(285);
				match(LPAR);
				setState(286);
				match(RPAR);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Write_ioContext extends ParserRuleContext {
		public TerminalNode LPAR() { return getToken(PascalParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(PascalParser.RPAR, 0); }
		public TerminalNode WRITE() { return getToken(PascalParser.WRITE, 0); }
		public TerminalNode WRITELN() { return getToken(PascalParser.WRITELN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Write_ioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_write_io; }
	}

	public final Write_ioContext write_io() throws RecognitionException {
		Write_ioContext _localctx = new Write_ioContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_write_io);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(289);
			_la = _input.LA(1);
			if ( !(_la==WRITE || _la==WRITELN) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(290);
			match(LPAR);
			{
			setState(291);
			expr(0);
			}
			setState(292);
			match(RPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Read_ioContext extends ParserRuleContext {
		public TerminalNode READ() { return getToken(PascalParser.READ, 0); }
		public TerminalNode LPAR() { return getToken(PascalParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(PascalParser.RPAR, 0); }
		public TerminalNode ID() { return getToken(PascalParser.ID, 0); }
		public Acess_arrayContext acess_array() {
			return getRuleContext(Acess_arrayContext.class,0);
		}
		public Read_ioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_read_io; }
	}

	public final Read_ioContext read_io() throws RecognitionException {
		Read_ioContext _localctx = new Read_ioContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_read_io);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			match(READ);
			setState(295);
			match(LPAR);
			setState(298);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				setState(296);
				match(ID);
				}
				break;
			case 2:
				{
				setState(297);
				acess_array();
				}
				break;
			}
			setState(300);
			match(RPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Type_simple_arrayContext extends ParserRuleContext {
		public Type_simple_arrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_simple_array; }
	 
		public Type_simple_arrayContext() { }
		public void copyFrom(Type_simple_arrayContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Type_simple_array_realContext extends Type_simple_arrayContext {
		public TerminalNode REAL() { return getToken(PascalParser.REAL, 0); }
		public Type_simple_array_realContext(Type_simple_arrayContext ctx) { copyFrom(ctx); }
	}
	public static class Type_simple_array_integerContext extends Type_simple_arrayContext {
		public TerminalNode INTEGER() { return getToken(PascalParser.INTEGER, 0); }
		public Type_simple_array_integerContext(Type_simple_arrayContext ctx) { copyFrom(ctx); }
	}
	public static class Type_simple_array_booleanContext extends Type_simple_arrayContext {
		public TerminalNode BOOLEAN() { return getToken(PascalParser.BOOLEAN, 0); }
		public Type_simple_array_booleanContext(Type_simple_arrayContext ctx) { copyFrom(ctx); }
	}

	public final Type_simple_arrayContext type_simple_array() throws RecognitionException {
		Type_simple_arrayContext _localctx = new Type_simple_arrayContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_type_simple_array);
		try {
			setState(305);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER:
				_localctx = new Type_simple_array_integerContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(302);
				match(INTEGER);
				}
				break;
			case REAL:
				_localctx = new Type_simple_array_realContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(303);
				match(REAL);
				}
				break;
			case BOOLEAN:
				_localctx = new Type_simple_array_booleanContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(304);
				match(BOOLEAN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Type_simpleContext extends ParserRuleContext {
		public Type_simpleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_simple; }
	 
		public Type_simpleContext() { }
		public void copyFrom(Type_simpleContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Type_simple_stringContext extends Type_simpleContext {
		public TerminalNode STRING() { return getToken(PascalParser.STRING, 0); }
		public Type_simple_stringContext(Type_simpleContext ctx) { copyFrom(ctx); }
	}
	public static class Type_simple_integerContext extends Type_simpleContext {
		public TerminalNode INTEGER() { return getToken(PascalParser.INTEGER, 0); }
		public Type_simple_integerContext(Type_simpleContext ctx) { copyFrom(ctx); }
	}
	public static class Type_simple_realContext extends Type_simpleContext {
		public TerminalNode REAL() { return getToken(PascalParser.REAL, 0); }
		public Type_simple_realContext(Type_simpleContext ctx) { copyFrom(ctx); }
	}
	public static class Type_simple_booleanContext extends Type_simpleContext {
		public TerminalNode BOOLEAN() { return getToken(PascalParser.BOOLEAN, 0); }
		public Type_simple_booleanContext(Type_simpleContext ctx) { copyFrom(ctx); }
	}

	public final Type_simpleContext type_simple() throws RecognitionException {
		Type_simpleContext _localctx = new Type_simpleContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_type_simple);
		try {
			setState(311);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER:
				_localctx = new Type_simple_integerContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(307);
				match(INTEGER);
				}
				break;
			case REAL:
				_localctx = new Type_simple_realContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(308);
				match(REAL);
				}
				break;
			case BOOLEAN:
				_localctx = new Type_simple_booleanContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(309);
				match(BOOLEAN);
				}
				break;
			case STRING:
				_localctx = new Type_simple_stringContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(310);
				match(STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Array_type_rangeContext extends ParserRuleContext {
		public TerminalNode ARRAY() { return getToken(PascalParser.ARRAY, 0); }
		public TerminalNode LBRACK() { return getToken(PascalParser.LBRACK, 0); }
		public List<TerminalNode> INT_VAL() { return getTokens(PascalParser.INT_VAL); }
		public TerminalNode INT_VAL(int i) {
			return getToken(PascalParser.INT_VAL, i);
		}
		public TerminalNode RANGE() { return getToken(PascalParser.RANGE, 0); }
		public TerminalNode RBRACK() { return getToken(PascalParser.RBRACK, 0); }
		public TerminalNode OF() { return getToken(PascalParser.OF, 0); }
		public Type_simple_arrayContext type_simple_array() {
			return getRuleContext(Type_simple_arrayContext.class,0);
		}
		public Array_type_rangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_type_range; }
	}

	public final Array_type_rangeContext array_type_range() throws RecognitionException {
		Array_type_rangeContext _localctx = new Array_type_rangeContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_array_type_range);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(313);
			match(ARRAY);
			setState(314);
			match(LBRACK);
			setState(315);
			match(INT_VAL);
			setState(316);
			match(RANGE);
			setState(317);
			match(INT_VAL);
			setState(318);
			match(RBRACK);
			setState(319);
			match(OF);
			setState(320);
			type_simple_array();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Array_typeContext extends ParserRuleContext {
		public TerminalNode ARRAY() { return getToken(PascalParser.ARRAY, 0); }
		public TerminalNode OF() { return getToken(PascalParser.OF, 0); }
		public Type_simple_arrayContext type_simple_array() {
			return getRuleContext(Type_simple_arrayContext.class,0);
		}
		public Array_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_type; }
	}

	public final Array_typeContext array_type() throws RecognitionException {
		Array_typeContext _localctx = new Array_typeContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_array_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(322);
			match(ARRAY);
			setState(323);
			match(OF);
			setState(324);
			type_simple_array();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Acess_arrayContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PascalParser.ID, 0); }
		public TerminalNode LBRACK() { return getToken(PascalParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(PascalParser.RBRACK, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Acess_arrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_acess_array; }
	}

	public final Acess_arrayContext acess_array() throws RecognitionException {
		Acess_arrayContext _localctx = new Acess_arrayContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_acess_array);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326);
			match(ID);
			setState(327);
			match(LBRACK);
			{
			setState(328);
			expr(0);
			}
			setState(329);
			match(RBRACK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Val_simple_arrayContext extends ParserRuleContext {
		public Val_simpleContext val_simple() {
			return getRuleContext(Val_simpleContext.class,0);
		}
		public Acess_arrayContext acess_array() {
			return getRuleContext(Acess_arrayContext.class,0);
		}
		public Val_simple_arrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_val_simple_array; }
	}

	public final Val_simple_arrayContext val_simple_array() throws RecognitionException {
		Val_simple_arrayContext _localctx = new Val_simple_arrayContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_val_simple_array);
		try {
			setState(333);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLUS:
			case MINUS:
			case INT_VAL:
			case REAL_VAL:
			case BOOLEAN_VAL:
			case STRING_VAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(331);
				val_simple();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(332);
				acess_array();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Val_simpleContext extends ParserRuleContext {
		public Val_simpleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_val_simple; }
	 
		public Val_simpleContext() { }
		public void copyFrom(Val_simpleContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Real_valContext extends Val_simpleContext {
		public TerminalNode REAL_VAL() { return getToken(PascalParser.REAL_VAL, 0); }
		public TerminalNode PLUS() { return getToken(PascalParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(PascalParser.MINUS, 0); }
		public Real_valContext(Val_simpleContext ctx) { copyFrom(ctx); }
	}
	public static class String_valContext extends Val_simpleContext {
		public TerminalNode STRING_VAL() { return getToken(PascalParser.STRING_VAL, 0); }
		public String_valContext(Val_simpleContext ctx) { copyFrom(ctx); }
	}
	public static class Int_valContext extends Val_simpleContext {
		public TerminalNode INT_VAL() { return getToken(PascalParser.INT_VAL, 0); }
		public TerminalNode PLUS() { return getToken(PascalParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(PascalParser.MINUS, 0); }
		public Int_valContext(Val_simpleContext ctx) { copyFrom(ctx); }
	}
	public static class Boolean_valContext extends Val_simpleContext {
		public TerminalNode BOOLEAN_VAL() { return getToken(PascalParser.BOOLEAN_VAL, 0); }
		public Boolean_valContext(Val_simpleContext ctx) { copyFrom(ctx); }
	}

	public final Val_simpleContext val_simple() throws RecognitionException {
		Val_simpleContext _localctx = new Val_simpleContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_val_simple);
		int _la;
		try {
			setState(345);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				_localctx = new Int_valContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(336);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PLUS || _la==MINUS) {
					{
					setState(335);
					_la = _input.LA(1);
					if ( !(_la==PLUS || _la==MINUS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(338);
				match(INT_VAL);
				}
				break;
			case 2:
				_localctx = new Real_valContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(340);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PLUS || _la==MINUS) {
					{
					setState(339);
					_la = _input.LA(1);
					if ( !(_la==PLUS || _la==MINUS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(342);
				match(REAL_VAL);
				}
				break;
			case 3:
				_localctx = new String_valContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(343);
				match(STRING_VAL);
				}
				break;
			case 4:
				_localctx = new Boolean_valContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(344);
				match(BOOLEAN_VAL);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 17:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 8);
		case 1:
			return precpred(_ctx, 7);
		case 2:
			return precpred(_ctx, 6);
		case 3:
			return precpred(_ctx, 5);
		case 4:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\67\u015e\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\3\2\3\2\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\4\5\4H\n\4\3\4\5\4K\n\4\3\4\7\4N\n\4\f\4\16\4"+
		"Q\13\4\3\4\3\4\3\5\3\5\5\5W\n\5\3\6\3\6\3\6\3\6\3\6\3\6\6\6_\n\6\r\6\16"+
		"\6`\3\7\3\7\3\7\3\7\6\7g\n\7\r\7\16\7h\3\b\3\b\3\b\7\bn\n\b\f\b\16\bq"+
		"\13\b\3\b\3\b\3\b\3\b\3\b\7\bx\n\b\f\b\16\b{\13\b\3\b\3\b\5\b\177\n\b"+
		"\3\t\3\t\3\t\3\t\3\t\5\t\u0086\n\t\3\t\5\t\u0089\n\t\3\t\3\t\3\t\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\5\n\u0095\n\n\3\n\5\n\u0098\n\n\3\n\3\n\3\n\3\13"+
		"\3\13\5\13\u009f\n\13\3\13\3\13\3\f\3\f\3\f\7\f\u00a6\n\f\f\f\16\f\u00a9"+
		"\13\f\3\r\3\r\3\r\7\r\u00ae\n\r\f\r\16\r\u00b1\13\r\3\r\3\r\3\r\3\r\3"+
		"\r\7\r\u00b8\n\r\f\r\16\r\u00bb\13\r\3\r\3\r\5\r\u00bf\n\r\3\16\3\16\3"+
		"\16\3\16\3\16\3\17\3\17\5\17\u00c8\n\17\3\20\3\20\3\20\3\20\7\20\u00ce"+
		"\n\20\f\20\16\20\u00d1\13\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\5"+
		"\21\u00db\n\21\3\22\3\22\5\22\u00df\n\22\3\22\3\22\3\22\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00f0\n\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\7\23"+
		"\u0101\n\23\f\23\16\23\u0104\13\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\5\25\u0111\n\25\3\26\3\26\3\26\3\26\3\26\7\26\u0118"+
		"\n\26\f\26\16\26\u011b\13\26\3\26\3\26\3\26\3\26\3\26\5\26\u0122\n\26"+
		"\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\5\30\u012d\n\30\3\30\3\30"+
		"\3\31\3\31\3\31\5\31\u0134\n\31\3\32\3\32\3\32\3\32\5\32\u013a\n\32\3"+
		"\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\35\3"+
		"\35\3\35\3\35\3\35\3\36\3\36\5\36\u0150\n\36\3\37\5\37\u0153\n\37\3\37"+
		"\3\37\5\37\u0157\n\37\3\37\3\37\3\37\5\37\u015c\n\37\3\37\2\3$ \2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<\2\6\4\2\35\36"+
		"..\3\2\33\34\4\2\37!*,\3\2\60\61\2\u0172\2>\3\2\2\2\4@\3\2\2\2\6G\3\2"+
		"\2\2\bV\3\2\2\2\nX\3\2\2\2\fb\3\2\2\2\16~\3\2\2\2\20\u0080\3\2\2\2\22"+
		"\u008d\3\2\2\2\24\u009c\3\2\2\2\26\u00a2\3\2\2\2\30\u00be\3\2\2\2\32\u00c0"+
		"\3\2\2\2\34\u00c7\3\2\2\2\36\u00c9\3\2\2\2 \u00da\3\2\2\2\"\u00de\3\2"+
		"\2\2$\u00ef\3\2\2\2&\u0105\3\2\2\2(\u010a\3\2\2\2*\u0121\3\2\2\2,\u0123"+
		"\3\2\2\2.\u0128\3\2\2\2\60\u0133\3\2\2\2\62\u0139\3\2\2\2\64\u013b\3\2"+
		"\2\2\66\u0144\3\2\2\28\u0148\3\2\2\2:\u014f\3\2\2\2<\u015b\3\2\2\2>?\5"+
		"\4\3\2?\3\3\2\2\2@A\7\5\2\2AB\7\66\2\2BC\7\'\2\2CD\5\6\4\2DE\7$\2\2E\5"+
		"\3\2\2\2FH\5\f\7\2GF\3\2\2\2GH\3\2\2\2HJ\3\2\2\2IK\5\n\6\2JI\3\2\2\2J"+
		"K\3\2\2\2KO\3\2\2\2LN\5\b\5\2ML\3\2\2\2NQ\3\2\2\2OM\3\2\2\2OP\3\2\2\2"+
		"PR\3\2\2\2QO\3\2\2\2RS\5\36\20\2S\7\3\2\2\2TW\5\20\t\2UW\5\22\n\2VT\3"+
		"\2\2\2VU\3\2\2\2W\t\3\2\2\2X^\7\6\2\2YZ\7\66\2\2Z[\7\37\2\2[\\\5<\37\2"+
		"\\]\7\'\2\2]_\3\2\2\2^Y\3\2\2\2_`\3\2\2\2`^\3\2\2\2`a\3\2\2\2a\13\3\2"+
		"\2\2bf\7\7\2\2cd\5\16\b\2de\7\'\2\2eg\3\2\2\2fc\3\2\2\2gh\3\2\2\2hf\3"+
		"\2\2\2hi\3\2\2\2i\r\3\2\2\2jo\7\66\2\2kl\7%\2\2ln\7\66\2\2mk\3\2\2\2n"+
		"q\3\2\2\2om\3\2\2\2op\3\2\2\2pr\3\2\2\2qo\3\2\2\2rs\7&\2\2s\177\5\62\32"+
		"\2ty\7\66\2\2uv\7%\2\2vx\7\66\2\2wu\3\2\2\2x{\3\2\2\2yw\3\2\2\2yz\3\2"+
		"\2\2z|\3\2\2\2{y\3\2\2\2|}\7&\2\2}\177\5\64\33\2~j\3\2\2\2~t\3\2\2\2\177"+
		"\17\3\2\2\2\u0080\u0081\7\13\2\2\u0081\u0082\7\66\2\2\u0082\u0083\5\24"+
		"\13\2\u0083\u0085\7\'\2\2\u0084\u0086\5\f\7\2\u0085\u0084\3\2\2\2\u0085"+
		"\u0086\3\2\2\2\u0086\u0088\3\2\2\2\u0087\u0089\5\n\6\2\u0088\u0087\3\2"+
		"\2\2\u0088\u0089\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008b\5\36\20\2\u008b"+
		"\u008c\7\'\2\2\u008c\21\3\2\2\2\u008d\u008e\7\n\2\2\u008e\u008f\7\66\2"+
		"\2\u008f\u0090\5\24\13\2\u0090\u0091\7&\2\2\u0091\u0092\5\62\32\2\u0092"+
		"\u0094\7\'\2\2\u0093\u0095\5\f\7\2\u0094\u0093\3\2\2\2\u0094\u0095\3\2"+
		"\2\2\u0095\u0097\3\2\2\2\u0096\u0098\5\n\6\2\u0097\u0096\3\2\2\2\u0097"+
		"\u0098\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009a\5\36\20\2\u009a\u009b\7"+
		"\'\2\2\u009b\23\3\2\2\2\u009c\u009e\7(\2\2\u009d\u009f\5\26\f\2\u009e"+
		"\u009d\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a1\7)"+
		"\2\2\u00a1\25\3\2\2\2\u00a2\u00a7\5\34\17\2\u00a3\u00a4\7\'\2\2\u00a4"+
		"\u00a6\5\34\17\2\u00a5\u00a3\3\2\2\2\u00a6\u00a9\3\2\2\2\u00a7\u00a5\3"+
		"\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\27\3\2\2\2\u00a9\u00a7\3\2\2\2\u00aa"+
		"\u00af\7\66\2\2\u00ab\u00ac\7%\2\2\u00ac\u00ae\7\66\2\2\u00ad\u00ab\3"+
		"\2\2\2\u00ae\u00b1\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0"+
		"\u00b2\3\2\2\2\u00b1\u00af\3\2\2\2\u00b2\u00b3\7&\2\2\u00b3\u00bf\5\62"+
		"\32\2\u00b4\u00b9\7\66\2\2\u00b5\u00b6\7%\2\2\u00b6\u00b8\7\66\2\2\u00b7"+
		"\u00b5\3\2\2\2\u00b8\u00bb\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba\3\2"+
		"\2\2\u00ba\u00bc\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bc\u00bd\7&\2\2\u00bd"+
		"\u00bf\5\66\34\2\u00be\u00aa\3\2\2\2\u00be\u00b4\3\2\2\2\u00bf\31\3\2"+
		"\2\2\u00c0\u00c1\7\6\2\2\u00c1\u00c2\7\66\2\2\u00c2\u00c3\7&\2\2\u00c3"+
		"\u00c4\5\62\32\2\u00c4\33\3\2\2\2\u00c5\u00c8\5\30\r\2\u00c6\u00c8\5\32"+
		"\16\2\u00c7\u00c5\3\2\2\2\u00c7\u00c6\3\2\2\2\u00c8\35\3\2\2\2\u00c9\u00cf"+
		"\7\b\2\2\u00ca\u00cb\5 \21\2\u00cb\u00cc\7\'\2\2\u00cc\u00ce\3\2\2\2\u00cd"+
		"\u00ca\3\2\2\2\u00ce\u00d1\3\2\2\2\u00cf\u00cd\3\2\2\2\u00cf\u00d0\3\2"+
		"\2\2\u00d0\u00d2\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d2\u00d3\7\t\2\2\u00d3"+
		"\37\3\2\2\2\u00d4\u00db\5\"\22\2\u00d5\u00db\5&\24\2\u00d6\u00db\5(\25"+
		"\2\u00d7\u00db\5*\26\2\u00d8\u00db\5.\30\2\u00d9\u00db\5,\27\2\u00da\u00d4"+
		"\3\2\2\2\u00da\u00d5\3\2\2\2\u00da\u00d6\3\2\2\2\u00da\u00d7\3\2\2\2\u00da"+
		"\u00d8\3\2\2\2\u00da\u00d9\3\2\2\2\u00db!\3\2\2\2\u00dc\u00df\7\66\2\2"+
		"\u00dd\u00df\58\35\2\u00de\u00dc\3\2\2\2\u00de\u00dd\3\2\2\2\u00df\u00e0"+
		"\3\2\2\2\u00e0\u00e1\7-\2\2\u00e1\u00e2\5$\23\2\u00e2#\3\2\2\2\u00e3\u00e4"+
		"\b\23\1\2\u00e4\u00e5\7(\2\2\u00e5\u00e6\5$\23\2\u00e6\u00e7\7)\2\2\u00e7"+
		"\u00f0\3\2\2\2\u00e8\u00e9\7\32\2\2\u00e9\u00f0\5$\23\f\u00ea\u00eb\7"+
		"\34\2\2\u00eb\u00f0\5$\23\13\u00ec\u00f0\7\66\2\2\u00ed\u00f0\5*\26\2"+
		"\u00ee\u00f0\5:\36\2\u00ef\u00e3\3\2\2\2\u00ef\u00e8\3\2\2\2\u00ef\u00ea"+
		"\3\2\2\2\u00ef\u00ec\3\2\2\2\u00ef\u00ed\3\2\2\2\u00ef\u00ee\3\2\2\2\u00f0"+
		"\u0102\3\2\2\2\u00f1\u00f2\f\n\2\2\u00f2\u00f3\t\2\2\2\u00f3\u0101\5$"+
		"\23\13\u00f4\u00f5\f\t\2\2\u00f5\u00f6\7\30\2\2\u00f6\u0101\5$\23\n\u00f7"+
		"\u00f8\f\b\2\2\u00f8\u00f9\t\3\2\2\u00f9\u0101\5$\23\t\u00fa\u00fb\f\7"+
		"\2\2\u00fb\u00fc\7\31\2\2\u00fc\u0101\5$\23\b\u00fd\u00fe\f\6\2\2\u00fe"+
		"\u00ff\t\4\2\2\u00ff\u0101\5$\23\7\u0100\u00f1\3\2\2\2\u0100\u00f4\3\2"+
		"\2\2\u0100\u00f7\3\2\2\2\u0100\u00fa\3\2\2\2\u0100\u00fd\3\2\2\2\u0101"+
		"\u0104\3\2\2\2\u0102\u0100\3\2\2\2\u0102\u0103\3\2\2\2\u0103%\3\2\2\2"+
		"\u0104\u0102\3\2\2\2\u0105\u0106\7\26\2\2\u0106\u0107\5$\23\2\u0107\u0108"+
		"\7\27\2\2\u0108\u0109\5\36\20\2\u0109\'\3\2\2\2\u010a\u010b\7\23\2\2\u010b"+
		"\u010c\5$\23\2\u010c\u010d\7\24\2\2\u010d\u0110\5\36\20\2\u010e\u010f"+
		"\7\25\2\2\u010f\u0111\5\36\20\2\u0110\u010e\3\2\2\2\u0110\u0111\3\2\2"+
		"\2\u0111)\3\2\2\2\u0112\u0113\7\66\2\2\u0113\u0114\7(\2\2\u0114\u0119"+
		"\5$\23\2\u0115\u0116\7%\2\2\u0116\u0118\5$\23\2\u0117\u0115\3\2\2\2\u0118"+
		"\u011b\3\2\2\2\u0119\u0117\3\2\2\2\u0119\u011a\3\2\2\2\u011a\u011c\3\2"+
		"\2\2\u011b\u0119\3\2\2\2\u011c\u011d\7)\2\2\u011d\u0122\3\2\2\2\u011e"+
		"\u011f\7\66\2\2\u011f\u0120\7(\2\2\u0120\u0122\7)\2\2\u0121\u0112\3\2"+
		"\2\2\u0121\u011e\3\2\2\2\u0122+\3\2\2\2\u0123\u0124\t\5\2\2\u0124\u0125"+
		"\7(\2\2\u0125\u0126\5$\23\2\u0126\u0127\7)\2\2\u0127-\3\2\2\2\u0128\u0129"+
		"\7/\2\2\u0129\u012c\7(\2\2\u012a\u012d\7\66\2\2\u012b\u012d\58\35\2\u012c"+
		"\u012a\3\2\2\2\u012c\u012b\3\2\2\2\u012d\u012e\3\2\2\2\u012e\u012f\7)"+
		"\2\2\u012f/\3\2\2\2\u0130\u0134\7\f\2\2\u0131\u0134\7\r\2\2\u0132\u0134"+
		"\7\16\2\2\u0133\u0130\3\2\2\2\u0133\u0131\3\2\2\2\u0133\u0132\3\2\2\2"+
		"\u0134\61\3\2\2\2\u0135\u013a\7\f\2\2\u0136\u013a\7\r\2\2\u0137\u013a"+
		"\7\16\2\2\u0138\u013a\7\17\2\2\u0139\u0135\3\2\2\2\u0139\u0136\3\2\2\2"+
		"\u0139\u0137\3\2\2\2\u0139\u0138\3\2\2\2\u013a\63\3\2\2\2\u013b\u013c"+
		"\7\20\2\2\u013c\u013d\7\"\2\2\u013d\u013e\7\62\2\2\u013e\u013f\7\21\2"+
		"\2\u013f\u0140\7\62\2\2\u0140\u0141\7#\2\2\u0141\u0142\7\22\2\2\u0142"+
		"\u0143\5\60\31\2\u0143\65\3\2\2\2\u0144\u0145\7\20\2\2\u0145\u0146\7\22"+
		"\2\2\u0146\u0147\5\60\31\2\u0147\67\3\2\2\2\u0148\u0149\7\66\2\2\u0149"+
		"\u014a\7\"\2\2\u014a\u014b\5$\23\2\u014b\u014c\7#\2\2\u014c9\3\2\2\2\u014d"+
		"\u0150\5<\37\2\u014e\u0150\58\35\2\u014f\u014d\3\2\2\2\u014f\u014e\3\2"+
		"\2\2\u0150;\3\2\2\2\u0151\u0153\t\3\2\2\u0152\u0151\3\2\2\2\u0152\u0153"+
		"\3\2\2\2\u0153\u0154\3\2\2\2\u0154\u015c\7\62\2\2\u0155\u0157\t\3\2\2"+
		"\u0156\u0155\3\2\2\2\u0156\u0157\3\2\2\2\u0157\u0158\3\2\2\2\u0158\u015c"+
		"\7\63\2\2\u0159\u015c\7\65\2\2\u015a\u015c\7\64\2\2\u015b\u0152\3\2\2"+
		"\2\u015b\u0156\3\2\2\2\u015b\u0159\3\2\2\2\u015b\u015a\3\2\2\2\u015c="+
		"\3\2\2\2%GJOV`hoy~\u0085\u0088\u0094\u0097\u009e\u00a7\u00af\u00b9\u00be"+
		"\u00c7\u00cf\u00da\u00de\u00ef\u0100\u0102\u0110\u0119\u0121\u012c\u0133"+
		"\u0139\u014f\u0152\u0156\u015b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}