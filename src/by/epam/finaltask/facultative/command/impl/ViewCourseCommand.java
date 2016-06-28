package by.epam.finaltask.facultative.command.impl;

import by.epam.finaltask.facultative.command.Command;
import by.epam.finaltask.facultative.command.exception.CommandException;
import by.epam.finaltask.facultative.controller.PageName;
import by.epam.finaltask.facultative.entity.CourseDescription;
import by.epam.finaltask.facultative.service.CourseService;
import by.epam.finaltask.facultative.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;

public class ViewCourseCommand implements Command {
    private static final String COURSE = "course";

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String page;
        try {

            CourseDescription course = CourseService.getDescriptionStudent(Integer.parseInt(request.getParameter(COURSE)));
            request.setAttribute(COURSE, course);
            page = PageName.VIEW_COURSE_PAGE;
        } catch (ServiceException e) {
            throw new CommandException(e);
        }

        return page;
    }
}
