package by.epam.finaltask.facultative.command.impl;

import by.epam.finaltask.facultative.command.Command;
import by.epam.finaltask.facultative.command.exception.CommandException;
import by.epam.finaltask.facultative.controller.PageName;
import by.epam.finaltask.facultative.entity.User;
import by.epam.finaltask.facultative.service.OperationWithCourseService;
import by.epam.finaltask.facultative.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;

/**
 * AddCourseCommand, teacher may add course
 */
public class AddCourseCommand implements Command {


    private static final String USER = "user";
    private static final String NAME_COURSE = "nameCourse";
    private static final String DAY_TIME = "dayTime";
    private static final String NUMBER_OF_STUDENT = "numberOfStudent";
    private static final String START_COURSE = "startCourse";
    private static final String END_COURSE = "endCourse";
    private static final String DESCRIPTION = "description";

    /**
     * @param request
     * @return PageName.TEACHER_PAGE
     */
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String page = PageName.ERROR_PAGE;
       User user= (User)request.getSession().getAttribute(USER);
        try {

            OperationWithCourseService.addCourseForTeacher(request.getParameter(NAME_COURSE), user,request.getParameter(DAY_TIME),Integer.parseInt(request.getParameter(NUMBER_OF_STUDENT)),request.getParameter(START_COURSE),request.getParameter(END_COURSE),request.getParameter(DESCRIPTION));
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return PageName.TEACHER_PAGE;
    }

}
