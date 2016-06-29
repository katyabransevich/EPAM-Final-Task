package by.epam.finaltask.facultative.command.impl;

import by.epam.finaltask.facultative.command.Command;
import by.epam.finaltask.facultative.command.exception.CommandException;
import by.epam.finaltask.facultative.controller.PageName;
import by.epam.finaltask.facultative.entity.User;
import by.epam.finaltask.facultative.service.CourseService;
import by.epam.finaltask.facultative.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;


public class AllCoursesCommand implements Command {


    private static final String SUBJECT = "subject";
    private static final String BACK = "back";


    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        request.getSession(true).setAttribute(BACK, PageName.INDEX_PAGE);
        try {
            request.setAttribute(SUBJECT, CourseService.getAllSubject());
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return null;
    }
}
