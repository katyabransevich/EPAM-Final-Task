package by.epam.finaltask.facultative.dao;


import by.epam.finaltask.facultative.dao.impl.*;

public class DAOFactory {
    private static OperationWithCourseDAO operationWithCourseDAO = new OperationWithCourseDAOImpl();
    private static UserDAO userDAO= new UserDAOImpl();
    private static GroupStudentDAO groupStudentDAO = new GroupStudentDAOImpl();
    private static SubjectsForUserDAO subjectsForUserDAO= new SubjectsForUserDOAImpl();
    private static UpdateContextTableStudentDAO updateContextTableStudentDAO = new UpdateContextTableStudentDAOImpl();

    public static OperationWithCourseDAO getOperationWithCourseDAO() {
        return operationWithCourseDAO;
    }


    public static GroupStudentDAO getGroupStudentDAO() {
        return groupStudentDAO;
    }

    public static SubjectsForUserDAO getSubjectsForUserDAO() {
        return subjectsForUserDAO;
    }


    public static UpdateContextTableStudentDAO getUpdateContextTableStudentDAO() {
        return updateContextTableStudentDAO;
    }

    public static UserDAO getUserDAO() {
        return userDAO;
    }
}
