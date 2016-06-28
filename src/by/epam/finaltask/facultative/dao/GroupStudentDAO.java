package by.epam.finaltask.facultative.dao;

import by.epam.finaltask.facultative.dao.exception.DAOException;
import by.epam.finaltask.facultative.entity.CourseDescription;
import by.epam.finaltask.facultative.entity.CourseStatistic;

import java.util.List;



public interface GroupStudentDAO {
    public abstract List<CourseStatistic> getGroupOfStudentForCurrentSubject( CourseDescription course) throws DAOException;
}
