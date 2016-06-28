package by.epam.finaltask.facultative.service;

import by.epam.finaltask.facultative.dao.OperationWithCourseDAO;
import by.epam.finaltask.facultative.dao.DAOFactory;
import by.epam.finaltask.facultative.dao.exception.DAOException;
import by.epam.finaltask.facultative.entity.CourseDescription;
import by.epam.finaltask.facultative.entity.User;
import by.epam.finaltask.facultative.service.exception.ServiceException;


public class OperationWithCourseService {


    public final static boolean applyCourseForStudent(int idStudent, int idSubject) throws ServiceException {

        OperationWithCourseDAO operationWithCourse = DAOFactory.getOperationWithCourseDAO();
        try {

            return operationWithCourse.applyCourseForStudent(idStudent,idSubject);

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
