package by.epam.finaltask.facultative.service;

import by.epam.finaltask.facultative.dao.Apply;
import by.epam.finaltask.facultative.dao.exception.DAOException;
import by.epam.finaltask.facultative.dao.impl.ApplyDAOImpl;
import by.epam.finaltask.facultative.service.exception.ServiceException;


public class ApplyService {
    public final static boolean apply(int idStudent, int idSubject) throws ServiceException {

        Apply apply = new ApplyDAOImpl();
        try {
            return apply.apply(idStudent,idSubject);

        } catch (DAOException e) {
            throw new ServiceException("Error access database",e);
        }

    }
}
