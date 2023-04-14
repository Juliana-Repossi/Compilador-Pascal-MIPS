// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class Pascal extends Lexer {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, COMMENT=2, PROGRAM=3, CONST=4, VAR=5, BEGIN=6, END=7, FUNCTION=8, 
		PROCEDURE=9, INTEGER=10, REAL=11, BOOLEAN=12, STRING=13, CHAR=14, ARRAY=15, 
		RANGE=16, OF=17, IF=18, THEN=19, ELSE=20, WHILE=21, DO=22, AND=23, OR=24, 
		NOT=25, PLUS=26, MINUS=27, ASTERISK=28, SLASH=29, EQUAL=30, LESSTHAN=31, 
		GREATERTHAN=32, LBRACK=33, RBRACK=34, PERIOD=35, COMMA=36, COLON=37, SEMICOLON=38, 
		LPAR=39, RPAR=40, NOTEQUAL=41, LEQ=42, BEQ=43, BECOMES=44, MOD=45, READ=46, 
		WRITE=47, WRITELN=48, INT_VAL=49, REAL_VAL=50, STRING_VAL=51, BOOLEAN_VAL=52, 
		ID=53, UNKNOWN=54;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"INT_VALUE", "REAL_VALUE", "BOOLEAN_VALUE", "ID_VALUE", "STR_VALUE", 
			"LINE_COMMENT", "MULTILINE_COMMENT1", "WS", "COMMENT", "PROGRAM", "CONST", 
			"VAR", "BEGIN", "END", "FUNCTION", "PROCEDURE", "INTEGER", "REAL", "BOOLEAN", 
			"STRING", "CHAR", "ARRAY", "RANGE", "OF", "IF", "THEN", "ELSE", "WHILE", 
			"DO", "AND", "OR", "NOT", "PLUS", "MINUS", "ASTERISK", "SLASH", "EQUAL", 
			"LESSTHAN", "GREATERTHAN", "LBRACK", "RBRACK", "PERIOD", "COMMA", "COLON", 
			"SEMICOLON", "LPAR", "RPAR", "NOTEQUAL", "LEQ", "BEQ", "BECOMES", "MOD", 
			"READ", "WRITE", "WRITELN", "INT_VAL", "REAL_VAL", "STRING_VAL", "BOOLEAN_VAL", 
			"ID", "UNKNOWN"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'program'", "'const'", "'var'", "'begin'", "'end'", 
			"'function'", "'procedure'", "'integer'", "'real'", "'boolean'", "'string'", 
			"'char'", "'array'", "'..'", "'of'", "'if'", "'then'", "'else'", "'while'", 
			"'do'", "'and'", "'or'", "'not'", "'+'", "'-'", "'*'", "'/'", "'='", 
			"'<'", "'>'", "'['", "']'", "'.'", "','", "':'", "';'", "'('", "')'", 
			"'<>'", "'<='", "'>='", "':='", "'mod'", "'read'", "'write'", "'writeln'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WS", "COMMENT", "PROGRAM", "CONST", "VAR", "BEGIN", "END", "FUNCTION", 
			"PROCEDURE", "INTEGER", "REAL", "BOOLEAN", "STRING", "CHAR", "ARRAY", 
			"RANGE", "OF", "IF", "THEN", "ELSE", "WHILE", "DO", "AND", "OR", "NOT", 
			"PLUS", "MINUS", "ASTERISK", "SLASH", "EQUAL", "LESSTHAN", "GREATERTHAN", 
			"LBRACK", "RBRACK", "PERIOD", "COMMA", "COLON", "SEMICOLON", "LPAR", 
			"RPAR", "NOTEQUAL", "LEQ", "BEQ", "BECOMES", "MOD", "READ", "WRITE", 
			"WRITELN", "INT_VAL", "REAL_VAL", "STRING_VAL", "BOOLEAN_VAL", "ID", 
			"UNKNOWN"
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


	public Pascal(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Pascal.g"; }

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
		case 60:
			UNKNOWN_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void UNKNOWN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			System.out.println("Error na linha: " + getLine() + " - Simbolo desconhecido: '" + getText() + "'") ; System.exit(0);
			break;
		}
	}

	public static final String _serializedATN =
		"\u0004\u00006\u018b\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"+
		"\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"+
		"\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007"+
		"!\u0002\"\u0007\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007"+
		"&\u0002\'\u0007\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007"+
		"+\u0002,\u0007,\u0002-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u0007"+
		"0\u00021\u00071\u00022\u00072\u00023\u00073\u00024\u00074\u00025\u0007"+
		"5\u00026\u00076\u00027\u00077\u00028\u00078\u00029\u00079\u0002:\u0007"+
		":\u0002;\u0007;\u0002<\u0007<\u0001\u0000\u0004\u0000}\b\u0000\u000b\u0000"+
		"\f\u0000~\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0003\u0002\u008e\b\u0002\u0001\u0003\u0001\u0003"+
		"\u0005\u0003\u0092\b\u0003\n\u0003\f\u0003\u0095\t\u0003\u0001\u0004\u0001"+
		"\u0004\u0005\u0004\u0099\b\u0004\n\u0004\f\u0004\u009c\t\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005"+
		"\u00a4\b\u0005\n\u0005\f\u0005\u00a7\t\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0005\u0006\u00ad\b\u0006\n\u0006\f\u0006\u00b0\t\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0004\u0007\u00b5\b\u0007\u000b\u0007"+
		"\f\u0007\u00b6\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0003\b\u00bd\b"+
		"\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001"+
		"\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001"+
		"!\u0001!\u0001\"\u0001\"\u0001#\u0001#\u0001$\u0001$\u0001%\u0001%\u0001"+
		"&\u0001&\u0001\'\u0001\'\u0001(\u0001(\u0001)\u0001)\u0001*\u0001*\u0001"+
		"+\u0001+\u0001,\u0001,\u0001-\u0001-\u0001.\u0001.\u0001/\u0001/\u0001"+
		"/\u00010\u00010\u00010\u00011\u00011\u00011\u00012\u00012\u00012\u0001"+
		"3\u00013\u00013\u00013\u00014\u00014\u00014\u00014\u00014\u00015\u0001"+
		"5\u00015\u00015\u00015\u00015\u00016\u00016\u00016\u00016\u00016\u0001"+
		"6\u00016\u00016\u00017\u00017\u00018\u00018\u00019\u00019\u0001:\u0001"+
		":\u0001;\u0001;\u0001<\u0001<\u0001<\u0000\u0000=\u0001\u0000\u0003\u0000"+
		"\u0005\u0000\u0007\u0000\t\u0000\u000b\u0000\r\u0000\u000f\u0001\u0011"+
		"\u0002\u0013\u0003\u0015\u0004\u0017\u0005\u0019\u0006\u001b\u0007\u001d"+
		"\b\u001f\t!\n#\u000b%\f\'\r)\u000e+\u000f-\u0010/\u00111\u00123\u0013"+
		"5\u00147\u00159\u0016;\u0017=\u0018?\u0019A\u001aC\u001bE\u001cG\u001d"+
		"I\u001eK\u001fM O!Q\"S#U$W%Y&[\'](_)a*c+e,g-i.k/m0o1q2s3u4w5y6\u0001\u0000"+
		"\u0007\u0001\u000009\u0002\u0000AZaz\u0004\u000009AZ__az\u0001\u0000\'"+
		"\'\u0001\u0000\n\n\u0001\u0000}}\u0002\u0000\t\n  \u018b\u0000\u000f\u0001"+
		"\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001"+
		"\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001"+
		"\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001"+
		"\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001"+
		"\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000"+
		"\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000"+
		"\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-"+
		"\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001\u0000"+
		"\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u00005\u0001\u0000\u0000\u0000"+
		"\u00007\u0001\u0000\u0000\u0000\u00009\u0001\u0000\u0000\u0000\u0000;"+
		"\u0001\u0000\u0000\u0000\u0000=\u0001\u0000\u0000\u0000\u0000?\u0001\u0000"+
		"\u0000\u0000\u0000A\u0001\u0000\u0000\u0000\u0000C\u0001\u0000\u0000\u0000"+
		"\u0000E\u0001\u0000\u0000\u0000\u0000G\u0001\u0000\u0000\u0000\u0000I"+
		"\u0001\u0000\u0000\u0000\u0000K\u0001\u0000\u0000\u0000\u0000M\u0001\u0000"+
		"\u0000\u0000\u0000O\u0001\u0000\u0000\u0000\u0000Q\u0001\u0000\u0000\u0000"+
		"\u0000S\u0001\u0000\u0000\u0000\u0000U\u0001\u0000\u0000\u0000\u0000W"+
		"\u0001\u0000\u0000\u0000\u0000Y\u0001\u0000\u0000\u0000\u0000[\u0001\u0000"+
		"\u0000\u0000\u0000]\u0001\u0000\u0000\u0000\u0000_\u0001\u0000\u0000\u0000"+
		"\u0000a\u0001\u0000\u0000\u0000\u0000c\u0001\u0000\u0000\u0000\u0000e"+
		"\u0001\u0000\u0000\u0000\u0000g\u0001\u0000\u0000\u0000\u0000i\u0001\u0000"+
		"\u0000\u0000\u0000k\u0001\u0000\u0000\u0000\u0000m\u0001\u0000\u0000\u0000"+
		"\u0000o\u0001\u0000\u0000\u0000\u0000q\u0001\u0000\u0000\u0000\u0000s"+
		"\u0001\u0000\u0000\u0000\u0000u\u0001\u0000\u0000\u0000\u0000w\u0001\u0000"+
		"\u0000\u0000\u0000y\u0001\u0000\u0000\u0000\u0001|\u0001\u0000\u0000\u0000"+
		"\u0003\u0080\u0001\u0000\u0000\u0000\u0005\u008d\u0001\u0000\u0000\u0000"+
		"\u0007\u008f\u0001\u0000\u0000\u0000\t\u0096\u0001\u0000\u0000\u0000\u000b"+
		"\u009f\u0001\u0000\u0000\u0000\r\u00aa\u0001\u0000\u0000\u0000\u000f\u00b4"+
		"\u0001\u0000\u0000\u0000\u0011\u00bc\u0001\u0000\u0000\u0000\u0013\u00c0"+
		"\u0001\u0000\u0000\u0000\u0015\u00c8\u0001\u0000\u0000\u0000\u0017\u00ce"+
		"\u0001\u0000\u0000\u0000\u0019\u00d2\u0001\u0000\u0000\u0000\u001b\u00d8"+
		"\u0001\u0000\u0000\u0000\u001d\u00dc\u0001\u0000\u0000\u0000\u001f\u00e5"+
		"\u0001\u0000\u0000\u0000!\u00ef\u0001\u0000\u0000\u0000#\u00f7\u0001\u0000"+
		"\u0000\u0000%\u00fc\u0001\u0000\u0000\u0000\'\u0104\u0001\u0000\u0000"+
		"\u0000)\u010b\u0001\u0000\u0000\u0000+\u0110\u0001\u0000\u0000\u0000-"+
		"\u0116\u0001\u0000\u0000\u0000/\u0119\u0001\u0000\u0000\u00001\u011c\u0001"+
		"\u0000\u0000\u00003\u011f\u0001\u0000\u0000\u00005\u0124\u0001\u0000\u0000"+
		"\u00007\u0129\u0001\u0000\u0000\u00009\u012f\u0001\u0000\u0000\u0000;"+
		"\u0132\u0001\u0000\u0000\u0000=\u0136\u0001\u0000\u0000\u0000?\u0139\u0001"+
		"\u0000\u0000\u0000A\u013d\u0001\u0000\u0000\u0000C\u013f\u0001\u0000\u0000"+
		"\u0000E\u0141\u0001\u0000\u0000\u0000G\u0143\u0001\u0000\u0000\u0000I"+
		"\u0145\u0001\u0000\u0000\u0000K\u0147\u0001\u0000\u0000\u0000M\u0149\u0001"+
		"\u0000\u0000\u0000O\u014b\u0001\u0000\u0000\u0000Q\u014d\u0001\u0000\u0000"+
		"\u0000S\u014f\u0001\u0000\u0000\u0000U\u0151\u0001\u0000\u0000\u0000W"+
		"\u0153\u0001\u0000\u0000\u0000Y\u0155\u0001\u0000\u0000\u0000[\u0157\u0001"+
		"\u0000\u0000\u0000]\u0159\u0001\u0000\u0000\u0000_\u015b\u0001\u0000\u0000"+
		"\u0000a\u015e\u0001\u0000\u0000\u0000c\u0161\u0001\u0000\u0000\u0000e"+
		"\u0164\u0001\u0000\u0000\u0000g\u0167\u0001\u0000\u0000\u0000i\u016b\u0001"+
		"\u0000\u0000\u0000k\u0170\u0001\u0000\u0000\u0000m\u0176\u0001\u0000\u0000"+
		"\u0000o\u017e\u0001\u0000\u0000\u0000q\u0180\u0001\u0000\u0000\u0000s"+
		"\u0182\u0001\u0000\u0000\u0000u\u0184\u0001\u0000\u0000\u0000w\u0186\u0001"+
		"\u0000\u0000\u0000y\u0188\u0001\u0000\u0000\u0000{}\u0007\u0000\u0000"+
		"\u0000|{\u0001\u0000\u0000\u0000}~\u0001\u0000\u0000\u0000~|\u0001\u0000"+
		"\u0000\u0000~\u007f\u0001\u0000\u0000\u0000\u007f\u0002\u0001\u0000\u0000"+
		"\u0000\u0080\u0081\u0003\u0001\u0000\u0000\u0081\u0082\u0005.\u0000\u0000"+
		"\u0082\u0083\u0003\u0001\u0000\u0000\u0083\u0004\u0001\u0000\u0000\u0000"+
		"\u0084\u0085\u0005t\u0000\u0000\u0085\u0086\u0005r\u0000\u0000\u0086\u0087"+
		"\u0005u\u0000\u0000\u0087\u008e\u0005e\u0000\u0000\u0088\u0089\u0005f"+
		"\u0000\u0000\u0089\u008a\u0005a\u0000\u0000\u008a\u008b\u0005l\u0000\u0000"+
		"\u008b\u008c\u0005s\u0000\u0000\u008c\u008e\u0005e\u0000\u0000\u008d\u0084"+
		"\u0001\u0000\u0000\u0000\u008d\u0088\u0001\u0000\u0000\u0000\u008e\u0006"+
		"\u0001\u0000\u0000\u0000\u008f\u0093\u0007\u0001\u0000\u0000\u0090\u0092"+
		"\u0007\u0002\u0000\u0000\u0091\u0090\u0001\u0000\u0000\u0000\u0092\u0095"+
		"\u0001\u0000\u0000\u0000\u0093\u0091\u0001\u0000\u0000\u0000\u0093\u0094"+
		"\u0001\u0000\u0000\u0000\u0094\b\u0001\u0000\u0000\u0000\u0095\u0093\u0001"+
		"\u0000\u0000\u0000\u0096\u009a\u0007\u0003\u0000\u0000\u0097\u0099\b\u0003"+
		"\u0000\u0000\u0098\u0097\u0001\u0000\u0000\u0000\u0099\u009c\u0001\u0000"+
		"\u0000\u0000\u009a\u0098\u0001\u0000\u0000\u0000\u009a\u009b\u0001\u0000"+
		"\u0000\u0000\u009b\u009d\u0001\u0000\u0000\u0000\u009c\u009a\u0001\u0000"+
		"\u0000\u0000\u009d\u009e\u0007\u0003\u0000\u0000\u009e\n\u0001\u0000\u0000"+
		"\u0000\u009f\u00a0\u0005/\u0000\u0000\u00a0\u00a1\u0005/\u0000\u0000\u00a1"+
		"\u00a5\u0001\u0000\u0000\u0000\u00a2\u00a4\b\u0004\u0000\u0000\u00a3\u00a2"+
		"\u0001\u0000\u0000\u0000\u00a4\u00a7\u0001\u0000\u0000\u0000\u00a5\u00a3"+
		"\u0001\u0000\u0000\u0000\u00a5\u00a6\u0001\u0000\u0000\u0000\u00a6\u00a8"+
		"\u0001\u0000\u0000\u0000\u00a7\u00a5\u0001\u0000\u0000\u0000\u00a8\u00a9"+
		"\u0007\u0004\u0000\u0000\u00a9\f\u0001\u0000\u0000\u0000\u00aa\u00ae\u0005"+
		"{\u0000\u0000\u00ab\u00ad\b\u0005\u0000\u0000\u00ac\u00ab\u0001\u0000"+
		"\u0000\u0000\u00ad\u00b0\u0001\u0000\u0000\u0000\u00ae\u00ac\u0001\u0000"+
		"\u0000\u0000\u00ae\u00af\u0001\u0000\u0000\u0000\u00af\u00b1\u0001\u0000"+
		"\u0000\u0000\u00b0\u00ae\u0001\u0000\u0000\u0000\u00b1\u00b2\u0005}\u0000"+
		"\u0000\u00b2\u000e\u0001\u0000\u0000\u0000\u00b3\u00b5\u0007\u0006\u0000"+
		"\u0000\u00b4\u00b3\u0001\u0000\u0000\u0000\u00b5\u00b6\u0001\u0000\u0000"+
		"\u0000\u00b6\u00b4\u0001\u0000\u0000\u0000\u00b6\u00b7\u0001\u0000\u0000"+
		"\u0000\u00b7\u00b8\u0001\u0000\u0000\u0000\u00b8\u00b9\u0006\u0007\u0000"+
		"\u0000\u00b9\u0010\u0001\u0000\u0000\u0000\u00ba\u00bd\u0003\u000b\u0005"+
		"\u0000\u00bb\u00bd\u0003\r\u0006\u0000\u00bc\u00ba\u0001\u0000\u0000\u0000"+
		"\u00bc\u00bb\u0001\u0000\u0000\u0000\u00bd\u00be\u0001\u0000\u0000\u0000"+
		"\u00be\u00bf\u0006\b\u0000\u0000\u00bf\u0012\u0001\u0000\u0000\u0000\u00c0"+
		"\u00c1\u0005p\u0000\u0000\u00c1\u00c2\u0005r\u0000\u0000\u00c2\u00c3\u0005"+
		"o\u0000\u0000\u00c3\u00c4\u0005g\u0000\u0000\u00c4\u00c5\u0005r\u0000"+
		"\u0000\u00c5\u00c6\u0005a\u0000\u0000\u00c6\u00c7\u0005m\u0000\u0000\u00c7"+
		"\u0014\u0001\u0000\u0000\u0000\u00c8\u00c9\u0005c\u0000\u0000\u00c9\u00ca"+
		"\u0005o\u0000\u0000\u00ca\u00cb\u0005n\u0000\u0000\u00cb\u00cc\u0005s"+
		"\u0000\u0000\u00cc\u00cd\u0005t\u0000\u0000\u00cd\u0016\u0001\u0000\u0000"+
		"\u0000\u00ce\u00cf\u0005v\u0000\u0000\u00cf\u00d0\u0005a\u0000\u0000\u00d0"+
		"\u00d1\u0005r\u0000\u0000\u00d1\u0018\u0001\u0000\u0000\u0000\u00d2\u00d3"+
		"\u0005b\u0000\u0000\u00d3\u00d4\u0005e\u0000\u0000\u00d4\u00d5\u0005g"+
		"\u0000\u0000\u00d5\u00d6\u0005i\u0000\u0000\u00d6\u00d7\u0005n\u0000\u0000"+
		"\u00d7\u001a\u0001\u0000\u0000\u0000\u00d8\u00d9\u0005e\u0000\u0000\u00d9"+
		"\u00da\u0005n\u0000\u0000\u00da\u00db\u0005d\u0000\u0000\u00db\u001c\u0001"+
		"\u0000\u0000\u0000\u00dc\u00dd\u0005f\u0000\u0000\u00dd\u00de\u0005u\u0000"+
		"\u0000\u00de\u00df\u0005n\u0000\u0000\u00df\u00e0\u0005c\u0000\u0000\u00e0"+
		"\u00e1\u0005t\u0000\u0000\u00e1\u00e2\u0005i\u0000\u0000\u00e2\u00e3\u0005"+
		"o\u0000\u0000\u00e3\u00e4\u0005n\u0000\u0000\u00e4\u001e\u0001\u0000\u0000"+
		"\u0000\u00e5\u00e6\u0005p\u0000\u0000\u00e6\u00e7\u0005r\u0000\u0000\u00e7"+
		"\u00e8\u0005o\u0000\u0000\u00e8\u00e9\u0005c\u0000\u0000\u00e9\u00ea\u0005"+
		"e\u0000\u0000\u00ea\u00eb\u0005d\u0000\u0000\u00eb\u00ec\u0005u\u0000"+
		"\u0000\u00ec\u00ed\u0005r\u0000\u0000\u00ed\u00ee\u0005e\u0000\u0000\u00ee"+
		" \u0001\u0000\u0000\u0000\u00ef\u00f0\u0005i\u0000\u0000\u00f0\u00f1\u0005"+
		"n\u0000\u0000\u00f1\u00f2\u0005t\u0000\u0000\u00f2\u00f3\u0005e\u0000"+
		"\u0000\u00f3\u00f4\u0005g\u0000\u0000\u00f4\u00f5\u0005e\u0000\u0000\u00f5"+
		"\u00f6\u0005r\u0000\u0000\u00f6\"\u0001\u0000\u0000\u0000\u00f7\u00f8"+
		"\u0005r\u0000\u0000\u00f8\u00f9\u0005e\u0000\u0000\u00f9\u00fa\u0005a"+
		"\u0000\u0000\u00fa\u00fb\u0005l\u0000\u0000\u00fb$\u0001\u0000\u0000\u0000"+
		"\u00fc\u00fd\u0005b\u0000\u0000\u00fd\u00fe\u0005o\u0000\u0000\u00fe\u00ff"+
		"\u0005o\u0000\u0000\u00ff\u0100\u0005l\u0000\u0000\u0100\u0101\u0005e"+
		"\u0000\u0000\u0101\u0102\u0005a\u0000\u0000\u0102\u0103\u0005n\u0000\u0000"+
		"\u0103&\u0001\u0000\u0000\u0000\u0104\u0105\u0005s\u0000\u0000\u0105\u0106"+
		"\u0005t\u0000\u0000\u0106\u0107\u0005r\u0000\u0000\u0107\u0108\u0005i"+
		"\u0000\u0000\u0108\u0109\u0005n\u0000\u0000\u0109\u010a\u0005g\u0000\u0000"+
		"\u010a(\u0001\u0000\u0000\u0000\u010b\u010c\u0005c\u0000\u0000\u010c\u010d"+
		"\u0005h\u0000\u0000\u010d\u010e\u0005a\u0000\u0000\u010e\u010f\u0005r"+
		"\u0000\u0000\u010f*\u0001\u0000\u0000\u0000\u0110\u0111\u0005a\u0000\u0000"+
		"\u0111\u0112\u0005r\u0000\u0000\u0112\u0113\u0005r\u0000\u0000\u0113\u0114"+
		"\u0005a\u0000\u0000\u0114\u0115\u0005y\u0000\u0000\u0115,\u0001\u0000"+
		"\u0000\u0000\u0116\u0117\u0005.\u0000\u0000\u0117\u0118\u0005.\u0000\u0000"+
		"\u0118.\u0001\u0000\u0000\u0000\u0119\u011a\u0005o\u0000\u0000\u011a\u011b"+
		"\u0005f\u0000\u0000\u011b0\u0001\u0000\u0000\u0000\u011c\u011d\u0005i"+
		"\u0000\u0000\u011d\u011e\u0005f\u0000\u0000\u011e2\u0001\u0000\u0000\u0000"+
		"\u011f\u0120\u0005t\u0000\u0000\u0120\u0121\u0005h\u0000\u0000\u0121\u0122"+
		"\u0005e\u0000\u0000\u0122\u0123\u0005n\u0000\u0000\u01234\u0001\u0000"+
		"\u0000\u0000\u0124\u0125\u0005e\u0000\u0000\u0125\u0126\u0005l\u0000\u0000"+
		"\u0126\u0127\u0005s\u0000\u0000\u0127\u0128\u0005e\u0000\u0000\u01286"+
		"\u0001\u0000\u0000\u0000\u0129\u012a\u0005w\u0000\u0000\u012a\u012b\u0005"+
		"h\u0000\u0000\u012b\u012c\u0005i\u0000\u0000\u012c\u012d\u0005l\u0000"+
		"\u0000\u012d\u012e\u0005e\u0000\u0000\u012e8\u0001\u0000\u0000\u0000\u012f"+
		"\u0130\u0005d\u0000\u0000\u0130\u0131\u0005o\u0000\u0000\u0131:\u0001"+
		"\u0000\u0000\u0000\u0132\u0133\u0005a\u0000\u0000\u0133\u0134\u0005n\u0000"+
		"\u0000\u0134\u0135\u0005d\u0000\u0000\u0135<\u0001\u0000\u0000\u0000\u0136"+
		"\u0137\u0005o\u0000\u0000\u0137\u0138\u0005r\u0000\u0000\u0138>\u0001"+
		"\u0000\u0000\u0000\u0139\u013a\u0005n\u0000\u0000\u013a\u013b\u0005o\u0000"+
		"\u0000\u013b\u013c\u0005t\u0000\u0000\u013c@\u0001\u0000\u0000\u0000\u013d"+
		"\u013e\u0005+\u0000\u0000\u013eB\u0001\u0000\u0000\u0000\u013f\u0140\u0005"+
		"-\u0000\u0000\u0140D\u0001\u0000\u0000\u0000\u0141\u0142\u0005*\u0000"+
		"\u0000\u0142F\u0001\u0000\u0000\u0000\u0143\u0144\u0005/\u0000\u0000\u0144"+
		"H\u0001\u0000\u0000\u0000\u0145\u0146\u0005=\u0000\u0000\u0146J\u0001"+
		"\u0000\u0000\u0000\u0147\u0148\u0005<\u0000\u0000\u0148L\u0001\u0000\u0000"+
		"\u0000\u0149\u014a\u0005>\u0000\u0000\u014aN\u0001\u0000\u0000\u0000\u014b"+
		"\u014c\u0005[\u0000\u0000\u014cP\u0001\u0000\u0000\u0000\u014d\u014e\u0005"+
		"]\u0000\u0000\u014eR\u0001\u0000\u0000\u0000\u014f\u0150\u0005.\u0000"+
		"\u0000\u0150T\u0001\u0000\u0000\u0000\u0151\u0152\u0005,\u0000\u0000\u0152"+
		"V\u0001\u0000\u0000\u0000\u0153\u0154\u0005:\u0000\u0000\u0154X\u0001"+
		"\u0000\u0000\u0000\u0155\u0156\u0005;\u0000\u0000\u0156Z\u0001\u0000\u0000"+
		"\u0000\u0157\u0158\u0005(\u0000\u0000\u0158\\\u0001\u0000\u0000\u0000"+
		"\u0159\u015a\u0005)\u0000\u0000\u015a^\u0001\u0000\u0000\u0000\u015b\u015c"+
		"\u0005<\u0000\u0000\u015c\u015d\u0005>\u0000\u0000\u015d`\u0001\u0000"+
		"\u0000\u0000\u015e\u015f\u0005<\u0000\u0000\u015f\u0160\u0005=\u0000\u0000"+
		"\u0160b\u0001\u0000\u0000\u0000\u0161\u0162\u0005>\u0000\u0000\u0162\u0163"+
		"\u0005=\u0000\u0000\u0163d\u0001\u0000\u0000\u0000\u0164\u0165\u0005:"+
		"\u0000\u0000\u0165\u0166\u0005=\u0000\u0000\u0166f\u0001\u0000\u0000\u0000"+
		"\u0167\u0168\u0005m\u0000\u0000\u0168\u0169\u0005o\u0000\u0000\u0169\u016a"+
		"\u0005d\u0000\u0000\u016ah\u0001\u0000\u0000\u0000\u016b\u016c\u0005r"+
		"\u0000\u0000\u016c\u016d\u0005e\u0000\u0000\u016d\u016e\u0005a\u0000\u0000"+
		"\u016e\u016f\u0005d\u0000\u0000\u016fj\u0001\u0000\u0000\u0000\u0170\u0171"+
		"\u0005w\u0000\u0000\u0171\u0172\u0005r\u0000\u0000\u0172\u0173\u0005i"+
		"\u0000\u0000\u0173\u0174\u0005t\u0000\u0000\u0174\u0175\u0005e\u0000\u0000"+
		"\u0175l\u0001\u0000\u0000\u0000\u0176\u0177\u0005w\u0000\u0000\u0177\u0178"+
		"\u0005r\u0000\u0000\u0178\u0179\u0005i\u0000\u0000\u0179\u017a\u0005t"+
		"\u0000\u0000\u017a\u017b\u0005e\u0000\u0000\u017b\u017c\u0005l\u0000\u0000"+
		"\u017c\u017d\u0005n\u0000\u0000\u017dn\u0001\u0000\u0000\u0000\u017e\u017f"+
		"\u0003\u0001\u0000\u0000\u017fp\u0001\u0000\u0000\u0000\u0180\u0181\u0003"+
		"\u0003\u0001\u0000\u0181r\u0001\u0000\u0000\u0000\u0182\u0183\u0003\t"+
		"\u0004\u0000\u0183t\u0001\u0000\u0000\u0000\u0184\u0185\u0003\u0005\u0002"+
		"\u0000\u0185v\u0001\u0000\u0000\u0000\u0186\u0187\u0003\u0007\u0003\u0000"+
		"\u0187x\u0001\u0000\u0000\u0000\u0188\u0189\t\u0000\u0000\u0000\u0189"+
		"\u018a\u0006<\u0001\u0000\u018az\u0001\u0000\u0000\u0000\t\u0000~\u008d"+
		"\u0093\u009a\u00a5\u00ae\u00b6\u00bc\u0002\u0006\u0000\u0000\u0001<\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}