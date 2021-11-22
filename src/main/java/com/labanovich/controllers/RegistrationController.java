package com.labanovich.controllers;

import com.labanovich.constants.AppConstant;
import com.labanovich.model.entities.User;
import com.labanovich.model.exceptions.ServiceException;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "RegistrationController", value = AppConstant.REGISTRATION_CONTROLLER)
public class RegistrationController extends AbstractController {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter(AppConstant.NAME_LABEL);
        String surname = request.getParameter(AppConstant.SURNAME_LABEL);
        String login = request.getParameter(AppConstant.LOGIN_LABEL);
        String email = request.getParameter(AppConstant.EMAIL_LABEL);
        String password = request.getParameter(AppConstant.PASSWORD_LABEL);

        try {
            User user = userService.registration(name, surname, email, login, password);
            if (Objects.nonNull(user)) {
                HttpSession session = request.getSession();
                session.setAttribute(AppConstant.USER_ATTR, user);
                redirect(request, response, AppConstant.LOGIN_JSP);
            } else {
                jumpMessage(request, response, AppConstant.REGISTRATION_JSP, AppConstant.INVALID_REGISTRATION_MESSAGE);
            }
        } catch (ServiceException e) {
            e.printStackTrace();
            jumpMessage(request, response, AppConstant.REGISTRATION_JSP, AppConstant.INVALID_REGISTRATION_MESSAGE);
        }
    }
}
