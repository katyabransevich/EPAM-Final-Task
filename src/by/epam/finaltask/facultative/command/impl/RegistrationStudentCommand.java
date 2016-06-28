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
 * Created by Admin on 26.05.2016.
 */
public class RegistrationStudentCommand implements Command {

    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String USER = "user";
    private static final String UPDATE_STUDENT = "updateStudent";
    private static final String MESSAGE = "message";
    private static final String STUDENT = "student";


    @Override
    public String execute(HttpServletRequest request) throws CommandException {
       String page=null;
        try {
            User user = UserService.checkRegistrationField(request.getParameter(LOGIN), request.getParameter(PASSWORD),STUDENT);
            if (user!=null){
                request.getSession().setAttribute(USER, user);
                request.setAttribute(UPDATE_STUDENT,false);
                page = PageName.CORRECT_PROFILE_USER_PAGE;
            }else{
                request.setAttribute(MESSAGE, Message.getInstanse().getMessage());
                page = PageName.INDEX_PAGE;
            }
        } catch (ServiceException e) {
            throw new CommandException(e);
        }

        return page;
    }

}
