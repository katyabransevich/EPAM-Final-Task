package by.epam.finaltask.facultative.service;

import by.epam.finaltask.facultative.dao.OperationWithCourseDAO;
import by.epam.finaltask.facultative.dao.DAOFactory;
import by.epam.finaltask.facultative.dao.exception.DAOException;
import by.epam.finaltask.facultative.entity.CourseDescription;
import by.epam.finaltask.facultative.entity.User;
import by.epam.finaltask.facultative.service.exception.ServiceException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class OperationWithCourseService {


    public final static void applyCourseForStudent(int idStudent, int idSubject) throws ServiceException {

        OperationWithCourseDAO operationWithCourse = DAOFactory.getOperationWithCourseDAO();
        try {

            operationWithCourse.applyCourseForStudent(idStudent,idSubject);

        } catch (DAOException e) {
            throw new ServiceException("Error access database",e);
        }

    }

    public final static void deleteCourseForStudent(int idStudent, int idSubject) throws ServiceException {

        OperationWithCourseDAO operationWithCourse = DAOFactory.getOperationWithCourseDAO();
        try {
            operationWithCourse.deleteCourseForStudent(idStudent,idSubject);

        } catch (DAOException e) {
            throw new ServiceException("Error access database",e);
        }

    }

    public final static void addCourseForTeacher(String courseName, User teacher, String dayTime, int numberOfStudent, String startCourse, String endCourse, String description) throws ServiceException {

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date start = format.parse(startCourse);
            Date end = format.parse(endCourse);
        } catch (ParseException e) {
            throw new ServiceException("Error access date",e);
        }

        CourseDescription courseDescription=new CourseDescription();
        courseDescription.setCourseName(courseName);
        courseDescription.setTeacher(teacher);
        courseDescription.setTime(dayTime);
        courseDescription.setNumberOfStudent(numberOfStudent);
        courseDescription.setStartCourse(startCourse);
        courseDescription.setEndCourse(endCourse);
        courseDescription.setDescription(description);

        OperationWithCourseDAO course = DAOFactory.getOperationWithCourseDAO();
        try {
            course.addCourseForTeacher(courseDescription);

        } catch (DAOException e) {
            throw new ServiceException("Error access database",e);
        }

    }

    public final static void deleteCourseForTeacher(int idCourse) throws ServiceException {


        OperationWithCourseDAO course = DAOFactory.getOperationWithCourseDAO();
        try {
            course.deleteCourseForTeacher(idCourse);

        } catch (DAOException e) {
            throw new ServiceException("Error access database",e);
        }

    }
}
