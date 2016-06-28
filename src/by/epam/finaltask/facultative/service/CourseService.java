package by.epam.finaltask.facultative.service;

import by.epam.finaltask.facultative.dao.DAOFactory;
import by.epam.finaltask.facultative.dao.SubjectsForUserDAO;
import by.epam.finaltask.facultative.dao.exception.DAOException;
import by.epam.finaltask.facultative.entity.CourseDescription;
import by.epam.finaltask.facultative.entity.User;
import by.epam.finaltask.facultative.service.exception.ServiceException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class CourseService {


    public final static List<CourseDescription> getAllSubject() throws ServiceException {

        SubjectsForUserDAO allSubject = DAOFactory.getSubjectsForUserDAO();
        try {
           return allSubject.getAllSubject();

        } catch (DAOException e) {
            throw new ServiceException("Error access database",e);
        }

    }

    public final static List<CourseDescription> getSubjectForTeachar(User teacher) throws ServiceException {


        SubjectsForUserDAO subjects = DAOFactory.getSubjectsForUserDAO();
        try {
            return subjects.getSubjectsForTeacher(teacher);

        } catch (DAOException e) {
            throw new ServiceException("Error access database",e);
        }

    }
    public final static List<CourseDescription> getSubjectForStudent(User student) throws ServiceException {


        SubjectsForUserDAO subjects = DAOFactory.getSubjectsForUserDAO();
        try {
            return subjects.getSubjectsForStudent(student);

        } catch (DAOException e) {
            throw new ServiceException("Error access database",e);
        }

    }
    public final static List<CourseDescription> getOtherSubjectForStudent(User student) throws ServiceException {

        SubjectsForUserDAO subjects = DAOFactory.getSubjectsForUserDAO();
        try {
            return subjects.getOtherSubjectsForStudent(student);

        } catch (DAOException e) {
            throw new ServiceException("Error access database",e);
        }

    }
    public final static CourseDescription getDescriptionStudent(int idSubject) throws ServiceException {

        SubjectsForUserDAO subjects = DAOFactory.getSubjectsForUserDAO();
        try {
            return subjects.getDescriptionSubject(idSubject);

        } catch (DAOException e) {
            throw new ServiceException("Error access database",e);
        }

    }

}
