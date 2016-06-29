package by.epam.finaltask.facultative.command.impl;

import by.epam.finaltask.facultative.command.Command;
import by.epam.finaltask.facultative.command.exception.CommandException;
import by.epam.finaltask.facultative.controller.PageName;
import by.epam.finaltask.facultative.entity.User;
import by.epam.finaltask.facultative.resourses.Message;
import by.epam.finaltask.facultative.service.UserService;
import by.epam.finaltask.facultative.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;


public class RegistrationTeacherCommand implements Command {

    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String MESSAGE = "message";
    private static final String TEACHER = "teacher";


    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String page=null;
        try {
            User user = UserService.checkRegistrationField(request.getParameter(LOGIN), request.getParameter(PASSWORD),TEACHER);
            if (user!=null){

                request.setAttribute(MESSAGE, "Преподаватель зарегистрирован");
            }else{
                request.setAttribute(MESSAGE, Message.getInstanse().getMessage());

            }
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        page = PageName.ADMIN_PAGE;

        return page;
    }

}
