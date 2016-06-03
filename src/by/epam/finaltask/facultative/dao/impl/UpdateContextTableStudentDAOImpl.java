package by.epam.finaltask.facultative.dao.impl;

import by.epam.finaltask.facultative.dao.UpdateContextTableStudent;
import by.epam.finaltask.facultative.dao.connectionpool.ConnectionPool;
import by.epam.finaltask.facultative.dao.exception.ConnectionPoolException;
import by.epam.finaltask.facultative.dao.exception.DAOException;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class UpdateContextTableStudentDAOImpl implements UpdateContextTableStudent {
    public void updateMark (int mark,int idStudent, int idSubject) throws DAOException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = null;
        Statement st = null;
        try {
            connection = connectionPool.takeConnection();
            String sql = "update facultative set mark="+mark+" where id_student="+idStudent+" and id_subject="+idSubject;
            st = connection.createStatement();
            st.executeUpdate(sql);

        } catch (ConnectionPoolException | SQLException e) {

            throw new DAOException(e);

        } finally {
            connectionPool.closeConnection(connection, st);
        }

    }

    public void updateComment (String comment ,int idStudent, int idSubject) throws DAOException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = null;
        Statement st = null;
        try {
            connection = connectionPool.takeConnection();
            String sql = "update facultative set comment='"+comment+"' where id_student="+idStudent+" and id_subject="+idSubject;
            st = connection.createStatement();
            st.executeUpdate(sql);

        } catch (ConnectionPoolException | SQLException e) {

            throw new DAOException(e);

        } finally {
            connectionPool.closeConnection(connection, st);
        }

    }
}
