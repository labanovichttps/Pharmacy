package com.labanovich.model.services;

import com.labanovich.model.dao.impl.MySQLCourseDAOImpl;
import com.labanovich.model.dao.interfaces.CourseDAO;
import com.labanovich.model.entities.Course;
import com.labanovich.model.exceptions.DAOException;
import com.labanovich.model.exceptions.ServiceException;

import java.util.List;

public class CourseService {
    private CourseDAO courseDAO;

    public CourseService() {
        this.courseDAO = new MySQLCourseDAOImpl();
    }

    public List<Course> getBySection(String section) throws ServiceException {
        try {
            return courseDAO.getBySection(section);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public List<Course> getAll() throws ServiceException {
        try {
            return courseDAO.getAll();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }


}
