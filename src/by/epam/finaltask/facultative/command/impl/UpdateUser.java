package by.epam.finaltask.facultative.command.impl;

import by.epam.finaltask.facultative.command.Command;
import by.epam.finaltask.facultative.command.exception.CommandException;
import by.epam.finaltask.facultative.controller.PageName;
import by.epam.finaltask.facultative.entity.User;

import javax.servlet.http.HttpServletRequest;


public class UpdateUser implements Command {


    private static final String USER = "user";
    private static final String UPDATE_STUDENT = "updateStudent";


    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        User user=(User)request.getSession().getAttribute(USER);

        request.setAttribute(USER, user);

        return  PageName.CORRECT_PROFILE_USER_PAGE;
    }}