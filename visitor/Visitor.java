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

    //adiciona Id na tabela de escopo atual - sendo id unico - retorna a linha na tabela
    private int addIdTable (String s, int line, Type type, Boolean ehConst, int positionArgument){
        
        int index;

        if(currentIdTable.lookupVar(s)==-1 && currentArrayTable.lookupArray(s)==-1)
        {
            index = currentIdTable.addId(s,line,type,ehConst, positionArgument);
            return index;
        }
        MsgErros.idJaDeclarado(s,line);
        return -1;
    }

    //adiciona array na tabela de escopo atual - sendo id unico
    private int addArrayTable (String s, int line, Type type, Type typeElement, int size, int positionArgument){
        int index;
        if(currentIdTable.lookupVar(s)==-1 && currentArrayTable.lookupArray(s)==-1)
        {
            index = currentArrayTable.addArray(s,line,type, typeElement, size, positionArgument);
            return index;
        }
        MsgErros.idJaDeclarado(s,line);
        return -1;
    }
    @Override 
    public AST visitProgram(PascalParser.ProgramContext ctx) {
        return visit(ctx.program_pascal());
    }

    @Override 
    public AST visitProgram_pascal(PascalParser.Program_pascalContext ctx) {
        AST ast = new AST(NodeKind.PROGRAM_NODE,0,Type.NO_TYPE);
        
        AST ast_id_list = new AST(NodeKind.VAR_LIST_NODE,0,Type.NO_TYPE);

        AST var_child;
        if(ctx.var_section()!= null){
            var_child = visit(ctx.var_section());
            ast_id_list.copyChildren(var_child); 
        }        
        
        AST const_child;
        if(ctx.const_section()!= null){
            const_child = visit(ctx.const_section()); 
            ast_id_list.copyChildren(const_child); 
        }

        ast.addChild(ast_id_list);
        
        AST proced_function_child;
        for(int i = 0; i< ctx.procedure_function().size(); i++){
            proced_function_child = visit(ctx.procedure_function(i)); 
            ast.addChild(proced_function_child);
        }

        if(ctx.block() != null){
            ast.addChild(visit(ctx.block()));
        }
        
        return ast;        
    }

    @Override 
    public AST visitVar_section(PascalParser.Var_sectionContext ctx) {
        AST ast = new AST(NodeKind.PROVISORY_NODE,0,Type.NO_TYPE);

        AST inter;
        //linha
        for(int i=0; i < ctx.var().size() ; i++){
            inter = visit(ctx.var(i));
            ast.copyChildren(inter);
        }
        return ast;
    }

    @Override
    public AST visitConst_section(PascalParser.Const_sectionContext ctx) {
        AST ast = new AST(NodeKind.PROVISORY_NODE,0,Type.NO_TYPE);
        AST value = null;
        AST child = null;
        int index;

        for(int i = 0 ; i < ctx.ID().size(); i ++){
            value = visit(ctx.val_simple(i));
            index = addIdTable(ctx.ID(i).getText(),currentLine,currentType,true,-1);
            child = new AST(NodeKind.VAR_DECL_NODE, index,value.type);  
            ast.addChild(child);    
        }
        return ast;
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
    public AST visitBoolean_val(PascalParser.Boolean_valContext ctx) {

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
    public AST visitVar(PascalParser.VarContext ctx) {

        AST provisory = new AST(NodeKind.PROVISORY_NODE,0,Type.NO_TYPE); 
        AST child = null;
        int line;

        if(ctx.type_simple() != null)
        {
            visit(ctx.type_simple());
            for(int i = 0 ; i < ctx.ID().size(); i ++)
            {            
                line = addIdTable(ctx.ID(i).getText(),currentLine,currentType,false,-1);
                provisory.addChild( new AST(NodeKind.VAR_DECL_NODE,line,currentType));         
            }
        }
        else if(ctx.array_type_range() != null)
        {
            visit(ctx.array_type_range());
            for(int i = 0 ; i < ctx.ID().size(); i ++)
            {            
                line = addArrayTable(ctx.ID(i).getText(),currentLine,currentType, currentTypeElement, currentSize,-1);
                provisory.addChild( new AST(NodeKind.ARRAY_DECL_NODE,line,currentType));                    
            }
        } 
        else
        {
           MsgErros.erroInesperado(ctx.getStart().getLine()); 
        }
        return provisory; 
    }

    @Override public AST visitBlock(PascalParser.BlockContext ctx) {
        AST ast = new AST(NodeKind.BLOCK_NODE,0,Type.NO_TYPE);

        for(int i = 0; i< ctx.statement().size(); i++){
            ast.addChild(visit(ctx.statement(i)));
        }
        return ast;
    }

    @Override 
    public AST visitType_simple_integer(PascalParser.Type_simple_integerContext ctx) { 
        currentType = Type.INTEGER;
        currentLine = ctx.getStart().getLine();
        return null;
    }
	
	@Override 
    public AST visitType_simple_real(PascalParser.Type_simple_realContext ctx) { 
        currentType = Type.REAL;
        currentLine = ctx.getStart().getLine();
        return null;
    }

	@Override 
    public AST visitType_simple_boolean(PascalParser.Type_simple_booleanContext ctx) {
        currentType = Type.BOOLEAN;
        currentLine = ctx.getStart().getLine();
        return null;
    }
	
	@Override 
    public AST visitType_simple_string(PascalParser.Type_simple_stringContext ctx) {
        currentType = Type.STRING;
        currentLine = ctx.getStart().getLine();
        return null;
    }

    @Override 
    public AST visitType_simple_array_integer(PascalParser.Type_simple_array_integerContext ctx) {
        currentType = Type.ARRAY_INTEGER;
        currentTypeElement = Type.INTEGER;
        currentLine = ctx.getStart().getLine();
        return null;
    }
	
	@Override 
    public AST visitType_simple_array_real(PascalParser.Type_simple_array_realContext ctx) { 
        currentType = Type.ARRAY_REAL;
        currentTypeElement = Type.REAL;
        currentLine = ctx.getStart().getLine();
        return null;
    }
	
	@Override 
    public AST visitType_simple_array_boolean(PascalParser.Type_simple_array_booleanContext ctx) { 
        currentType = Type.ARRAY_BOOLEAN;
        currentTypeElement = Type.BOOLEAN;
        currentLine = ctx.getStart().getLine();
        return null;
    }

    private int  checkId(String s, int line){
        int index = currentIdTable.lookupVar(s);
        if( index == -1)
        {
            MsgErros.idNaoDeclarado(s,line);           
        }
        return index;
    }

    private int checkArray(String s, int line){
        int index = currentArrayTable.lookupArray(s);
        if(index == -1)
        {
            MsgErros.idNaoDeclarado(s, line);           
        }
        return index;
    }

    private AST insertConversion(AST sub, Type conv, NodeKind typeNode){
        AST wideNode = new AST(typeNode,0,conv);
        wideNode.addChild(sub);
        return wideNode;
    }

    @Override 
    public AST visitAtribution(PascalParser.AtributionContext ctx) {
        Type type1;

        AST ast = new AST(NodeKind.ASSIGN_NODE,0,Type.NO_TYPE);
        AST left = null;
        AST right = null;
        int index = -1;

        if(ctx.ID() != null)
        {
            index = checkId(ctx.ID().getText(),ctx.getStart().getLine());
            type1 = currentIdTable.getTypeByName(ctx.ID().getText());
            left = new AST(NodeKind.VAR_USE_NODE,index,type1);
            ast.addChild(left);   
        }
        else if (ctx.acess_array() != null)
        {
            left = visit(ctx.acess_array());
            ast.addChild(left);   
        }
        else
        {
            MsgErros.erroInesperado(ctx.getStart().getLine());
        }
        
        right = visit(ctx.expr());

        if(SemanticTypeOperations.typesAtribution(left.type, right.type) == null) {
            MsgErros.incompatibleTypesAtribution(ctx.getStart().getLine(), left.type, right.type);
        } 

        if(left.type == Type.REAL && right.type == Type.INTEGER)
        {
            ast.addChild(insertConversion(right, Type.REAL,NodeKind.I2R_NODE));
        }
        else{
            ast.addChild(right);
        }       

        return ast;
    }

    @Override 
    public AST visitAcess_array(PascalParser.Acess_arrayContext ctx) {
        
        int index = checkArray(ctx.ID().getText(),ctx.getStart().getLine());
        AST element = visit(ctx.expr());
        if (element.type != Type.INTEGER) 
        {
            MsgErros.typeIndexError(ctx.getStart().getLine());
        }
        Type type = currentArrayTable.getTypeElement(index);
        AST ast = new AST(NodeKind.ACCESS_ARRAY_USE_NODE, index, type);
        ast.addChild(element); // informação da expressão para acessar o index correto do array
        return ast;
    }

    @Override
    public AST visitExpr_id(PascalParser.Expr_idContext ctx) {
        AST ast ;
        int line;
        
        if(currentIdTable.lookupVar(ctx.ID().getText())==-1 && currentArrayTable.lookupArray(ctx.ID().getText()) == -1) {   
            MsgErros.idNaoDeclarado(ctx.ID().getText(), ctx.getStart().getLine());
        }

        if(currentIdTable.lookupVar(ctx.ID().getText()) != -1) {
            line = currentIdTable.lookupVar(ctx.ID().getText());
            ast = new AST(NodeKind.VAR_USE_NODE, line , currentIdTable.getType(line));
            return ast;

        } else if(currentArrayTable.lookupArray(ctx.ID().getText()) != -1) {
            line = currentArrayTable.lookupArray(ctx.ID().getText());
            ast = new AST(NodeKind.VAR_USE_NODE,line,currentArrayTable.getType(line));
            return ast;
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
            child = visit(ctx.acess_array());
            
            if(child.type != Type.BOOLEAN && child.type != null){ // Não é booleano nem ID
                ast.addChild(child);
                return ast;
            }
            else{
                MsgErros.readErrorTypeNotAccepted(ctx.getStart().getLine(), child.type);
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
    public AST visitProcedure(PascalParser.ProcedureContext ctx) {
        AST ast = null;
        if(funcTable.lookupVar(ctx.ID().getText())==-1 && procTable.lookupVar(ctx.ID().getText())==-1)
        {
            int id = procTable.addProc(ctx.ID().getText(),0,ctx.getStart().getLine());

            ast = new AST(NodeKind.PROCEDURE_NODE,id,Type.NO_TYPE);

            //trocar as tabelas correntes
            changeCurrentFunctionProcedure(procTable.getIdTable(id),procTable.getArrayTable(id),2);
        }
        else
        {
            MsgErros.idJaDeclarado(ctx.ID().getText(),ctx.getStart().getLine());
        }

        AST parameters = visit(ctx.parameter_list());
        ast.addChild(parameters);
        
         AST ast_id_list = new AST(NodeKind.VAR_LIST_NODE,0,Type.NO_TYPE);

        AST var_child;
        if(ctx.var_section()!= null){
            var_child = visit(ctx.var_section());
            ast_id_list.copyChildren(var_child); 
        }        
        
        AST const_child;
        if(ctx.const_section()!= null){
            const_child = visit(ctx.const_section()); 
            ast_id_list.copyChildren(const_child); 
        }

        ast.addChild(ast_id_list);

        ast.addChild(visit(ctx.block()));

        restoreCurrentTable();

        return ast;
    }

    @Override 
    public AST visitParameter_list(PascalParser.Parameter_listContext ctx) { 
        
        if(ctx.parameters() != null)
        {
            return visit(ctx.parameters());
        }
        AST ast = new AST(NodeKind.PARAMETERS_NODE,0,Type.NO_TYPE);
        return ast;
    }

	@Override 
    public AST visitParameters(PascalParser.ParametersContext ctx) {

        AST ast = new AST(NodeKind.PARAMETERS_NODE,0,Type.NO_TYPE);
        AST inter;

        for(int i=0; ctx.parameter(i) != null ; i++)
        {
            inter = (visit(ctx.parameter(i)));
            ast.copyChildren(inter);
        }
        return ast;
    }

    
	@Override 
    public AST visitVar_parameter(PascalParser.Var_parameterContext ctx) {

        AST ast = new AST(NodeKind.PROVISORY_NODE,0,Type.NO_TYPE);
        int index;

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
            for(int i=0; i < ctx.ID().size();i++)
            {
                index = addIdTable(ctx.ID(i).getText(), currentLine, currentType,false,qtdParam+i);                
                ast.addChild( new AST(NodeKind.VAR_PARAMETER_NODE,index,currentIdTable.getType(index)));
            }
       }
       else if (ctx.array_type() != null)
       {
            visit(ctx.array_type());
            for(int i=0; i<ctx.ID().size();i++)
            {
                index = addArrayTable(ctx.ID(i).getText(), currentLine, currentType, currentTypeElement, 0,qtdParam+i);
                ast.addChild( new AST(NodeKind.ARRAY_PARAMETER_NODE,index,currentArrayTable.getType(index)));
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
       
       return ast; 
    }
	
	@Override
    public AST visitConstant(PascalParser.ConstantContext ctx) { 
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
    public AST visitFunction(PascalParser.FunctionContext ctx) {  
        AST ast = null;
        int index = -1;
        int id =-1;
    
        if(funcTable.lookupVar(ctx.ID().getText())==-1 && procTable.lookupVar(ctx.ID().getText())==-1)
        {
            visit(ctx.type_simple());
            id = funcTable.addFunc(ctx.ID().getText(), currentType, ctx.getStart().getLine());
            ast = new AST(NodeKind.FUNCTION_NODE, id, funcTable.getTypeReturn(id));  

            //trocar as tabelas correntes
            changeCurrentFunctionProcedure(funcTable.getIdTable(id),funcTable.getArrayTable(id),1);

            //add nome da tabela a tabela de Id, já que este é usado para fazer retorno em pascal
            index = addIdTable(funcTable.getName(id),funcTable.getLine(id),funcTable.getTypeReturn(id),false,-1);
        }
        else
        {
            MsgErros.idJaDeclarado(ctx.ID().getText(),ctx.getStart().getLine());
        }

        AST param = visit(ctx.parameter_list());
        ast.addChild(param);
        
        AST ast_id_list = new AST(NodeKind.VAR_LIST_NODE,0,Type.NO_TYPE);

        AST ret = new AST(NodeKind.VAR_DECL_NODE, index, funcTable.getTypeReturn(id));
        ast_id_list.addChild(ret); 

        AST var_child;
        if(ctx.var_section()!= null){
            var_child = visit(ctx.var_section());           
            ast_id_list.copyChildren(var_child); 
        }        
        
        AST const_child;
        if(ctx.const_section()!= null){
            const_child = visit(ctx.const_section()); 
            ast_id_list.copyChildren(const_child); 
        }

        ast.addChild(ast_id_list);
        ast.addChild(visit(ctx.block()));

        restoreCurrentTable();
        return ast;
    }

    @Override
    public AST visitCall_function_procedure(PascalParser.Call_function_procedureContext ctx) {   
        if(funcTable.lookupVar(ctx.ID().getText())==-1 && procTable.lookupVar(ctx.ID().getText())==-1)
        {
            MsgErros.metodoNaoDeclarado(ctx.ID().getText(), ctx.getStart().getLine());
        }
       
        AST ast ;
        AST child;

        if(funcTable.lookupVar(ctx.ID().getText())!=-1) 
        {
            // Chamada de função
            int index = funcTable.lookupVar(ctx.ID().getText());

            ast = new AST(NodeKind.CALL_FUNCTION_NODE,index,funcTable.getTypeReturn(index));

            if(funcTable.getQtdParameters(index) != ctx.expr().size()){
                MsgErros.incompatibleQtdParameters(ctx.getStart().getLine(),funcTable.getQtdParameters(index),ctx.expr().size());
            }

            for(int i = 0; ctx.expr(i) != null; i++) {
                child = visit(ctx.expr(i));
                Type type = funcTable.getTypeByArgument(i, ctx.ID().getText());
                if(type != child.type){
                    if(child.type == Type.INTEGER && type == Type.REAL){
                        ast.addChild(insertConversion(child,Type.REAL, NodeKind.I2R_NODE));
                        
                    }else{
                        MsgErros.incompatibleTypesParameters(ctx.getStart().getLine(), funcTable.getTypeByArgument(i, ctx.ID().getText()), child.type);
                    }
                }else{
                    ast.addChild(child);
                }
            }  
            
            return ast;          

        } else if (procTable.lookupVar(ctx.ID().getText())!=-1){ // Chamada de procedimento

           // Chamada de procedure
            int index = procTable.lookupVar(ctx.ID().getText());

            ast = new AST(NodeKind.CALL_PROCEDURE_NODE,index,Type.NO_TYPE);
            
            if(procTable.getQtdParameters(index) != ctx.expr().size()){
                MsgErros.incompatibleQtdParameters(ctx.getStart().getLine(),procTable.getQtdParameters(index),ctx.expr().size());
            }

            for(int i = 0; ctx.expr(i) != null; i++) {
                child = visit(ctx.expr(i));
                Type type = procTable.getTypeByArgument(i, ctx.ID().getText());
                if(type != child.type){
                    if(child.type == Type.INTEGER && type == Type.REAL){
                        ast.addChild(insertConversion(child,Type.REAL, NodeKind.I2R_NODE));
                        
                    }else{
                        MsgErros.incompatibleTypesParameters(ctx.getStart().getLine(), procTable.getTypeByArgument(i, ctx.ID().getText()), child.type);
                    }
                }else{
                    ast.addChild(child);
                }
            }
            return ast;
            
        } else {
            MsgErros.erroInesperado(ctx.getStart().getLine());
        }

        return null;
    }

	@Override
    public AST visitArray_type_range(PascalParser.Array_type_rangeContext ctx) {    
        currentSize = Integer.parseInt(ctx.INT_VAL(1).getText()) - Integer.parseInt(ctx.INT_VAL(0).getText()) + 1;
        
        if (currentSize < 1)
        {
            MsgErros.tamArrayInvalido(ctx.getStart().getLine());
        }

        visit(ctx.type_simple_array());

        return null;
    }

    @Override 
    public AST visitExpr_call(PascalParser.Expr_callContext ctx) {
        return visit(ctx.call_function_procedure());
    }
	
	@Override 
    public AST visitExpr_equal(PascalParser.Expr_equalContext ctx) { 

        AST ast = null;
        NodeKind typeOp = null;

        switch(ctx.op.getType()){
            case PascalParser.NOTEQUAL:
                typeOp = NodeKind.NOTEQUAL_NODE;
                break;

            case PascalParser.EQUAL:
                typeOp = NodeKind.EQUAL_NODE;
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
        Type typeResult = SemanticTypeOperations.getTypeReturnByOperation(left.type, right.type, ctx.op.getText());

        if(typeResult == null) {
            MsgErros.incompatibleTypesOperation(ctx.getStart().getLine(), left.type, right.type, ctx.op.getText());
        }

        ast = new AST(typeOp, 0, Type.BOOLEAN);
        convertAndAddFactors(ast, right, left);
        // ast.addChild(left);
        // ast.addChild(right);
        
        return ast; 
    }

	@Override 
    public AST visitExpr_minus(PascalParser.Expr_minusContext ctx) { 
        AST expr = visit(ctx.expr());

        if(SemanticTypeOperations.getTypeReturnByOperation(Type.INTEGER, expr.type, "*") == null) {
            MsgErros.incompatibleTypesOperation(ctx.getStart().getLine(), Type.INTEGER, expr.type, "-()");
        }
        AST ast = new AST(NodeKind.ONE_MINUS_NODE, 0, expr.type);
        
        ast.addChild(expr);
        return ast;
    }
	
	@Override 
    public AST visitExpr_div(PascalParser.Expr_divContext ctx) { 

        AST ast = null;

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
            MsgErros.incompatibleTypesOperation(ctx.getStart().getLine(), astExpr1.type, astExpr2.type, ctx.op.getText());
        }

        convertAndAddFactors(ast,astExpr2,astExpr1);
        
        return ast; 
    }
	
	@Override 
    public AST visitExpr_or(PascalParser.Expr_orContext ctx) { 
        AST ast = new AST(NodeKind.OR_NODE, 0, Type.BOOLEAN);
        AST expr1 = visit(ctx.expr(0));
        AST expr2 = visit(ctx.expr(1));
        
        if(expr1.type != Type.BOOLEAN) {
            MsgErros.exprIsNotBoolean(ctx.getStart().getLine(), expr1.type );
        }

        if(expr2.type != Type.BOOLEAN) {
            MsgErros.exprIsNotBoolean(ctx.getStart().getLine(), expr2.type);
        }

        ast.addChild(expr1);
        ast.addChild(expr2);

        return ast; 
    }
	
	@Override 
    public AST visitExpr_and(PascalParser.Expr_andContext ctx) { 

        AST ast = new AST(NodeKind.AND_NODE,0,Type.BOOLEAN);
        AST expr1 = visit(ctx.expr(0));
        AST expr2 = visit(ctx.expr(1));
        
        if(expr1.type != Type.BOOLEAN) {
            MsgErros.exprIsNotBoolean(ctx.getStart().getLine(), expr1.type);
        }

        if(expr2.type != Type.BOOLEAN) {
            MsgErros.exprIsNotBoolean(ctx.getStart().getLine(), expr2.type);
        }

        ast.addChild(expr1);
        ast.addChild(expr2);

        return ast; 
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
        AST ast = null ;
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
    public AST visitExpr_not(PascalParser.Expr_notContext ctx) { 
        AST ast = new AST(NodeKind.NOT_NODE,0,Type.BOOLEAN);
        AST expr = visit(ctx.expr());
        
        if(expr.type != Type.BOOLEAN) {
            MsgErros.exprIsNotBoolean(ctx.getStart().getLine(), expr.type);
        }
        ast.addChild(expr);
        return ast; 
    }

    @Override
    public AST visitWhile_block(PascalParser.While_blockContext ctx) { 

        AST ast = new AST(NodeKind.WHILE_NODE,0,Type.NO_TYPE);
        
        AST astExpr = visit(ctx.expr());
        if(astExpr.type != Type.BOOLEAN){
          MsgErros.exprIsNotBoolean(ctx.getStart().getLine(), astExpr.type);
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
        AST ifBlock = visit(ctx.block(0)); 
        ast.addChild(ifBlock);

        if(ctx.block(1)!=null){
            AST elseBlock = visit(ctx.block(1));
            ast.addChild(elseBlock);
        }
        return ast;
    }
    

    @Override 
    public AST visitWrite_io(PascalParser.Write_ioContext ctx) { 
        AST ast = null;
        AST astExpr = visit(ctx.expr());

        if(astExpr.type == Type.BOOLEAN || astExpr.type == Type.REAL || astExpr.type == Type.INTEGER || astExpr.type == Type.STRING){ //aceita
            if(ctx.WRITE() != null) {
                ast = new AST(NodeKind.WRITE_NODE,0,Type.NO_TYPE);

            } else if(ctx.WRITELN() != null) { 
                ast = new AST(NodeKind.WRITELN_NODE,0,Type.NO_TYPE);
                
            } else {
                MsgErros.erroInesperado(ctx.getStart().getLine());
            }
        
            ast.addChild(astExpr);
          return ast;
           
        } else {
            MsgErros.writeErrorTypeExprNotAccepted(ctx.getStart().getLine(), astExpr.type);
        }
        
        return null;
    }

    @Override 
    public AST visitVal_simple_array(PascalParser.Val_simple_arrayContext ctx) {
        if(ctx.val_simple() != null){
            return visit(ctx.val_simple());
        } else if(ctx.acess_array() != null) {
            return visit(ctx.acess_array());
        } else {
            MsgErros.erroInesperado(ctx.getStart().getLine());
        }
        return null;
    }

    @Override 
    public AST visitExpr_array(PascalParser.Expr_arrayContext ctx) {
        return visit(ctx.val_simple_array()); 
    }

    @Override 
    public AST visitExpr_par(PascalParser.Expr_parContext ctx) { 
        return visit(ctx.expr()); 
    }

    @Override 
    public AST visitStatement(PascalParser.StatementContext ctx) { 
        if(ctx.atribution() != null){
            return visit(ctx.atribution());
            
        } else if(ctx.while_block() != null) {
            return visit(ctx.while_block());

        } else if(ctx.if_block() != null) {
            return visit(ctx.if_block());
            
        } else if(ctx.call_function_procedure() != null) {
            return visit(ctx.call_function_procedure());

        } else if(ctx.read_io() != null) {
            return visit(ctx.read_io());
            
        } else if(ctx.write_io() != null) {
            return visit(ctx.write_io());
            
        } else {
            MsgErros.erroInesperado(ctx.getStart().getLine());
        }
        return null;
    }

    @Override
    public AST visitParameter(PascalParser.ParameterContext ctx) { 
        if(ctx.var_parameter() != null) {
            return visit(ctx.var_parameter());

        } else if(ctx.constant() != null) {
             return visit(ctx.constant());
             
        } else {
            MsgErros.erroInesperado(ctx.getStart().getLine());
        }
        return null;
    }

    @Override 
    public AST visitProcedure_function(PascalParser.Procedure_functionContext ctx) { 
        if(ctx.procedure() != null) {
            return visit(ctx.procedure());

        } else if(ctx.function() != null) {
            return visit(ctx.function());

        } else {
            MsgErros.erroInesperado(ctx.getStart().getLine());
        }
        return null;
    }

    @Override 
    public AST visitBegin(PascalParser.BeginContext ctx) { 
        if(ctx.program() != null){
            return visit(ctx.program());
        } else {
            MsgErros.erroInesperado(ctx.getStart().getLine());
        }
        return null;
    }
}
