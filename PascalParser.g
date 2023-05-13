parser grammar PascalParser;

@header{
    package parser;
}

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
    CONST (ID EQUAL val_simple SEMICOLON)+
;

var_section:
    VAR (var SEMICOLON)+
;

var:
    (ID)(COMMA ID)* COLON type_simple
|   (ID)(COMMA ID)* COLON array_type_range
;

procedure:
    PROCEDURE ID parameter_list SEMICOLON const_var_section* block SEMICOLON
;

function:
    FUNCTION ID parameter_list COLON type_simple SEMICOLON const_var_section* block SEMICOLON
;

parameter_list:
    LPAR parameters? RPAR
;

parameters:
    parameter (SEMICOLON parameter)*
;

var_parameter:
    ID (COMMA ID)* COLON type_simple
|   ID (COMMA ID)* COLON array_type
;

constant:
    CONST ID COLON type_simple
;

//Limitações
// constantes só podem receber valores hard coded 
// constante so pode ser type simples

parameter:
    var_parameter
|   constant
;


block:
    BEGIN (statement SEMICOLON)* END
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
    (ID | acess_array) BECOMES ( expr )
;

expr:  
    LPAR expr RPAR                                                          #expr_par
|   NOT expr                                                                #expr_not
|   MINUS expr                                                              #expr_minus
|   expr (ASTERISK | SLASH | MOD ) expr                                     #expr_div
|   expr AND expr                                                           #expr_and
|   expr (PLUS | MINUS) expr                                                #expr_plus
|   expr OR expr                                                            #expr_or
|   expr ( NOTEQUAL | EQUAL | LESSTHAN | GREATERTHAN | LEQ | BEQ ) expr     #expr_equal
|   ID                                                                      #expr_id
|   call_function_procedure                                                 #expr_call
|   val_simple_array                                                        #expr_array
;

while_block:
  WHILE expr DO block 
;

if_block:
    IF expr THEN block (ELSE block)? 
;

param_call:
    expr
|   param_call COMMA param_call
;

call_function_procedure:
    ID LPAR param_call? RPAR
;

write_io:
    (WRITE | WRITELN) LPAR (expr) RPAR  
;

read_io:
    READ LPAR (ID | acess_array) RPAR 
;

type:
    type_simple 
|   array_type_range
;

type_simple: 
    INTEGER  #type_simple_integer
|   REAL     #type_simple_real
|   BOOLEAN  #type_simple_boolean
|   STRING   #type_simple_string
;

array_type_range:
   ARRAY LBRACK INT_VAL RANGE INT_VAL RBRACK OF type_simple
;

array_type:
   ARRAY OF type_simple
;

acess_array:
    ID LBRACK (expr) RBRACK
;

val_simple_array:
    val_simple
|   acess_array
;

val_simple:
    (PLUS|MINUS)? INT_VAL      #int_val
|   (PLUS|MINUS)?  REAL_VAL    #real_val
|    STRING_VAL                #string_val
|    BOOLEAN_VAL               #boolean_val
;



