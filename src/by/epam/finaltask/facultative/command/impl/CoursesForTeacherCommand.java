package by.epam.finaltask.facultative.command.impl;

import by.epam.finaltask.facultative.command.Command;
import by.epam.finaltask.facultative.command.exception.CommandException;
import by.epam.finaltask.facultative.controller.PageName;
import by.epam.finaltask.facultative.entity.User;
import by.epam.finaltask.facultative.service.CourseService;
import by.epam.finaltask.facultative.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Admin on 05.06.2016.
 */
public class CoursesForTeacherCommand implements Command {


    private static final String SUBJECT = "subject";
    private static final String USER = "user";
    private static final String BACK = "back";


    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        User user = (User) request.getSession().getAttribute(USER);
        request.getSession(true).setAttribute(BACK, PageName.TEACHER_PAGE);

        try {
            request.setAttribute(SUBJECT, CourseService.getSubjectForTeachar( user));
        } catch (ServiceException e) {
            throw new CommandException(e);
        }

        return null;
    }
}
