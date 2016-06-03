package by.epam.finaltask.facultative.service;

import by.epam.finaltask.facultative.dao.SubjectsForUser;
import by.epam.finaltask.facultative.dao.exception.DAOException;
import by.epam.finaltask.facultative.dao.impl.SubjectsForUserDOAImpl;
import by.epam.finaltask.facultative.entity.CourseDescription;
import by.epam.finaltask.facultative.entity.User;
import by.epam.finaltask.facultative.service.exception.ServiceException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Admin on 27.05.2016.
 */
public class SubjectService {
    private static String getCurrentDate(){
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd ");
                    System.out.println("date: " + dateFormat.format( new Date() ) );
        String date= dateFormat.format( new Date() );

        return date;
    }
    public final static List<CourseDescription> getAllSubject() throws ServiceException {

        SubjectsForUser allSubject = new SubjectsForUserDOAImpl();
        try {
           return allSubject.getAllSubject();

        } catch (DAOException e) {
            throw new ServiceException("Error access database",e);
        }

    }

    public final static List<CourseDescription> getSubjectForTeachar(User teacher) throws ServiceException {


        SubjectsForUser subjects = new SubjectsForUserDOAImpl();
        try {
            return subjects.getSubjectsForTeacher(teacher);

        } catch (DAOException e) {
            throw new ServiceException("Error access database",e);
        }

    }
    public final static List<CourseDescription> getSubjectForStudent(User student) throws ServiceException {


        SubjectsForUser subjects = new SubjectsForUserDOAImpl();
        try {
            return subjects.getSubjectsForStudent(student,getCurrentDate());

        } catch (DAOException e) {
            throw new ServiceException("Error access database",e);
        }

    }
    public final static List<CourseDescription> getOtherSubjectForStudent(User student) throws ServiceException {

        SubjectsForUser subjects = new SubjectsForUserDOAImpl();
        try {
            return subjects.getOtherSubjectsForStudent(student,getCurrentDate());

        } catch (DAOException e) {
            throw new ServiceException("Error access database",e);
        }

    }
    public final static CourseDescription getDescriptionStudent(int idSubject) throws ServiceException {

        SubjectsForUser subjects = new SubjectsForUserDOAImpl();
        try {
            return subjects.getDescriptionSubject(idSubject);

        } catch (DAOException e) {
            throw new ServiceException("Error access database",e);
        }

    }
}
