package by.epam.finaltask.facultative.dao.impl;

import by.epam.finaltask.facultative.dao.SubjectsForUserDAO;
import by.epam.finaltask.facultative.dao.connectionpool.ConnectionPool;
import by.epam.finaltask.facultative.dao.exception.ConnectionPoolException;
import by.epam.finaltask.facultative.dao.exception.DAOException;
import by.epam.finaltask.facultative.entity.CourseDescription;
import by.epam.finaltask.facultative.entity.User;

import java.sql.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;


public class SubjectsForUserDOAImpl implements SubjectsForUserDAO {
    private final static String SQL_COURSES_FOR_TEACHER = "SELECT DISTINCT id_subject, name_subject,day_time,number_of_students,number_of_current_students,start_of_course,end_of_course FROM teacher_schedule WHERE id_teacher = ? ";
    private final static String SQL_COURSES_FOR_STUDENT = "SELECT DISTINCT teacher_schedule.id_subject,id_teacher, name_subject,day_time,number_of_students,number_of_current_students, start_of_course,end_of_course FROM teacher_schedule JOIN " +
            "facultative ON(teacher_schedule.id_subject=facultative.id_subject) WHERE id_student= ?  AND end_of_course> ? ";
    private final static String SQL_OTHER_COURSES_FOR_STUDENT = "SELECT DISTINCT id_subject,id_teacher, name_subject,day_time,number_of_students," +
            "number_of_current_students, start_of_course,end_of_course  FROM teacher_schedule WHERE id_subject " +
            "NOT IN(SELECT id_subject FROM facultative WHERE id_student = ? )AND end_of_course > ? ";
    private final static String SQL_ALL_COURSES = "SELECT DISTINCT id_subject,name_subject,id_teacher,day_time,number_of_students,number_of_current_students ," +
            " start_of_course,end_of_course FROM teacher_schedule WHERE end_of_course> ? ;";
    private final static String SQL_GET_COURSE_DESCRIPTION = "SELECT id_subject,id_teacher, name ,surname,name_subject,day_time,number_of_students,start_of_course,end_of_course,description  FROM teacher_schedule JOIN authoriz ON(authoriz.id=teacher_schedule.id_teacher) WHERE id_subject = ? ";
    private final static String SQL_ID_SUBJECT = "id_subject";
    private final static String SQL_NAME_SUBJECT = "name_subject";
    private final static String SQL_NAME_USER = "name";
    private final static String SQL_SURNAME = "surname";
    private final static String SQL_DAY_TIME = "day_time";
    private final static String SQL_NUMBER_OF_STUDENT = "number_of_students";
    private final static String SQL_NUMBER_OF_CURRENT_STUDENT = "number_of_current_students";
    private final static String SQL_START_OF_COURSE = "start_of_course";
    private final static String SQL_END_OF_COURSE = "end_of_course";
    private final static String SQL_ID_TEACHER = "id_teacher";
    private final static String SQL_COURSE_DESCRIPTION = "description";


    public List<CourseDescription> getSubjectsForTeacher(User teacher) throws DAOException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        List<CourseDescription> listSubjectsForTeacher = new ArrayList<>();
        try {
            connection = connectionPool.takeConnection();
            preparedStatement = connection.prepareStatement(SQL_COURSES_FOR_TEACHER);
            preparedStatement.setInt(1, teacher.getId());
            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                CourseDescription courseDescription = new CourseDescription();
                courseDescription.setId(rs.getInt(SQL_ID_SUBJECT));
                courseDescription.setCourseName(rs.getString(SQL_NAME_SUBJECT));
                courseDescription.setTeacher(teacher);
                courseDescription.setTime(rs.getString(SQL_DAY_TIME));
                courseDescription.setNumberOfStudent(rs.getInt(SQL_NUMBER_OF_STUDENT));
                courseDescription.setNumberOfCurrentStudent(rs.getInt(SQL_NUMBER_OF_CURRENT_STUDENT));
                courseDescription.setStartCourse(rs.getString(SQL_START_OF_COURSE));
                courseDescription.setEndCourse(rs.getString(SQL_END_OF_COURSE));
                listSubjectsForTeacher.add(courseDescription);
            }
            return listSubjectsForTeacher;

        } catch (ConnectionPoolException | SQLException e) {

            throw new DAOException(e);

        } finally {
            connectionPool.closeConnection(connection, preparedStatement, rs);
        }

    }

    @Override
    public List<CourseDescription> getSubjectsForStudent(User student) throws DAOException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            connection = connectionPool.takeConnection();
            preparedStatement = connection.prepareStatement(SQL_COURSES_FOR_STUDENT);
            preparedStatement.setInt(1, student.getId());
            preparedStatement.setDate(2, java.sql.Date.valueOf(java.time.LocalDate.now()));
            rs = preparedStatement.executeQuery();
            return getSubjectList(rs);

        } catch (ConnectionPoolException | SQLException e) {

            throw new DAOException(e);

        } finally {
            connectionPool.closeConnection(connection, preparedStatement, rs);
        }

    }

    @Override
    public List<CourseDescription> getOtherSubjectsForStudent(User student) throws DAOException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            connection = connectionPool.takeConnection();
            preparedStatement = connection.prepareStatement(SQL_OTHER_COURSES_FOR_STUDENT);
            preparedStatement.setInt(1, student.getId());
            preparedStatement.setDate(2, java.sql.Date.valueOf(java.time.LocalDate.now()));
            rs = preparedStatement.executeQuery();
            return getSubjectList(rs);


        } catch (ConnectionPoolException | SQLException e) {

            throw new DAOException(e);

        } finally {
            connectionPool.closeConnection(connection, preparedStatement, rs);
        }
    }

    private List<CourseDescription> getSubjectList(ResultSet rs) throws SQLException {
        List<CourseDescription> listSubjectsForTeacher = new ArrayList<>();
        while (rs.next()) {
            CourseDescription courseDescription = new CourseDescription();
            courseDescription.setId(rs.getInt(SQL_ID_SUBJECT));
            User teacher = new User();
            teacher.setId(rs.getInt(SQL_ID_TEACHER));
            courseDescription.setTeacher(teacher);
            courseDescription.setCourseName(rs.getString(SQL_NAME_SUBJECT));
            courseDescription.setTime(rs.getString(SQL_DAY_TIME));
            courseDescription.setNumberOfStudent(rs.getInt(SQL_NUMBER_OF_STUDENT));
            courseDescription.setNumberOfCurrentStudent(rs.getInt(SQL_NUMBER_OF_CURRENT_STUDENT));
            courseDescription.setStartCourse(rs.getString(SQL_START_OF_COURSE));
            courseDescription.setEndCourse(rs.getString(SQL_END_OF_COURSE));
            listSubjectsForTeacher.add(courseDescription);
        }
        return listSubjectsForTeacher;
    }


    public List<CourseDescription> getAllSubject() throws DAOException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = null;
        ResultSet rs = null;
        List<CourseDescription> listCourseDescription = new ArrayList<>();
        PreparedStatement preparedStatement = null;


        try {
            connection = connectionPool.takeConnection();
            preparedStatement = connection.prepareStatement(SQL_ALL_COURSES);
            preparedStatement.setDate(1,java.sql.Date.valueOf(java.time.LocalDate.now()));
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                CourseDescription courseDescription = new CourseDescription();
                User teacher = new User();
                courseDescription.setId(rs.getInt(SQL_ID_SUBJECT));
                courseDescription.setCourseName(rs.getString(SQL_NAME_SUBJECT));
                teacher.setId(rs.getInt(SQL_ID_TEACHER));
                courseDescription.setTeacher(teacher);
                courseDescription.setTime(rs.getString(SQL_DAY_TIME));
                courseDescription.setNumberOfStudent(rs.getInt(SQL_NUMBER_OF_STUDENT));
                courseDescription.setNumberOfCurrentStudent(rs.getInt(SQL_NUMBER_OF_CURRENT_STUDENT));
                courseDescription.setStartCourse(rs.getString(SQL_START_OF_COURSE));
                courseDescription.setEndCourse(rs.getString(SQL_END_OF_COURSE));
                if (courseDescription.getNumberOfCurrentStudent() != courseDescription.getNumberOfStudent()) {
                    listCourseDescription.add(courseDescription);
                }
            }
            return listCourseDescription;

        } catch (ConnectionPoolException | SQLException e) {

            throw new DAOException(e);

        } finally {
            connectionPool.closeConnection(connection, preparedStatement, rs);
        }

    }


    public CourseDescription getDescriptionSubject(int idSubject) throws DAOException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = null;
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;


        try {
            connection = connectionPool.takeConnection();
            preparedStatement = connection.prepareStatement(SQL_GET_COURSE_DESCRIPTION);
            preparedStatement.setInt(1, idSubject);
            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                CourseDescription courseDescription = new CourseDescription();
                User teacher = new User();
                courseDescription.setId(rs.getInt(SQL_ID_SUBJECT));
                teacher.setId(rs.getInt(SQL_ID_TEACHER));
                teacher.setName(rs.getString(SQL_NAME_USER));
                teacher.setSurname(rs.getString(SQL_SURNAME));
                courseDescription.setTeacher(teacher);
                courseDescription.setCourseName(rs.getString(SQL_NAME_SUBJECT));
                courseDescription.setTime(rs.getString(SQL_DAY_TIME));
                courseDescription.setNumberOfStudent(rs.getInt(SQL_NUMBER_OF_STUDENT));
                courseDescription.setStartCourse(rs.getString(SQL_START_OF_COURSE));
                courseDescription.setEndCourse(rs.getString(SQL_END_OF_COURSE));
                courseDescription.setDescription(rs.getString(SQL_COURSE_DESCRIPTION));
                return courseDescription;
            }


        } catch (ConnectionPoolException | SQLException e) {

            throw new DAOException(e);

        } finally {
            connectionPool.closeConnection(connection, preparedStatement, rs);
        }
        return null;

    }
}
