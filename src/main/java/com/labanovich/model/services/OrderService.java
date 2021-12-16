package com.labanovich.model.services;

import com.labanovich.model.dao.impl.MySQLOrderImpl;
import com.labanovich.model.dao.interfaces.OrderDAO;
import com.labanovich.model.entities.Order;
import com.labanovich.model.exceptions.DAOException;
import com.labanovich.model.exceptions.ServiceException;

import java.util.List;

public class OrderService {
    private OrderDAO mySQLOrder = new MySQLOrderImpl();


    public List<Order> getAll() throws ServiceException {
        try {
            return mySQLOrder.getAll();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public boolean place(String id){
        return mySQLOrder.place(Integer.parseInt(id));
    }

    public List<Order> getByUserId(String id){
        return mySQLOrder.getByUserId(Integer.parseInt(id));
    }





}
