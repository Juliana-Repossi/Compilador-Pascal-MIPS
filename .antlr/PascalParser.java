// Generated from /home/juliana/Compilador-Pascal-MIPS/PascalParser.g by ANTLR 4.9.2

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
		WRITELN=47, INT_VAL=48, REAL_VAL=49, STRING_VAL=50, BOOLEAN_VAL=51, ID=52, 
		UNKNOWN=53;
	public static final int
		RULE_begin = 0, RULE_program = 1, RULE_program_pascal = 2, RULE_const_var_section = 3, 
		RULE_const_section = 4, RULE_var_section = 5, RULE_var = 6, RULE_procedure = 7, 
		RULE_function = 8, RULE_parameter_list = 9, RULE_parameters = 10, RULE_var_parameter = 11, 
		RULE_constant = 12, RULE_parameter = 13, RULE_block = 14, RULE_statement = 15, 
		RULE_atribution = 16, RULE_expr = 17, RULE_while_block = 18, RULE_if_block = 19, 
		RULE_param_call = 20, RULE_call_function_procedure = 21, RULE_write_io = 22, 
		RULE_read_io = 23, RULE_type = 24, RULE_type_simple = 25, RULE_array_type_range = 26, 
		RULE_array_type = 27, RULE_acess_array = 28, RULE_val_simple_array = 29, 
		RULE_val_simple = 30;
	private static String[] makeRuleNames() {
		return new String[] {
			"begin", "program", "program_pascal", "const_var_section", "const_section", 
			"var_section", "var", "procedure", "function", "parameter_list", "parameters", 
			"var_parameter", "constant", "parameter", "block", "statement", "atribution", 
			"expr", "while_block", "if_block", "param_call", "call_function_procedure", 
			"write_io", "read_io", "type", "type_simple", "array_type_range", "array_type", 
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
			"REAL_VAL", "STRING_VAL", "BOOLEAN_VAL", "ID", "UNKNOWN"
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
			setState(62);
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
			setState(64);
			match(PROGRAM);
			setState(65);
			match(ID);
			setState(66);
			match(SEMICOLON);
			setState(67);
			program_pascal();
			setState(68);
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
	}

	public final Program_pascalContext program_pascal() throws RecognitionException {
		Program_pascalContext _localctx = new Program_pascalContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_program_pascal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CONST || _la==VAR) {
				{
				{
				setState(70);
				const_var_section();
				}
				}
				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FUNCTION || _la==PROCEDURE) {
				{
				setState(78);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PROCEDURE:
					{
					setState(76);
					procedure();
					}
					break;
				case FUNCTION:
					{
					setState(77);
					function();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(82);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(84); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(83);
				block();
				}
				}
				setState(86); 
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
	}

	public final Const_var_sectionContext const_var_section() throws RecognitionException {
		Const_var_sectionContext _localctx = new Const_var_sectionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_const_var_section);
		try {
			setState(90);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONST:
				enterOuterAlt(_localctx, 1);
				{
				setState(88);
				const_section();
				}
				break;
			case VAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(89);
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
			setState(92);
			match(CONST);
			setState(98); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(93);
				match(ID);
				setState(94);
				match(EQUAL);
				setState(95);
				val_simple();
				setState(96);
				match(SEMICOLON);
				}
				}
				setState(100); 
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
			setState(102);
			match(VAR);
			setState(106); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(103);
				var();
				setState(104);
				match(SEMICOLON);
				}
				}
				setState(108); 
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
		public TerminalNode COLON() { return getToken(PascalParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(PascalParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PascalParser.ID, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PascalParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PascalParser.COMMA, i);
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
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(110);
			match(ID);
			}
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(111);
				match(COMMA);
				setState(112);
				match(ID);
				}
				}
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(118);
			match(COLON);
			setState(119);
			type();
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
	}

	public final ProcedureContext procedure() throws RecognitionException {
		ProcedureContext _localctx = new ProcedureContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_procedure);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			match(PROCEDURE);
			setState(122);
			match(ID);
			setState(123);
			parameter_list();
			setState(124);
			match(SEMICOLON);
			setState(128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CONST || _la==VAR) {
				{
				{
				setState(125);
				const_var_section();
				}
				}
				setState(130);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(131);
			block();
			setState(132);
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
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
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
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(FUNCTION);
			setState(135);
			match(ID);
			setState(136);
			parameter_list();
			setState(137);
			match(COLON);
			setState(138);
			type();
			setState(139);
			match(SEMICOLON);
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CONST || _la==VAR) {
				{
				{
				setState(140);
				const_var_section();
				}
				}
				setState(145);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(146);
			block();
			setState(147);
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
			setState(149);
			match(LPAR);
			setState(151);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONST || _la==ID) {
				{
				setState(150);
				parameters();
				}
			}

			setState(153);
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
			setState(155);
			parameter();
			setState(160);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEMICOLON) {
				{
				{
				setState(156);
				match(SEMICOLON);
				setState(157);
				parameter();
				}
				}
				setState(162);
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
			setState(183);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(163);
				match(ID);
				setState(168);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(164);
					match(COMMA);
					setState(165);
					match(ID);
					}
					}
					setState(170);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(171);
				match(COLON);
				setState(172);
				type_simple();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(173);
				match(ID);
				setState(178);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(174);
					match(COMMA);
					setState(175);
					match(ID);
					}
					}
					setState(180);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(181);
				match(COLON);
				setState(182);
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
			setState(185);
			match(CONST);
			setState(186);
			match(ID);
			setState(187);
			match(COLON);
			setState(188);
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
			setState(192);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(190);
				var_parameter();
				}
				break;
			case CONST:
				enterOuterAlt(_localctx, 2);
				{
				setState(191);
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
			setState(194);
			match(BEGIN);
			setState(200);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << READ) | (1L << WRITE) | (1L << WRITELN) | (1L << ID))) != 0)) {
				{
				{
				setState(195);
				statement();
				setState(196);
				match(SEMICOLON);
				}
				}
				setState(202);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(203);
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
			setState(211);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(205);
				atribution();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(206);
				while_block();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(207);
				if_block();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(208);
				call_function_procedure();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(209);
				read_io();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(210);
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
			setState(215);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(213);
				match(ID);
				}
				break;
			case 2:
				{
				setState(214);
				acess_array();
				}
				break;
			}
			setState(217);
			match(BECOMES);
			{
			setState(218);
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
			setState(232);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				_localctx = new Expr_parContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(221);
				match(LPAR);
				setState(222);
				expr(0);
				setState(223);
				match(RPAR);
				}
				break;
			case 2:
				{
				_localctx = new Expr_notContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(225);
				match(NOT);
				setState(226);
				expr(10);
				}
				break;
			case 3:
				{
				_localctx = new Expr_minusContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(227);
				match(MINUS);
				setState(228);
				expr(9);
				}
				break;
			case 4:
				{
				_localctx = new Expr_idContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(229);
				match(ID);
				}
				break;
			case 5:
				{
				_localctx = new Expr_callContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(230);
				call_function_procedure();
				}
				break;
			case 6:
				{
				_localctx = new Expr_arrayContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(231);
				val_simple_array();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(251);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(249);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						_localctx = new Expr_divContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(234);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(235);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ASTERISK) | (1L << SLASH) | (1L << MOD))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(236);
						expr(9);
						}
						break;
					case 2:
						{
						_localctx = new Expr_andContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(237);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(238);
						match(AND);
						setState(239);
						expr(8);
						}
						break;
					case 3:
						{
						_localctx = new Expr_plusContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(240);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(241);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(242);
						expr(7);
						}
						break;
					case 4:
						{
						_localctx = new Expr_orContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(243);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(244);
						match(OR);
						setState(245);
						expr(6);
						}
						break;
					case 5:
						{
						_localctx = new Expr_equalContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(246);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(247);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQUAL) | (1L << LESSTHAN) | (1L << GREATERTHAN) | (1L << NOTEQUAL) | (1L << LEQ) | (1L << BEQ))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(248);
						expr(5);
						}
						break;
					}
					} 
				}
				setState(253);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
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
			setState(254);
			match(WHILE);
			setState(255);
			expr(0);
			setState(256);
			match(DO);
			setState(257);
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
			setState(259);
			match(IF);
			setState(260);
			expr(0);
			setState(261);
			match(THEN);
			setState(262);
			block();
			setState(265);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(263);
				match(ELSE);
				setState(264);
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
			setState(268);
			expr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(275);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Param_callContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_param_call);
					setState(270);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(271);
					match(COMMA);
					setState(272);
					param_call(2);
					}
					} 
				}
				setState(277);
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
	}

	public final Call_function_procedureContext call_function_procedure() throws RecognitionException {
		Call_function_procedureContext _localctx = new Call_function_procedureContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_call_function_procedure);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			match(ID);
			setState(279);
			match(LPAR);
			setState(281);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT) | (1L << PLUS) | (1L << MINUS) | (1L << LPAR) | (1L << INT_VAL) | (1L << REAL_VAL) | (1L << STRING_VAL) | (1L << BOOLEAN_VAL) | (1L << ID))) != 0)) {
				{
				setState(280);
				param_call(0);
				}
			}

			setState(283);
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
		enterRule(_localctx, 44, RULE_write_io);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
			_la = _input.LA(1);
			if ( !(_la==WRITE || _la==WRITELN) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(286);
			match(LPAR);
			{
			setState(287);
			expr(0);
			}
			setState(288);
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
		enterRule(_localctx, 46, RULE_read_io);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(290);
			match(READ);
			setState(291);
			match(LPAR);
			setState(294);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				{
				setState(292);
				match(ID);
				}
				break;
			case 2:
				{
				setState(293);
				acess_array();
				}
				break;
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
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_type);
		try {
			setState(300);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER:
			case REAL:
			case BOOLEAN:
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(298);
				type_simple();
				}
				break;
			case ARRAY:
				enterOuterAlt(_localctx, 2);
				{
				setState(299);
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
		enterRule(_localctx, 50, RULE_type_simple);
		try {
			setState(306);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER:
				_localctx = new Type_simple_integerContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(302);
				match(INTEGER);
				}
				break;
			case REAL:
				_localctx = new Type_simple_realContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(303);
				match(REAL);
				}
				break;
			case BOOLEAN:
				_localctx = new Type_simple_booleanContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(304);
				match(BOOLEAN);
				}
				break;
			case STRING:
				_localctx = new Type_simple_stringContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(305);
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
		public Type_simpleContext type_simple() {
			return getRuleContext(Type_simpleContext.class,0);
		}
		public Array_type_rangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_type_range; }
	}

	public final Array_type_rangeContext array_type_range() throws RecognitionException {
		Array_type_rangeContext _localctx = new Array_type_rangeContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_array_type_range);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
			match(ARRAY);
			setState(309);
			match(LBRACK);
			setState(310);
			match(INT_VAL);
			setState(311);
			match(RANGE);
			setState(312);
			match(INT_VAL);
			setState(313);
			match(RBRACK);
			setState(314);
			match(OF);
			setState(315);
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
	}

	public final Array_typeContext array_type() throws RecognitionException {
		Array_typeContext _localctx = new Array_typeContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_array_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(317);
			match(ARRAY);
			setState(318);
			match(OF);
			setState(319);
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
		enterRule(_localctx, 56, RULE_acess_array);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(321);
			match(ID);
			setState(322);
			match(LBRACK);
			{
			setState(323);
			expr(0);
			}
			setState(324);
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
		enterRule(_localctx, 58, RULE_val_simple_array);
		try {
			setState(328);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLUS:
			case MINUS:
			case INT_VAL:
			case REAL_VAL:
			case STRING_VAL:
			case BOOLEAN_VAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(326);
				val_simple();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(327);
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
		enterRule(_localctx, 60, RULE_val_simple);
		int _la;
		try {
			setState(340);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				_localctx = new Int_valContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(331);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PLUS || _la==MINUS) {
					{
					setState(330);
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

				setState(333);
				match(INT_VAL);
				}
				break;
			case 2:
				_localctx = new Real_valContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(335);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PLUS || _la==MINUS) {
					{
					setState(334);
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

				setState(337);
				match(REAL_VAL);
				}
				break;
			case 3:
				_localctx = new String_valContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(338);
				match(STRING_VAL);
				}
				break;
			case 4:
				_localctx = new Boolean_valContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(339);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\67\u0159\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \3\2"+
		"\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\7\4J\n\4\f\4\16\4M\13\4\3\4\3\4\7\4Q"+
		"\n\4\f\4\16\4T\13\4\3\4\6\4W\n\4\r\4\16\4X\3\5\3\5\5\5]\n\5\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\6\6e\n\6\r\6\16\6f\3\7\3\7\3\7\3\7\6\7m\n\7\r\7\16\7n\3"+
		"\b\3\b\3\b\7\bt\n\b\f\b\16\bw\13\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\7\t"+
		"\u0081\n\t\f\t\16\t\u0084\13\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\7\n\u0090\n\n\f\n\16\n\u0093\13\n\3\n\3\n\3\n\3\13\3\13\5\13\u009a\n"+
		"\13\3\13\3\13\3\f\3\f\3\f\7\f\u00a1\n\f\f\f\16\f\u00a4\13\f\3\r\3\r\3"+
		"\r\7\r\u00a9\n\r\f\r\16\r\u00ac\13\r\3\r\3\r\3\r\3\r\3\r\7\r\u00b3\n\r"+
		"\f\r\16\r\u00b6\13\r\3\r\3\r\5\r\u00ba\n\r\3\16\3\16\3\16\3\16\3\16\3"+
		"\17\3\17\5\17\u00c3\n\17\3\20\3\20\3\20\3\20\7\20\u00c9\n\20\f\20\16\20"+
		"\u00cc\13\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00d6\n\21\3"+
		"\22\3\22\5\22\u00da\n\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00eb\n\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\7\23\u00fc\n\23\f\23"+
		"\16\23\u00ff\13\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\5\25\u010c\n\25\3\26\3\26\3\26\3\26\3\26\3\26\7\26\u0114\n\26\f\26"+
		"\16\26\u0117\13\26\3\27\3\27\3\27\5\27\u011c\n\27\3\27\3\27\3\30\3\30"+
		"\3\30\3\30\3\30\3\31\3\31\3\31\3\31\5\31\u0129\n\31\3\31\3\31\3\32\3\32"+
		"\5\32\u012f\n\32\3\33\3\33\3\33\3\33\5\33\u0135\n\33\3\34\3\34\3\34\3"+
		"\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3"+
		"\36\3\37\3\37\5\37\u014b\n\37\3 \5 \u014e\n \3 \3 \5 \u0152\n \3 \3 \3"+
		" \5 \u0157\n \3 \2\4$*!\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*"+
		",.\60\62\64\668:<>\2\6\4\2\35\36..\3\2\33\34\4\2\37!*,\3\2\60\61\2\u0168"+
		"\2@\3\2\2\2\4B\3\2\2\2\6K\3\2\2\2\b\\\3\2\2\2\n^\3\2\2\2\fh\3\2\2\2\16"+
		"p\3\2\2\2\20{\3\2\2\2\22\u0088\3\2\2\2\24\u0097\3\2\2\2\26\u009d\3\2\2"+
		"\2\30\u00b9\3\2\2\2\32\u00bb\3\2\2\2\34\u00c2\3\2\2\2\36\u00c4\3\2\2\2"+
		" \u00d5\3\2\2\2\"\u00d9\3\2\2\2$\u00ea\3\2\2\2&\u0100\3\2\2\2(\u0105\3"+
		"\2\2\2*\u010d\3\2\2\2,\u0118\3\2\2\2.\u011f\3\2\2\2\60\u0124\3\2\2\2\62"+
		"\u012e\3\2\2\2\64\u0134\3\2\2\2\66\u0136\3\2\2\28\u013f\3\2\2\2:\u0143"+
		"\3\2\2\2<\u014a\3\2\2\2>\u0156\3\2\2\2@A\5\4\3\2A\3\3\2\2\2BC\7\5\2\2"+
		"CD\7\66\2\2DE\7\'\2\2EF\5\6\4\2FG\7$\2\2G\5\3\2\2\2HJ\5\b\5\2IH\3\2\2"+
		"\2JM\3\2\2\2KI\3\2\2\2KL\3\2\2\2LR\3\2\2\2MK\3\2\2\2NQ\5\20\t\2OQ\5\22"+
		"\n\2PN\3\2\2\2PO\3\2\2\2QT\3\2\2\2RP\3\2\2\2RS\3\2\2\2SV\3\2\2\2TR\3\2"+
		"\2\2UW\5\36\20\2VU\3\2\2\2WX\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y\7\3\2\2\2Z]"+
		"\5\n\6\2[]\5\f\7\2\\Z\3\2\2\2\\[\3\2\2\2]\t\3\2\2\2^d\7\6\2\2_`\7\66\2"+
		"\2`a\7\37\2\2ab\5> \2bc\7\'\2\2ce\3\2\2\2d_\3\2\2\2ef\3\2\2\2fd\3\2\2"+
		"\2fg\3\2\2\2g\13\3\2\2\2hl\7\7\2\2ij\5\16\b\2jk\7\'\2\2km\3\2\2\2li\3"+
		"\2\2\2mn\3\2\2\2nl\3\2\2\2no\3\2\2\2o\r\3\2\2\2pu\7\66\2\2qr\7%\2\2rt"+
		"\7\66\2\2sq\3\2\2\2tw\3\2\2\2us\3\2\2\2uv\3\2\2\2vx\3\2\2\2wu\3\2\2\2"+
		"xy\7&\2\2yz\5\62\32\2z\17\3\2\2\2{|\7\13\2\2|}\7\66\2\2}~\5\24\13\2~\u0082"+
		"\7\'\2\2\177\u0081\5\b\5\2\u0080\177\3\2\2\2\u0081\u0084\3\2\2\2\u0082"+
		"\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0085\3\2\2\2\u0084\u0082\3\2"+
		"\2\2\u0085\u0086\5\36\20\2\u0086\u0087\7\'\2\2\u0087\21\3\2\2\2\u0088"+
		"\u0089\7\n\2\2\u0089\u008a\7\66\2\2\u008a\u008b\5\24\13\2\u008b\u008c"+
		"\7&\2\2\u008c\u008d\5\62\32\2\u008d\u0091\7\'\2\2\u008e\u0090\5\b\5\2"+
		"\u008f\u008e\3\2\2\2\u0090\u0093\3\2\2\2\u0091\u008f\3\2\2\2\u0091\u0092"+
		"\3\2\2\2\u0092\u0094\3\2\2\2\u0093\u0091\3\2\2\2\u0094\u0095\5\36\20\2"+
		"\u0095\u0096\7\'\2\2\u0096\23\3\2\2\2\u0097\u0099\7(\2\2\u0098\u009a\5"+
		"\26\f\2\u0099\u0098\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009b\3\2\2\2\u009b"+
		"\u009c\7)\2\2\u009c\25\3\2\2\2\u009d\u00a2\5\34\17\2\u009e\u009f\7\'\2"+
		"\2\u009f\u00a1\5\34\17\2\u00a0\u009e\3\2\2\2\u00a1\u00a4\3\2\2\2\u00a2"+
		"\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\27\3\2\2\2\u00a4\u00a2\3\2\2"+
		"\2\u00a5\u00aa\7\66\2\2\u00a6\u00a7\7%\2\2\u00a7\u00a9\7\66\2\2\u00a8"+
		"\u00a6\3\2\2\2\u00a9\u00ac\3\2\2\2\u00aa\u00a8\3\2\2\2\u00aa\u00ab\3\2"+
		"\2\2\u00ab\u00ad\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ad\u00ae\7&\2\2\u00ae"+
		"\u00ba\5\64\33\2\u00af\u00b4\7\66\2\2\u00b0\u00b1\7%\2\2\u00b1\u00b3\7"+
		"\66\2\2\u00b2\u00b0\3\2\2\2\u00b3\u00b6\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b4"+
		"\u00b5\3\2\2\2\u00b5\u00b7\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b7\u00b8\7&"+
		"\2\2\u00b8\u00ba\58\35\2\u00b9\u00a5\3\2\2\2\u00b9\u00af\3\2\2\2\u00ba"+
		"\31\3\2\2\2\u00bb\u00bc\7\6\2\2\u00bc\u00bd\7\66\2\2\u00bd\u00be\7&\2"+
		"\2\u00be\u00bf\5\64\33\2\u00bf\33\3\2\2\2\u00c0\u00c3\5\30\r\2\u00c1\u00c3"+
		"\5\32\16\2\u00c2\u00c0\3\2\2\2\u00c2\u00c1\3\2\2\2\u00c3\35\3\2\2\2\u00c4"+
		"\u00ca\7\b\2\2\u00c5\u00c6\5 \21\2\u00c6\u00c7\7\'\2\2\u00c7\u00c9\3\2"+
		"\2\2\u00c8\u00c5\3\2\2\2\u00c9\u00cc\3\2\2\2\u00ca\u00c8\3\2\2\2\u00ca"+
		"\u00cb\3\2\2\2\u00cb\u00cd\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cd\u00ce\7\t"+
		"\2\2\u00ce\37\3\2\2\2\u00cf\u00d6\5\"\22\2\u00d0\u00d6\5&\24\2\u00d1\u00d6"+
		"\5(\25\2\u00d2\u00d6\5,\27\2\u00d3\u00d6\5\60\31\2\u00d4\u00d6\5.\30\2"+
		"\u00d5\u00cf\3\2\2\2\u00d5\u00d0\3\2\2\2\u00d5\u00d1\3\2\2\2\u00d5\u00d2"+
		"\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d5\u00d4\3\2\2\2\u00d6!\3\2\2\2\u00d7"+
		"\u00da\7\66\2\2\u00d8\u00da\5:\36\2\u00d9\u00d7\3\2\2\2\u00d9\u00d8\3"+
		"\2\2\2\u00da\u00db\3\2\2\2\u00db\u00dc\7-\2\2\u00dc\u00dd\5$\23\2\u00dd"+
		"#\3\2\2\2\u00de\u00df\b\23\1\2\u00df\u00e0\7(\2\2\u00e0\u00e1\5$\23\2"+
		"\u00e1\u00e2\7)\2\2\u00e2\u00eb\3\2\2\2\u00e3\u00e4\7\32\2\2\u00e4\u00eb"+
		"\5$\23\f\u00e5\u00e6\7\34\2\2\u00e6\u00eb\5$\23\13\u00e7\u00eb\7\66\2"+
		"\2\u00e8\u00eb\5,\27\2\u00e9\u00eb\5<\37\2\u00ea\u00de\3\2\2\2\u00ea\u00e3"+
		"\3\2\2\2\u00ea\u00e5\3\2\2\2\u00ea\u00e7\3\2\2\2\u00ea\u00e8\3\2\2\2\u00ea"+
		"\u00e9\3\2\2\2\u00eb\u00fd\3\2\2\2\u00ec\u00ed\f\n\2\2\u00ed\u00ee\t\2"+
		"\2\2\u00ee\u00fc\5$\23\13\u00ef\u00f0\f\t\2\2\u00f0\u00f1\7\30\2\2\u00f1"+
		"\u00fc\5$\23\n\u00f2\u00f3\f\b\2\2\u00f3\u00f4\t\3\2\2\u00f4\u00fc\5$"+
		"\23\t\u00f5\u00f6\f\7\2\2\u00f6\u00f7\7\31\2\2\u00f7\u00fc\5$\23\b\u00f8"+
		"\u00f9\f\6\2\2\u00f9\u00fa\t\4\2\2\u00fa\u00fc\5$\23\7\u00fb\u00ec\3\2"+
		"\2\2\u00fb\u00ef\3\2\2\2\u00fb\u00f2\3\2\2\2\u00fb\u00f5\3\2\2\2\u00fb"+
		"\u00f8\3\2\2\2\u00fc\u00ff\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fd\u00fe\3\2"+
		"\2\2\u00fe%\3\2\2\2\u00ff\u00fd\3\2\2\2\u0100\u0101\7\26\2\2\u0101\u0102"+
		"\5$\23\2\u0102\u0103\7\27\2\2\u0103\u0104\5\36\20\2\u0104\'\3\2\2\2\u0105"+
		"\u0106\7\23\2\2\u0106\u0107\5$\23\2\u0107\u0108\7\24\2\2\u0108\u010b\5"+
		"\36\20\2\u0109\u010a\7\25\2\2\u010a\u010c\5\36\20\2\u010b\u0109\3\2\2"+
		"\2\u010b\u010c\3\2\2\2\u010c)\3\2\2\2\u010d\u010e\b\26\1\2\u010e\u010f"+
		"\5$\23\2\u010f\u0115\3\2\2\2\u0110\u0111\f\3\2\2\u0111\u0112\7%\2\2\u0112"+
		"\u0114\5*\26\4\u0113\u0110\3\2\2\2\u0114\u0117\3\2\2\2\u0115\u0113\3\2"+
		"\2\2\u0115\u0116\3\2\2\2\u0116+\3\2\2\2\u0117\u0115\3\2\2\2\u0118\u0119"+
		"\7\66\2\2\u0119\u011b\7(\2\2\u011a\u011c\5*\26\2\u011b\u011a\3\2\2\2\u011b"+
		"\u011c\3\2\2\2\u011c\u011d\3\2\2\2\u011d\u011e\7)\2\2\u011e-\3\2\2\2\u011f"+
		"\u0120\t\5\2\2\u0120\u0121\7(\2\2\u0121\u0122\5$\23\2\u0122\u0123\7)\2"+
		"\2\u0123/\3\2\2\2\u0124\u0125\7/\2\2\u0125\u0128\7(\2\2\u0126\u0129\7"+
		"\66\2\2\u0127\u0129\5:\36\2\u0128\u0126\3\2\2\2\u0128\u0127\3\2\2\2\u0129"+
		"\u012a\3\2\2\2\u012a\u012b\7)\2\2\u012b\61\3\2\2\2\u012c\u012f\5\64\33"+
		"\2\u012d\u012f\5\66\34\2\u012e\u012c\3\2\2\2\u012e\u012d\3\2\2\2\u012f"+
		"\63\3\2\2\2\u0130\u0135\7\f\2\2\u0131\u0135\7\r\2\2\u0132\u0135\7\16\2"+
		"\2\u0133\u0135\7\17\2\2\u0134\u0130\3\2\2\2\u0134\u0131\3\2\2\2\u0134"+
		"\u0132\3\2\2\2\u0134\u0133\3\2\2\2\u0135\65\3\2\2\2\u0136\u0137\7\20\2"+
		"\2\u0137\u0138\7\"\2\2\u0138\u0139\7\62\2\2\u0139\u013a\7\21\2\2\u013a"+
		"\u013b\7\62\2\2\u013b\u013c\7#\2\2\u013c\u013d\7\22\2\2\u013d\u013e\5"+
		"\64\33\2\u013e\67\3\2\2\2\u013f\u0140\7\20\2\2\u0140\u0141\7\22\2\2\u0141"+
		"\u0142\5\64\33\2\u01429\3\2\2\2\u0143\u0144\7\66\2\2\u0144\u0145\7\"\2"+
		"\2\u0145\u0146\5$\23\2\u0146\u0147\7#\2\2\u0147;\3\2\2\2\u0148\u014b\5"+
		"> \2\u0149\u014b\5:\36\2\u014a\u0148\3\2\2\2\u014a\u0149\3\2\2\2\u014b"+
		"=\3\2\2\2\u014c\u014e\t\3\2\2\u014d\u014c\3\2\2\2\u014d\u014e\3\2\2\2"+
		"\u014e\u014f\3\2\2\2\u014f\u0157\7\62\2\2\u0150\u0152\t\3\2\2\u0151\u0150"+
		"\3\2\2\2\u0151\u0152\3\2\2\2\u0152\u0153\3\2\2\2\u0153\u0157\7\63\2\2"+
		"\u0154\u0157\7\64\2\2\u0155\u0157\7\65\2\2\u0156\u014d\3\2\2\2\u0156\u0151"+
		"\3\2\2\2\u0156\u0154\3\2\2\2\u0156\u0155\3\2\2\2\u0157?\3\2\2\2\"KPRX"+
		"\\fnu\u0082\u0091\u0099\u00a2\u00aa\u00b4\u00b9\u00c2\u00ca\u00d5\u00d9"+
		"\u00ea\u00fb\u00fd\u010b\u0115\u011b\u0128\u012e\u0134\u014a\u014d\u0151"+
		"\u0156";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}