package by.epam.finaltask.facultative.dao.impl;

import by.epam.finaltask.facultative.dao.GroupStudentDAO;
import by.epam.finaltask.facultative.dao.connectionpool.ConnectionPool;
import by.epam.finaltask.facultative.dao.exception.ConnectionPoolException;
import by.epam.finaltask.facultative.dao.exception.DAOException;
import by.epam.finaltask.facultative.entity.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class GroupStudentDAOImpl implements GroupStudentDAO {
    private final static String SQL_GET_STUDENT_INF= "SELECT DISTINCT id_student, mark,comment ,name,surname FROM facultative join authoriz " +
            "on(facultative.id_student=authoriz.id) Where id_subject= ? ;";
    private final static String SQL_ID_STUDENT="id_student";
    private final static String SQL_MARK="mark";
    private final static String SQL_COMMENT="comment";
    private final static String SQL_NAME="name";
    private final static String SQL_SURNAME="surname";


    /**
     * get student group for current subject and teacher
     *
     * @param course
     * @return listStudents
     * @throws DAOException
     */
    public List<CourseStatistic> getGroupOfStudentForCurrentSubject ( CourseDescription course) throws DAOException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = null;
        ResultSet rs=null;
        List<CourseStatistic> listStudents = new ArrayList<>();
        PreparedStatement preparedStatement= null;


        try {
            connection = connectionPool.takeConnection();
            preparedStatement = connection.prepareStatement(SQL_GET_STUDENT_INF);
            preparedStatement.setInt(1, course.getId());
            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                CourseStatistic studentFromGroup = new CourseStatistic();
                studentFromGroup.setMark(rs.getInt(SQL_MARK));
                studentFromGroup.setComment(rs.getString(SQL_COMMENT));
                studentFromGroup.setSubject(course);
                User student= new User();
                student.setId(rs.getInt(SQL_ID_STUDENT));
                student.setName(rs.getString(SQL_NAME));
                student.setSurname(rs.getString(SQL_SURNAME));
                studentFromGroup.setStudent(student);

                listStudents.add(studentFromGroup);
            }
            return listStudents;

        } catch (ConnectionPoolException | SQLException e) {

            throw new DAOException(e);

        } finally {
            connectionPool.closeConnection(connection,preparedStatement,rs);
        }

    }
}
