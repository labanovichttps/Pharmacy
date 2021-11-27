package com.labanovich.model.dao.interfaces;

import com.labanovich.model.entities.Cure;
import com.labanovich.model.exceptions.DAOException;

import java.util.List;

public interface CureDAO {
    List<Cure> getAll() throws DAOException;
}
