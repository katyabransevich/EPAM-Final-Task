package by.epam.finaltask.facultative.dao;

import by.epam.finaltask.facultative.dao.exception.DAOException;
import by.epam.finaltask.facultative.entity.CourseDescription;

import java.sql.SQLException;

/**
 * Created by Admin on 01.06.2016.
 */
public interface ViewCourse {
    public CourseDescription getFullCourseDescription (int idCourse) throws DAOException;
}
