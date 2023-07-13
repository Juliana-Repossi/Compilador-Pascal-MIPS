package code;

/*
 * Enumeração das instruções aceitas pela TM (Tiny Machine).
 * Adaptado do arquivo 'instruction.h'.
 */
public enum OpCode {
	// ---------------------------------------------------
	// Basic ops ****
    HALT("syscall", 1),
    NOOP("NOOP", 0),

    // ---------------------------------------------------

    // ---------------------------------------------------
	// Operações de declaração de data ****

    //Para imprimir um .data no arq
    DATA("DATA",0),
    //int e boolean - word
    DATAw("DATAw",1),
    //float - float
    DATAf("DATAf",1),
    //ascii - valor da string - nome da string
    DATAa("DATAa",2),
    //vetor - passar o space já calculado
    DATAv("DATAv",1),

    //com constantes
    //int e boolean - word
    DATAcw("DATAcw",2),
    //float - float
    DATAcf("DATAcf",2),



    // ---------------------------------------------------
    // Arith ops ******

    ADDi("add", 3),	// ADDi ix, iy, iz	; ix <- iy + iz *
    ADDiu("addiu", 3),    
    ADDf("add.s", 3),	// ADDf fx, fy, fz	; fx <- fy + fz *
    SUBi("sub", 3),	// SUBi ix, iy, iz	; ix <- iy - iz *
    SUBf("sub.s", 3),	// SUBf fx, fy, fz	; fx <- fy - fz *
    MULi("mul", 3),	// MULi ix, iy, iz	; ix <- iy * iz *
    MULf("mul.s", 3),	// MULf fx, fy, fz	; fx <- fy * fz *
    DIVi("div", 3),	// DIVi ix, iy, iz	; ix <- iy / iz *
    DIVf("div.s", 3),	// DIVf fx, fy, fz	; fx <- fy / fz *


    // Widen to float ***
    WIDf("cvt.s.w", 2),	// WIDf fx, iy		; fx <- (float) iy *

    // ---------------------------------------------------
    // Logic ops

    // Logical OR
    OROR("or", 3), 	// OROR ix, iy, iz	; ix <- (bool) iy || (bool) iz
    // Equality
    EQUi("EQUi", 3), 	// EQUi ix, iy, iz	; ix <- iy == iz ? 1 : 0
    EQUf("c.eq.s", 3),	// EQUf ix, fy, fz	; ix <- fy == fz ? 1 : 0
    EQUs("EQUs", 3), 	// EQUs ix, iy, iz	; ix <- str_tab[iy] == str_tab[iz] ? 1 : 0
    // Less than
    LTHi("LTHi", 3), 	// LTHi ix, iy, iz	; ix <- iy < iz ? 1 : 0
    LTHf("LTHf", 3), 	// LTHi ix, fy, fz	; ix <- iy < iz ? 1 : 0
    LTHs("LTHs", 3), 	// LTHs ix, iy, iz	; ix <- str_tab[iy] < str_tab[iz] ? 1 : 0
    
    SLT("slt", 3),  //** */
    SGT("sgt", 3),
    CLTS("c.lt.s", 2),  //** */
    AND("and", 3), // AND ix, iy, iz ; ix <- iy && iz BITWISE **
    OR("or", 3), // OR ix, iy, iz ; ix <- iy || iz BITWISE **
    NOR("nor", 3), // OR ix, iy, iz ; ix <- iy nor iz  ** It can be used to make NOT, just put zero on iz
    // ---------------------------------------------------
    // Branches and jumps

    // Absolute jump
    JUMP("JUMP", 1),	// JUMP addr		; PC <- addr
    J("J", 1),
    // Branch on true
    BOTb("beq", 3), 	// BOTb ix, off		; PC <- PC + off, if ix == 1
    // Branch on false
    BOFb("BOFb", 2),	// BOFb ix, off		; PC <- PC + off, if ix == 0

    BEQZ("beqz", 2),
    BGTZ("bgtz", 2),
    BLTZ("bltz", 2),

    // ---------------------------------------------------
    // Loads and stores *****

    // Load word (from address)
    LDWi("lw", 2), 	// LDWi ix, addr	; ix <- data_mem[addr] *
    LDWf("l.s", 2), 	// LDWf fx, addr	; fx <- data_mem[addr] *

    // Load immediate (constant) 
    LDIi("li", 2), 	// LDIi ix, int_const	; ix <- int_const *
    LDIf("li.s", 2),  	// LDIf fx, float_const	; fx <- float_const (must be inside an int) *

    // Store word (to address) 
    STWi("sw", 2),  	// STWi addr, ix		; data_mem[addr] <- ix *
    STWf("s.s", 2),  	// STWf addr, fx		; data_mem[addr] <- fx *

    //Load addr (to name data)
    LA("la", 2),              //LAA register nameData  -  addr_nameData <- nameData;
    LB("lb", 2),

    MOVf("mov.s", 2),
    BC1t("bc1t", 1),
    BC1f("bc1f", 1),


    // ---------------------------------------------------
    // Coprocessador 1
    MCP("mtc1",2),        //# Move o valor inteiro de $t0->$f0    

    //-----------------------------------------------------------------------


    // ---------------------------------------------------
    // Array

    
    //-----------------------------------------------------------------------

    // ---------------------------------------------------
    // Strings

    // (These strings instructions ar  // la $R0, string1 
    // la $R1, string2  iz	; str_tab[ix] <- str_tab[iy] + str_tab[iz]
    // Bool to String

    //-----------------------------------------------------------------------

    //store 
    // sw $R0, offset($R1) //offset eh opcional, valor contido em $R0 eh armazendado em $R1 + o offset
    // //load
    // la $R0, string  //load the adress os string in register R0
    LOAD("la", 2),
    STORE("sw", 2),

    //Concat ---eh uma função
    // la $R0, string1 
    // la $R1, string2 
    
    


    // ---------------------------------------------------
    // System calls, for I/O (see below)

    CALL("syscall", 0), // CALL code, x
    MFHi("mfhi", 1);   //
    //ALL instruction. 
    // Step 4. Retrieve return values, if any, from result registers as specified.
	// ----------------------------------------------------------------------------
	// Service number
	// ----------- -----------------------------------------------------------
	//  1   Print integer
	//  2   Print Float
	//  4   Print String
	//  5   read integer
	//  6   read float
    //  8   read string
	// ----------------------------------------------------------------------------
	// OBS.: All strings in memory are null ('\0') terminated, like in C.
	// ----------------------------------------------------------------------------


    public final String name;
	public final int opCount;

	private OpCode(String name, int opCount) {
		this.name = name;
		this.opCount = opCount;
	}

	public String toString() {
		return this.name;
	}

}