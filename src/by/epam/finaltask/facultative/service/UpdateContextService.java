package by.epam.finaltask.facultative.service;

import by.epam.finaltask.facultative.dao.DAOFactory;
import by.epam.finaltask.facultative.dao.UpdateContextTableStudentDAO;
import by.epam.finaltask.facultative.dao.exception.DAOException;
import by.epam.finaltask.facultative.service.exception.ServiceException;

public class UpdateContextService {
    public final static void checkCommentField(String comment ,int idStudent, int idSubject) throws ServiceException {
        if (!Validator.validateComment(comment)){
            throw new ServiceException("Invalid comment");
        }
        UpdateContextTableStudentDAO update = DAOFactory.getUpdateContextTableStudentDAO();
        try {
            update.updateComment(comment,idStudent,idSubject);

        } catch (DAOException e) {
            throw new ServiceException("Error access database",e);
        }

    }
    public final static void checkMarkField(String mark ,int idStudent, int idSubject) throws ServiceException {
        if (!Validator.validateMark(mark)){
            throw new ServiceException("Invalid comment");
        }
        UpdateContextTableStudentDAO update = DAOFactory.getUpdateContextTableStudentDAO();
        try {
            update.updateMark(Integer.parseInt(mark),idStudent,idSubject);

        } catch (DAOException e) {
            throw new ServiceException("Error access database",e);
        }

    }

    static class Validator{
        public static boolean validateComment(String comment ){
            if(comment.isEmpty()){
                return false;
            }
          return true;
        }
        public static boolean validateMark(String mark ){
            if(mark.isEmpty()){
                return false;
            }
            try {
                int mark1 =Integer.parseInt(mark);
                if(mark1<0&&mark1>10){
                    return false;
                }
            }catch (Exception e){
                return false;
            }

            return true;
        }
    }
}
