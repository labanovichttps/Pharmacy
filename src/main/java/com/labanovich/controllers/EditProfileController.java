package com.labanovich.controllers;

import com.labanovich.model.entities.User;
import com.labanovich.model.exceptions.ServiceException;
import com.labanovich.model.services.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditProfileController", value = "/edit")
public class EditProfileController extends AbstractController {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        try {
            userService.edit(user.getId(), name, surname, email);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        User newUser = null;
        try {
            newUser = userService.getById(user.getId());
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        session.setAttribute("user", newUser);
        redirect(request, response, "/Profile.jsp");
    }
}
