package by.epam.finaltask.facultative.command.impl;

import by.epam.finaltask.facultative.command.Command;
import by.epam.finaltask.facultative.command.exception.CommandException;
import by.epam.finaltask.facultative.controller.PageName;
import by.epam.finaltask.facultative.entity.User;
import by.epam.finaltask.facultative.service.SubjectService;
import by.epam.finaltask.facultative.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;


public class UpdateStudent implements Command {


    private static final String SUBJECT = "subject";
    private static final String USER = "user";
    private static final String SUBJECT_STUDENT = "subjectStudent";
    private static final String UPDATE_STUDENT = "updateStudent";


    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        User user=(User)request.getSession().getAttribute(USER);

        request.setAttribute(USER, user);
        request.setAttribute(UPDATE_STUDENT,true);
        try {
            request.setAttribute(SUBJECT, SubjectService.getOtherSubjectForStudent(user));
            request.setAttribute(SUBJECT_STUDENT, SubjectService.getSubjectForStudent(user));
        } catch (ServiceException e) {
            throw  new CommandException(e);
        }

        return  PageName.STUDENT_PAGE;
    }}