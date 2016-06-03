package by.epam.finaltask.facultative.dao;

import by.epam.finaltask.facultative.dao.exception.DAOException;
import by.epam.finaltask.facultative.entity.CourseDescription;
import by.epam.finaltask.facultative.entity.CourseStatistic;

import java.util.List;


/**
 * Created by Admin on 30.05.2016.
 */
public interface GroupStudent {
    public abstract List<CourseStatistic> getGroupOfStudentForCurrentSubject( CourseDescription course) throws DAOException;
}
