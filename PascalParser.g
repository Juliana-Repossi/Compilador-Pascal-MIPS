parser grammar PascalParser;

options {
  tokenVocab = PascalLexer;
}

begin:
    program
;

program: 
    PROGRAM ID SEMICOLON program_pascal PERIOD
;

program_pascal:
    const_var_section* (procedure | function)* block+          
;

const_var_section:
    const_section
|   var_section
;

const_section:
    CONST (ID EQUAL val SEMICOLON)+
;

var_section:
    VAR (var SEMICOLON)+
;

var:
    (ID)(COMMA ID)* COLON type
;

constant:
    CONST ID COLON type_simple
;

procedure:
    PROCEDURE ID parameter_list SEMICOLON const_var_section* block SEMICOLON
;

function:
    FUNCTION ID parameter_list COLON type SEMICOLON const_var_section* block SEMICOLON
;

parameter_list:
    LPAR (var|constant)* RPAR
;

block:
    BEGIN (statement SEMICOLON)* END
;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
acess_array:
    ID LBRACK (INT_VAL | ID ) RBRACK
;

statement:
    atribution 
|   while_block
|   if_block
|   call_function_procedure
|   read_io
|   write_io
;

atribution:
    ID BECOMES (expr_mat| expr_log | STRING | CHAR | array | acess_array | val )
;

expr_mat:  
    LPAR expr_mat RPAR
|   expr_mat (ASTERISK | SLASH | MOD) expr_mat
|   expr_mat (PLUS | MINUS) expr_mat
|   INT_VAL
|   REAL_VAL
|   acess_array
|   ID
|   call_function_procedure
;

expr_log:  
    LPAR expr_log RPAR
|   expr_log ( NOTEQUAL | EQUAL ) expr_log
|   expr_mat ( LESSTHAN | GREATERTHAN | LEQ | REQ | NOTEQUAL | EQUAL ) expr_mat
|   NOT expr_log
|   expr_log AND expr_log
|   expr_log OR expr_log
|   BOOLEAN_VAL
|   ID
;

while_block:
  WHILE (expr_log | expr_mat) DO block 
;

if_block:
    IF expr_log THEN block (ELSE block)? 
;

param_call:
    expr_mat
|   expr_log
|   call_function_procedure
|   param_call COMMA param_call
;

call_function_procedure:
    ID LPAR param_call RPAR
;

write_io:
    (WRITE | WRITELN) LPAR (val|ID|expr_log|expr_mat) RPAR  
;

read_io:
    READ LPAR (ID | acess_array) RPAR 
;

type:
    type_simple 
|   array_type
;

type_simple: 
    INTEGER 
|   REAL 
|   BOOLEAN 
|   STRING
|   CHAR 
;

array_type:
   ARRAY LBRACK INT_VAL RANGE INT_VAL RBRACK OF type_simple
;

val:
    (INT_VAL | REAL_VAL | STRING_VAL | BOOLEAN_VAL | CHAR_VAL )
;

// PERGUNTAR SOBRE PASSAR PARAMETRO PARA FUNÇÃO
//operacoes de array


//Limitações
// constantes só podem receber valores hard coded 
// constante so pode ser type simples
