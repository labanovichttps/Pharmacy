package com.labanovich.model.services;

import com.labanovich.model.dao.impl.MySQLUserDAOImpl;
import com.labanovich.model.dao.interfaces.UserDAO;
import com.labanovich.model.entities.User;
import com.labanovich.model.exceptions.DAOException;
import com.labanovich.model.exceptions.ServiceException;

public class UserService {
    private UserDAO userDAO;

    public UserService() {
        this.userDAO = new MySQLUserDAOImpl();
    }

    public User authorisation(String login, String password) throws ServiceException {
        try {
            return userDAO.get(login, password);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public User registration(String name, String surname, String email,
                             String login, String password) throws ServiceException {
        User user = new User(login, name, surname, email);
        try {
            if (!userDAO.save(user, password)) {
                user = null;
            }
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        return user;
    }

    public void edit(int id, String name, String surname, String email) throws ServiceException {
        try {
            userDAO.editUserById(id, name, surname, email);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public User getById(int id) throws ServiceException {
        try {
            return userDAO.getById(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

}
