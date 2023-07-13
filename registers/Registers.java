package registers;

import java.io.*;
import java.util.*;

public class Registers{

	Hashtable<TypeRegister, Register> hashRegister = new Hashtable<>();


	public Registers(){

		// $v0-$v1 ($2-$3): Registradores para valores de retorno de funções.
		hashRegister.put(TypeRegister.v,new Register(2,3,TypeRegister.v));

		// $a0-$a3 ($4-$7): Registradores para argumentos.
		hashRegister.put(TypeRegister.a, new Register(4,7,TypeRegister.a));

		// $t0-$t9 ($8-$17): Registradores temporários.
		hashRegister.put(TypeRegister.t,new Register(8,17,TypeRegister.t));

		// $s0-$s7 ($18-$25): Registradores salvos.
		hashRegister.put(TypeRegister.s,new Register(18,25,TypeRegister.s));

		// $sp ($29): Ponteiro de pilha (stack pointer).
		hashRegister.put(TypeRegister.sp,new Register(29,29,TypeRegister.sp));

		// $ra ($31): Endereço de retorno.
		hashRegister.put(TypeRegister.ra,new Register(31,31,TypeRegister.ra));

		//$f0-$f31: Registradores de ponto flutuante de precisão simples (floats) e precisão dupla (doubles).
		hashRegister.put(TypeRegister.f,new Register(32,63,TypeRegister.f));
	}


	public int alocTypeRegister(TypeRegister type){

		Register register = hashRegister.get(type);
		return register.alocRegister();
	}

	public void freeTypeRegister(TypeRegister type){
		Register register = hashRegister.get(type);
		register.freeRegister();
	}
	
	
	// public String toString();


    
	
}
