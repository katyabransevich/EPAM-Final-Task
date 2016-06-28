package by.epam.finaltask.facultative.command.impl;

import by.epam.finaltask.facultative.command.Command;
import by.epam.finaltask.facultative.command.exception.CommandException;
import by.epam.finaltask.facultative.controller.PageName;
import by.epam.finaltask.facultative.entity.CourseDescription;
import by.epam.finaltask.facultative.entity.CourseStatistic;
import by.epam.finaltask.facultative.entity.User;
import by.epam.finaltask.facultative.service.GroupStudentService;
import by.epam.finaltask.facultative.service.UpdateContextService;
import by.epam.finaltask.facultative.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


public class UpdateMarkCommentCommand implements Command{
    private static final String ID_SUBJECT = "idSubject";
    private static final String ID_STUDENT = "idStudent";
    private static final String  UPDATE = "update";
    private static final String  MARK = "mark";
    private static final String  COMMENT = "comment";

    private static final String  GROUP_STUDENTS= "groupStudents";
    private static final String  COURSE_NAME= "courseName";
    private static final String  COURSE= "course";

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String page;
        try {
            User user =null;
            String command=request.getParameter(UPDATE);
            int idStudent=Integer.parseInt(request.getParameter(ID_STUDENT));
            int idSubject=Integer.parseInt(request.getParameter(ID_SUBJECT));
            if(command.equals("mark")){
                System.out.println("mark");
                UpdateContextService.checkMarkField(request.getParameter(MARK),idStudent,idSubject);
            }else{
                UpdateContextService.checkCommentField(request.getParameter(COMMENT),idStudent,idSubject);

            }

            CourseDescription course=new CourseDescription();
            course.setId(Integer.parseInt(request.getParameter(ID_SUBJECT)));
            course.setCourseName(request.getParameter(COURSE_NAME));
            List<CourseStatistic> studentGroup= GroupStudentService.getAllSubject(course);
            request.setAttribute(GROUP_STUDENTS, studentGroup);
            request.setAttribute(COURSE, course);
            page = PageName.STUDENT_GROUP_PAGE;


        } catch (ServiceException e) {
            throw new CommandException(e);
        }

        return page;
    }
}
