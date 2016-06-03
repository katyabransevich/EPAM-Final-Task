package by.epam.finaltask.facultative.dao.impl;

import by.epam.finaltask.facultative.dao.GroupStudent;
import by.epam.finaltask.facultative.dao.connectionpool.ConnectionPool;
import by.epam.finaltask.facultative.dao.exception.ConnectionPoolException;
import by.epam.finaltask.facultative.dao.exception.DAOException;
import by.epam.finaltask.facultative.entity.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class GroupStudentDAOImpl implements GroupStudent {
    public List<CourseStatistic> getGroupOfStudentForCurrentSubject ( CourseDescription course) throws DAOException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = null;
        Statement st=null;
        ResultSet rs=null;
        List<CourseStatistic> listStudents = new ArrayList<>();
        try {
            connection = connectionPool.takeConnection();
            String sql =  "SELECT DISTINCT id_student, mark,comment ,name,surname FROM facultative join authoriz " +
                    "on(facultative.id_student=authoriz.id) Where id_subject="+course.getId()+";";
            st = connection.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                CourseStatistic studentFromGroup = new CourseStatistic();
                studentFromGroup.setMark(rs.getInt(2));
                studentFromGroup.setComment(rs.getString(3));
                studentFromGroup.setSubject(course);
                User student= new User();
                student.setId(rs.getInt(1));
                student.setName(rs.getString(4));
                student.setSurname(rs.getString(5));
                studentFromGroup.setStudent(student);

                listStudents.add(studentFromGroup);
            }
            return listStudents;

        } catch (ConnectionPoolException | SQLException e) {

            throw new DAOException(e);

        } finally {
            connectionPool.closeConnection(connection,st,rs);
        }

    }
}
