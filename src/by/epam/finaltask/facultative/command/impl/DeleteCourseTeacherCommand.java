package by.epam.finaltask.facultative.command.impl;

import by.epam.finaltask.facultative.command.Command;
import by.epam.finaltask.facultative.command.exception.CommandException;
import by.epam.finaltask.facultative.controller.PageName;
import by.epam.finaltask.facultative.service.OperationWithCourseService;
import by.epam.finaltask.facultative.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;

public class DeleteCourseTeacherCommand implements Command {


    private static final String ID_COURSE= "idCourse";


    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        int idSubject=Integer.parseInt(request.getParameter(ID_COURSE));

        try {
           OperationWithCourseService.deleteCourseForTeacher(idSubject);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }

        return PageName.TEACHER_PAGE;
    }}
