package com.labanovich.model.services;

import com.labanovich.model.dao.impl.MySQLBasketImpl;
import com.labanovich.model.entities.Cure;
import com.labanovich.model.exceptions.DAOException;
import com.labanovich.model.exceptions.ServiceException;

import java.util.List;

public class BasketService {
    private MySQLBasketImpl mySQLBasket;

    public BasketService() {
        this.mySQLBasket = new MySQLBasketImpl();
    }

    public void add(String userID, String cureID) throws ServiceException {
        int uID = Integer.parseInt(userID);
        int cID = Integer.parseInt(cureID);
        try {
            mySQLBasket.add(uID, cID);
        } catch (DAOException | NumberFormatException e) {
            throw new ServiceException(e);
        }
    }

    public List<Cure> getAllByUserId(String userID) throws ServiceException {
        int uID = Integer.parseInt(userID);
        try {
            return mySQLBasket.getAllByuUerId(uID);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public void deleteById(String id) throws ServiceException {
        int cureId = Integer.parseInt(id);
        System.out.println(cureId);
        try {
            mySQLBasket.deleteById(cureId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }


}
