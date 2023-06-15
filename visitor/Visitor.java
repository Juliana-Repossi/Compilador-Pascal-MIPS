package visitor;

import java.io.*;
import java.util.*;

import parser.PascalParserBaseVisitor;
import parser.PascalParser;
import tables.FuncTable;
import tables.ProcTable;
import tables.StrTable;
import tables.IdTable;
import tables.ArrayTable;

import error.MsgErros;
import semantic_type_operations.SemanticTypeOperations;

import types.Type;

import ast.AST;
import ast.NodeKind;

public class Visitor extends PascalParserBaseVisitor<AST>
{
    //tables da main
    private StrTable strTable = new StrTable();
    private IdTable idTable = new IdTable();
    private ArrayTable arrayTable = new ArrayTable();

    //auxiliares para obter dados das variáveis
    private Type currentType;
    private int currentLine;
    private int currentSize;
    private Type currentTypeElement;
    
    //current function
    // 0 - main
    // 1 - function
    // 2 - procedure
    private int currentTypeMethod;

    //escopo da função atual
    private IdTable currentIdTable = idTable;
    private StrTable currentStrTable = strTable;
    private ArrayTable currentArrayTable = arrayTable;
    
    private FuncTable funcTable = new FuncTable();
    private ProcTable procTable = new ProcTable();


    public StrTable getStrTable() {
        return this.strTable;
    }

    public IdTable getIdTable() {
        return this.idTable;
    }

    public ArrayTable getArrayTable(){
        return this.arrayTable;
    }

    public FuncTable getFuncTable(){
        return this.funcTable;
    }

    public ProcTable getProcTable(){
        return this.procTable;
    }

    public StrTable getCurrentStrTable() {
        return this.currentStrTable;
    }

    public IdTable getCurrentIdTable() {
        return this.currentIdTable;
    }

    public ArrayTable getCurrentArrayTable() {
        return this.currentArrayTable;
    }

    //adiciona Id na tabela de escopo atual - sendo id unico
    private Type addIdTable (String s, int line, Type type, Boolean ehConst, int positionArgument){

        if(currentIdTable.lookupVar(s)==-1 && currentArrayTable.lookupArray(s)==-1)
        {
            currentIdTable.addId(s,line,type,ehConst, positionArgument);
            return null;
        }
        MsgErros.idJaDeclarado(s,line);
        return null;
    }

    //adiciona array na tabela de escopo atual - sendo id unico
    private Type addArrayTable (String s, int line, Type type, Type typeElement, int size, int positionArgument){

        if(currentIdTable.lookupVar(s)==-1 && currentArrayTable.lookupArray(s)==-1)
        {
            currentArrayTable.addArray(s,line,type, typeElement, size, positionArgument);
            return null;
        }
        MsgErros.idJaDeclarado(s,line);
        return null;
    }

    @Override 
    public AST visitProgram_pascal(PascalParser.Program_pascalContext ctx) {
        AST ast = new AST(NodeKind.PROGRAM_NODE,0,Type.NO_TYPE);

        AST const_var_child;
        for(int i = 0; i< ctx.const_var_section().size(); i++){
            const_var_child = visit(ctx.const_var_section(i)); 
            ast.addChild(const_var_child);
        }

        AST proced_function_child;
        for(int i = 0; i< ctx.procedure_function.size(); i++){
            proced_function_child = visit(ctx.procedure_function(i)); 
            ast.addChild(proced_function_child);
        }

        ast.addChild(visit(ctx.block()));

        return ast;        
    }

    @Override
    public Type visitConst_section(PascalParser.Const_sectionContext ctx) {
        
        for(int i = 0 ; i < ctx.ID().size(); i ++){
            visit(ctx.val_simple(i));
            addIdTable(ctx.ID(i).getText(),currentLine,currentType,true,-1);          
        }
        return null;
    }

    @Override 
    public AST visitInt_val(PascalParser.Int_valContext ctx) {

        int value = Integer.parseInt(ctx.INT_VAL().getText());
        AST ast = new AST(NodeKind.INT_VAL_NODE, value, Type.INTEGER);
        
        currentType = Type.INTEGER;
        currentLine = ctx.getStart().getLine();
        return ast;
    }

	@Override
    public AST visitReal_val(PascalParser.Real_valContext ctx) {

        float value = Float.parseFloat(ctx.REAL_VAL().getText());

        if (ctx.MINUS() != null)
        {
            value = value * (-1);
        }

        AST ast =  new AST(NodeKind.REAL_VAL_NODE,value,Type.REAL);

        currentType = Type.REAL;
        currentLine = ctx.getStart().getLine();
        return ast;
    }
	
     @Override 
    public AST visitString_val(PascalParser.String_valContext ctx) { 

        currentStrTable.add(ctx.getText());
        AST ast = new AST(NodeKind.STR_VAL_NODE,currentStrTable.size()-1,Type.STRING);
        currentType = Type.STRING;
        currentLine = ctx.getStart().getLine();
        return ast;    
    }

	@Override 
    public Type visitBoolean_val(PascalParser.Boolean_valContext ctx) {

        int value;
        if (ctx.BOOLEAN_VAL().getText().equals("true")){
            value = 1;
        }
        else{
            value = 0;
        }
        AST ast = new AST(NodeKind.BOOL_VAL_NODE,value,Type.BOOLEAN);
        
        currentType = Type.BOOLEAN;
        currentLine = ctx.getStart().getLine();
        return ast;  
    }

    @Override 
    public Type visitVar(PascalParser.VarContext ctx) {

        AST ast;

        if(ctx.type_simple() != null)
        {
            visit(ctx.type_simple());
            for(int i = 0 ; i < ctx.ID().size(); i ++)
            {            
                addIdTable(ctx.ID(i).getText(),currentLine,currentType,false,-1);
                ast = new AST(NodeKind.VAR_DECL_NODE,currentIdTable.getSize()-1,currentType);          
            }
        }
        else if(ctx.array_type_range() != null)
        {
            visit(ctx.array_type_range());
            for(int i = 0 ; i < ctx.ID().size(); i ++)
            {            
                addArrayTable(ctx.ID(i).getText(),currentLine,currentType, currentTypeElement, currentSize,-1);
                ast = new AST(NodeKind.VAR_DECL_NODE,currentArrayTable.getSizeArrayTable()-1,currentType);             
            }
        }
        else
        {
           MsgErros.erroInesperado(ctx.getStart().getLine()); 
        }
        return ast; 
    }

    @Override public AST visitBlock(PascalParser.BlockContext ctx) {
        AST ast = new AST(NodeKind.BLOCK_NODE,0,Type.NO_TYPE);

        for(int i = 0; i< ctx.statement().size(); i++){
            ast.addChild(visit(ctx.statement(i)));
        }
        return ast;
    }

    @Override public Type visitType_simple_integer(PascalParser.Type_simple_integerContext ctx) { 
        currentType = Type.INTEGER;
        currentLine = ctx.getStart().getLine();
        return null;
    }
	
	@Override 
    public Type visitType_simple_real(PascalParser.Type_simple_realContext ctx) { 
        currentType = Type.REAL;
        currentLine = ctx.getStart().getLine();
        return null;
    }

	@Override 
    public Type visitType_simple_boolean(PascalParser.Type_simple_booleanContext ctx) {
        currentType = Type.BOOLEAN;
        currentLine = ctx.getStart().getLine();
        return null;
    }
	
	@Override 
    public Type visitType_simple_string(PascalParser.Type_simple_stringContext ctx) {
        currentType = Type.STRING;
        currentLine = ctx.getStart().getLine();
        return null;
    }

    @Override 
    public Type visitType_simple_array_integer(PascalParser.Type_simple_array_integerContext ctx) {
        currentType = Type.ARRAY_INTEGER;
        currentTypeElement = Type.INTEGER;
        currentLine = ctx.getStart().getLine();
        return null;
    }
	
	@Override 
    public Type visitType_simple_array_real(PascalParser.Type_simple_array_realContext ctx) { 
        currentType = Type.ARRAY_REAL;
        currentTypeElement = Type.REAL;
        currentLine = ctx.getStart().getLine();
        return null;
    }
	
	@Override 
    public Type visitType_simple_array_boolean(PascalParser.Type_simple_array_booleanContext ctx) { 
        currentType = Type.ARRAY_BOOLEAN;
        currentTypeElement = Type.BOOLEAN;
        currentLine = ctx.getStart().getLine();
        return null;
    }

    private void checkId(String s, int line){
        if(currentIdTable.lookupVar(s) == -1)
        {
            MsgErros.idNaoDeclarado(s,line);           
        }
    }

    private void checkArray(String s, int line){
        if(currentArrayTable.lookupArray(s) == -1)
        {
            MsgErros.idNaoDeclarado(s, line);           
        }
    }

    private AST insertConversion(AST sub, Type conv, NodeKind typeNode){
        AST wideNode = new AST(typeNode,0,conv);
        wideNode.addChild(sub);
        return wideNode;
    }

    @Override 
    public AST visitAtribution(PascalParser.AtributionContext ctx) {
        Type type1 = null;

        AST ast = new AST(NodeKind.ASSIGN_NODE,0,Type.NO_TYPE);
        AST left;
        AST right;

        if(ctx.ID() != null)
        {
            checkId(ctx.ID().getText(),ctx.getStart().getLine());
            type1 = currentIdTable.getTypeByName(ctx.ID().getText());
            left = new AST(NodeKind.VAR_USE_NODE,0,type1);
            ast.addChild(left);   
        }
        else if (ctx.acess_array() != null)
        {
            type1 = visit(ctx.acess_array());
            left = new AST(NodeKind.VAR_USE_NODE,0,type1);
            ast.addChild(left);   
        }
        else
        {
            MsgErros.erroInesperado(ctx.getStart().getLine());
        }
        
        right = visit(ctx.expr());

        if(SemanticTypeOperations.typesAtribution(type1, right.type) == null) {
            MsgErros.incompatibleTypesAtribution(ctx.getStart().getLine(), type1, right.type);
        } 

        if(left.Type == Type.INTEGER && right.type == Type.REAL)
        {
            ast.addChild(insertConversion(right, Type.REAL,NodeKind.I2R));
        }
        else{
            ast.addChild(right);
        }       

        return ast;
    }

    @Override 
    public Type visitAcess_array(PascalParser.Acess_arrayContext ctx) {

        checkArray(ctx.ID().getText(),ctx.getStart().getLine());
        
        if (visit(ctx.expr()) != Type.INTEGER ) 
        {
            MsgErros.typeIndexError(ctx.getStart().getLine());
        }
        Type type = currentArrayTable.getTypeElementByName(ctx.ID().getText());
        // return null;
        return type;
    }

    @Override
    public Type visitExpr_id(PascalParser.Expr_idContext ctx) {
        
        if(currentIdTable.lookupVar(ctx.ID().getText())==-1 && currentArrayTable.lookupArray(ctx.ID().getText()) == -1) {   
            MsgErros.idNaoDeclarado(ctx.ID().getText(), ctx.getStart().getLine());
        }

        if(currentIdTable.lookupVar(ctx.ID().getText()) != -1) {
            return currentIdTable.getTypeByName(ctx.ID().getText());

        } else if(currentArrayTable.lookupArray(ctx.ID().getText()) != -1) {
            return currentArrayTable.getTypeByName(ctx.ID().getText());

        } else {
            MsgErros.erroInesperado(ctx.getStart().getLine());
        }
          
        return null; 
    }

    @Override 
    public AST visitRead_io(PascalParser.Read_ioContext ctx) {

        AST ast = new AST(NodeKind.READ_NODE,0,Type.NO_TYPE);
        AST child;
        Type type = null;
        if(ctx.ID() != null)
        {
            checkId(ctx.ID().getText(),ctx.getStart().getLine());
            
            type = currentIdTable.getTypeByName(ctx.ID().getText());

            if(type != Type.BOOLEAN && type != null){ // Não é booleano nem array
                child = new AST(NodeKind.VAR_USE_NODE,currentIdTable.lookupVar(ctx.ID().getText()),type);
                ast.addChild(child);
                return ast;
            }
            else{
                MsgErros.readErrorTypeNotAccepted(ctx.getStart().getLine(), type);
            }
        }
        else if (ctx.acess_array() != null)
        {
            type = visit(ctx.acess_array());
            
            if(type != Type.BOOLEAN && type != null){ // Não é booleano nem ID
                child = new AST(NodeKind.ARRAY_USE_NODE,currentArrayTable.lookupVar(ctx.acess_array().getText()),type);
                ast.addChild(child);
                return ast;
            }
            else{
                MsgErros.readErrorTypeNotAccepted(ctx.getStart().getLine(), type);
            }
        }
        else
        {
            MsgErros.erroInesperado(ctx.getStart().getLine());
        }
        return null;
    }

    //mudando as tabelas correntes quando ocorre mudança de escopo
    private Type changeCurrentFunctionProcedure(IdTable idTable, ArrayTable arrayTable,int TypeMethod) {
        this.currentIdTable = idTable;
        this.currentArrayTable = arrayTable;
        this.currentTypeMethod = TypeMethod;
        return null;
    }

    //retomando as tabelas correntes apontarem para o escopo main
    private Type restoreCurrentTable(){
        currentIdTable = idTable;
        currentArrayTable = arrayTable;
        this.currentTypeMethod = 0;
        return null;
    }

    @Override 
    public Type visitProcedure(PascalParser.ProcedureContext ctx) {
        if(funcTable.lookupVar(ctx.ID().getText())==-1 && procTable.lookupVar(ctx.ID().getText())==-1)
        {
            int id = procTable.addProc(ctx.ID().getText(),0,ctx.getStart().getLine());

            //trocar as tabelas correntes
            changeCurrentFunctionProcedure(procTable.getIdTable(id),procTable.getArrayTable(id),2);
        }
        else
        {
            MsgErros.idJaDeclarado(ctx.ID().getText(),ctx.getStart().getLine());
        }

        visit(ctx.parameter_list());
        
        if( ctx.const_var_section(0) != null)
        {
            for(int i=0; i< ctx.const_var_section().size(); i++)
            {
                visit(ctx.const_var_section(i));
            }
        }

        visit(ctx.block());

        restoreCurrentTable();

        return null;
    }

    @Override 
    public Type visitParameter_list(PascalParser.Parameter_listContext ctx) {  
        if(ctx.parameters() != null)
        {
            visit(ctx.parameters());
        }

        return null; 
    }

	@Override 
    public Type visitParameters(PascalParser.ParametersContext ctx) {
        for(int i=0; ctx.parameter(i) != null ; i++)
        {
            visit(ctx.parameter(i));
        }

        return null;
    }

    
	@Override 
    public Type visitVar_parameter(PascalParser.Var_parameterContext ctx) {       
        int qtdParam=0;

        if (currentTypeMethod == 1)
        {
            //function
            qtdParam = funcTable.getQtdParameters(funcTable.getTableSize()-1);
        }else if (currentTypeMethod == 2){
            //procedure
            qtdParam = procTable.getQtdParameters(procTable.getTableSize()-1);
        }       
       
       if( ctx.type_simple() !=null)
       {
            visit(ctx.type_simple());
            for(int i=0; i<ctx.ID().size();i++)
            {
                addIdTable(ctx.ID(i).getText(), currentLine, currentType,false,qtdParam+i);
            }
       }
       else if (ctx.array_type() != null)
       {
            visit(ctx.array_type());
            for(int i=0; i<ctx.ID().size();i++)
            {
                addArrayTable(ctx.ID(i).getText(), currentLine, currentType, currentTypeElement, 0,qtdParam+i);
            }
       }
       else
       {
            MsgErros.erroInesperado(ctx.getStart().getLine());
       }

       if (currentTypeMethod == 1)
        {
            //function
            funcTable.incrementQtdParameters(ctx.ID().size(),funcTable.getTableSize()-1);
        }else if (currentTypeMethod == 2){
            //procedure
            procTable.incrementQtdParameters(ctx.ID().size(),procTable.getTableSize()-1);
        }   
       
       return null; 
    }
	
	@Override public Type visitConstant(PascalParser.ConstantContext ctx) { 
        int qtdParam=0;

        if(currentTypeMethod == 1){
            //function
            funcTable.getQtdParameters(funcTable.getTableSize()-1);

        } else if (currentTypeMethod == 2){
            //procedure
            procTable.getQtdParameters(procTable.getTableSize()-1);

        } else {
            MsgErros.erroInesperado(ctx.getStart().getLine());
        }

        visit(ctx.type_simple());
        addIdTable (ctx.ID().getText(), currentLine, currentType,true,qtdParam);

   
        if(currentTypeMethod == 1){
            //function
            funcTable.incrementQtdParameters(1,funcTable.getTableSize()-1);

        } else if (currentTypeMethod == 2){
            //procedure
            procTable.incrementQtdParameters(1,procTable.getTableSize()-1);

        } else {
            MsgErros.erroInesperado(ctx.getStart().getLine());
        }

        return null; 
    }

    @Override
    public Type visitFunction(PascalParser.FunctionContext ctx) {    
        if(funcTable.lookupVar(ctx.ID().getText())==-1 && procTable.lookupVar(ctx.ID().getText())==-1)
        {
            visit(ctx.type_simple());
            int id = funcTable.addFunc(ctx.ID().getText(), currentType, ctx.getStart().getLine());

            //trocar as tabelas correntes
            changeCurrentFunctionProcedure(funcTable.getIdTable(id),funcTable.getArrayTable(id),1);

            //add nome da tabela a tabela de Id, já que este é usado para fazer retorno em pascal
            addIdTable(funcTable.getName(id),funcTable.getLine(id),funcTable.getTypeReturn(id),false,-1);
        }
        else
        {
            MsgErros.idJaDeclarado(ctx.ID().getText(),ctx.getStart().getLine());
        }

        visit(ctx.parameter_list());
        
        if( ctx.const_var_section(0) != null)
        {
            for(int i=0; i< ctx.const_var_section().size(); i++)
            {
                visit(ctx.const_var_section(i));
            }
        }

        visit(ctx.block());

        restoreCurrentTable();

        return null;
    }

    @Override
    public Type visitCall_function_procedure(PascalParser.Call_function_procedureContext ctx) {   
        if(funcTable.lookupVar(ctx.ID().getText())==-1 && procTable.lookupVar(ctx.ID().getText())==-1)
        {
            MsgErros.metodoNaoDeclarado(ctx.ID().getText(), ctx.getStart().getLine());
        }
       
        Type type;
        if(funcTable.lookupVar(ctx.ID().getText())!=-1) 
        {
            // Chamada de função
            int index = funcTable.lookupVar(ctx.ID().getText());

            if(funcTable.getQtdParameters(index) != ctx.expr().size()){
                MsgErros.incompatibleQtdParameters(ctx.getStart().getLine(),funcTable.getQtdParameters(index),ctx.expr().size());
            }

            for(int i = 0; ctx.expr(i) != null; i++) {
                type = visit(ctx.expr(i));
               
                if(!funcTable.getTypeByArgument(i, ctx.ID().getText()).toString().equals(type.toString())){
                    MsgErros.incompatibleTypesParameters(ctx.getStart().getLine(), funcTable.getTypeByArgument(i, ctx.ID().getText()), type);
                }
                else{
                    //chamar função de setar tamanho do array
                }
            }  
            
            return funcTable.getTypeReturn(index);          

        } else if (procTable.lookupVar(ctx.ID().getText())!=-1){ // Chamada de procedimento

           // Chamada de procedure
            int index = procTable.lookupVar(ctx.ID().getText());

            if(procTable.getQtdParameters(index) != ctx.expr().size()){
                MsgErros.incompatibleQtdParameters(ctx.getStart().getLine(),procTable.getQtdParameters(index),ctx.expr().size());
            }

            for(int i = 0; ctx.expr(i) != null; i++) {
                type = visit(ctx.expr(i));
                if(!procTable.getTypeByArgument(i, ctx.ID().getText()).toString().equals(type.toString()))
                {
                    MsgErros.incompatibleTypesParameters(ctx.getStart().getLine(), procTable.getTypeByArgument(i, ctx.ID().getText()), type);
                }
            }
            return null;
            
        } else {
            MsgErros.erroInesperado(ctx.getStart().getLine());
        }

        return null;
    }

	@Override
    public Type visitArray_type_range(PascalParser.Array_type_rangeContext ctx) {    
        currentSize = Integer.parseInt(ctx.INT_VAL(1).getText()) - Integer.parseInt(ctx.INT_VAL(0).getText()) + 1;
        
        if (currentSize < 1)
        {
            MsgErros.tamArrayInvalido(ctx.getStart().getLine());
        }

        visit(ctx.type_simple_array());

        return null;
    }

    @Override 
    public Type visitExpr_call(PascalParser.Expr_callContext ctx) { 
        Type type = visit(ctx.call_function_procedure());
        return type;
    }
	
	@Override 
    public AST visitExpr_equal(PascalParser.Expr_equalContext ctx) { 

        AST ast;
        NodeKind typeOp;

        switch(ctx.op.getType()){
            case PascalParser.NOTEQUAL:
                typeOp = NodeKind.NOTEQUAL_NODE;
                break;

            case PascalParser.EQUAL:
                typeOp = NodeKind.NOTEQUAL_NODE;
                break;

            case PascalParser.LESSTHAN:
                typeOp = NodeKind.LESSTHAN_NODE;
                break;

            case PascalParser.GREATERTHAN:
                typeOp = NodeKind.GREATERTHAN_NODE;
                break;

            case PascalParser.LEQ:
                typeOp = NodeKind.LEQ_NODE;
                break;

            case PascalParser.BEQ:
                typeOp = NodeKind.BEQ_NODE;
                break;

            default:
                MsgErros.erroInesperado(ctx.getStart().getLine());           
        }

        AST left = visit(ctx.expr(0));
        AST right = visit(ctx.expr(1));
        Type typeResult = SemanticTypeOperations.getTypeReturnByOperation(left.type, right.type, typeOp);

        if(typeResult == null) {
            MsgErros.incompatibleTypesOperation(ctx.getStart().getLine(), left.type, right.type, typeOp);
        }

        ast = new AST(typeOp, 0, Type.BOOLEAN);
        ast.addChild(left);
        ast.addChild(right);
        
        return ast; 
    }

	@Override 
    public Type visitExpr_minus(PascalParser.Expr_minusContext ctx) { 
        Type type = visit(ctx.expr());

        if(SemanticTypeOperations.getTypeReturnByOperation(Type.INTEGER, type, "*") == null) {
            MsgErros.incompatibleTypesOperation(ctx.getStart().getLine(), Type.INTEGER, type, "-()");
        }
        return type;
    }
	
	@Override 
    public Type visitExpr_div(PascalParser.Expr_divContext ctx) { 

        AST ast;

        AST astExpr1 = visit(ctx.expr(0));
        AST astExpr2 = visit(ctx.expr(1));
        Type typeResult = null;

        if(ctx.op.getType() == PascalParser.ASTERISK) {
            typeResult = SemanticTypeOperations.getTypeReturnByOperation(astExpr1.type, astExpr2.type, "*");
            ast = new AST(NodeKind.ASTERISK_NODE,0,typeResult);
        
        } else if(ctx.op.getType() == PascalParser.SLASH) {
            typeResult = SemanticTypeOperations.getTypeReturnByOperation(astExpr1.type, astExpr2.type, "/");
            ast = new AST(NodeKind.SLASH_NODE,0,typeResult);

        } else if(ctx.op.getType() == PascalParser.MOD) {
            typeResult = SemanticTypeOperations.getTypeReturnByOperation(astExpr1.type, astExpr2.type, "mod");
            ast = new AST(NodeKind.MOD_NODE,0,typeResult);
             
        } else {
            MsgErros.erroInesperado(ctx.getStart().getLine());
        }

        if(typeResult == null) {
            MsgErros.incompatibleTypesOperation(ctx.getStart().getLine(), type1, type2, ctx.op.getText());
        }

        convertAndAddFactors(ast,right,left);
        
        return ast; 
    }
	
	@Override 
    public Type visitExpr_or(PascalParser.Expr_orContext ctx) { 
        Type type1 = visit(ctx.expr(0));
        Type type2 = visit(ctx.expr(1));
        
        if(type1 != Type.BOOLEAN) {
            MsgErros.exprIsNotBoolean(ctx.getStart().getLine(), type1);
        }

        if(type2 != Type.BOOLEAN) {
            MsgErros.exprIsNotBoolean(ctx.getStart().getLine(), type2);
        }

        return Type.BOOLEAN; 
    }
	
	@Override 
    public Type visitExpr_and(PascalParser.Expr_andContext ctx) { 
        Type type1 = visit(ctx.expr(0));
        Type type2 = visit(ctx.expr(1));
        
        if(type1 != Type.BOOLEAN) {
            MsgErros.exprIsNotBoolean(ctx.getStart().getLine(), type1);
        }

        if(type2 != Type.BOOLEAN) {
            MsgErros.exprIsNotBoolean(ctx.getStart().getLine(), type2);
        }

        return Type.BOOLEAN; 
    }
	
    private void convertAndAddFactors(AST dad, AST right, AST left){
        if(left.type == Type.INTEGER && right.type == Type.REAL){
            dad.addChild(insertConversion(left, Type.REAL, NodeKind.I2R_NODE));
            dad.addChild(right);
        }else if(left.type == Type.REAL && right.type == Type.INTEGER){
            dad.addChild(left);
            dad.addChild(insertConversion(right, Type.REAL, NodeKind.I2R_NODE));
        }else{
            dad.addChild(left);
            dad.addChild(right);
        }
    }

	@Override 
    public AST visitExpr_plus(PascalParser.Expr_plusContext ctx) { 
        AST ast;
        AST left = visit(ctx.expr(0));
        AST right = visit(ctx.expr(1));
        Type typeResult = null;

        if(ctx.op.getType() == PascalParser.PLUS) {
            typeResult = SemanticTypeOperations.getTypeReturnByOperation(left.type, right.type, "+");
            ast = new AST(NodeKind.PLUS_NODE, 0, typeResult);

        } else if(ctx.op.getType() == PascalParser.MINUS) {
            typeResult = SemanticTypeOperations.getTypeReturnByOperation(left.type, right.type, "-");
            ast = new AST(NodeKind.MINUS_NODE, 0, typeResult);
        } else {
            MsgErros.erroInesperado(ctx.getStart().getLine());
        }

        if(typeResult == null) {
            MsgErros.incompatibleTypesOperation(ctx.getStart().getLine(), left.type, right.type, ctx.op.getText());
        }

        convertAndAddFactors(ast,right,left);
        return ast; 
    }
	
	@Override 
    public Type visitExpr_not(PascalParser.Expr_notContext ctx) { 
        Type type = visit(ctx.expr());
        
        if(type != Type.BOOLEAN) {
            MsgErros.exprIsNotBoolean(ctx.getStart().getLine(), type);
        }
        return type; 
    }

    @Override
    public AST visitWhile_block(PascalParser.While_blockContext ctx) { 

        AST ast = new AST(NodeKind.WHILE_NODE,0,Type.NO_TYPE);
        
        AST astExpr = visit(ctx.expr());
        if(type != Type.BOOLEAN){
          MsgErros.exprIsNotBoolean(ctx.getStart().getLine(), type);
        }
        ast.addChild(astExpr);
        ast.addChild(visit(ctx.block()));
        
        return ast; 
    }

    @Override 
    public AST visitIf_block(PascalParser.If_blockContext ctx) { 
        AST ast = new AST(NodeKind.IF_NODE,0,Type.NO_TYPE);
        AST exp = visit(ctx.expr());
        if(exp.type != Type.BOOLEAN){
          MsgErros.exprIsNotBoolean(ctx.getStart().getLine(), exp.type);
        }
        else{
            ast.addChild(exp);
        }
        // for(int i=0; ctx.block(i)!=null; i++){
        //     visit(ctx.block(i));
        // }
        ast ifBlock = visit(ctx.block(0)); 
        ast.addChild(ifBlock);

        if(ctx.block(1)!=null){
            AST elseBlock = visit(ctx.block(1));
            ast.addChild(elseBlock);
        }
        return ast;
    }
    

    @Override 
    public AST visitWrite_io(PascalParser.Write_ioContext ctx) { 

        AST ast;

        AST astExpr = visit(ctx.expr());

        if(astExpr.type == Type.BOOLEAN || astExpr.type == Type.REAL || astExpr.type == Type.INTEGER || astExpr.type == Type.STRING){ //aceita
            ast = new AST(NodeKind.WRITE_NODE,0,astExpr.type);
            ast.addChild(astExpr);
          return ast;
           
        } else {
            MsgErros.writeErrorTypeExprNotAccepted(ctx.getStart().getLine(), type);
        }
        
        return null;
    }
}
