package com.labanovich.model.dao.impl;

import com.labanovich.constants.SqlConstants;
import com.labanovich.model.dao.interfaces.UserDAO;
import com.labanovich.model.db.ConnectionManager;
import com.labanovich.model.entities.User;
import com.labanovich.model.exceptions.DAOException;

import java.sql.*;


public class MySQLUserDAOImpl implements UserDAO {
    @Override
    public User get(String login, String password) throws DAOException {
        User user = null;
        try (var connection = ConnectionManager.open();
             var preparedStatement = connection.prepareStatement(SqlConstants.GET_USER_BY_LOGIN)) {
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            var resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int uId = resultSet.getInt("id");
                String uLogin = resultSet.getString("login");
                String uName = resultSet.getString("name");
                String uSurname = resultSet.getString("surname");
                String uEmail = resultSet.getString("email");
                user = new User(uId, uLogin, uName, uSurname, uEmail);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }

        return user;
    }

    @Override
    public boolean save(User user, String password) throws DAOException {
        boolean isSave = false;
        try (var open = ConnectionManager.open();
             PreparedStatement preparedStatement = open.prepareStatement(SqlConstants.INSERT_NEW_USER, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getSurname());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, password);

            isSave = preparedStatement.executeUpdate() > 0;
            if (isSave) {
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    user.setId(id);
                }
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return isSave;
    }

    @Override
    public User getById(int id) throws DAOException {
        User user = null;
        try (var connection = ConnectionManager.open();
             PreparedStatement ps = connection.prepareStatement(SqlConstants.GET_USER_BY_ID)) {
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()) {
                int uId = resultSet.getInt("id");
                String uLogin = resultSet.getString("login");
                String uName = resultSet.getString("name");
                String uSurname = resultSet.getString("surname");
                String uEmail = resultSet.getString("email");
                user = new User(uId, uLogin, uName, uSurname, uEmail);
            }
        } catch (SQLException e) {
            throw new DAOException();
        }
        return user;
    }

    @Override
    public void editUserById(int id, String name, String surname, String email) throws DAOException {
        try (var connection = ConnectionManager.open();
             PreparedStatement ps = connection.prepareStatement(SqlConstants.EDIT_USER)) {
            ps.setString(1, name);
            ps.setString(2, surname);
            ps.setString(3, email);
            ps.setInt(4, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
}
