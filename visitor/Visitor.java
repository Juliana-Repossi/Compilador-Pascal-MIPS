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

    public StrTable getStrTable() {
        return this.strTable;
    }

    public IdTable getIdTable() {
        return this.idTable;
    }

    @Override 
    public Void visitString_val(PascalParser.String_valContext ctx) { 
        strTable.add(ctx.getText());
        currentType = Type.STRING;
        return null;    
    }
/*
    private Void addId (String s, int line, Type type){

        if(idTable.lookupVar(s)==-1)
        {
            idTable.addVar(s,line,type);
            return null;
        }
        System.out.println("Variável já foi declarada" + s);
        return null;
    }

    @Override
    public Void visitConst_section(PascalParser.Const_sectionContext ctx) {
        
        for(int i = 0 ; i < ctx.ID().size(); i ++){

            visit(ctx.val(i));
            addId(ctx.ID(i).getText(),ctx.getStart(i).getLine(),currentType);          

        }
        

        return null;
    }

    @Override 
    public Void visitInt_val(PascalParser.Int_valContext ctx) {
        currentType = Type.INTEGER;
        return null;
    }


	@Override
    public Void visitReal_val(PascalParser.Real_valContext ctx) { 
        currentType = Type.REAL;
        return null;
    }
	

	@Override 
    public Void visitBoolean_val(PascalParser.Boolean_valContext ctx) {
        currentType = Type.BOOLEAN;
        return null;    
    }
*/
}
