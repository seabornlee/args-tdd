package exception;

public class SchemaCanNotBeBlankException extends RuntimeException {
    public SchemaCanNotBeBlankException() {
        super("Schema can not be blank.");
    }
}
