package by.epam.finaltask.facultative.command.impl;

import by.epam.finaltask.facultative.command.Command;
import by.epam.finaltask.facultative.command.exception.CommandException;
import by.epam.finaltask.facultative.controller.PageName;
import by.epam.finaltask.facultative.entity.User;
import by.epam.finaltask.facultative.service.CourseService;
import by.epam.finaltask.facultative.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;

public class CoursesForStudentCommand implements Command {


    private static final String SUBJECT = "subject";
    private static final String USER = "user";
    private static final String DELETE_APPLY = "deleteApply";
    private static final String BACK = "back";
    private static final String URL = "url";


    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        User user = (User) request.getSession().getAttribute(USER);
        request.getSession(true).setAttribute(BACK, PageName.STUDENT_PAGE);

        try {
            request.setAttribute(SUBJECT, CourseService.getSubjectForStudent(user));
            request.setAttribute(DELETE_APPLY,1);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }

        return null;
    }
}
