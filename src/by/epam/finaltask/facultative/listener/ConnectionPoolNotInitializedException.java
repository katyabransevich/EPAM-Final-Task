package by.epam.finaltask.facultative.listener;

/**
 * Created by Admin on 13.06.2016.
 */
public class ConnectionPoolNotInitializedException extends RuntimeException {
    public ConnectionPoolNotInitializedException() {
        super();
    }

    public ConnectionPoolNotInitializedException(String message) {
        super(message);
    }

    public ConnectionPoolNotInitializedException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConnectionPoolNotInitializedException(Throwable cause) {
        super(cause);
    }
}