package by.epam.finaltask.facultative.dao;

import by.epam.finaltask.facultative.dao.exception.DAOException;
import by.epam.finaltask.facultative.entity.CourseDescription;
import by.epam.finaltask.facultative.entity.User;


public interface OperationWithCourseDAO {
    public  void applyCourseForStudent(int id_student, int id_subject) throws DAOException;
    public void deleteCourseForStudent(int id_student, int id_subject) throws DAOException;
    public void addCourseForTeacher (CourseDescription course) throws DAOException ;
    public void deleteCourseForTeacher (int idCourse) throws DAOException ;
}
