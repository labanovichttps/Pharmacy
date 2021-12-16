package com.labanovich.model.dao.impl;

import com.labanovich.constants.SqlConstants;
import com.labanovich.model.dao.interfaces.CureDAO;
import com.labanovich.model.db.ConnectionManager;
import com.labanovich.model.entities.Cure;
import com.labanovich.model.exceptions.DAOException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLCureDAOImpl implements CureDAO {


    @Override
    public List<Cure> getAll() throws DAOException {
        List<Cure> cures = new ArrayList<>();
        try (var connection = ConnectionManager.open();
             var ps = connection.prepareStatement(SqlConstants.GET_ALL_CURES)) {
            var resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String type = resultSet.getString("type");
                String dose = resultSet.getString("dose");
                String deliveryTime = resultSet.getString("delivery_time");
                String description = resultSet.getString("description");
                double price = resultSet.getDouble("price");
                Cure cure = new Cure(id, name, type, dose, deliveryTime, description, price);
                cures.add(cure);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DAOException(e);
        }

        return cures;
    }

    @Override
    public boolean add(String name, String dose, String deliveryTime, String description, int typeId, double price) {
        boolean isAdded = false;
        try (var connection = ConnectionManager.open();
             var ps = connection.prepareStatement(SqlConstants.ADD_NEW_CURE)) {
            ps.setString(1, name);
            ps.setString(2, dose);
            ps.setString(3, deliveryTime);
            ps.setString(4, description);
            ps.setInt(5, typeId);
            ps.setDouble(6, price);
            isAdded = ps.executeUpdate() == 1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return isAdded;
    }


    @Override
    public boolean delete(int id) {
        boolean isDeleted = false;
        try (var connection = ConnectionManager.open();
             var ps = connection.prepareStatement(SqlConstants.DELETE_CURE)) {
            ps.setInt(1, id);
            isDeleted = ps.executeUpdate() == 1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return isDeleted;
    }

    @Override
    public List<Cure> getAdminUser(int id, Timestamp orderTime) {
        List<Cure> cures = new ArrayList<>();
        try (var connection = ConnectionManager.open();
             var ps = connection.prepareStatement(SqlConstants.GET_ADMIN_USER_ORDERS)) {
            ps.setInt(1, id);
            ps.setTimestamp(2, orderTime);
            var rs = ps.executeQuery();
            while (rs.next()) {
                int id1 = rs.getInt("id");
                String type = rs.getString("type");
                String name = rs.getString("name");
                String dose = rs.getString("dose");
                String description = rs.getString("description");
                double price = rs.getDouble("price");
                String deliveryTime = rs.getString("delivery_time");
                Cure cure = new Cure(id1, name, type, dose, deliveryTime, description, price);
                cures.add(cure);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(cures);
        return cures;
    }


}
