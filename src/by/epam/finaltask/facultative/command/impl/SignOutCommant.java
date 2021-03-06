package by.epam.finaltask.facultative.command.impl;

import by.epam.finaltask.facultative.command.Command;
import by.epam.finaltask.facultative.command.exception.CommandException;
import by.epam.finaltask.facultative.controller.PageName;

import javax.servlet.http.HttpServletRequest;


public class SignOutCommant implements Command {



    private static final String USER = "user";


    @Override
    public String execute(HttpServletRequest request) throws CommandException {

        request.getSession().removeAttribute(USER);
        return  PageName.INDEX_PAGE;
    }}