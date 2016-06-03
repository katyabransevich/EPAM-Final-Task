package by.epam.finaltask.facultative.command.impl;

import by.epam.finaltask.facultative.command.Command;
import by.epam.finaltask.facultative.command.exception.CommandException;
import by.epam.finaltask.facultative.controller.PageName;
import by.epam.finaltask.facultative.entity.User;
import by.epam.finaltask.facultative.service.ApplyService;
import by.epam.finaltask.facultative.service.SubjectService;
import by.epam.finaltask.facultative.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;


public class ApplyCommand  implements Command {


    private static final String ID_SUBJECT = "course";
    private static final String SUBJECT = "subject";
    private static final String USER = "user";
    private static final String SUBJECT_STUDENT = "subjectStudent";

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String page;
        try {
           User user =(User)request.getSession().getAttribute(USER);
            int idStudent=user.getId();
            int idSubject=Integer.parseInt(request.getParameter(ID_SUBJECT));
            System.out.println(idStudent+"------------"+idSubject);
            if (ApplyService.apply(idStudent,idSubject)) {
                request.setAttribute(SUBJECT, SubjectService.getOtherSubjectForStudent(user));
                request.setAttribute(SUBJECT_STUDENT, SubjectService.getSubjectForStudent(user));
                page = PageName.STUDENT_PAGE;
            } else {
                page = PageName.ERROR_PAGE;
            }
        } catch (ServiceException e) {
            throw new CommandException(e);
    }

        return page;
    }
}