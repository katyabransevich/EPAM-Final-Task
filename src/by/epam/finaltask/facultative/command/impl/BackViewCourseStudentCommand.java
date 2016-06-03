package by.epam.finaltask.facultative.command.impl;

import by.epam.finaltask.facultative.command.Command;
import by.epam.finaltask.facultative.command.exception.CommandException;
import by.epam.finaltask.facultative.controller.PageName;
import by.epam.finaltask.facultative.entity.User;
import by.epam.finaltask.facultative.service.SubjectService;
import by.epam.finaltask.facultative.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;


public class BackViewCourseStudentCommand implements Command {

    private static final String SUBJECT = "subject";
    private static final String USER = "user";
    private static final String SUBJECT_STUDENT = "subjectStudent";

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String page ;
        try {
            User user = (User) request.getSession().getAttribute(USER);
            System.out.println(user.getId());
            request.setAttribute(SUBJECT, SubjectService.getOtherSubjectForStudent(user));
            System.out.println(user.getId());
            request.setAttribute(SUBJECT_STUDENT, SubjectService.getSubjectForStudent(user));
            System.out.println(user.getId());
            page = PageName.STUDENT_PAGE;
            System.out.println(user.getId());
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return page;
    }
}