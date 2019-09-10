package exception;

public class FlagNotDefinedException extends RuntimeException {
    public FlagNotDefinedException(String flag) {
        super("Flag '" + flag + "' not supported.");
    }
}
