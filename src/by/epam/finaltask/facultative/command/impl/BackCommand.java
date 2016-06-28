package by.epam.finaltask.facultative.command.impl;

import by.epam.finaltask.facultative.command.Command;
import by.epam.finaltask.facultative.command.exception.CommandException;
import by.epam.finaltask.facultative.controller.PageName;
import by.epam.finaltask.facultative.entity.User;


import javax.servlet.http.HttpServletRequest;


public class BackCommand implements Command {
    private static final String BACK = "back";


    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String page = (String) request.getSession().getAttribute(BACK);
        return page;
    }
}