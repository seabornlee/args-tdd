package exception;

public class TypeNotSupportedException extends RuntimeException {
    public TypeNotSupportedException(String type) {
        super("Type '" + type + "' not supported.");
    }
}
