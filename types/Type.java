package types;

// Enumeração dos tipos primitivos que podem existir em EZLang.
public enum Type {
	INTEGER,
    REAL,
    BOOLEAN,
    STRING,
    CHAR,
    ARRAY;


	public String toString() {
		switch(this) {
			case INTEGER:	return "int";
			case REAL:      return "real";
			case BOOLEAN:   return "bool";
			case STRING: 	return "string";
            case CHAR:      return "char";
            case ARRAY:     return "array";
			default:
				System.err.println("ERROR: Fall through in Type enumeration!");
				System.exit(1);
				return ""; // Never reached.
		}
	}
}