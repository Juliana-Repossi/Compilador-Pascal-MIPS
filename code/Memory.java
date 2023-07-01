package code;

import java.util.Vector;

import tables.IdTable;

/*
 * Implementação de uma memória (vetor) de words,
 * com os métodos que facilitam acessar um valor
 * inteiro ou real.
 */
@SuppressWarnings("serial")
public class Memory extends Vector<Word> {

	// Cria a memória do tamanho das tabela de variáveis.
	// O índice na tabela é o "endereço" na memória.
	public Memory(int size) {
		for (int i = 0; i < size; i++) {
			this.add(Word.fromInt(0));
		}
	}
			
	// No mundo real esses métodos precisam de verificações de erros.
	
	public void storei(int addr, int value) {
		this.set(addr, Word.fromInt(value));
	}
	
	public int loadi(int addr) {
		return this.get(addr).toInt();
	}
	
	public void storef(int addr, float value) {
		this.set(addr, Word.fromFloat(value));
	}
	
	public float loadf(int addr) {
		return this.get(addr).toFloat();
	}

	public void imprime(){
		for(int i=0; i<13;i++){
			System.out.println(i + "-" + this.get(i).toInt());
			// System.out.println(this.get(i).toInt());
		}
	}
	
}
