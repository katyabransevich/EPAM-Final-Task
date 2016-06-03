package by.epam.finaltask.facultative.command.impl;

import by.epam.finaltask.facultative.command.Command;
import by.epam.finaltask.facultative.command.exception.CommandException;
import by.epam.finaltask.facultative.controller.PageName;
import by.epam.finaltask.facultative.entity.CourseDescription;
import by.epam.finaltask.facultative.entity.User;
import by.epam.finaltask.facultative.service.SubjectService;
import by.epam.finaltask.facultative.service.AuthorizationUserService;
import by.epam.finaltask.facultative.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Admin on 19.04.2016.
 */
public class AuthorizationCommand implements Command {

    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String SUBJECT = "subject";
    private static final String USER = "user";
    private static final String SUBJECT_STUDENT = "subjectStudent";
    private static final String UPDATE_STUDENT = "updateStudent";

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String page=PageName.ERROR_PAGE; ;
        try {

            User user = AuthorizationUserService.checkLogin(request.getParameter(LOGIN), request.getParameter(PASSWORD));
            request.getSession().setAttribute(USER, user);
            request.setAttribute(USER, user);
            request.setAttribute(UPDATE_STUDENT,false);

            if (user != null){
                if(user.getType().equals("student")){
                    request.setAttribute(SUBJECT, SubjectService.getOtherSubjectForStudent(user));
                    request.setAttribute(SUBJECT_STUDENT, SubjectService.getSubjectForStudent(user));
                    page = PageName.STUDENT_PAGE;
                }else {

                    List<CourseDescription> sub= SubjectService.getSubjectForTeachar( user);
                    request.setAttribute(SUBJECT, sub);

                    page = PageName.TEACHER_PAGE;
                }
            }else{
                page = PageName.ERROR_PAGE;
            }
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return page;
    }

}
