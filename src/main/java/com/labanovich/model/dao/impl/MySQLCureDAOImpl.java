package com.labanovich.model.dao.impl;

import com.labanovich.constants.SqlConstants;
import com.labanovich.model.dao.interfaces.CureDAO;
import com.labanovich.model.db.ConnectionManager;
import com.labanovich.model.entities.Cure;
import com.labanovich.model.exceptions.DAOException;

import java.sql.SQLException;
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


}
