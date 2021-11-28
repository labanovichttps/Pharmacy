package com.labanovich.model.services;

import com.labanovich.model.dao.impl.MySQLOrderImpl;
import com.labanovich.model.entities.Order;
import com.labanovich.model.exceptions.DAOException;
import com.labanovich.model.exceptions.ServiceException;

import java.util.List;

public class OrderService {
    private MySQLOrderImpl mySQLOrder;

    public OrderService(MySQLOrderImpl mySQLOrder) {
        this.mySQLOrder = mySQLOrder;
    }

    public List<Order> getAll() throws ServiceException {
        try {
            return mySQLOrder.getAll();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
