package types;

// Enumeração dos tipos primitivos que podem existir em MIPS.
public enum TypeData {
	WORD,
    FLOAT,
    ASCIIZ,
	SPACE;

	public String toString() {
		switch(this) {
			case WORD:	return ".word";
			case FLOAT:      return ".float";
			case ASCIIZ:   return ".asciiz";
			case SPACE:   return ".space";
			default:
				System.err.println("ERROR: Tipo inválido de Data!");
				System.exit(1);
		}
		return "";
	}
}