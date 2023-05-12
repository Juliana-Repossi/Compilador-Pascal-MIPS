package visitor;

import parser.PascalParserBaseVisitor;
import parser.PascalParser;
import tables.StrTable;
import tables.IdTable;

import types.Type;

public class Visitor extends PascalParserBaseVisitor<Void>
{
    private StrTable strTable = new StrTable();
    private IdTable idTable = new IdTable();

    private Type currentType;
    private int currentLine;
    private IdTable currentTable = idTable;

    public StrTable getStrTable() {
        return this.strTable;
    }

    public IdTable getIdTable() {
        return this.idTable;
    }

    private Void addIdTable (String s, int line, Type type, Boolean ehConst){

        if(idTable.lookupVar(s)==-1)
        {
            currentTable.addId(s,line,type,ehConst);
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
        strTable.add(ctx.getText());
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

        for(int i = 0 ; i < ctx.ID().size(); i ++){
            visit(ctx.type());
            addIdTable(ctx.ID(i).getText(),currentLine,currentType,false);          
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
        currentType = Type.REAL;
        currentLine = ctx.getStart().getLine();
        return null;
    }
    
        /*
    ** Verifica se um dado Id já foi declarado
    ** Caso não exista na tabela de Id encerra o programa
    */
    private void checkId(String s){
        if(currentTable.lookupVar(s) == -1)
        {
            System.out.println("O Id \'"+ s + "\' não foi declarado previamente");
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
        return null;
    }

    @Override 
    public Void visitAcess_array(PascalParser.Acess_arrayContext ctx) {

        checkId(ctx.ID().getText());

        visit(ctx.expr());
        
        return null;
    }

    @Override
    public Void visitExpr_id(PascalParser.Expr_idContext ctx) {

        checkId(ctx.ID().getText());
                
        return null; 
    }




}
