package by.epam.finaltask.facultative.dao.impl;

import by.epam.finaltask.facultative.dao.SubjectsForUser;
import by.epam.finaltask.facultative.dao.connectionpool.ConnectionPool;
import by.epam.finaltask.facultative.dao.exception.ConnectionPoolException;
import by.epam.finaltask.facultative.dao.exception.DAOException;
import by.epam.finaltask.facultative.entity.CourseDescription;
import by.epam.finaltask.facultative.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class SubjectsForUserDOAImpl implements SubjectsForUser {
    public List<CourseDescription> getSubjectsForTeacher(User teacher) throws DAOException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;
        List<CourseDescription> listSubjectsForTeacher = new ArrayList<>();
        try {
            connection = connectionPool.takeConnection();
            String sql = "SELECT DISTINCT id_subject, name_subject,day_time,number_of_students,number_of_current_students, " +
                    " start_of_course,end_of_course,description FROM teacher_schedule Where id_teacher=" + teacher.getId() + ";";
            st = connection.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                CourseDescription courseDescription = new CourseDescription();
                courseDescription.setId(rs.getInt(1));
                courseDescription.setCourseName(rs.getString(2));
                courseDescription.setTeacher(teacher);
                courseDescription.setTime(rs.getString(3));
                courseDescription.setNumberOfStudent(rs.getInt(4));
                courseDescription.setNumberOfCurrentStudent(rs.getInt(5));
                courseDescription.setStartCourse(rs.getString(6));
                courseDescription.setEndCourse(rs.getString(7));
                courseDescription.setDescription(rs.getString(8));
                listSubjectsForTeacher.add(courseDescription);
            }
            return listSubjectsForTeacher;

        } catch (ConnectionPoolException | SQLException e) {

            throw new DAOException(e);

        } finally {
            connectionPool.closeConnection(connection, st, rs);
        }

    }

    @Override
    public List<CourseDescription> getSubjectsForStudent(User student, String date) throws DAOException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            connection = connectionPool.takeConnection();
            String sql = "SELECT DISTINCT teacher_schedule.id_subject,id_teacher, name_subject,day_time,number_of_students," +
                    "number_of_current_students, start_of_course,end_of_course,description  FROM teacher_schedule join " +
                    "facultative on(teacher_schedule.id_subject=facultative.id_subject) WHERE id_student=" +
                    student.getId() + " and end_of_course>'"+date+"';";
            st = connection.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("getSubjectsForStudent");
            return getSubjectList(rs);

        } catch (ConnectionPoolException | SQLException e) {

            throw new DAOException(e);

        } finally {
            connectionPool.closeConnection(connection, st, rs);
        }

    }

    @Override
    public List<CourseDescription> getOtherSubjectsForStudent(User student,String date) throws DAOException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            connection = connectionPool.takeConnection();
            String sql = "SELECT DISTINCT id_subject,id_teacher, name_subject,day_time,number_of_students," +
                    "number_of_current_students, start_of_course,end_of_course,description  FROM teacher_schedule where id_subject " +
                    "not in(Select id_subject from facultative where id_student="+student.getId()+")and start_of_course>'"+date+"';";
            st = connection.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("getOtherSubjectsForStudent");
            return getSubjectList(rs);


        } catch (ConnectionPoolException | SQLException e) {

            throw new DAOException(e);

        } finally {
            connectionPool.closeConnection(connection, st, rs);
        }
    }

    private List<CourseDescription> getSubjectList(ResultSet rs) throws SQLException {
        List<CourseDescription> listSubjectsForTeacher = new ArrayList<>();
        while (rs.next()) {
            CourseDescription courseDescription = new CourseDescription();
            courseDescription.setId(rs.getInt(1));
            User teacher=new User();
            teacher.setId(rs.getInt(2));
            courseDescription.setTeacher(teacher);
            courseDescription.setCourseName(rs.getString(3));
            courseDescription.setTime(rs.getString(4));
            courseDescription.setNumberOfStudent(rs.getInt(5));
            courseDescription.setNumberOfCurrentStudent(rs.getInt(6));
            courseDescription.setStartCourse(rs.getString(7));
            courseDescription.setEndCourse(rs.getString(8));
            courseDescription.setDescription(rs.getString(9));
            listSubjectsForTeacher.add(courseDescription);
        }
        return listSubjectsForTeacher;
    }


    public List<CourseDescription> getAllSubject () throws DAOException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = null;
        Statement st=null;
        ResultSet rs=null;
        List<CourseDescription> listCourseDescription = new ArrayList<>();
        try {
            connection = connectionPool.takeConnection();
            String sql =  "SELECT DISTINCT id_subject,name_subject,id_teacher,day_time,number_of_students,number_of_current_students ," +
                    " start_of_course,eng_of_course, description FROM teacher_schedule";
            st = connection.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                CourseDescription courseDescription = new CourseDescription();
                User teacher=new User();
                courseDescription.setId(rs.getInt(1));
                courseDescription.setCourseName(rs.getString(2));
                teacher.setId(rs.getInt(3));
                courseDescription.setTeacher(teacher);
                courseDescription.setTime(rs.getString(4));
                courseDescription.setNumberOfStudent(rs.getInt(5));
                courseDescription.setNumberOfCurrentStudent(rs.getInt(6));
                courseDescription.setStartCourse(rs.getString(7));
                courseDescription.setEndCourse(rs.getString(8));
                courseDescription.setDescription(rs.getString(9));
                if(courseDescription.getNumberOfCurrentStudent()!= courseDescription.getNumberOfStudent()) {
                    listCourseDescription.add(courseDescription);
                }
            }
            return listCourseDescription;

        } catch (ConnectionPoolException | SQLException e) {

            throw new DAOException(e);

        } finally {
            connectionPool.closeConnection(connection,st,rs);
        }

    }


    public CourseDescription getDescriptionSubject (int idSubject) throws DAOException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = null;
        Statement st=null;
        ResultSet rs=null;
        try {
            connection = connectionPool.takeConnection();
            String sql =  "SELECT id_subject,id_teacher, name ,surname,name_subject,day_time,number_of_students,start_of_course,end_of_course,description  FROM teacher_schedule join authoriz on(authoriz.id=teacher_schedule.id_teacher) where id_subject="+idSubject;
            st = connection.createStatement();
            System.out.println("disk");
            rs = st.executeQuery(sql);
            System.out.println("disk");
            while (rs.next()) {
                CourseDescription courseDescription = new CourseDescription();
                User teacher=new User();
                courseDescription.setId(rs.getInt(1));
                teacher.setId(rs.getInt(2));
                teacher.setName(rs.getString(3));
                teacher.setSurname(rs.getString(4));
                courseDescription.setTeacher(teacher);
                courseDescription.setCourseName(rs.getString(5));
                courseDescription.setTime(rs.getString(6));
                courseDescription.setNumberOfStudent(rs.getInt(7));
                courseDescription.setStartCourse(rs.getString(8));
                courseDescription.setEndCourse(rs.getString(9));
                courseDescription.setDescription(rs.getString(10));
                return courseDescription;
            }


        } catch (ConnectionPoolException | SQLException e) {

            throw new DAOException(e);

        } finally {
            connectionPool.closeConnection(connection,st,rs);
        }
        return null;

    }
}
