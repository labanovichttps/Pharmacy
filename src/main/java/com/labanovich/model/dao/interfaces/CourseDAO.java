package com.labanovich.model.dao.interfaces;

import com.labanovich.model.entities.Course;
import com.labanovich.model.exceptions.DAOException;

import java.util.List;

public interface CourseDAO {
    List<Course> getBySection(String section) throws DAOException;
    List<Course> getAll() throws DAOException;
}
