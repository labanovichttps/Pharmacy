package com.labanovich.model.dao.interfaces;

import com.labanovich.model.entities.Order;
import com.labanovich.model.exceptions.DAOException;

import java.util.List;

public interface OrderDAO {
    List<Order> getAll() throws DAOException;
    boolean place(int id);
    List<Order> getByUserId(int id);
}
