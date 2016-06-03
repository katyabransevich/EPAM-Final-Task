package by.epam.finaltask.facultative.dao;

import by.epam.finaltask.facultative.dao.exception.DAOException;
import by.epam.finaltask.facultative.entity.CourseDescription;
import by.epam.finaltask.facultative.entity.User;

import java.util.List;

/**
 * Created by Admin on 30.05.2016.
 */
public interface SubjectsForUser {
    public List<CourseDescription> getSubjectsForTeacher (User teacher) throws DAOException;
    public List<CourseDescription> getSubjectsForStudent (User student, String date) throws DAOException;
    public List<CourseDescription> getOtherSubjectsForStudent (User student,String date) throws DAOException;
    public List<CourseDescription> getAllSubject () throws DAOException;
    public CourseDescription getDescriptionSubject(int idSubject)throws DAOException;
}
