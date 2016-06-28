package by.epam.finaltask.facultative.dao.impl;

import by.epam.finaltask.facultative.dao.UpdateContextTableStudentDAO;
import by.epam.finaltask.facultative.dao.connectionpool.ConnectionPool;
import by.epam.finaltask.facultative.dao.exception.ConnectionPoolException;
import by.epam.finaltask.facultative.dao.exception.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class UpdateContextTableStudentDAOImpl implements UpdateContextTableStudentDAO {
    private final static String SQL_UPDATE_MARK="update facultative set mark= ? where id_student= ? and id_subject= ?";
    private final static String SQL_UPDATE_COMMENT="update facultative set comment= ? where id_student= ? and id_subject= ?";



    public void updateMark (int mark,int idStudent, int idSubject) throws DAOException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = null;
        PreparedStatement preparedStatement= null;
        try {
            connection = connectionPool.takeConnection();


            preparedStatement = connection.prepareStatement(SQL_UPDATE_MARK);
            preparedStatement.setInt(1, mark);
            preparedStatement.setInt(2, idStudent);
            preparedStatement.setInt(3, idSubject);
           preparedStatement.executeUpdate();

        } catch (ConnectionPoolException | SQLException e) {

            throw new DAOException(e);

        } finally {
            connectionPool.closeConnection(connection, preparedStatement);
        }

    }

    public void updateComment (String comment ,int idStudent, int idSubject) throws DAOException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = null;
        PreparedStatement preparedStatement= null;
        try {
            connection = connectionPool.takeConnection();
            preparedStatement = connection.prepareStatement(SQL_UPDATE_COMMENT);
            preparedStatement.setString(1, comment);
            preparedStatement.setInt(2, idStudent);
            preparedStatement.setInt(3, idSubject);
            preparedStatement.executeUpdate();

        } catch (ConnectionPoolException | SQLException e) {

            throw new DAOException(e);

        } finally {
            connectionPool.closeConnection(connection, preparedStatement);
        }

    }
}
