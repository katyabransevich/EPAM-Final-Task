package by.epam.finaltask.facultative.command.exception;

/**
 * Created by Admin on 19.04.2016.
 */
public class CommandException extends Exception{

    private static final long serialVersionUID = 1L;

    public CommandException(String message){
        super(message);
    }

    public CommandException(Exception e){
        super(e);
    }

    public CommandException(String message, Exception e){
        super(message, e);
    }

}

