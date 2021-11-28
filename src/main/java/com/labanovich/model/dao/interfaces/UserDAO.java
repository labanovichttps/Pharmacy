package com.labanovich.model.dao.interfaces;

import com.labanovich.model.entities.User;
import com.labanovich.model.exceptions.DAOException;

public interface UserDAO {
    User get(String login, String password) throws DAOException;

    boolean save(User user, String password) throws DAOException;

    User getById(int id) throws DAOException;

    void editUserById(int id, String name, String surname, String email) throws DAOException;
}
