package by.epam.finaltask.facultative.command.impl;

import by.epam.finaltask.facultative.command.Command;
import by.epam.finaltask.facultative.command.exception.CommandException;
import by.epam.finaltask.facultative.controller.PageName;
import by.epam.finaltask.facultative.entity.CourseDescription;
import by.epam.finaltask.facultative.entity.CourseStatistic;
import by.epam.finaltask.facultative.entity.User;
import by.epam.finaltask.facultative.service.GroupStudentService;
import by.epam.finaltask.facultative.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


public class GroupStudentCommand implements Command{


    private static final String ID_COURSE = "idCourse";
    private static final String  GROUP_STUDENTS= "groupStudents";
    private static final String  COURSE_NAME= "courseName";
    private static final String  COURSE= "course";

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String page;
        try {
            CourseDescription course=new CourseDescription();
            course.setId(Integer.parseInt(request.getParameter(ID_COURSE)));
            course.setCourseName(request.getParameter(COURSE_NAME));
            List<CourseStatistic> studentGroup=GroupStudentService.getAllSubject(course);
                request.setAttribute(GROUP_STUDENTS, studentGroup);
                request.setAttribute(COURSE, course);
                page = PageName.STUDENT_GROUP_PAGE;
            return page;
        } catch (ServiceException e) {
            throw new CommandException(e);
        }

    }
}
