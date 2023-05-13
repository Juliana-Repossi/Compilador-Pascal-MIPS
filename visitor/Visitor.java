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

import types.Type;

public class Visitor extends PascalParserBaseVisitor<Void>
{
    private StrTable strTable = new StrTable();
    private IdTable idTable = new IdTable();
    private ArrayTable arrayTable = new ArrayTable();

    private Type currentType;
    private int currentLine;
    private int currentSize;

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

    public StrTable getCurrentStrTable() {
        return this.currentStrTable;
    }

    public IdTable getCurrentIdTable() {
        return this.currentIdTable;
    }

    public ArrayTable getCurrentArrayTable() {
        return this.currentArrayTable;
    }

    

    private Void addIdTable (String s, int line, Type type, Boolean ehConst){

        if(currentIdTable.lookupVar(s)==-1 && currentArrayTable.lookupArray(s)==-1)
        {
            currentIdTable.addId(s,line,type,ehConst);
            return null;
        }
        System.out.println("O Id \'" + s + "\' já foi declarado" );
        System.exit(3);
        return null;
    }

    private Void addArrayTable (String s, int line, Type type, int size){

        if(currentIdTable.lookupVar(s)==-1 && currentArrayTable.lookupArray(s)==-1)
        {
            currentArrayTable.addArray(s,line,type,size);
            return null;
        }
        System.out.println("O Id \'" + s + "\' já foi declarado" );
        System.exit(3);
        return null;
    }

    @Override
    public Void visitConst_section(PascalParser.Const_sectionContext ctx) {
        
        for(int i = 0 ; i < ctx.ID().size(); i ++){
            visit(ctx.val_simple(i));
            addIdTable(ctx.ID(i).getText(),currentLine,currentType,true);          
        }
        return null;
    }

    @Override 
    public Void visitInt_val(PascalParser.Int_valContext ctx) {
        currentType = Type.INTEGER;
        currentLine = ctx.getStart().getLine();
        return null;
    }

	@Override
    public Void visitReal_val(PascalParser.Real_valContext ctx) { 
        currentType = Type.REAL;
        currentLine = ctx.getStart().getLine();
        return null;
    }
	
     @Override 
    public Void visitString_val(PascalParser.String_valContext ctx) { 
        currentStrTable.add(ctx.getText());
        currentType = Type.STRING;
        currentLine = ctx.getStart().getLine();
        return null;    
    }

	@Override 
    public Void visitBoolean_val(PascalParser.Boolean_valContext ctx) {
        currentType = Type.BOOLEAN;
        currentLine = ctx.getStart().getLine();
        return null;    
    }

    @Override 
    public Void visitVar(PascalParser.VarContext ctx) {

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
            System.out.println("Erro inesperado!!!");
            System.exit(5);
        }
        return null; 
    }

    @Override public Void visitType_simple_integer(PascalParser.Type_simple_integerContext ctx) { 
        currentType = Type.INTEGER;
        currentLine = ctx.getStart().getLine();
        return null;
    }
	
	@Override 
    public Void visitType_simple_real(PascalParser.Type_simple_realContext ctx) { 
        currentType = Type.REAL;
        currentLine = ctx.getStart().getLine();
        return null;
    }

	@Override 
    public Void visitType_simple_boolean(PascalParser.Type_simple_booleanContext ctx) {
        currentType = Type.BOOLEAN;
        currentLine = ctx.getStart().getLine();
        return null;
    }
	
	@Override 
    public Void visitType_simple_string(PascalParser.Type_simple_stringContext ctx) {
        currentType = Type.STRING;
        currentLine = ctx.getStart().getLine();
        return null;
    }
    
    /*
    ** Verifica se um dado Id já foi declarado
    ** Caso não exista na tabela de Id encerra o programa
    */
    private void checkId(String s){
        if(currentIdTable.lookupVar(s) == -1)
        {
            System.out.println("O Id \'"+ s + "\' não foi declarado previamente");
            System.exit(4);
        }
    }

    private void checkArray(String s){
        if(currentArrayTable.lookupArray(s) == -1)
        {
            System.out.println("O Id Array \'"+ s + "\' não foi declarado previamente");
            System.exit(4);
        }
    }

    @Override 
    public Void visitAtribution(PascalParser.AtributionContext ctx) {
        if(ctx.ID() != null)
        {
            checkId(ctx.ID().getText());
        }
        else if (ctx.acess_array() != null)
        {
            visit(ctx.acess_array());
        }
        else
        {
            System.out.println("Erro inesperado!!!");
            System.exit(5);
        }
        visit(ctx.expr());
        return null;
    }

    @Override 
    public Void visitAcess_array(PascalParser.Acess_arrayContext ctx) {

        checkArray(ctx.ID().getText());
        visit(ctx.expr());
        
        return null;
    }

    @Override
    public Void visitExpr_id(PascalParser.Expr_idContext ctx) {

        checkId(ctx.ID().getText());
                
        return null; 
    }

    @Override 
    public Void visitRead_io(PascalParser.Read_ioContext ctx) {
        if(ctx.ID() != null)
        {
            checkId(ctx.ID().getText());
        }
        else if (ctx.acess_array() != null)
        {
          visit(ctx.acess_array());
        }
        else
        {
            System.out.println("Erro inesperado!!!");
            System.exit(5);
        }
        return null;
    }


    private Void changeCurrentFunctionProcedure(StrTable strTable, IdTable idTable, ArrayTable arrayTable)
    {
        currentStrTable = strTable;
        currentIdTable = idTable;
        currentArrayTable = arrayTable;
        return null;
    }

    private Void restoreCurrentTable(){
        currentStrTable = strTable;
        currentIdTable = idTable;
        currentArrayTable = arrayTable;
        return null;
    }

    @Override 
    public Void visitProcedure(PascalParser.ProcedureContext ctx) {

        if(funcTable.lookupVar(ctx.ID().getText())==-1 && procTable.lookupVar(ctx.ID().getText())==-1)
        {
            int id = procTable.addProc(ctx.ID().getText(),ctx.getStart().getLine());

            //trocar as tabelas correntes
            changeCurrentFunctionProcedure(procTable.getStrTable(id),procTable.getIdTable(id),procTable.getArrayTable(id));
        }
        else
        {
            System.out.println("O Id " + ctx.ID().getText() + " já foi usado");
            System.exit(3);
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
    public Void visitParameter_list(PascalParser.Parameter_listContext ctx) {
        
        if(ctx.parameters() != null)
        {
            visit(ctx.parameters());
        }

        return null; 
    }

	@Override 
    public Void visitParameters(PascalParser.ParametersContext ctx) {

        visit(ctx.parameter(0));

        for(int i=1; i < ctx.parameter().size(); i++)
        {
            visit(ctx.parameter(i));
        }
        return null;
    }

    
	@Override public Void visitVar_parameter(PascalParser.Var_parameterContext ctx) {
       
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
            System.out.println("Erro inesperado!!!");
            System.exit(5);
       }
       
        return null; 
    }
	
	@Override public Void visitConstant(PascalParser.ConstantContext ctx) { 
        
        visit(ctx.type_simple());
        addIdTable (ctx.ID().getText(), currentLine, currentType,true);
        return null; 
    }

    @Override
    public Void visitFunction(PascalParser.FunctionContext ctx) {
        
        if(funcTable.lookupVar(ctx.ID().getText())==-1 && procTable.lookupVar(ctx.ID().getText())==-1)
        {
            visit(ctx.type_simple());
            int id = funcTable.addFunc(ctx.ID().getText(), currentType, ctx.getStart().getLine());

            //trocar as tabelas correntes
            changeCurrentFunctionProcedure(funcTable.getStrTable(id),funcTable.getIdTable(id),funcTable.getArrayTable(id));
        }
        else
        {
            System.out.println("O Id " + ctx.ID().getText() + " já foi usado");
            System.exit(3);
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
    public Void visitCall_function_procedure(PascalParser.Call_function_procedureContext ctx) {
        
        if(funcTable.lookupVar(ctx.ID().getText())==-1 && procTable.lookupVar(ctx.ID().getText())==-1)
        {
            System.out.println("A função " + ctx.ID().getText() + "não foi previamente declarada!");
            System.exit(4);
        }
        return null;
    }

	@Override
    public Void visitArray_type_range(PascalParser.Array_type_rangeContext ctx) {
        
        currentSize = Integer.parseInt(ctx.INT_VAL(1).getText()) - Integer.parseInt(ctx.INT_VAL(0).getText());
        
        if (currentSize < 1)
        {
            System.out.println("O tamanho do array é inválido");
            System.exit(6);
        }

        visit(ctx.type_simple());

        return null;
    }
}
