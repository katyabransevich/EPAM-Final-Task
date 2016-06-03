package by.epam.finaltask.facultative.dao.impl;

import by.epam.finaltask.facultative.dao.RegistrationUser;
import by.epam.finaltask.facultative.dao.connectionpool.ConnectionPool;
import by.epam.finaltask.facultative.dao.exception.ConnectionPoolException;
import by.epam.finaltask.facultative.dao.exception.DAOException;
import by.epam.finaltask.facultative.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class RegistrationUserDAOImpl implements RegistrationUser {
    @Override
    public User authorization(String name, String surname, String login, String password) throws DAOException {
        return new User();

    }

    @Override
    public void updateUser(User user) throws DAOException {
            ConnectionPool connectionPool = ConnectionPool.getInstance();
            Connection connection = null;
            Statement st = null;
            try {
                connection = connectionPool.takeConnection();
                String sql = "update authoriz set name='"+user.getName()+"', surname='"+user.getSurname()+"'" +
                        "skype='"+user.getSkype()+"', email='"+user.getEmail()+"' telephone='"+user.getTelephone()+"'"+
                        " where id="+user.getId();
                st = connection.createStatement();
                st.executeUpdate(sql);

            } catch (ConnectionPoolException | SQLException e) {

                throw new DAOException(e);

            } finally {
                connectionPool.closeConnection(connection, st);
            }


    }

    private User createUser(int id,String name, String surname, String login, String password){
        User user= new User();
        user.setId(id);
        user.setLogin(login);
        user.setPassword(password);
        user.setName(name);
        user.setSurname(surname);
        return user;
    }
}
