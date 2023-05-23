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

import types.Type;

public class Visitor extends PascalParserBaseVisitor<Type>
{
    //tables da main
    private StrTable strTable = new StrTable();
    private IdTable idTable = new IdTable();
    private ArrayTable arrayTable = new ArrayTable();

    //auxiliares para obter dados das variáveis
    private Type currentType;
    private int currentLine;
    private int currentSize;

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
    private Type addIdTable (String s, int line, Type type, Boolean ehConst){

        if(currentIdTable.lookupVar(s)==-1 && currentArrayTable.lookupArray(s)==-1)
        {
            currentIdTable.addId(s,line,type,ehConst);
            return null;
        }
        MsgErros.idJaDeclarado(s,line);
        return null;
    }

    //adiciona array na tabela de escopo atual - sendo id unico
    private Type addArrayTable (String s, int line, Type type, int size){

        if(currentIdTable.lookupVar(s)==-1 && currentArrayTable.lookupArray(s)==-1)
        {
            currentArrayTable.addArray(s,line,type,size);
            return null;
        }
        MsgErros.idJaDeclarado(s,line);
        return null;
    }

    @Override
    public Type visitConst_section(PascalParser.Const_sectionContext ctx) {
        
        for(int i = 0 ; i < ctx.ID().size(); i ++){
            visit(ctx.val_simple(i));
            addIdTable(ctx.ID(i).getText(),currentLine,currentType,true);          
        }
        return null;
    }

    @Override 
    public Type visitInt_val(PascalParser.Int_valContext ctx) {
        currentType = Type.INTEGER;
        currentLine = ctx.getStart().getLine();
        return null;
    }

	@Override
    public Type visitReal_val(PascalParser.Real_valContext ctx) { 
        currentType = Type.REAL;
        currentLine = ctx.getStart().getLine();
        return null;
    }
	
     @Override 
    public Type visitString_val(PascalParser.String_valContext ctx) { 
        currentStrTable.add(ctx.getText());
        currentType = Type.STRING;
        currentLine = ctx.getStart().getLine();
        return null;    
    }

	@Override 
    public Type visitBoolean_val(PascalParser.Boolean_valContext ctx) {
        currentType = Type.BOOLEAN;
        currentLine = ctx.getStart().getLine();
        return null;    
    }

    @Override 
    public Type visitVar(PascalParser.VarContext ctx) {

        if(ctx.type_simple() != null)
        {
            visit(ctx.type_simple());
            for(int i = 0 ; i < ctx.ID().size(); i ++)
            {            
                addIdTable(ctx.ID(i).getText(),currentLine,currentType,false);          
            }
        }
        else if(ctx.array_type_range() != null)
        {
            visit(ctx.array_type_range());
            for(int i = 0 ; i < ctx.ID().size(); i ++)
            {            
                addArrayTable(ctx.ID(i).getText(),currentLine,currentType,currentSize);          
            }
        }
        else
        {
           MsgErros.erroInesperado(ctx.getStart().getLine()); 
        }
        return null; 
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
    
    /*
    ** Verifica se um dado Id já foi declarado
    ** Caso não exista na tabela de Id encerra o programa
    */
    private void checkId(String s, int line){
        if(currentIdTable.lookupVar(s) == -1)
        {
            MsgErros.idNaoDeclarado(s,line);           
        }
    }

    /*
    ** Verifica se um dado Id de array já foi declarado
    ** Caso não exista na tabela de Id encerra o programa
    */
    private void checkArray(String s, int line){
        if(currentArrayTable.lookupArray(s) == -1)
        {
            MsgErros.idNaoDeclarado(s, line);           
        }
    }

    @Override 
    public Type visitAtribution(PascalParser.AtributionContext ctx) {
        Type type1;

        if(ctx.ID() != null)
        {
            checkId(ctx.ID().getText(),ctx.getStart().getLine());

        }
        else if (ctx.acess_array() != null)
        {
            type1 = visit(ctx.acess_array());
        }
        else
        {
            MsgErros.erroInesperado(ctx.getStart().getLine());
        }
        visit(ctx.expr());



        return null;
    }

    @Override 
    public Type visitAcess_array(PascalParser.Acess_arrayContext ctx) {

        checkArray(ctx.ID().getText(),ctx.getStart().getLine());
        visit(ctx.expr());
        
        return null;
    }

    @Override
    public Type visitExpr_id(PascalParser.Expr_idContext ctx) {

        if(currentIdTable.lookupVar(ctx.ID().getText())==-1 && currentArrayTable.lookupArray(ctx.ID().getText()) == -1)
        {
            MsgErros.idNaoDeclarado(ctx.ID().getText(), ctx.getStart().getLine());
        }
                
        return null; 
    }

    @Override 
    public Type visitRead_io(PascalParser.Read_ioContext ctx) {
        if(ctx.ID() != null)
        {
            checkId(ctx.ID().getText(),ctx.getStart().getLine());
        }
        else if (ctx.acess_array() != null)
        {
          visit(ctx.acess_array());
        }
        else
        {
            MsgErros.erroInesperado(ctx.getStart().getLine());
        }
        return null;
    }

    //mudando as tabelas correntes quando ocorre mudança de escopo
    private Type changeCurrentFunctionProcedure(IdTable idTable, ArrayTable arrayTable)
    {
        this.currentIdTable = idTable;
        this.currentArrayTable = arrayTable;
        return null;
    }

    //retomando as tabelas correntes apontarem para o escopo main
    private Type restoreCurrentTable(){
        currentIdTable = idTable;
        currentArrayTable = arrayTable;
        return null;
    }

    @Override 
    public Type visitProcedure(PascalParser.ProcedureContext ctx) {

        if(funcTable.lookupVar(ctx.ID().getText())==-1 && procTable.lookupVar(ctx.ID().getText())==-1)
        {
            int id = procTable.addProc(ctx.ID().getText(),ctx.getStart().getLine());

            //trocar as tabelas correntes
            changeCurrentFunctionProcedure(procTable.getIdTable(id),procTable.getArrayTable(id));
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

        visit(ctx.parameter(0));

        for(int i=1; i < ctx.parameter().size(); i++)
        {
            visit(ctx.parameter(i));
        }
        return null;
    }

    
	@Override public Type visitVar_parameter(PascalParser.Var_parameterContext ctx) {
       
       if( ctx.type_simple() !=null)
       {
            visit(ctx.type_simple());
            for(int i=0; i<ctx.ID().size();i++)
            {
                addIdTable(ctx.ID(i).getText(), currentLine, currentType,false);
            }
       }
       else if (ctx.array_type() != null)
       {
            visit(ctx.array_type());
            for(int i=0; i<ctx.ID().size();i++)
            {
                addArrayTable(ctx.ID(i).getText(),currentLine,currentType,currentSize);
            }
       }
       else
       {
            MsgErros.erroInesperado(ctx.getStart().getLine());
       }
       
        return null; 
    }
	
	@Override public Type visitConstant(PascalParser.ConstantContext ctx) { 
        
        visit(ctx.type_simple());
        addIdTable (ctx.ID().getText(), currentLine, currentType,true);
        return null; 
    }

    @Override
    public Type visitFunction(PascalParser.FunctionContext ctx) {
        
        if(funcTable.lookupVar(ctx.ID().getText())==-1 && procTable.lookupVar(ctx.ID().getText())==-1)
        {
            visit(ctx.type_simple());
            int id = funcTable.addFunc(ctx.ID().getText(), currentType, ctx.getStart().getLine());

            //trocar as tabelas correntes
            changeCurrentFunctionProcedure(funcTable.getIdTable(id),funcTable.getArrayTable(id));

            //add nome da tabela a tabela de Id, já que este é usado para fazer retorno em pascal
            addIdTable(funcTable.getName(id),funcTable.getLine(id),funcTable.getTypeReturn(id),false);
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

        if(ctx.param_call() != null)
        {
            visit(ctx.param_call());
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

        visit(ctx.type_simple());

        return null;
    }
}
