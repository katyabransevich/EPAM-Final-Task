package by.epam.finaltask.facultative.dao;

import by.epam.finaltask.facultative.dao.exception.DAOException;
import by.epam.finaltask.facultative.entity.User;

/**
 * Created by Admin on 26.05.2016.
 */
public interface AuthorizationUser {
    public abstract User authorization(User user) throws DAOException;
}
