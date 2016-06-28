package by.epam.finaltask.facultative.command.impl;

import by.epam.finaltask.facultative.command.Command;
import by.epam.finaltask.facultative.command.exception.CommandException;
import by.epam.finaltask.facultative.controller.PageName;
import by.epam.finaltask.facultative.entity.User;
import by.epam.finaltask.facultative.resourses.Message;
import by.epam.finaltask.facultative.service.UserService;
import by.epam.finaltask.facultative.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Admin on 19.04.2016.
 */
public class AuthorizationCommand implements Command {

    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String USER = "user";
    private static final String UPDATE_STUDENT = "updateStudent";
    private static final String MESSAGE = "message";

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String page=PageName.ERROR_PAGE;
        try {

            User user = UserService.checkLogin(request.getParameter(LOGIN), request.getParameter(PASSWORD));
            request.getSession().setAttribute(USER, user);
            request.setAttribute(USER, user);
            request.setAttribute(UPDATE_STUDENT,true);

            if (user != null){
                if(user.getType().equals("student")){
                    page = PageName.STUDENT_PAGE;
                }else if (user.getType().equals("teacher")){
                    page = PageName.TEACHER_PAGE;
                }else if (user.getType().equals("admin")){
                page = PageName.ADMIN_PAGE;
            }
            }else {
                request.setAttribute(MESSAGE, Message.getInstanse().getMessage());
                page = PageName.INDEX_PAGE;
            }
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return page;
    }

}
