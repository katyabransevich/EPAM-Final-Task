package by.epam.finaltask.facultative.dao.impl;

import by.epam.finaltask.facultative.dao.OperationWithCourseDAO;
import by.epam.finaltask.facultative.dao.connectionpool.ConnectionPool;
import by.epam.finaltask.facultative.dao.exception.ConnectionPoolException;
import by.epam.finaltask.facultative.dao.exception.DAOException;
import by.epam.finaltask.facultative.entity.CourseDescription;


import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class OperationWithCourseDAOImpl implements OperationWithCourseDAO {
    private final static String SQL_APPLY_COURSE_STUDENT = "UPDATE teacher_schedule SET number_of_current_students =(SELECT number_of_current_students FROM teacher_schedule WHERE id_subject= ?)+1  WHERE id_subject= ?;";
    private final static String SQL_APPLY_STUDENT = "INSERT INTO facultative (id_student, id_subject) VALUES (?,?);";
    private final static String SQL_DELETE_COURSE_STUDENT = "UPDATE teacher_schedule SET number_of_current_students=(SELECT number_of_current_students FROM teacher_schedule WHERE id_subject= ?)-1 WHERE id_subject= ?;";
    private final static String SQL_DELETE_STUDENT = "DELETE FROM facultative WHERE id_subject= ? AND id_student= ?";
    private final static String SQL_ADD_COURSE = "INSERT INTO teacher_schedule(name_subject, id_teacher, day_time, number_of_students, number_of_current_students , start_of_course, end_of_course,description) VALUES" +
            " (?,?,?,?,0,?,?,? );";
    private final static String SQL_DELETE_COURSE_TEACHER = "DELETE FROM teacher_schedule WHERE id_subject= ?";


    /**
     * Student apply course
     *
     * @param idStudent
     * @param idSubject
     * @throws DAOException
     */
    public void applyCourseForStudent(int idStudent, int idSubject) throws DAOException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = connectionPool.takeConnection();
            preparedStatement = connection.prepareStatement(SQL_APPLY_COURSE_STUDENT);
            preparedStatement.setInt(1, idSubject);
            preparedStatement.setInt(2, idSubject);
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement(SQL_APPLY_STUDENT);
            preparedStatement.setInt(1, idStudent);
            preparedStatement.setInt(2, idSubject);
            preparedStatement.executeUpdate();
        } catch (ConnectionPoolException | SQLException e) {

            throw new DAOException(e);

        } finally {
            connectionPool.closeConnection(connection, preparedStatement);
        }

    }

    /**
     * Sudent can delete course
     *
     * @param idStudent
     * @param idSubject
     * @throws DAOException
     */

    @Override
    public void deleteCourseForStudent(int idStudent, int idSubject) throws DAOException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = connectionPool.takeConnection();
            preparedStatement = connection.prepareStatement(SQL_DELETE_COURSE_STUDENT);
            preparedStatement.setInt(1, idSubject);
            preparedStatement.setInt(2, idSubject);
            preparedStatement.executeUpdate();
            preparedStatement = connection.prepareStatement(SQL_DELETE_STUDENT);
            preparedStatement.setInt(1, idSubject);
            preparedStatement.setInt(2, idStudent);
            preparedStatement.executeUpdate();
        } catch (ConnectionPoolException | SQLException e) {

            throw new DAOException(e);

        } finally {
            connectionPool.closeConnection(connection, preparedStatement);
        }

    }

    /**
     * Teacher can create new course
     *
     * @param course
     * @throws DAOException
     */


    public void addCourseForTeacher(CourseDescription course) throws DAOException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Date sqlStartDate = null;
        Date sqlEndDate = null;


        try {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            sqlStartDate = new Date(format.parse(course.getStartCourse()).getTime());
            sqlEndDate = new Date(format.parse(course.getEndCourse()).getTime());

            connection = connectionPool.takeConnection();
            preparedStatement = connection.prepareStatement(SQL_ADD_COURSE);
            preparedStatement.setString(1, course.getCourseName());
            preparedStatement.setInt(2, course.getTeacher().getId());
            preparedStatement.setString(3, course.getTime());
            preparedStatement.setInt(4, course.getNumberOfStudent());
            preparedStatement.setDate(5, sqlStartDate);
            preparedStatement.setDate(6, sqlEndDate);
            preparedStatement.setString(7, course.getDescription());
            preparedStatement.executeUpdate();
        } catch (ConnectionPoolException | SQLException | ParseException e) {

            throw new DAOException(e);
        } finally {
            connectionPool.closeConnection(connection, preparedStatement);
        }

    }

    /**
     * teacher can delete course if there is no student
     *
     * @param idCourse
     * @throws DAOException
     */

    @Override
    public void deleteCourseForTeacher(int idCourse) throws DAOException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = null;

        PreparedStatement preparedStatement = null;
        try {
            connection = connectionPool.takeConnection();
            preparedStatement = connection.prepareStatement(SQL_DELETE_COURSE_TEACHER);
            preparedStatement.setInt(1, idCourse);
            preparedStatement.executeUpdate();
        } catch (ConnectionPoolException | SQLException e) {

            throw new DAOException(e);

        } finally {
            connectionPool.closeConnection(connection, preparedStatement);
        }


    }
}
