package com.labanovich.model.dao.impl;

import com.labanovich.constants.SqlConstants;
import com.labanovich.model.dao.interfaces.BasketDAO;
import com.labanovich.model.db.ConnectionManager;
import com.labanovich.model.entities.Cure;
import com.labanovich.model.exceptions.DAOException;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLBasketImpl implements BasketDAO {
    @Override
    public void deleteById(int id) throws DAOException {
        try (var connection = ConnectionManager.open();
             var ps = connection.prepareStatement(SqlConstants.DELETE_CURE_FROM_BASKET)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public void add(int userId, int cureId) throws DAOException {
        try (var connection = ConnectionManager.open();
             PreparedStatement ps = connection.prepareStatement(SqlConstants.ADD_NEW_CURE_INTO_BASKET)) {
            ps.setInt(1, userId);
            ps.setInt(2, cureId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }


    @Override
    public List<Cure> getAllByuUerId(int userId) throws DAOException {
        List<Cure> cures = new ArrayList<>();
        try (var connection = ConnectionManager.open();
             var ps = connection.prepareStatement(SqlConstants.GET_ALL_CURES_FROM_BASKET)) {
            ps.setInt(1, userId);
            var resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String type = resultSet.getString("type");
                String dose = resultSet.getString("dose");
                String deliveryTime = resultSet.getString("delivery_time");
                String description = resultSet.getString("description");
                double price = resultSet.getDouble("price");
                int basketCureId = resultSet.getInt("basket_cure_id");
                Cure cure = new Cure(id, name, type, dose, deliveryTime, description, price, basketCureId);

                cures.add(cure);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return cures;
    }
}
