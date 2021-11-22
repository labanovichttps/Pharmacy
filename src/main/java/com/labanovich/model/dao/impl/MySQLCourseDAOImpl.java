package com.labanovich.model.dao.impl;

import com.labanovich.constants.SqlConstants;
import com.labanovich.model.dao.interfaces.CourseDAO;
import com.labanovich.model.db.ConnectionManager;
import com.labanovich.model.entities.Course;
import com.labanovich.model.entities.Status;
import com.labanovich.model.entities.Type;
import com.labanovich.model.exceptions.DAOException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLCourseDAOImpl implements CourseDAO {

    @Override
    public List<Course> getAll() throws DAOException {
        List<Course> courses = new ArrayList<>();
        try (Connection connection = ConnectionManager.open();
             PreparedStatement preparedStatement = connection.prepareStatement(SqlConstants.GET_ALL_COURSES)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String subtitle = resultSet.getString("subtitle");
                String description = resultSet.getString("description");
                Date date = resultSet.getDate("date");
                String place = resultSet.getString("place");
                String author = resultSet.getString("author");
                Status status = switch (resultSet.getInt("status")) {
                    case 0 -> Status.NOT_EXECUTED;
                    case 1 -> Status.EXECUTED;
                    default -> throw new DAOException("Course status not found");
                };
                Type type = switch (resultSet.getString("type")) {
                    case "Conference" -> Type.CONFERENCE;
                    case "Lecture" -> Type.LECTURE;
                    case "Training" -> Type.TRAINING;
                    default -> throw new DAOException("Course type not found");
                };
                int user_id = resultSet.getInt("user_id");
                Course course = new Course(id, title, subtitle, description, date, place, author, status, type, user_id);
                courses.add(course);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }

        return courses;
    }

    @Override
    public List<Course> getBySection(String section) throws DAOException {
        return null;
    }
}
