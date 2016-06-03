package by.epam.finaltask.facultative.dao;

import by.epam.finaltask.facultative.dao.exception.DAOException;
import by.epam.finaltask.facultative.entity.User;

/**
 * Created by Admin on 29.05.2016.
 */
public interface Apply {
    public abstract boolean apply(int id_student, int id_subject) throws DAOException;
}
