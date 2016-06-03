package by.epam.finaltask.facultative.service;

import by.epam.finaltask.facultative.dao.AuthorizationUser;
import by.epam.finaltask.facultative.dao.RegistrationUser;
import by.epam.finaltask.facultative.dao.exception.DAOException;
import by.epam.finaltask.facultative.dao.impl.AuthorizationUserDAOImpl;
import by.epam.finaltask.facultative.dao.impl.RegistrationUserDAOImpl;
import by.epam.finaltask.facultative.entity.User;
import by.epam.finaltask.facultative.service.exception.ServiceException;


public class SaveUserService {
    public final static User saveStudent(String name, String surname, String email, String skype,String phone,User user) throws ServiceException {

        user=Validator.loginValidator(name,surname,email,skype,phone, user);

        RegistrationUser registrationUser = new RegistrationUserDAOImpl();
        try {
            registrationUser.updateUser(user);

        } catch (DAOException e) {
            throw new ServiceException("Error access database",e);
        }
        return user;
    }



    static class Validator{
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
