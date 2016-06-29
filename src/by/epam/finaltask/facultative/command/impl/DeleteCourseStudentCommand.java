package by.epam.finaltask.facultative.command.impl;

import by.epam.finaltask.facultative.command.Command;
import by.epam.finaltask.facultative.command.exception.CommandException;
import by.epam.finaltask.facultative.controller.PageName;
import by.epam.finaltask.facultative.entity.User;
import by.epam.finaltask.facultative.service.OperationWithCourseService;
import by.epam.finaltask.facultative.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;


public class DeleteCourseStudentCommand implements Command {


    private static final String ID_COURSE= "course";
    private static final String USER = "user";


    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        User user = (User) request.getSession().getAttribute(USER);
        int idSubject=Integer.parseInt(request.getParameter(ID_COURSE));

        try {
           OperationWithCourseService.deleteCourseForStudent(user.getId(),idSubject);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }

        return PageName.STUDENT_PAGE;
    }
}
