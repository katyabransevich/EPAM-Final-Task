package by.epam.finaltask.facultative.dao.exception;

/**
 * Created by Admin on 08.04.2016.
 */
public class ConnectionPoolException extends Exception {
    private static final long serialVersionUID=1L;

    public  ConnectionPoolException(String message, Exception e){
        super(message,e);
    }

}
