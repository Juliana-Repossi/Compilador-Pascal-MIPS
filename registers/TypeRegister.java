package registers;

// Enumeração dos tipos primitivos que podem existir em mips.
public enum TypeRegister {
	v,
    a,
    t,
    s,
    sp,
    ra,
    f;

    // $v0-$v1 ($2-$3): Registradores para valores de retorno de funções.

    // $a0-$a3 ($4-$7): Registradores para argumentos.

    // $t0-$t9 ($8-$17): Registradores temporários.

    // $s0-$s7 ($18-$25): Registradores salvos.

    // $sp ($29): Ponteiro de pilha (stack pointer).

    // $ra ($31): Endereço de retorno.

    //Unico com offset (começa em 32 - 63)
    //$f0-$f31: Registradores de ponto flutuante de precisão simples (floats) e precisão dupla (doubles).
	
}
