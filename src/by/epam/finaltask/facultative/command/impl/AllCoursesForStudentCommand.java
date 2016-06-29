package by.epam.finaltask.facultative.command.impl;

import by.epam.finaltask.facultative.command.Command;
import by.epam.finaltask.facultative.command.exception.CommandException;
import by.epam.finaltask.facultative.controller.PageName;
import by.epam.finaltask.facultative.entity.User;
import by.epam.finaltask.facultative.service.CourseService;
import by.epam.finaltask.facultative.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;


public class AllCoursesForStudentCommand implements Command {


    private static final String SUBJECT = "subject";
    private static final String USER = "user";



    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        User user = (User) request.getSession().getAttribute(USER);

        try {
            request.setAttribute(SUBJECT, CourseService.getOtherSubjectForStudent(user));
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return PageName.ALL_COURSES;
    }
}
