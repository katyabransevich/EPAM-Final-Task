package by.epam.finaltask.facultative.dao;

import by.epam.finaltask.facultative.dao.exception.DAOException;
import by.epam.finaltask.facultative.entity.User;

/**
 * Created by Admin on 26.05.2016.
 */
public interface RegistrationUser {

    public abstract User authorization(String name,String surname,String login, String password) throws DAOException;
    public abstract void updateUser(User user) throws DAOException;

}
