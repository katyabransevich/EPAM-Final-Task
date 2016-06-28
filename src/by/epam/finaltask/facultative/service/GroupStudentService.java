package by.epam.finaltask.facultative.service;

import by.epam.finaltask.facultative.dao.DAOFactory;
import by.epam.finaltask.facultative.dao.GroupStudentDAO;
import by.epam.finaltask.facultative.dao.exception.DAOException;
import by.epam.finaltask.facultative.entity.CourseDescription;
import by.epam.finaltask.facultative.entity.CourseStatistic;
import by.epam.finaltask.facultative.service.exception.ServiceException;

import java.util.List;


public class GroupStudentService {
    public final static List<CourseStatistic> getAllSubject( CourseDescription course) throws ServiceException {

        GroupStudentDAO groupStudent = DAOFactory.getGroupStudentDAO();
        try {

            return groupStudent.getGroupOfStudentForCurrentSubject(course);

        } catch (DAOException e) {
            throw new ServiceException("Error access database",e);
        }

    }
}
