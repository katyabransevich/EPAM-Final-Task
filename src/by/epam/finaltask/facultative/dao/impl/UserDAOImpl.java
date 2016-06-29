package by.epam.finaltask.facultative.dao.impl;

import by.epam.finaltask.facultative.dao.UserDAO;
import by.epam.finaltask.facultative.dao.connectionpool.ConnectionPool;
import by.epam.finaltask.facultative.dao.exception.ConnectionPoolException;
import by.epam.finaltask.facultative.dao.exception.DAOException;
import by.epam.finaltask.facultative.entity.User;

import java.sql.*;


public class UserDAOImpl implements UserDAO {

    private final static String SQL_FIND_USER_BY_LOGIN = "SELECT id FROM authoriz WHERE login= ?";
    private final static String SQL_NEW_USER = "INSERT into authoriz (login,password,type) values (?,?,?)";
    private final static String SQL_UPDATE_USER=" UPDATE authoriz set name= ?, surname= ? ,skype= ?, email= ?, telephone= ?  where id= ? ";
    private final static String SQL_GET_USER="SELECT id, name, surname, email, telephone ,skype ,type FROM authoriz WHERE login= ? AND password= ?;";
    private final static String SQL_USER_ID="id";
    private final static String SQL_USER_NAME="name";
    private final static String SQL_USER_SURNAME="surname";
    private final static String SQL_USER_EMAIL="email";
    private final static String SQL_USER_PHONE="telephone";
    private final static String SQL_USER_SKYPE="skype";
    private final static String SQL_USER_TYPE="type";

    /**
     * check if current user is in the datedase and if he there then we take all information of him
     *
     * @param user
     * @return user
     * @throws DAOException
     */

    public User authorization(User user) throws DAOException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connection = connectionPool.takeConnection();
            preparedStatement = connection.prepareStatement(SQL_GET_USER);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                user.setId(rs.getInt(SQL_USER_ID));
                user.setName(rs.getString(SQL_USER_NAME));
                user.setSurname(rs.getString(SQL_USER_SURNAME));
                user.setEmail(rs.getString(SQL_USER_EMAIL));
                user.setTelephone(rs.getString(SQL_USER_PHONE));
                user.setSkype(rs.getString(SQL_USER_SKYPE));
                user.setType(rs.getString(SQL_USER_TYPE));
                return user;
            }
            return null;
        } catch (ConnectionPoolException | SQLException e) {

            throw new DAOException(e);

        } finally {
            connectionPool.closeConnection(connection, preparedStatement, rs);
        }

    }

    /**
     * chech if this user is in datebase if we dont find him than insert him
     *
     * @param user
     * @return user
     * @throws DAOException
     */

    @Override
    public User registration(User user) throws DAOException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = null;
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = connectionPool.takeConnection();
            preparedStatement = connection.prepareStatement(SQL_FIND_USER_BY_LOGIN);
            preparedStatement.setString(1, user.getLogin());
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
            return null;
            }

            preparedStatement = connection.prepareStatement(SQL_NEW_USER,Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getType());
            if (preparedStatement.executeUpdate() == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }
            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    user.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
            return user;


        } catch (ConnectionPoolException | SQLException e) {

            throw new DAOException(e);

        } finally {
            connectionPool.closeConnection(connection, preparedStatement, rs);
        }
    }

    /**
     * update user information
     *
     * @param user
     * @throws DAOException
     */
    @Override
    public void updateUser(User user) throws DAOException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = connectionPool.takeConnection();


            preparedStatement = connection.prepareStatement(SQL_UPDATE_USER);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getSkype());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getTelephone());
            preparedStatement.setInt(6, user.getId());
            preparedStatement.executeUpdate();

        } catch (ConnectionPoolException | SQLException e) {

            throw new DAOException(e);

        } finally {
            connectionPool.closeConnection(connection, preparedStatement);
        }


    }


}