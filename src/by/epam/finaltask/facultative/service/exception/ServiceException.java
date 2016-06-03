package by.epam.finaltask.facultative.service.exception;

/**
 * Created by Admin on 19.04.2016.
 */
public class ServiceException extends Exception {
    private static final long serialVersionUID = 1L;

    public ServiceException(String message){
        super(message);
    }

    public ServiceException(String message, Exception e){
        super(message, e);
    }

}

