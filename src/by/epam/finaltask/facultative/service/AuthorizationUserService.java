package by.epam.finaltask.facultative.service;

import by.epam.finaltask.facultative.dao.AuthorizationUser;
import by.epam.finaltask.facultative.dao.impl.AuthorizationUserDAOImpl;
import by.epam.finaltask.facultative.dao.exception.DAOException;
import by.epam.finaltask.facultative.entity.User;
import by.epam.finaltask.facultative.service.exception.ServiceException;


public class AuthorizationUserService {
    public final static User checkLogin(String login, String password) throws ServiceException{
        if (!Validator.loginValidator(login, password)){
            throw new ServiceException("Invalid login or password");
        }
        User user= new User();
        user.setLogin(login);
        user.setPassword(password);
        AuthorizationUser authorizationUserDAOImpl = new AuthorizationUserDAOImpl();
        try {
            user =  authorizationUserDAOImpl.authorization(user);

        } catch (DAOException e) {
            throw new ServiceException("Error access database",e);
        }

        return user;
    }



    static class Validator{
        public static boolean loginValidator(String login, String password){
            if(login.isEmpty()){
                return false;
            }
            if(password.isEmpty()){
                return false;
            }
            return true;
        }
    }
}
