package types;

// Enumeração dos tipos primitivos que podem existir em Pascal.
public enum Type {
	INTEGER,
    REAL,
    BOOLEAN,
    STRING,
    ARRAY_INTEGER,
    ARRAY_REAL,
    ARRAY_BOOLEAN,
	NO_TYPE;

	public String toString() {
		switch(this) {
			case INTEGER:	return "integer";
			case REAL:      return "real";
			case BOOLEAN:   return "boolean";
			case STRING: 	return "string";
			case ARRAY_INTEGER: return "array of integer";
			case ARRAY_REAL: return "array of real";
			case ARRAY_BOOLEAN: return "array of boolean";
			case NO_TYPE: return "no type";
			default:
				System.err.println("ERROR: Fall through in Type enumeration!");
				System.exit(1);
				return ""; // Never reached.
		}
	}
}