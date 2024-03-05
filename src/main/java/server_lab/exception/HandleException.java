package server_lab.exception;

public class HandleException extends Exception {
    public HandleException(String message) {
        super(message);
    }

    public HandleException(String message, Throwable cause) {
        super(message, cause);
    }
}
