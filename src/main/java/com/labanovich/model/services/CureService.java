package com.labanovich.model.services;

import com.labanovich.model.dao.impl.MySQLCureDAOImpl;
import com.labanovich.model.dao.interfaces.CureDAO;
import com.labanovich.model.entities.Cure;
import com.labanovich.model.entities.Type;
import com.labanovich.model.exceptions.DAOException;
import com.labanovich.model.exceptions.ServiceException;

import java.sql.Timestamp;
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

    public boolean add(String name, String dose, String deliveryTime,
                       String description, String typeId, String price, String country) {
        int tId = Integer.parseInt(typeId);
        double cPr = Double.parseDouble(price);
        return cureDAO.add(name, dose, deliveryTime, description, tId, cPr, country);
    }

    public boolean delete(String id) {
        int cId = Integer.parseInt(id);
        return cureDAO.delete(cId);
    }

    public List<Cure> getAllUserAdmin(String id, String timestamp) {
        return cureDAO.getAdminUser(Integer.parseInt(id), Timestamp.valueOf(timestamp));
    }

    public List<Type> getAllTypes() {
        return cureDAO.getAllTypes();
    }

    public boolean edit(String id, String name, String dose, String deliveryTime,
                        String description, String typeId, String price, String country) {
        int cid = Integer.parseInt(id);
        double v = Double.parseDouble(price);
        int tId = Integer.parseInt(typeId);
        return cureDAO.edit(cid, name, dose, deliveryTime, description, tId, v, country);
    }

}
