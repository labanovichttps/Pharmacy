package com.labanovich.model.services;

import com.labanovich.model.dao.impl.MySQLCureDAOImpl;
import com.labanovich.model.dao.interfaces.CureDAO;
import com.labanovich.model.entities.Cure;
import com.labanovich.model.exceptions.DAOException;
import com.labanovich.model.exceptions.ServiceException;

import java.util.List;

public class CureService {
    private CureDAO cureDAO;

    public CureService() {
        this.cureDAO = new MySQLCureDAOImpl();
    }



    public List<Cure> getAll() throws ServiceException {
        try {
            return cureDAO.getAll();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }


}
