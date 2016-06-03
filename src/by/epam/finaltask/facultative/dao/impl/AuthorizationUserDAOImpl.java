package by.epam.finaltask.facultative.dao.impl;

import by.epam.finaltask.facultative.dao.AuthorizationUser;
import by.epam.finaltask.facultative.dao.connectionpool.ConnectionPool;
import by.epam.finaltask.facultative.dao.exception.ConnectionPoolException;
import by.epam.finaltask.facultative.dao.exception.DAOException;
import by.epam.finaltask.facultative.entity.User;

import java.sql.*;


public class AuthorizationUserDAOImpl implements AuthorizationUser {

    public User authorization(User user) throws DAOException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            connection = connectionPool.takeConnection();
            String sql = "SELECT id, name, surname, email, telephone ,skype ,type FROM authoriz WHERE login='" +
                    user.getLogin() + "' AND password='" + user.getPassword() + "';";
            st = connection.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setSurname(rs.getString(3));
                user.setEmail(rs.getString(4));
                user.setTelephone(rs.getString(5));
                user.setSkype(rs.getString(6));
                user.setType(rs.getString(7));
            }
            return user;


        } catch (ConnectionPoolException | SQLException e) {

            throw new DAOException(e);

        } finally {
            connectionPool.closeConnection(connection, st, rs);
        }

    }

}