package by.epam.finaltask.facultative.command.impl;

import by.epam.finaltask.facultative.command.Command;
import by.epam.finaltask.facultative.command.exception.CommandException;
import by.epam.finaltask.facultative.controller.PageName;
import by.epam.finaltask.facultative.entity.User;
import by.epam.finaltask.facultative.service.CourseService;
import by.epam.finaltask.facultative.service.UserService;
import by.epam.finaltask.facultative.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;

public class SaveUser implements Command {


    private static final String SUBJECT = "subject";
    private static final String USER = "user";
    private static final String SUBJECT_STUDENT = "subjectStudent";
    private static final String UPDATE_STUDENT = "updateStudent";
    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String EMAIL = "email";
    private static final String SKYPE = "skype";
    private static final String PHONE = "phone";
    private static final String BACK = "back";



    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        User user = (User) request.getSession().getAttribute(USER);


        request.setAttribute(UPDATE_STUDENT, true);
        String user_page=(String) request.getSession().getAttribute(BACK);
        try {

            user = UserService.saveStudent(request.getParameter(NAME), request.getParameter(SURNAME),  request.getParameter(EMAIL), request.getParameter(SKYPE), request.getParameter(PHONE), user);
            request.setAttribute(USER, user);
            request.setAttribute(SUBJECT, CourseService.getOtherSubjectForStudent(user));
            request.setAttribute(SUBJECT_STUDENT, CourseService.getSubjectForStudent(user));
        } catch (ServiceException e) {
            throw new CommandException(e);
        }

        return user_page;
    }
}