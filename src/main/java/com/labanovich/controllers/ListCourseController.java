package com.labanovich.controllers;

import com.labanovich.constants.AppConstant;
import com.labanovich.model.dao.impl.MySQLCourseDAOImpl;
import com.labanovich.model.dao.interfaces.CourseDAO;
import com.labanovich.model.entities.Course;
import com.labanovich.model.exceptions.ServiceException;
import com.labanovich.model.services.CourseService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListCourseController", value = "/qwe")
public class ListCourseController extends HttpServlet {
    private CourseService courseService;

    @Override
    public void init() throws ServletException {
        courseService = new CourseService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Course> courses = null;
        try {
            courses = courseService.getAll();
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        request.setAttribute("courses", courses);

    }

}
