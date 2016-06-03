package by.epam.finaltask.facultative.command.impl;

import by.epam.finaltask.facultative.command.Command;
import by.epam.finaltask.facultative.command.exception.CommandException;
import by.epam.finaltask.facultative.controller.PageName;
import by.epam.finaltask.facultative.entity.CourseDescription;
import by.epam.finaltask.facultative.service.SubjectService;
import by.epam.finaltask.facultative.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;

public class ViewCourseCommand implements Command {
    private static final String COURSE = "course";

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String page;
        try {
            System.out.println("command course");
         //   CourseDescription courseDescription=(CourseDescription)request.getAttribute(COURSE);

            CourseDescription course = SubjectService.getDescriptionStudent(Integer.parseInt(request.getParameter(COURSE)));
            System.out.println(course.getId());
                request.setAttribute(COURSE, course);
                page = PageName.VIEW_COURSE_PAGE;
            System.out.println("end course");
        } catch (ServiceException e) {
            throw new CommandException(e);
        }

        return page;
    }
}
