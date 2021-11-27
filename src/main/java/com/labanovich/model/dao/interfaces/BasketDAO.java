package com.labanovich.model.dao.interfaces;

import com.labanovich.model.entities.Cure;
import com.labanovich.model.exceptions.DAOException;

import java.util.List;

public interface BasketDAO {
    void deleteById(int id);
    void add(int userId, int cureId) throws DAOException;
    List<Cure> getAllByuUerId(int userId) throws DAOException;
}
