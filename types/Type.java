package types;

// Enumeração dos tipos primitivos que podem existir em EZLang.
public enum Type {
	INTEGER,
    REAL,
    BOOLEAN,
    STRING,
    ARRAY_INTEGER,
    ARRAY_REAL,
    ARRAY_BOOLEAN;

	public String toString() {
		switch(this) {
			case INTEGER:	return "integer";
			case REAL:      return "real";
			case BOOLEAN:   return "boolean";
			case STRING: 	return "string";
			default:
				System.err.println("ERROR: Fall through in Type enumeration!");
				System.exit(1);
				return ""; // Never reached.
		}
	}
}