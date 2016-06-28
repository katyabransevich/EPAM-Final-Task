package by.epam.finaltask.facultative.service;

import by.epam.finaltask.facultative.dao.UserDAO;
import by.epam.finaltask.facultative.dao.DAOFactory;
import by.epam.finaltask.facultative.dao.exception.DAOException;
import by.epam.finaltask.facultative.entity.User;
import by.epam.finaltask.facultative.resourses.AllErrorMessages;
import by.epam.finaltask.facultative.resourses.Message;
import by.epam.finaltask.facultative.service.exception.ServiceException;


public class UserService {
    public final static User checkLogin(String login, String password) throws ServiceException{
        User user= new User();
        user.setLogin(login);
        user.setPassword(password);
        UserDAO authorizationUserDAOImpl = DAOFactory.getUserDAO();
        try {
            user =  authorizationUserDAOImpl.authorization(user);
            if(user!=null){
                return user;
            }else{
                Message.getInstanse().setMessage(AllErrorMessages.NOT_CORRECT_LOGIN_OR_PASSWORD);
                return null;
            }

        } catch (DAOException e) {
            throw new ServiceException("Error access database",e);
        }


    }
    public final static User checkRegistrationField(String login, String password,String type) throws ServiceException{
        User user= new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setType(type);
        UserDAO authorizationUserDAOImpl = DAOFactory.getUserDAO();
        try {
            user =  authorizationUserDAOImpl.registration(user);
            if(user!=null){
                return user;
            }else {
                Message.getInstanse().setMessage(AllErrorMessages.LOGIN_BAD);
                return null;
            }

        } catch (DAOException e) {
            throw new ServiceException("Error access database",e);
        }
    }

    public final static User saveStudent(String name, String surname, String email, String skype,String phone,User user) throws ServiceException {

        user=Validator1.loginValidator(name,surname,email,skype,phone, user);

        UserDAO authorizationUserDAOImpl = DAOFactory.getUserDAO();
        try {
            authorizationUserDAOImpl.updateUser(user);

        } catch (DAOException e) {
            throw new ServiceException("Error access database",e);
        }
        return user;
    }



    static class Validator1{
        public static User loginValidator(String name, String surname, String email, String skype,String phone,User user){
            if(!name.isEmpty()){
                user.setName(name);
            }
            if(!surname.isEmpty()){
                user.setSurname(surname);
            }
            if(!email.isEmpty()){
                user.setEmail(email);
            }
            if(!skype.isEmpty()){
                user.setSkype(skype);
            }
            if(!phone.isEmpty()){
                user.setTelephone(phone);
            }
            return user;
        }
    }

}
