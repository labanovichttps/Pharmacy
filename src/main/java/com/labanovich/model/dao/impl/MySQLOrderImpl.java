package com.labanovich.model.dao.impl;

import com.labanovich.constants.SqlConstants;
import com.labanovich.model.dao.interfaces.OrderDAO;
import com.labanovich.model.db.ConnectionManager;
import com.labanovich.model.entities.Cure;
import com.labanovich.model.entities.Order;
import com.labanovich.model.exceptions.DAOException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLOrderImpl implements OrderDAO {
    @Override
    public List<Order> getAll() throws DAOException {
        List<Order> orders = new ArrayList<>();
        try (var connection = ConnectionManager.open();
             PreparedStatement ps = connection.prepareStatement(SqlConstants.GET_ALL_ORDERS)) {
            var rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int user_id = rs.getInt("user_id");
                String initials = rs.getString("user_initials");
                String email = rs.getString("user_email");
                double total = rs.getDouble("total");
                Timestamp orderDate = rs.getTimestamp("order_time");
                Order order = new Order(id, user_id ,initials, email, total, orderDate);
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public boolean place(int id) {
        boolean isAdded = false;
        try (var connection = ConnectionManager.open();
             var ps1 = connection.prepareStatement(SqlConstants.PLACE_THE_ORDER1);
             var ps2 = connection.prepareStatement(SqlConstants.PLACE_THE_ORDER2);
             var ps3 = connection.prepareStatement(SqlConstants.PLACE_THE_ORDER3);
             var ps4 = connection.prepareStatement(SqlConstants.PLACE_THE_ORDER4)) {
            ps1.setInt(1, id);
            ps2.setInt(1, id);
            ps3.setInt(1, id);
            ps4.setInt(1, id);
            isAdded = ps1.executeUpdate() == 1;
            isAdded = ps2.executeUpdate() == 1;
            isAdded = ps3.executeUpdate() == 1;
            isAdded = ps4.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isAdded;
    }

    @Override
    public List<Order> getByUserId(int id) {
        List<Order> orders = new ArrayList<>();
        try (var connection = ConnectionManager.open();
             var ps = connection.prepareStatement(SqlConstants.GET_ORDERS_BY_ID)) {
            ps.setInt(1, id);
            var rs = ps.executeQuery();
            while (rs.next()){
                int oId = rs.getInt("id");
                int user_id = rs.getInt("user_id");
                String userInitials = rs.getString("user_initials");
                String userEmail = rs.getString("user_email");
                double total = rs.getDouble("total");
                Timestamp order_time = rs.getTimestamp("order_time");
                Order order = new Order(oId, user_id, userInitials, userEmail, total, order_time);
                orders.add(order);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return orders;
    }
}
