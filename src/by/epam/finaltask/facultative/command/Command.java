package by.epam.finaltask.facultative.command;

import by.epam.finaltask.facultative.command.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Admin on 19.04.2016.
 */
public interface Command {
    String execute(HttpServletRequest request) throws CommandException;
}
