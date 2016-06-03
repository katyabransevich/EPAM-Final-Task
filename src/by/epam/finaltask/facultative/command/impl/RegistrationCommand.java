package by.epam.finaltask.facultative.command.impl;

import by.epam.finaltask.facultative.command.Command;
import by.epam.finaltask.facultative.command.exception.CommandException;
import by.epam.finaltask.facultative.controller.PageName;
import by.epam.finaltask.facultative.entity.User;
import by.epam.finaltask.facultative.service.SaveUserService;
import by.epam.finaltask.facultative.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Admin on 26.05.2016.
 */
public class RegistrationCommand implements Command {

    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String USER = "user";


    @Override
    public String execute(HttpServletRequest request) throws CommandException {
       String page=null;
      /*  try {
            User user = SaveUserService.checkRegistrationField(request.getParameter(NAME),request.getParameter(SURNAME),
                    request.getParameter(LOGIN), request.getParameter(PASSWORD));
            if (user!=null){
                request.setAttribute(USER, user);

                page = PageName.STUDENT_PAGE;
            }else{
                page = PageName.ERROR_PAGE;
            }
        } catch (ServiceException e) {
            throw new CommandException(e);
        }*/

        return page;
    }

}
