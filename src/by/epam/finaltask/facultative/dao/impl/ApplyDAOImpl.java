package by.epam.finaltask.facultative.dao.impl;

import by.epam.finaltask.facultative.dao.Apply;
import by.epam.finaltask.facultative.dao.connectionpool.ConnectionPool;
import by.epam.finaltask.facultative.dao.exception.ConnectionPoolException;
import by.epam.finaltask.facultative.dao.exception.DAOException;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Admin on 29.05.2016.
 */
public class ApplyDAOImpl implements Apply{
    public boolean apply (int idStudent, int idSubject) throws DAOException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = null;
        Statement st=null;
        ResultSet rs=null;
        try {
            connection = connectionPool.takeConnection();
            String sql =  "SELECT DISTINCT number_of_students,number_of_current_students " +
                    " FROM teacher_schedule WHERE id_subject="+ idSubject+";";
            st = connection.createStatement();
            rs = st.executeQuery(sql);
            int currentCountStudent=0;
            int countStudent=0;
            while (rs.next()) {
                countStudent=rs.getInt(1);
                currentCountStudent=rs.getInt(2);
                }

            if(countStudent>currentCountStudent){
                currentCountStudent++;
                sql =  "UPDATE teacher_schedule SET number_of_current_students ="+ currentCountStudent+
                        " WHERE id_subject="+ idSubject+";";
                st = connection.createStatement();
                st.executeUpdate(sql);
                sql =  "INSERT INTO facultative  VALUES ("+idStudent+","+idSubject+");";
                st = connection.createStatement();
                st.executeUpdate(sql);
                return true;

            }else{
                return false;
            }


        } catch (ConnectionPoolException | SQLException e) {

            throw new DAOException(e);

        } finally {
            connectionPool.closeConnection(connection,st,rs);
        }

    }
}
