lexer grammar PascalLexer;

fragment INT_VALUE  : [0-9]+ ;
fragment REAL_VALUE : INT_VALUE '.' INT_VALUE ;
fragment SIGN       : [+\-]? ;
fragment BOOLEAN_VALUE : (('true') | ('false'));
fragment ID_VALUE   : [A-Za-z][A-Za-z0-9_]* ;
fragment STR_VALUE  : ['] ~[']* ['] ;
fragment LINE_COMMENT : '//' ~[\n]* [\n] ;
fragment MULTILINE_COMMENT :  '{' ~[}]* '}' ;

// Ignorar comentários, espaços e quebras de linha. 
WS          : [ \t\n]+      -> skip ;
COMMENT     : (LINE_COMMENT | MULTILINE_COMMENT) -> skip ;

// Palavras reservadas.
PROGRAM     : 'program' ; 
CONST       : 'const' ;
VAR         : 'var' ;
BEGIN       : 'begin' ;
END         : 'end' ;

FUNCTION    : 'function';
PROCEDURE   : 'procedure';

// Tipos primitivos.
INTEGER     : 'integer' ;
REAL        : 'real' ;
BOOLEAN     : 'boolean' ;
STRING      : 'string' ;
CHAR        : 'char' ;
ARRAY       : 'array' ;
RANGE       : '..' ;
OF          : 'of' ;

// Estruturas de controle de fluxo e repetição.
IF          : 'if' ;
THEN        : 'then' ;
ELSE        : 'else' ;
WHILE       : 'while' ;
DO          : 'do' ;

// Operadores lógicos.   
AND         : 'and' ;         
OR          : 'or' ;    
NOT         : 'not' ;

// Operadores aritméticos e de comparação.
PLUS        : '+' ;
MINUS       : '-' ; 
ASTERISK    : '*' ; 
SLASH       : '/' ; 
EQUAL       : '=' ; 
LESSTHAN    : '<' ;
GREATERTHAN : '>' ;
LBRACK      : '[' ;
RBRACK      : ']' ;
PERIOD      : '.' ;
COMMA       : ',' ;
COLON       : ':' ;
SEMICOLON   : ';' ; 
LPAR        : '(' ;
RPAR        : ')' ;
NOTEQUAL    : '<>' ; 
LEQ         : '<=' ;
BEQ         : '>=' ;
BECOMES     : ':=' ;  

// Funções matemáticas.
MOD         : 'mod' ;

// Manipulação de entrada e saída em stdin e stdout.
READ        : 'read' ;
WRITE       : 'write' ;
WRITELN     : 'writeln' ;



INT_VAL     : SIGN INT_VALUE ;
REAL_VAL    : SIGN REAL_VALUE ;
STRING_VAL  : STR_VALUE ;
BOOLEAN_VAL : BOOLEAN_VALUE ;

ID          : ID_VALUE ;

UNKNOWN : . {System.out.println("Error na linha: " + getLine() + " - Simbolo desconhecido: '" + getText() + "'") ; System.exit(0);};