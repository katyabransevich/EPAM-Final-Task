package by.epam.finaltask.facultative.dao;

import by.epam.finaltask.facultative.dao.exception.DAOException;

/**
 * Created by Admin on 01.06.2016.
 */
public interface UpdateContextTableStudent {
    public void updateComment (String comment ,int idStudent, int idSubject) throws DAOException ;
    public void updateMark (int mark ,int idStudent, int idSubject) throws DAOException ;
}
