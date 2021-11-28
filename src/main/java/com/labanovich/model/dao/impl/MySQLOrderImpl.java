package com.labanovich.model.dao.impl;

import com.labanovich.constants.SqlConstants;
import com.labanovich.model.dao.interfaces.OrderDAO;
import com.labanovich.model.db.ConnectionManager;
import com.labanovich.model.entities.Cure;
import com.labanovich.model.entities.Order;
import com.labanovich.model.exceptions.DAOException;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class MySQLOrderImpl implements OrderDAO {
    @Override
    public List<Order> getAll() throws DAOException {
        List<Order> orders = new ArrayList<>();
        try (var connection = ConnectionManager.open();
             PreparedStatement ps = connection.prepareStatement(SqlConstants.GET_ALL_ORDERS)) {
            var rs = ps.executeQuery();
            int id = rs.getInt("id");
            String initials = rs.getString("user_initials");
            String email = rs.getString("user_email");
            double total = rs.getDouble("total");
            Timestamp orderDate = rs.getTimestamp("order_time");
            Order order = new Order(id, initials, email, total, orderDate);
            orders.add(order);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }
}
