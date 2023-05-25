// Generated from java-escape by ANTLR 4.11.1

    package parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class PascalParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

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
		RULE_begin = 0, RULE_program = 1, RULE_program_pascal = 2, RULE_const_var_section = 3, 
		RULE_const_section = 4, RULE_var_section = 5, RULE_var = 6, RULE_procedure = 7, 
		RULE_function = 8, RULE_parameter_list = 9, RULE_parameters = 10, RULE_var_parameter = 11, 
		RULE_constant = 12, RULE_parameter = 13, RULE_block = 14, RULE_statement = 15, 
		RULE_atribution = 16, RULE_expr = 17, RULE_while_block = 18, RULE_if_block = 19, 
		RULE_param_call = 20, RULE_call_function_procedure = 21, RULE_write_io = 22, 
		RULE_read_io = 23, RULE_type = 24, RULE_type_simple_array = 25, RULE_type_simple = 26, 
		RULE_array_type_range = 27, RULE_array_type = 28, RULE_acess_array = 29, 
		RULE_val_simple_array = 30, RULE_val_simple = 31;
	private static String[] makeRuleNames() {
		return new String[] {
			"begin", "program", "program_pascal", "const_var_section", "const_section", 
			"var_section", "var", "procedure", "function", "parameter_list", "parameters", 
			"var_parameter", "constant", "parameter", "block", "statement", "atribution", 
			"expr", "while_block", "if_block", "param_call", "call_function_procedure", 
			"write_io", "read_io", "type", "type_simple_array", "type_simple", "array_type_range", 
			"array_type", "acess_array", "val_simple_array", "val_simple"
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
	public String getGrammarFileName() { return "java-escape"; }

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

	@SuppressWarnings("CheckReturnValue")
	public static class BeginContext extends ParserRuleContext {
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public BeginContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_begin; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalParserVisitor ) return ((PascalParserVisitor<? extends T>)visitor).visitBegin(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BeginContext begin() throws RecognitionException {
		BeginContext _localctx = new BeginContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_begin);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
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

	@SuppressWarnings("CheckReturnValue")
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalParserVisitor ) return ((PascalParserVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			match(PROGRAM);
			setState(67);
			match(ID);
			setState(68);
			match(SEMICOLON);
			setState(69);
			program_pascal();
			setState(70);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Program_pascalContext extends ParserRuleContext {
		public List<Const_var_sectionContext> const_var_section() {
			return getRuleContexts(Const_var_sectionContext.class);
		}
		public Const_var_sectionContext const_var_section(int i) {
			return getRuleContext(Const_var_sectionContext.class,i);
		}
		public List<ProcedureContext> procedure() {
			return getRuleContexts(ProcedureContext.class);
		}
		public ProcedureContext procedure(int i) {
			return getRuleContext(ProcedureContext.class,i);
		}
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public Program_pascalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program_pascal; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalParserVisitor ) return ((PascalParserVisitor<? extends T>)visitor).visitProgram_pascal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Program_pascalContext program_pascal() throws RecognitionException {
		Program_pascalContext _localctx = new Program_pascalContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_program_pascal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CONST || _la==VAR) {
				{
				{
				setState(72);
				const_var_section();
				}
				}
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FUNCTION || _la==PROCEDURE) {
				{
				setState(80);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PROCEDURE:
					{
					setState(78);
					procedure();
					}
					break;
				case FUNCTION:
					{
					setState(79);
					function();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(86); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(85);
				block();
				}
				}
				setState(88); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==BEGIN );
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

	@SuppressWarnings("CheckReturnValue")
	public static class Const_var_sectionContext extends ParserRuleContext {
		public Const_sectionContext const_section() {
			return getRuleContext(Const_sectionContext.class,0);
		}
		public Var_sectionContext var_section() {
			return getRuleContext(Var_sectionContext.class,0);
		}
		public Const_var_sectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_const_var_section; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalParserVisitor ) return ((PascalParserVisitor<? extends T>)visitor).visitConst_var_section(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Const_var_sectionContext const_var_section() throws RecognitionException {
		Const_var_sectionContext _localctx = new Const_var_sectionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_const_var_section);
		try {
			setState(92);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONST:
				enterOuterAlt(_localctx, 1);
				{
				setState(90);
				const_section();
				}
				break;
			case VAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(91);
				var_section();
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

	@SuppressWarnings("CheckReturnValue")
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalParserVisitor ) return ((PascalParserVisitor<? extends T>)visitor).visitConst_section(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Const_sectionContext const_section() throws RecognitionException {
		Const_sectionContext _localctx = new Const_sectionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_const_section);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(CONST);
			setState(100); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(95);
				match(ID);
				setState(96);
				match(EQUAL);
				setState(97);
				val_simple();
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

	@SuppressWarnings("CheckReturnValue")
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalParserVisitor ) return ((PascalParserVisitor<? extends T>)visitor).visitVar_section(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Var_sectionContext var_section() throws RecognitionException {
		Var_sectionContext _localctx = new Var_sectionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_var_section);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(VAR);
			setState(108); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(105);
				var();
				setState(106);
				match(SEMICOLON);
				}
				}
				setState(110); 
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

	@SuppressWarnings("CheckReturnValue")
	public static class VarContext extends ParserRuleContext {
		public TerminalNode COLON() { return getToken(PascalParser.COLON, 0); }
		public Type_simpleContext type_simple() {
			return getRuleContext(Type_simpleContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(PascalParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PascalParser.ID, i);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalParserVisitor ) return ((PascalParserVisitor<? extends T>)visitor).visitVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_var);
		int _la;
		try {
			setState(132);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(112);
				match(ID);
				}
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(113);
					match(COMMA);
					setState(114);
					match(ID);
					}
					}
					setState(119);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(120);
				match(COLON);
				setState(121);
				type_simple();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(122);
				match(ID);
				}
				setState(127);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(123);
					match(COMMA);
					setState(124);
					match(ID);
					}
					}
					setState(129);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(130);
				match(COLON);
				setState(131);
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

	@SuppressWarnings("CheckReturnValue")
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
		public List<Const_var_sectionContext> const_var_section() {
			return getRuleContexts(Const_var_sectionContext.class);
		}
		public Const_var_sectionContext const_var_section(int i) {
			return getRuleContext(Const_var_sectionContext.class,i);
		}
		public ProcedureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procedure; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalParserVisitor ) return ((PascalParserVisitor<? extends T>)visitor).visitProcedure(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProcedureContext procedure() throws RecognitionException {
		ProcedureContext _localctx = new ProcedureContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_procedure);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(PROCEDURE);
			setState(135);
			match(ID);
			setState(136);
			parameter_list();
			setState(137);
			match(SEMICOLON);
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CONST || _la==VAR) {
				{
				{
				setState(138);
				const_var_section();
				}
				}
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(144);
			block();
			setState(145);
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

	@SuppressWarnings("CheckReturnValue")
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
		public List<Const_var_sectionContext> const_var_section() {
			return getRuleContexts(Const_var_sectionContext.class);
		}
		public Const_var_sectionContext const_var_section(int i) {
			return getRuleContext(Const_var_sectionContext.class,i);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalParserVisitor ) return ((PascalParserVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(FUNCTION);
			setState(148);
			match(ID);
			setState(149);
			parameter_list();
			setState(150);
			match(COLON);
			setState(151);
			type_simple();
			setState(152);
			match(SEMICOLON);
			setState(156);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CONST || _la==VAR) {
				{
				{
				setState(153);
				const_var_section();
				}
				}
				setState(158);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(159);
			block();
			setState(160);
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

	@SuppressWarnings("CheckReturnValue")
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalParserVisitor ) return ((PascalParserVisitor<? extends T>)visitor).visitParameter_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parameter_listContext parameter_list() throws RecognitionException {
		Parameter_listContext _localctx = new Parameter_listContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_parameter_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			match(LPAR);
			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONST || _la==ID) {
				{
				setState(163);
				parameters();
				}
			}

			setState(166);
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

	@SuppressWarnings("CheckReturnValue")
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalParserVisitor ) return ((PascalParserVisitor<? extends T>)visitor).visitParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			parameter();
			setState(173);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEMICOLON) {
				{
				{
				setState(169);
				match(SEMICOLON);
				setState(170);
				parameter();
				}
				}
				setState(175);
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

	@SuppressWarnings("CheckReturnValue")
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalParserVisitor ) return ((PascalParserVisitor<? extends T>)visitor).visitVar_parameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Var_parameterContext var_parameter() throws RecognitionException {
		Var_parameterContext _localctx = new Var_parameterContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_var_parameter);
		int _la;
		try {
			setState(196);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(176);
				match(ID);
				setState(181);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(177);
					match(COMMA);
					setState(178);
					match(ID);
					}
					}
					setState(183);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(184);
				match(COLON);
				setState(185);
				type_simple();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(186);
				match(ID);
				setState(191);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(187);
					match(COMMA);
					setState(188);
					match(ID);
					}
					}
					setState(193);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(194);
				match(COLON);
				setState(195);
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

	@SuppressWarnings("CheckReturnValue")
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalParserVisitor ) return ((PascalParserVisitor<? extends T>)visitor).visitConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_constant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			match(CONST);
			setState(199);
			match(ID);
			setState(200);
			match(COLON);
			setState(201);
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

	@SuppressWarnings("CheckReturnValue")
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalParserVisitor ) return ((PascalParserVisitor<? extends T>)visitor).visitParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_parameter);
		try {
			setState(205);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(203);
				var_parameter();
				}
				break;
			case CONST:
				enterOuterAlt(_localctx, 2);
				{
				setState(204);
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

	@SuppressWarnings("CheckReturnValue")
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalParserVisitor ) return ((PascalParserVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			match(BEGIN);
			setState(213);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 4749890233171968L) != 0) {
				{
				{
				setState(208);
				statement();
				setState(209);
				match(SEMICOLON);
				}
				}
				setState(215);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(216);
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

	@SuppressWarnings("CheckReturnValue")
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalParserVisitor ) return ((PascalParserVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_statement);
		try {
			setState(224);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(218);
				atribution();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(219);
				while_block();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(220);
				if_block();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(221);
				call_function_procedure();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(222);
				read_io();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(223);
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

	@SuppressWarnings("CheckReturnValue")
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalParserVisitor ) return ((PascalParserVisitor<? extends T>)visitor).visitAtribution(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtributionContext atribution() throws RecognitionException {
		AtributionContext _localctx = new AtributionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_atribution);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(226);
				match(ID);
				}
				break;
			case 2:
				{
				setState(227);
				acess_array();
				}
				break;
			}
			setState(230);
			match(BECOMES);
			{
			setState(231);
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

	@SuppressWarnings("CheckReturnValue")
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
	@SuppressWarnings("CheckReturnValue")
	public static class Expr_callContext extends ExprContext {
		public Call_function_procedureContext call_function_procedure() {
			return getRuleContext(Call_function_procedureContext.class,0);
		}
		public Expr_callContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalParserVisitor ) return ((PascalParserVisitor<? extends T>)visitor).visitExpr_call(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalParserVisitor ) return ((PascalParserVisitor<? extends T>)visitor).visitExpr_equal(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Expr_parContext extends ExprContext {
		public TerminalNode LPAR() { return getToken(PascalParser.LPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(PascalParser.RPAR, 0); }
		public Expr_parContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalParserVisitor ) return ((PascalParserVisitor<? extends T>)visitor).visitExpr_par(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Expr_minusContext extends ExprContext {
		public TerminalNode MINUS() { return getToken(PascalParser.MINUS, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Expr_minusContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalParserVisitor ) return ((PascalParserVisitor<? extends T>)visitor).visitExpr_minus(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalParserVisitor ) return ((PascalParserVisitor<? extends T>)visitor).visitExpr_div(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Expr_orContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OR() { return getToken(PascalParser.OR, 0); }
		public Expr_orContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalParserVisitor ) return ((PascalParserVisitor<? extends T>)visitor).visitExpr_or(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Expr_andContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode AND() { return getToken(PascalParser.AND, 0); }
		public Expr_andContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalParserVisitor ) return ((PascalParserVisitor<? extends T>)visitor).visitExpr_and(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalParserVisitor ) return ((PascalParserVisitor<? extends T>)visitor).visitExpr_plus(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Expr_notContext extends ExprContext {
		public TerminalNode NOT() { return getToken(PascalParser.NOT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Expr_notContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalParserVisitor ) return ((PascalParserVisitor<? extends T>)visitor).visitExpr_not(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Expr_idContext extends ExprContext {
		public TerminalNode ID() { return getToken(PascalParser.ID, 0); }
		public Expr_idContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalParserVisitor ) return ((PascalParserVisitor<? extends T>)visitor).visitExpr_id(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Expr_arrayContext extends ExprContext {
		public Val_simple_arrayContext val_simple_array() {
			return getRuleContext(Val_simple_arrayContext.class,0);
		}
		public Expr_arrayContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalParserVisitor ) return ((PascalParserVisitor<? extends T>)visitor).visitExpr_array(this);
			else return visitor.visitChildren(this);
		}
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
			setState(245);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				_localctx = new Expr_parContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(234);
				match(LPAR);
				setState(235);
				expr(0);
				setState(236);
				match(RPAR);
				}
				break;
			case 2:
				{
				_localctx = new Expr_notContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(238);
				match(NOT);
				setState(239);
				expr(10);
				}
				break;
			case 3:
				{
				_localctx = new Expr_minusContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(240);
				match(MINUS);
				setState(241);
				expr(9);
				}
				break;
			case 4:
				{
				_localctx = new Expr_idContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(242);
				match(ID);
				}
				break;
			case 5:
				{
				_localctx = new Expr_callContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(243);
				call_function_procedure();
				}
				break;
			case 6:
				{
				_localctx = new Expr_arrayContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(244);
				val_simple_array();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(264);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(262);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
					case 1:
						{
						_localctx = new Expr_divContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(247);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(248);
						((Expr_divContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 17592588697600L) != 0) ) {
							((Expr_divContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(249);
						expr(9);
						}
						break;
					case 2:
						{
						_localctx = new Expr_andContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(250);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(251);
						match(AND);
						setState(252);
						expr(8);
						}
						break;
					case 3:
						{
						_localctx = new Expr_plusContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(253);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(254);
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
						setState(255);
						expr(7);
						}
						break;
					case 4:
						{
						_localctx = new Expr_orContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(256);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(257);
						match(OR);
						setState(258);
						expr(6);
						}
						break;
					case 5:
						{
						_localctx = new Expr_equalContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(259);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(260);
						((Expr_equalContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 7700339490816L) != 0) ) {
							((Expr_equalContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(261);
						expr(5);
						}
						break;
					}
					} 
				}
				setState(266);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalParserVisitor ) return ((PascalParserVisitor<? extends T>)visitor).visitWhile_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final While_blockContext while_block() throws RecognitionException {
		While_blockContext _localctx = new While_blockContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_while_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			match(WHILE);
			setState(268);
			expr(0);
			setState(269);
			match(DO);
			setState(270);
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

	@SuppressWarnings("CheckReturnValue")
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalParserVisitor ) return ((PascalParserVisitor<? extends T>)visitor).visitIf_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_blockContext if_block() throws RecognitionException {
		If_blockContext _localctx = new If_blockContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_if_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			match(IF);
			setState(273);
			expr(0);
			setState(274);
			match(THEN);
			setState(275);
			block();
			setState(278);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(276);
				match(ELSE);
				setState(277);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Param_callContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<Param_callContext> param_call() {
			return getRuleContexts(Param_callContext.class);
		}
		public Param_callContext param_call(int i) {
			return getRuleContext(Param_callContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(PascalParser.COMMA, 0); }
		public Param_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_call; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalParserVisitor ) return ((PascalParserVisitor<? extends T>)visitor).visitParam_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Param_callContext param_call() throws RecognitionException {
		return param_call(0);
	}

	private Param_callContext param_call(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Param_callContext _localctx = new Param_callContext(_ctx, _parentState);
		Param_callContext _prevctx = _localctx;
		int _startState = 40;
		enterRecursionRule(_localctx, 40, RULE_param_call, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(281);
			expr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(288);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Param_callContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_param_call);
					setState(283);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(284);
					match(COMMA);
					setState(285);
					param_call(2);
					}
					} 
				}
				setState(290);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Call_function_procedureContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PascalParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(PascalParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(PascalParser.RPAR, 0); }
		public Param_callContext param_call() {
			return getRuleContext(Param_callContext.class,0);
		}
		public Call_function_procedureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call_function_procedure; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalParserVisitor ) return ((PascalParserVisitor<? extends T>)visitor).visitCall_function_procedure(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Call_function_procedureContext call_function_procedure() throws RecognitionException {
		Call_function_procedureContext _localctx = new Call_function_procedureContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_call_function_procedure);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291);
			match(ID);
			setState(292);
			match(LPAR);
			setState(294);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 8725999273377792L) != 0) {
				{
				setState(293);
				param_call(0);
				}
			}

			setState(296);
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

	@SuppressWarnings("CheckReturnValue")
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalParserVisitor ) return ((PascalParserVisitor<? extends T>)visitor).visitWrite_io(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Write_ioContext write_io() throws RecognitionException {
		Write_ioContext _localctx = new Write_ioContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_write_io);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(298);
			_la = _input.LA(1);
			if ( !(_la==WRITE || _la==WRITELN) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(299);
			match(LPAR);
			{
			setState(300);
			expr(0);
			}
			setState(301);
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

	@SuppressWarnings("CheckReturnValue")
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalParserVisitor ) return ((PascalParserVisitor<? extends T>)visitor).visitRead_io(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Read_ioContext read_io() throws RecognitionException {
		Read_ioContext _localctx = new Read_ioContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_read_io);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(303);
			match(READ);
			setState(304);
			match(LPAR);
			setState(307);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(305);
				match(ID);
				}
				break;
			case 2:
				{
				setState(306);
				acess_array();
				}
				break;
			}
			setState(309);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public Type_simpleContext type_simple() {
			return getRuleContext(Type_simpleContext.class,0);
		}
		public Array_type_rangeContext array_type_range() {
			return getRuleContext(Array_type_rangeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalParserVisitor ) return ((PascalParserVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_type);
		try {
			setState(313);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER:
			case REAL:
			case BOOLEAN:
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(311);
				type_simple();
				}
				break;
			case ARRAY:
				enterOuterAlt(_localctx, 2);
				{
				setState(312);
				array_type_range();
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

	@SuppressWarnings("CheckReturnValue")
	public static class Type_simple_arrayContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(PascalParser.INTEGER, 0); }
		public TerminalNode REAL() { return getToken(PascalParser.REAL, 0); }
		public TerminalNode BOOLEAN() { return getToken(PascalParser.BOOLEAN, 0); }
		public Type_simple_arrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_simple_array; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalParserVisitor ) return ((PascalParserVisitor<? extends T>)visitor).visitType_simple_array(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_simple_arrayContext type_simple_array() throws RecognitionException {
		Type_simple_arrayContext _localctx = new Type_simple_arrayContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_type_simple_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(315);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 7168L) != 0) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	@SuppressWarnings("CheckReturnValue")
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
	@SuppressWarnings("CheckReturnValue")
	public static class Type_simple_stringContext extends Type_simpleContext {
		public TerminalNode STRING() { return getToken(PascalParser.STRING, 0); }
		public Type_simple_stringContext(Type_simpleContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalParserVisitor ) return ((PascalParserVisitor<? extends T>)visitor).visitType_simple_string(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Type_simple_integerContext extends Type_simpleContext {
		public TerminalNode INTEGER() { return getToken(PascalParser.INTEGER, 0); }
		public Type_simple_integerContext(Type_simpleContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalParserVisitor ) return ((PascalParserVisitor<? extends T>)visitor).visitType_simple_integer(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Type_simple_realContext extends Type_simpleContext {
		public TerminalNode REAL() { return getToken(PascalParser.REAL, 0); }
		public Type_simple_realContext(Type_simpleContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalParserVisitor ) return ((PascalParserVisitor<? extends T>)visitor).visitType_simple_real(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Type_simple_booleanContext extends Type_simpleContext {
		public TerminalNode BOOLEAN() { return getToken(PascalParser.BOOLEAN, 0); }
		public Type_simple_booleanContext(Type_simpleContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalParserVisitor ) return ((PascalParserVisitor<? extends T>)visitor).visitType_simple_boolean(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_simpleContext type_simple() throws RecognitionException {
		Type_simpleContext _localctx = new Type_simpleContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_type_simple);
		try {
			setState(321);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER:
				_localctx = new Type_simple_integerContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(317);
				match(INTEGER);
				}
				break;
			case REAL:
				_localctx = new Type_simple_realContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(318);
				match(REAL);
				}
				break;
			case BOOLEAN:
				_localctx = new Type_simple_booleanContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(319);
				match(BOOLEAN);
				}
				break;
			case STRING:
				_localctx = new Type_simple_stringContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(320);
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

	@SuppressWarnings("CheckReturnValue")
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalParserVisitor ) return ((PascalParserVisitor<? extends T>)visitor).visitArray_type_range(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Array_type_rangeContext array_type_range() throws RecognitionException {
		Array_type_rangeContext _localctx = new Array_type_rangeContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_array_type_range);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(323);
			match(ARRAY);
			setState(324);
			match(LBRACK);
			setState(325);
			match(INT_VAL);
			setState(326);
			match(RANGE);
			setState(327);
			match(INT_VAL);
			setState(328);
			match(RBRACK);
			setState(329);
			match(OF);
			setState(330);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Array_typeContext extends ParserRuleContext {
		public TerminalNode ARRAY() { return getToken(PascalParser.ARRAY, 0); }
		public TerminalNode OF() { return getToken(PascalParser.OF, 0); }
		public Type_simpleContext type_simple() {
			return getRuleContext(Type_simpleContext.class,0);
		}
		public Array_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalParserVisitor ) return ((PascalParserVisitor<? extends T>)visitor).visitArray_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Array_typeContext array_type() throws RecognitionException {
		Array_typeContext _localctx = new Array_typeContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_array_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(332);
			match(ARRAY);
			setState(333);
			match(OF);
			setState(334);
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

	@SuppressWarnings("CheckReturnValue")
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalParserVisitor ) return ((PascalParserVisitor<? extends T>)visitor).visitAcess_array(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Acess_arrayContext acess_array() throws RecognitionException {
		Acess_arrayContext _localctx = new Acess_arrayContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_acess_array);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(336);
			match(ID);
			setState(337);
			match(LBRACK);
			{
			setState(338);
			expr(0);
			}
			setState(339);
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

	@SuppressWarnings("CheckReturnValue")
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalParserVisitor ) return ((PascalParserVisitor<? extends T>)visitor).visitVal_simple_array(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Val_simple_arrayContext val_simple_array() throws RecognitionException {
		Val_simple_arrayContext _localctx = new Val_simple_arrayContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_val_simple_array);
		try {
			setState(343);
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
				setState(341);
				val_simple();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(342);
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

	@SuppressWarnings("CheckReturnValue")
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
	@SuppressWarnings("CheckReturnValue")
	public static class Real_valContext extends Val_simpleContext {
		public TerminalNode REAL_VAL() { return getToken(PascalParser.REAL_VAL, 0); }
		public TerminalNode PLUS() { return getToken(PascalParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(PascalParser.MINUS, 0); }
		public Real_valContext(Val_simpleContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalParserVisitor ) return ((PascalParserVisitor<? extends T>)visitor).visitReal_val(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class String_valContext extends Val_simpleContext {
		public TerminalNode STRING_VAL() { return getToken(PascalParser.STRING_VAL, 0); }
		public String_valContext(Val_simpleContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalParserVisitor ) return ((PascalParserVisitor<? extends T>)visitor).visitString_val(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Int_valContext extends Val_simpleContext {
		public TerminalNode INT_VAL() { return getToken(PascalParser.INT_VAL, 0); }
		public TerminalNode PLUS() { return getToken(PascalParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(PascalParser.MINUS, 0); }
		public Int_valContext(Val_simpleContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalParserVisitor ) return ((PascalParserVisitor<? extends T>)visitor).visitInt_val(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Boolean_valContext extends Val_simpleContext {
		public TerminalNode BOOLEAN_VAL() { return getToken(PascalParser.BOOLEAN_VAL, 0); }
		public Boolean_valContext(Val_simpleContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalParserVisitor ) return ((PascalParserVisitor<? extends T>)visitor).visitBoolean_val(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Val_simpleContext val_simple() throws RecognitionException {
		Val_simpleContext _localctx = new Val_simpleContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_val_simple);
		int _la;
		try {
			setState(355);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				_localctx = new Int_valContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(346);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PLUS || _la==MINUS) {
					{
					setState(345);
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

				setState(348);
				match(INT_VAL);
				}
				break;
			case 2:
				_localctx = new Real_valContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(350);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PLUS || _la==MINUS) {
					{
					setState(349);
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

				setState(352);
				match(REAL_VAL);
				}
				break;
			case 3:
				_localctx = new String_valContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(353);
				match(STRING_VAL);
				}
				break;
			case 4:
				_localctx = new Boolean_valContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(354);
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
		case 20:
			return param_call_sempred((Param_callContext)_localctx, predIndex);
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
	private boolean param_call_sempred(Param_callContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u00015\u0166\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0005\u0002"+
		"J\b\u0002\n\u0002\f\u0002M\t\u0002\u0001\u0002\u0001\u0002\u0005\u0002"+
		"Q\b\u0002\n\u0002\f\u0002T\t\u0002\u0001\u0002\u0004\u0002W\b\u0002\u000b"+
		"\u0002\f\u0002X\u0001\u0003\u0001\u0003\u0003\u0003]\b\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0004\u0004"+
		"e\b\u0004\u000b\u0004\f\u0004f\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0004\u0005m\b\u0005\u000b\u0005\f\u0005n\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0005\u0006t\b\u0006\n\u0006\f\u0006w\t\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006~\b\u0006"+
		"\n\u0006\f\u0006\u0081\t\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u0085"+
		"\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005"+
		"\u0007\u008c\b\u0007\n\u0007\f\u0007\u008f\t\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005"+
		"\b\u009b\b\b\n\b\f\b\u009e\t\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t"+
		"\u0003\t\u00a5\b\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0005\n\u00ac"+
		"\b\n\n\n\f\n\u00af\t\n\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b"+
		"\u00b4\b\u000b\n\u000b\f\u000b\u00b7\t\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00be\b\u000b\n\u000b\f\u000b"+
		"\u00c1\t\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00c5\b\u000b\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0003\r\u00ce\b\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u00d4\b\u000e\n"+
		"\u000e\f\u000e\u00d7\t\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u00e1"+
		"\b\u000f\u0001\u0010\u0001\u0010\u0003\u0010\u00e5\b\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0003\u0011\u00f6\b\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0005\u0011\u0107\b\u0011\n\u0011\f\u0011\u010a\t\u0011\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u0117"+
		"\b\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0005\u0014\u011f\b\u0014\n\u0014\f\u0014\u0122\t\u0014\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0003\u0015\u0127\b\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u0134\b\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0018\u0001\u0018\u0003\u0018\u013a\b\u0018\u0001\u0019"+
		"\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0003\u001a"+
		"\u0142\b\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0001\u001e\u0001\u001e\u0003\u001e\u0158\b\u001e\u0001\u001f"+
		"\u0003\u001f\u015b\b\u001f\u0001\u001f\u0001\u001f\u0003\u001f\u015f\b"+
		"\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0003\u001f\u0164\b\u001f\u0001"+
		"\u001f\u0000\u0002\"( \u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>\u0000\u0005\u0002"+
		"\u0000\u001b\u001c,,\u0001\u0000\u0019\u001a\u0002\u0000\u001d\u001f("+
		"*\u0001\u0000./\u0001\u0000\n\f\u0176\u0000@\u0001\u0000\u0000\u0000\u0002"+
		"B\u0001\u0000\u0000\u0000\u0004K\u0001\u0000\u0000\u0000\u0006\\\u0001"+
		"\u0000\u0000\u0000\b^\u0001\u0000\u0000\u0000\nh\u0001\u0000\u0000\u0000"+
		"\f\u0084\u0001\u0000\u0000\u0000\u000e\u0086\u0001\u0000\u0000\u0000\u0010"+
		"\u0093\u0001\u0000\u0000\u0000\u0012\u00a2\u0001\u0000\u0000\u0000\u0014"+
		"\u00a8\u0001\u0000\u0000\u0000\u0016\u00c4\u0001\u0000\u0000\u0000\u0018"+
		"\u00c6\u0001\u0000\u0000\u0000\u001a\u00cd\u0001\u0000\u0000\u0000\u001c"+
		"\u00cf\u0001\u0000\u0000\u0000\u001e\u00e0\u0001\u0000\u0000\u0000 \u00e4"+
		"\u0001\u0000\u0000\u0000\"\u00f5\u0001\u0000\u0000\u0000$\u010b\u0001"+
		"\u0000\u0000\u0000&\u0110\u0001\u0000\u0000\u0000(\u0118\u0001\u0000\u0000"+
		"\u0000*\u0123\u0001\u0000\u0000\u0000,\u012a\u0001\u0000\u0000\u0000."+
		"\u012f\u0001\u0000\u0000\u00000\u0139\u0001\u0000\u0000\u00002\u013b\u0001"+
		"\u0000\u0000\u00004\u0141\u0001\u0000\u0000\u00006\u0143\u0001\u0000\u0000"+
		"\u00008\u014c\u0001\u0000\u0000\u0000:\u0150\u0001\u0000\u0000\u0000<"+
		"\u0157\u0001\u0000\u0000\u0000>\u0163\u0001\u0000\u0000\u0000@A\u0003"+
		"\u0002\u0001\u0000A\u0001\u0001\u0000\u0000\u0000BC\u0005\u0003\u0000"+
		"\u0000CD\u00054\u0000\u0000DE\u0005%\u0000\u0000EF\u0003\u0004\u0002\u0000"+
		"FG\u0005\"\u0000\u0000G\u0003\u0001\u0000\u0000\u0000HJ\u0003\u0006\u0003"+
		"\u0000IH\u0001\u0000\u0000\u0000JM\u0001\u0000\u0000\u0000KI\u0001\u0000"+
		"\u0000\u0000KL\u0001\u0000\u0000\u0000LR\u0001\u0000\u0000\u0000MK\u0001"+
		"\u0000\u0000\u0000NQ\u0003\u000e\u0007\u0000OQ\u0003\u0010\b\u0000PN\u0001"+
		"\u0000\u0000\u0000PO\u0001\u0000\u0000\u0000QT\u0001\u0000\u0000\u0000"+
		"RP\u0001\u0000\u0000\u0000RS\u0001\u0000\u0000\u0000SV\u0001\u0000\u0000"+
		"\u0000TR\u0001\u0000\u0000\u0000UW\u0003\u001c\u000e\u0000VU\u0001\u0000"+
		"\u0000\u0000WX\u0001\u0000\u0000\u0000XV\u0001\u0000\u0000\u0000XY\u0001"+
		"\u0000\u0000\u0000Y\u0005\u0001\u0000\u0000\u0000Z]\u0003\b\u0004\u0000"+
		"[]\u0003\n\u0005\u0000\\Z\u0001\u0000\u0000\u0000\\[\u0001\u0000\u0000"+
		"\u0000]\u0007\u0001\u0000\u0000\u0000^d\u0005\u0004\u0000\u0000_`\u0005"+
		"4\u0000\u0000`a\u0005\u001d\u0000\u0000ab\u0003>\u001f\u0000bc\u0005%"+
		"\u0000\u0000ce\u0001\u0000\u0000\u0000d_\u0001\u0000\u0000\u0000ef\u0001"+
		"\u0000\u0000\u0000fd\u0001\u0000\u0000\u0000fg\u0001\u0000\u0000\u0000"+
		"g\t\u0001\u0000\u0000\u0000hl\u0005\u0005\u0000\u0000ij\u0003\f\u0006"+
		"\u0000jk\u0005%\u0000\u0000km\u0001\u0000\u0000\u0000li\u0001\u0000\u0000"+
		"\u0000mn\u0001\u0000\u0000\u0000nl\u0001\u0000\u0000\u0000no\u0001\u0000"+
		"\u0000\u0000o\u000b\u0001\u0000\u0000\u0000pu\u00054\u0000\u0000qr\u0005"+
		"#\u0000\u0000rt\u00054\u0000\u0000sq\u0001\u0000\u0000\u0000tw\u0001\u0000"+
		"\u0000\u0000us\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000\u0000vx\u0001"+
		"\u0000\u0000\u0000wu\u0001\u0000\u0000\u0000xy\u0005$\u0000\u0000y\u0085"+
		"\u00034\u001a\u0000z\u007f\u00054\u0000\u0000{|\u0005#\u0000\u0000|~\u0005"+
		"4\u0000\u0000}{\u0001\u0000\u0000\u0000~\u0081\u0001\u0000\u0000\u0000"+
		"\u007f}\u0001\u0000\u0000\u0000\u007f\u0080\u0001\u0000\u0000\u0000\u0080"+
		"\u0082\u0001\u0000\u0000\u0000\u0081\u007f\u0001\u0000\u0000\u0000\u0082"+
		"\u0083\u0005$\u0000\u0000\u0083\u0085\u00036\u001b\u0000\u0084p\u0001"+
		"\u0000\u0000\u0000\u0084z\u0001\u0000\u0000\u0000\u0085\r\u0001\u0000"+
		"\u0000\u0000\u0086\u0087\u0005\t\u0000\u0000\u0087\u0088\u00054\u0000"+
		"\u0000\u0088\u0089\u0003\u0012\t\u0000\u0089\u008d\u0005%\u0000\u0000"+
		"\u008a\u008c\u0003\u0006\u0003\u0000\u008b\u008a\u0001\u0000\u0000\u0000"+
		"\u008c\u008f\u0001\u0000\u0000\u0000\u008d\u008b\u0001\u0000\u0000\u0000"+
		"\u008d\u008e\u0001\u0000\u0000\u0000\u008e\u0090\u0001\u0000\u0000\u0000"+
		"\u008f\u008d\u0001\u0000\u0000\u0000\u0090\u0091\u0003\u001c\u000e\u0000"+
		"\u0091\u0092\u0005%\u0000\u0000\u0092\u000f\u0001\u0000\u0000\u0000\u0093"+
		"\u0094\u0005\b\u0000\u0000\u0094\u0095\u00054\u0000\u0000\u0095\u0096"+
		"\u0003\u0012\t\u0000\u0096\u0097\u0005$\u0000\u0000\u0097\u0098\u0003"+
		"4\u001a\u0000\u0098\u009c\u0005%\u0000\u0000\u0099\u009b\u0003\u0006\u0003"+
		"\u0000\u009a\u0099\u0001\u0000\u0000\u0000\u009b\u009e\u0001\u0000\u0000"+
		"\u0000\u009c\u009a\u0001\u0000\u0000\u0000\u009c\u009d\u0001\u0000\u0000"+
		"\u0000\u009d\u009f\u0001\u0000\u0000\u0000\u009e\u009c\u0001\u0000\u0000"+
		"\u0000\u009f\u00a0\u0003\u001c\u000e\u0000\u00a0\u00a1\u0005%\u0000\u0000"+
		"\u00a1\u0011\u0001\u0000\u0000\u0000\u00a2\u00a4\u0005&\u0000\u0000\u00a3"+
		"\u00a5\u0003\u0014\n\u0000\u00a4\u00a3\u0001\u0000\u0000\u0000\u00a4\u00a5"+
		"\u0001\u0000\u0000\u0000\u00a5\u00a6\u0001\u0000\u0000\u0000\u00a6\u00a7"+
		"\u0005\'\u0000\u0000\u00a7\u0013\u0001\u0000\u0000\u0000\u00a8\u00ad\u0003"+
		"\u001a\r\u0000\u00a9\u00aa\u0005%\u0000\u0000\u00aa\u00ac\u0003\u001a"+
		"\r\u0000\u00ab\u00a9\u0001\u0000\u0000\u0000\u00ac\u00af\u0001\u0000\u0000"+
		"\u0000\u00ad\u00ab\u0001\u0000\u0000\u0000\u00ad\u00ae\u0001\u0000\u0000"+
		"\u0000\u00ae\u0015\u0001\u0000\u0000\u0000\u00af\u00ad\u0001\u0000\u0000"+
		"\u0000\u00b0\u00b5\u00054\u0000\u0000\u00b1\u00b2\u0005#\u0000\u0000\u00b2"+
		"\u00b4\u00054\u0000\u0000\u00b3\u00b1\u0001\u0000\u0000\u0000\u00b4\u00b7"+
		"\u0001\u0000\u0000\u0000\u00b5\u00b3\u0001\u0000\u0000\u0000\u00b5\u00b6"+
		"\u0001\u0000\u0000\u0000\u00b6\u00b8\u0001\u0000\u0000\u0000\u00b7\u00b5"+
		"\u0001\u0000\u0000\u0000\u00b8\u00b9\u0005$\u0000\u0000\u00b9\u00c5\u0003"+
		"4\u001a\u0000\u00ba\u00bf\u00054\u0000\u0000\u00bb\u00bc\u0005#\u0000"+
		"\u0000\u00bc\u00be\u00054\u0000\u0000\u00bd\u00bb\u0001\u0000\u0000\u0000"+
		"\u00be\u00c1\u0001\u0000\u0000\u0000\u00bf\u00bd\u0001\u0000\u0000\u0000"+
		"\u00bf\u00c0\u0001\u0000\u0000\u0000\u00c0\u00c2\u0001\u0000\u0000\u0000"+
		"\u00c1\u00bf\u0001\u0000\u0000\u0000\u00c2\u00c3\u0005$\u0000\u0000\u00c3"+
		"\u00c5\u00038\u001c\u0000\u00c4\u00b0\u0001\u0000\u0000\u0000\u00c4\u00ba"+
		"\u0001\u0000\u0000\u0000\u00c5\u0017\u0001\u0000\u0000\u0000\u00c6\u00c7"+
		"\u0005\u0004\u0000\u0000\u00c7\u00c8\u00054\u0000\u0000\u00c8\u00c9\u0005"+
		"$\u0000\u0000\u00c9\u00ca\u00034\u001a\u0000\u00ca\u0019\u0001\u0000\u0000"+
		"\u0000\u00cb\u00ce\u0003\u0016\u000b\u0000\u00cc\u00ce\u0003\u0018\f\u0000"+
		"\u00cd\u00cb\u0001\u0000\u0000\u0000\u00cd\u00cc\u0001\u0000\u0000\u0000"+
		"\u00ce\u001b\u0001\u0000\u0000\u0000\u00cf\u00d5\u0005\u0006\u0000\u0000"+
		"\u00d0\u00d1\u0003\u001e\u000f\u0000\u00d1\u00d2\u0005%\u0000\u0000\u00d2"+
		"\u00d4\u0001\u0000\u0000\u0000\u00d3\u00d0\u0001\u0000\u0000\u0000\u00d4"+
		"\u00d7\u0001\u0000\u0000\u0000\u00d5\u00d3\u0001\u0000\u0000\u0000\u00d5"+
		"\u00d6\u0001\u0000\u0000\u0000\u00d6\u00d8\u0001\u0000\u0000\u0000\u00d7"+
		"\u00d5\u0001\u0000\u0000\u0000\u00d8\u00d9\u0005\u0007\u0000\u0000\u00d9"+
		"\u001d\u0001\u0000\u0000\u0000\u00da\u00e1\u0003 \u0010\u0000\u00db\u00e1"+
		"\u0003$\u0012\u0000\u00dc\u00e1\u0003&\u0013\u0000\u00dd\u00e1\u0003*"+
		"\u0015\u0000\u00de\u00e1\u0003.\u0017\u0000\u00df\u00e1\u0003,\u0016\u0000"+
		"\u00e0\u00da\u0001\u0000\u0000\u0000\u00e0\u00db\u0001\u0000\u0000\u0000"+
		"\u00e0\u00dc\u0001\u0000\u0000\u0000\u00e0\u00dd\u0001\u0000\u0000\u0000"+
		"\u00e0\u00de\u0001\u0000\u0000\u0000\u00e0\u00df\u0001\u0000\u0000\u0000"+
		"\u00e1\u001f\u0001\u0000\u0000\u0000\u00e2\u00e5\u00054\u0000\u0000\u00e3"+
		"\u00e5\u0003:\u001d\u0000\u00e4\u00e2\u0001\u0000\u0000\u0000\u00e4\u00e3"+
		"\u0001\u0000\u0000\u0000\u00e5\u00e6\u0001\u0000\u0000\u0000\u00e6\u00e7"+
		"\u0005+\u0000\u0000\u00e7\u00e8\u0003\"\u0011\u0000\u00e8!\u0001\u0000"+
		"\u0000\u0000\u00e9\u00ea\u0006\u0011\uffff\uffff\u0000\u00ea\u00eb\u0005"+
		"&\u0000\u0000\u00eb\u00ec\u0003\"\u0011\u0000\u00ec\u00ed\u0005\'\u0000"+
		"\u0000\u00ed\u00f6\u0001\u0000\u0000\u0000\u00ee\u00ef\u0005\u0018\u0000"+
		"\u0000\u00ef\u00f6\u0003\"\u0011\n\u00f0\u00f1\u0005\u001a\u0000\u0000"+
		"\u00f1\u00f6\u0003\"\u0011\t\u00f2\u00f6\u00054\u0000\u0000\u00f3\u00f6"+
		"\u0003*\u0015\u0000\u00f4\u00f6\u0003<\u001e\u0000\u00f5\u00e9\u0001\u0000"+
		"\u0000\u0000\u00f5\u00ee\u0001\u0000\u0000\u0000\u00f5\u00f0\u0001\u0000"+
		"\u0000\u0000\u00f5\u00f2\u0001\u0000\u0000\u0000\u00f5\u00f3\u0001\u0000"+
		"\u0000\u0000\u00f5\u00f4\u0001\u0000\u0000\u0000\u00f6\u0108\u0001\u0000"+
		"\u0000\u0000\u00f7\u00f8\n\b\u0000\u0000\u00f8\u00f9\u0007\u0000\u0000"+
		"\u0000\u00f9\u0107\u0003\"\u0011\t\u00fa\u00fb\n\u0007\u0000\u0000\u00fb"+
		"\u00fc\u0005\u0016\u0000\u0000\u00fc\u0107\u0003\"\u0011\b\u00fd\u00fe"+
		"\n\u0006\u0000\u0000\u00fe\u00ff\u0007\u0001\u0000\u0000\u00ff\u0107\u0003"+
		"\"\u0011\u0007\u0100\u0101\n\u0005\u0000\u0000\u0101\u0102\u0005\u0017"+
		"\u0000\u0000\u0102\u0107\u0003\"\u0011\u0006\u0103\u0104\n\u0004\u0000"+
		"\u0000\u0104\u0105\u0007\u0002\u0000\u0000\u0105\u0107\u0003\"\u0011\u0005"+
		"\u0106\u00f7\u0001\u0000\u0000\u0000\u0106\u00fa\u0001\u0000\u0000\u0000"+
		"\u0106\u00fd\u0001\u0000\u0000\u0000\u0106\u0100\u0001\u0000\u0000\u0000"+
		"\u0106\u0103\u0001\u0000\u0000\u0000\u0107\u010a\u0001\u0000\u0000\u0000"+
		"\u0108\u0106\u0001\u0000\u0000\u0000\u0108\u0109\u0001\u0000\u0000\u0000"+
		"\u0109#\u0001\u0000\u0000\u0000\u010a\u0108\u0001\u0000\u0000\u0000\u010b"+
		"\u010c\u0005\u0014\u0000\u0000\u010c\u010d\u0003\"\u0011\u0000\u010d\u010e"+
		"\u0005\u0015\u0000\u0000\u010e\u010f\u0003\u001c\u000e\u0000\u010f%\u0001"+
		"\u0000\u0000\u0000\u0110\u0111\u0005\u0011\u0000\u0000\u0111\u0112\u0003"+
		"\"\u0011\u0000\u0112\u0113\u0005\u0012\u0000\u0000\u0113\u0116\u0003\u001c"+
		"\u000e\u0000\u0114\u0115\u0005\u0013\u0000\u0000\u0115\u0117\u0003\u001c"+
		"\u000e\u0000\u0116\u0114\u0001\u0000\u0000\u0000\u0116\u0117\u0001\u0000"+
		"\u0000\u0000\u0117\'\u0001\u0000\u0000\u0000\u0118\u0119\u0006\u0014\uffff"+
		"\uffff\u0000\u0119\u011a\u0003\"\u0011\u0000\u011a\u0120\u0001\u0000\u0000"+
		"\u0000\u011b\u011c\n\u0001\u0000\u0000\u011c\u011d\u0005#\u0000\u0000"+
		"\u011d\u011f\u0003(\u0014\u0002\u011e\u011b\u0001\u0000\u0000\u0000\u011f"+
		"\u0122\u0001\u0000\u0000\u0000\u0120\u011e\u0001\u0000\u0000\u0000\u0120"+
		"\u0121\u0001\u0000\u0000\u0000\u0121)\u0001\u0000\u0000\u0000\u0122\u0120"+
		"\u0001\u0000\u0000\u0000\u0123\u0124\u00054\u0000\u0000\u0124\u0126\u0005"+
		"&\u0000\u0000\u0125\u0127\u0003(\u0014\u0000\u0126\u0125\u0001\u0000\u0000"+
		"\u0000\u0126\u0127\u0001\u0000\u0000\u0000\u0127\u0128\u0001\u0000\u0000"+
		"\u0000\u0128\u0129\u0005\'\u0000\u0000\u0129+\u0001\u0000\u0000\u0000"+
		"\u012a\u012b\u0007\u0003\u0000\u0000\u012b\u012c\u0005&\u0000\u0000\u012c"+
		"\u012d\u0003\"\u0011\u0000\u012d\u012e\u0005\'\u0000\u0000\u012e-\u0001"+
		"\u0000\u0000\u0000\u012f\u0130\u0005-\u0000\u0000\u0130\u0133\u0005&\u0000"+
		"\u0000\u0131\u0134\u00054\u0000\u0000\u0132\u0134\u0003:\u001d\u0000\u0133"+
		"\u0131\u0001\u0000\u0000\u0000\u0133\u0132\u0001\u0000\u0000\u0000\u0134"+
		"\u0135\u0001\u0000\u0000\u0000\u0135\u0136\u0005\'\u0000\u0000\u0136/"+
		"\u0001\u0000\u0000\u0000\u0137\u013a\u00034\u001a\u0000\u0138\u013a\u0003"+
		"6\u001b\u0000\u0139\u0137\u0001\u0000\u0000\u0000\u0139\u0138\u0001\u0000"+
		"\u0000\u0000\u013a1\u0001\u0000\u0000\u0000\u013b\u013c\u0007\u0004\u0000"+
		"\u0000\u013c3\u0001\u0000\u0000\u0000\u013d\u0142\u0005\n\u0000\u0000"+
		"\u013e\u0142\u0005\u000b\u0000\u0000\u013f\u0142\u0005\f\u0000\u0000\u0140"+
		"\u0142\u0005\r\u0000\u0000\u0141\u013d\u0001\u0000\u0000\u0000\u0141\u013e"+
		"\u0001\u0000\u0000\u0000\u0141\u013f\u0001\u0000\u0000\u0000\u0141\u0140"+
		"\u0001\u0000\u0000\u0000\u01425\u0001\u0000\u0000\u0000\u0143\u0144\u0005"+
		"\u000e\u0000\u0000\u0144\u0145\u0005 \u0000\u0000\u0145\u0146\u00050\u0000"+
		"\u0000\u0146\u0147\u0005\u000f\u0000\u0000\u0147\u0148\u00050\u0000\u0000"+
		"\u0148\u0149\u0005!\u0000\u0000\u0149\u014a\u0005\u0010\u0000\u0000\u014a"+
		"\u014b\u00032\u0019\u0000\u014b7\u0001\u0000\u0000\u0000\u014c\u014d\u0005"+
		"\u000e\u0000\u0000\u014d\u014e\u0005\u0010\u0000\u0000\u014e\u014f\u0003"+
		"4\u001a\u0000\u014f9\u0001\u0000\u0000\u0000\u0150\u0151\u00054\u0000"+
		"\u0000\u0151\u0152\u0005 \u0000\u0000\u0152\u0153\u0003\"\u0011\u0000"+
		"\u0153\u0154\u0005!\u0000\u0000\u0154;\u0001\u0000\u0000\u0000\u0155\u0158"+
		"\u0003>\u001f\u0000\u0156\u0158\u0003:\u001d\u0000\u0157\u0155\u0001\u0000"+
		"\u0000\u0000\u0157\u0156\u0001\u0000\u0000\u0000\u0158=\u0001\u0000\u0000"+
		"\u0000\u0159\u015b\u0007\u0001\u0000\u0000\u015a\u0159\u0001\u0000\u0000"+
		"\u0000\u015a\u015b\u0001\u0000\u0000\u0000\u015b\u015c\u0001\u0000\u0000"+
		"\u0000\u015c\u0164\u00050\u0000\u0000\u015d\u015f\u0007\u0001\u0000\u0000"+
		"\u015e\u015d\u0001\u0000\u0000\u0000\u015e\u015f\u0001\u0000\u0000\u0000"+
		"\u015f\u0160\u0001\u0000\u0000\u0000\u0160\u0164\u00051\u0000\u0000\u0161"+
		"\u0164\u00053\u0000\u0000\u0162\u0164\u00052\u0000\u0000\u0163\u015a\u0001"+
		"\u0000\u0000\u0000\u0163\u015e\u0001\u0000\u0000\u0000\u0163\u0161\u0001"+
		"\u0000\u0000\u0000\u0163\u0162\u0001\u0000\u0000\u0000\u0164?\u0001\u0000"+
		"\u0000\u0000\"KPRX\\fnu\u007f\u0084\u008d\u009c\u00a4\u00ad\u00b5\u00bf"+
		"\u00c4\u00cd\u00d5\u00e0\u00e4\u00f5\u0106\u0108\u0116\u0120\u0126\u0133"+
		"\u0139\u0141\u0157\u015a\u015e\u0163";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}