// Generated from /home/juliana/Compilador-Pascal-MIPS/PascalLexer.g by ANTLR 4.9.2

    package parser;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PascalLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"INT_VALUE", "REAL_VALUE", "BOOLEAN_VALUE", "ID_VALUE", "STR_VALUE", 
			"LINE_COMMENT", "MULTILINE_COMMENT", "WS", "COMMENT", "PROGRAM", "CONST", 
			"VAR", "BEGIN", "END", "FUNCTION", "PROCEDURE", "INTEGER", "REAL", "BOOLEAN", 
			"STRING", "ARRAY", "RANGE", "OF", "IF", "THEN", "ELSE", "WHILE", "DO", 
			"AND", "OR", "NOT", "PLUS", "MINUS", "ASTERISK", "SLASH", "EQUAL", "LESSTHAN", 
			"GREATERTHAN", "LBRACK", "RBRACK", "PERIOD", "COMMA", "COLON", "SEMICOLON", 
			"LPAR", "RPAR", "NOTEQUAL", "LEQ", "BEQ", "BECOMES", "MOD", "READ", "WRITE", 
			"WRITELN", "INT_VAL", "REAL_VAL", "STRING_VAL", "BOOLEAN_VAL", "ID", 
			"UNKNOWN"
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


	public PascalLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "PascalLexer.g"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 59:
			UNKNOWN_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void UNKNOWN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			System.out.println("Error na linha: " + getLine() + " - Simbolo desconhecido: '" + getText() + "'") ; System.exit(1);
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\67\u0186\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t"+
		"=\3\2\6\2}\n\2\r\2\16\2~\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\5\4\u008e\n\4\3\5\3\5\7\5\u0092\n\5\f\5\16\5\u0095\13\5\3\6\3\6"+
		"\7\6\u0099\n\6\f\6\16\6\u009c\13\6\3\6\3\6\3\7\3\7\3\7\3\7\7\7\u00a4\n"+
		"\7\f\7\16\7\u00a7\13\7\3\7\3\7\3\b\3\b\7\b\u00ad\n\b\f\b\16\b\u00b0\13"+
		"\b\3\b\3\b\3\t\6\t\u00b5\n\t\r\t\16\t\u00b6\3\t\3\t\3\n\3\n\5\n\u00bd"+
		"\n\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3"+
		"\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3"+
		"\27\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3"+
		"\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3"+
		"\36\3\36\3\37\3\37\3\37\3 \3 \3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3"+
		"&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60"+
		"\3\60\3\61\3\61\3\61\3\62\3\62\3\62\3\63\3\63\3\63\3\64\3\64\3\64\3\64"+
		"\3\65\3\65\3\65\3\65\3\65\3\66\3\66\3\66\3\66\3\66\3\66\3\67\3\67\3\67"+
		"\3\67\3\67\3\67\3\67\3\67\38\38\39\39\3:\3:\3;\3;\3<\3<\3=\3=\3=\2\2>"+
		"\3\2\5\2\7\2\t\2\13\2\r\2\17\2\21\3\23\4\25\5\27\6\31\7\33\b\35\t\37\n"+
		"!\13#\f%\r\'\16)\17+\20-\21/\22\61\23\63\24\65\25\67\269\27;\30=\31?\32"+
		"A\33C\34E\35G\36I\37K M!O\"Q#S$U%W&Y\'[(])_*a+c,e-g.i/k\60m\61o\62q\63"+
		"s\64u\65w\66y\67\3\2\t\3\2\62;\4\2C\\c|\6\2\62;C\\aac|\3\2))\3\2\f\f\3"+
		"\2\177\177\4\2\13\f\"\"\2\u0186\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2"+
		"\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3"+
		"\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2"+
		"\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\2"+
		"9\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3"+
		"\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2"+
		"\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2"+
		"_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3"+
		"\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2"+
		"\2\2y\3\2\2\2\3|\3\2\2\2\5\u0080\3\2\2\2\7\u008d\3\2\2\2\t\u008f\3\2\2"+
		"\2\13\u0096\3\2\2\2\r\u009f\3\2\2\2\17\u00aa\3\2\2\2\21\u00b4\3\2\2\2"+
		"\23\u00bc\3\2\2\2\25\u00c0\3\2\2\2\27\u00c8\3\2\2\2\31\u00ce\3\2\2\2\33"+
		"\u00d2\3\2\2\2\35\u00d8\3\2\2\2\37\u00dc\3\2\2\2!\u00e5\3\2\2\2#\u00ef"+
		"\3\2\2\2%\u00f7\3\2\2\2\'\u00fc\3\2\2\2)\u0104\3\2\2\2+\u010b\3\2\2\2"+
		"-\u0111\3\2\2\2/\u0114\3\2\2\2\61\u0117\3\2\2\2\63\u011a\3\2\2\2\65\u011f"+
		"\3\2\2\2\67\u0124\3\2\2\29\u012a\3\2\2\2;\u012d\3\2\2\2=\u0131\3\2\2\2"+
		"?\u0134\3\2\2\2A\u0138\3\2\2\2C\u013a\3\2\2\2E\u013c\3\2\2\2G\u013e\3"+
		"\2\2\2I\u0140\3\2\2\2K\u0142\3\2\2\2M\u0144\3\2\2\2O\u0146\3\2\2\2Q\u0148"+
		"\3\2\2\2S\u014a\3\2\2\2U\u014c\3\2\2\2W\u014e\3\2\2\2Y\u0150\3\2\2\2["+
		"\u0152\3\2\2\2]\u0154\3\2\2\2_\u0156\3\2\2\2a\u0159\3\2\2\2c\u015c\3\2"+
		"\2\2e\u015f\3\2\2\2g\u0162\3\2\2\2i\u0166\3\2\2\2k\u016b\3\2\2\2m\u0171"+
		"\3\2\2\2o\u0179\3\2\2\2q\u017b\3\2\2\2s\u017d\3\2\2\2u\u017f\3\2\2\2w"+
		"\u0181\3\2\2\2y\u0183\3\2\2\2{}\t\2\2\2|{\3\2\2\2}~\3\2\2\2~|\3\2\2\2"+
		"~\177\3\2\2\2\177\4\3\2\2\2\u0080\u0081\5\3\2\2\u0081\u0082\7\60\2\2\u0082"+
		"\u0083\5\3\2\2\u0083\6\3\2\2\2\u0084\u0085\7v\2\2\u0085\u0086\7t\2\2\u0086"+
		"\u0087\7w\2\2\u0087\u008e\7g\2\2\u0088\u0089\7h\2\2\u0089\u008a\7c\2\2"+
		"\u008a\u008b\7n\2\2\u008b\u008c\7u\2\2\u008c\u008e\7g\2\2\u008d\u0084"+
		"\3\2\2\2\u008d\u0088\3\2\2\2\u008e\b\3\2\2\2\u008f\u0093\t\3\2\2\u0090"+
		"\u0092\t\4\2\2\u0091\u0090\3\2\2\2\u0092\u0095\3\2\2\2\u0093\u0091\3\2"+
		"\2\2\u0093\u0094\3\2\2\2\u0094\n\3\2\2\2\u0095\u0093\3\2\2\2\u0096\u009a"+
		"\t\5\2\2\u0097\u0099\n\5\2\2\u0098\u0097\3\2\2\2\u0099\u009c\3\2\2\2\u009a"+
		"\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009d\3\2\2\2\u009c\u009a\3\2"+
		"\2\2\u009d\u009e\t\5\2\2\u009e\f\3\2\2\2\u009f\u00a0\7\61\2\2\u00a0\u00a1"+
		"\7\61\2\2\u00a1\u00a5\3\2\2\2\u00a2\u00a4\n\6\2\2\u00a3\u00a2\3\2\2\2"+
		"\u00a4\u00a7\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a8"+
		"\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a8\u00a9\t\6\2\2\u00a9\16\3\2\2\2\u00aa"+
		"\u00ae\7}\2\2\u00ab\u00ad\n\7\2\2\u00ac\u00ab\3\2\2\2\u00ad\u00b0\3\2"+
		"\2\2\u00ae\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b1\3\2\2\2\u00b0"+
		"\u00ae\3\2\2\2\u00b1\u00b2\7\177\2\2\u00b2\20\3\2\2\2\u00b3\u00b5\t\b"+
		"\2\2\u00b4\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6"+
		"\u00b7\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b9\b\t\2\2\u00b9\22\3\2\2"+
		"\2\u00ba\u00bd\5\r\7\2\u00bb\u00bd\5\17\b\2\u00bc\u00ba\3\2\2\2\u00bc"+
		"\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00bf\b\n\2\2\u00bf\24\3\2\2"+
		"\2\u00c0\u00c1\7r\2\2\u00c1\u00c2\7t\2\2\u00c2\u00c3\7q\2\2\u00c3\u00c4"+
		"\7i\2\2\u00c4\u00c5\7t\2\2\u00c5\u00c6\7c\2\2\u00c6\u00c7\7o\2\2\u00c7"+
		"\26\3\2\2\2\u00c8\u00c9\7e\2\2\u00c9\u00ca\7q\2\2\u00ca\u00cb\7p\2\2\u00cb"+
		"\u00cc\7u\2\2\u00cc\u00cd\7v\2\2\u00cd\30\3\2\2\2\u00ce\u00cf\7x\2\2\u00cf"+
		"\u00d0\7c\2\2\u00d0\u00d1\7t\2\2\u00d1\32\3\2\2\2\u00d2\u00d3\7d\2\2\u00d3"+
		"\u00d4\7g\2\2\u00d4\u00d5\7i\2\2\u00d5\u00d6\7k\2\2\u00d6\u00d7\7p\2\2"+
		"\u00d7\34\3\2\2\2\u00d8\u00d9\7g\2\2\u00d9\u00da\7p\2\2\u00da\u00db\7"+
		"f\2\2\u00db\36\3\2\2\2\u00dc\u00dd\7h\2\2\u00dd\u00de\7w\2\2\u00de\u00df"+
		"\7p\2\2\u00df\u00e0\7e\2\2\u00e0\u00e1\7v\2\2\u00e1\u00e2\7k\2\2\u00e2"+
		"\u00e3\7q\2\2\u00e3\u00e4\7p\2\2\u00e4 \3\2\2\2\u00e5\u00e6\7r\2\2\u00e6"+
		"\u00e7\7t\2\2\u00e7\u00e8\7q\2\2\u00e8\u00e9\7e\2\2\u00e9\u00ea\7g\2\2"+
		"\u00ea\u00eb\7f\2\2\u00eb\u00ec\7w\2\2\u00ec\u00ed\7t\2\2\u00ed\u00ee"+
		"\7g\2\2\u00ee\"\3\2\2\2\u00ef\u00f0\7k\2\2\u00f0\u00f1\7p\2\2\u00f1\u00f2"+
		"\7v\2\2\u00f2\u00f3\7g\2\2\u00f3\u00f4\7i\2\2\u00f4\u00f5\7g\2\2\u00f5"+
		"\u00f6\7t\2\2\u00f6$\3\2\2\2\u00f7\u00f8\7t\2\2\u00f8\u00f9\7g\2\2\u00f9"+
		"\u00fa\7c\2\2\u00fa\u00fb\7n\2\2\u00fb&\3\2\2\2\u00fc\u00fd\7d\2\2\u00fd"+
		"\u00fe\7q\2\2\u00fe\u00ff\7q\2\2\u00ff\u0100\7n\2\2\u0100\u0101\7g\2\2"+
		"\u0101\u0102\7c\2\2\u0102\u0103\7p\2\2\u0103(\3\2\2\2\u0104\u0105\7u\2"+
		"\2\u0105\u0106\7v\2\2\u0106\u0107\7t\2\2\u0107\u0108\7k\2\2\u0108\u0109"+
		"\7p\2\2\u0109\u010a\7i\2\2\u010a*\3\2\2\2\u010b\u010c\7c\2\2\u010c\u010d"+
		"\7t\2\2\u010d\u010e\7t\2\2\u010e\u010f\7c\2\2\u010f\u0110\7{\2\2\u0110"+
		",\3\2\2\2\u0111\u0112\7\60\2\2\u0112\u0113\7\60\2\2\u0113.\3\2\2\2\u0114"+
		"\u0115\7q\2\2\u0115\u0116\7h\2\2\u0116\60\3\2\2\2\u0117\u0118\7k\2\2\u0118"+
		"\u0119\7h\2\2\u0119\62\3\2\2\2\u011a\u011b\7v\2\2\u011b\u011c\7j\2\2\u011c"+
		"\u011d\7g\2\2\u011d\u011e\7p\2\2\u011e\64\3\2\2\2\u011f\u0120\7g\2\2\u0120"+
		"\u0121\7n\2\2\u0121\u0122\7u\2\2\u0122\u0123\7g\2\2\u0123\66\3\2\2\2\u0124"+
		"\u0125\7y\2\2\u0125\u0126\7j\2\2\u0126\u0127\7k\2\2\u0127\u0128\7n\2\2"+
		"\u0128\u0129\7g\2\2\u01298\3\2\2\2\u012a\u012b\7f\2\2\u012b\u012c\7q\2"+
		"\2\u012c:\3\2\2\2\u012d\u012e\7c\2\2\u012e\u012f\7p\2\2\u012f\u0130\7"+
		"f\2\2\u0130<\3\2\2\2\u0131\u0132\7q\2\2\u0132\u0133\7t\2\2\u0133>\3\2"+
		"\2\2\u0134\u0135\7p\2\2\u0135\u0136\7q\2\2\u0136\u0137\7v\2\2\u0137@\3"+
		"\2\2\2\u0138\u0139\7-\2\2\u0139B\3\2\2\2\u013a\u013b\7/\2\2\u013bD\3\2"+
		"\2\2\u013c\u013d\7,\2\2\u013dF\3\2\2\2\u013e\u013f\7\61\2\2\u013fH\3\2"+
		"\2\2\u0140\u0141\7?\2\2\u0141J\3\2\2\2\u0142\u0143\7>\2\2\u0143L\3\2\2"+
		"\2\u0144\u0145\7@\2\2\u0145N\3\2\2\2\u0146\u0147\7]\2\2\u0147P\3\2\2\2"+
		"\u0148\u0149\7_\2\2\u0149R\3\2\2\2\u014a\u014b\7\60\2\2\u014bT\3\2\2\2"+
		"\u014c\u014d\7.\2\2\u014dV\3\2\2\2\u014e\u014f\7<\2\2\u014fX\3\2\2\2\u0150"+
		"\u0151\7=\2\2\u0151Z\3\2\2\2\u0152\u0153\7*\2\2\u0153\\\3\2\2\2\u0154"+
		"\u0155\7+\2\2\u0155^\3\2\2\2\u0156\u0157\7>\2\2\u0157\u0158\7@\2\2\u0158"+
		"`\3\2\2\2\u0159\u015a\7>\2\2\u015a\u015b\7?\2\2\u015bb\3\2\2\2\u015c\u015d"+
		"\7@\2\2\u015d\u015e\7?\2\2\u015ed\3\2\2\2\u015f\u0160\7<\2\2\u0160\u0161"+
		"\7?\2\2\u0161f\3\2\2\2\u0162\u0163\7o\2\2\u0163\u0164\7q\2\2\u0164\u0165"+
		"\7f\2\2\u0165h\3\2\2\2\u0166\u0167\7t\2\2\u0167\u0168\7g\2\2\u0168\u0169"+
		"\7c\2\2\u0169\u016a\7f\2\2\u016aj\3\2\2\2\u016b\u016c\7y\2\2\u016c\u016d"+
		"\7t\2\2\u016d\u016e\7k\2\2\u016e\u016f\7v\2\2\u016f\u0170\7g\2\2\u0170"+
		"l\3\2\2\2\u0171\u0172\7y\2\2\u0172\u0173\7t\2\2\u0173\u0174\7k\2\2\u0174"+
		"\u0175\7v\2\2\u0175\u0176\7g\2\2\u0176\u0177\7n\2\2\u0177\u0178\7p\2\2"+
		"\u0178n\3\2\2\2\u0179\u017a\5\3\2\2\u017ap\3\2\2\2\u017b\u017c\5\5\3\2"+
		"\u017cr\3\2\2\2\u017d\u017e\5\13\6\2\u017et\3\2\2\2\u017f\u0180\5\7\4"+
		"\2\u0180v\3\2\2\2\u0181\u0182\5\t\5\2\u0182x\3\2\2\2\u0183\u0184\13\2"+
		"\2\2\u0184\u0185\b=\3\2\u0185z\3\2\2\2\13\2~\u008d\u0093\u009a\u00a5\u00ae"+
		"\u00b6\u00bc\4\b\2\2\3=\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}