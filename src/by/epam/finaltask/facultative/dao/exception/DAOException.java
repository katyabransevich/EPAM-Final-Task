package by.epam.finaltask.facultative.dao.exception;

/**
 * Created by Admin on 25.04.2016.
 */
public class DAOException extends Exception {
    private static final long serialVersionUID=1L;


    public DAOException(String message){
        super(message);
    }

    public DAOException(Exception e){
        super(e);
    }

    public DAOException(String message, Exception e){
        super(message, e);
    }
}
