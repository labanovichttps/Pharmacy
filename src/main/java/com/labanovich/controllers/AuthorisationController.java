package com.labanovich.controllers;

import com.labanovich.constants.AppConstant;
import com.labanovich.model.entities.User;
import com.labanovich.model.exceptions.ServiceException;
import com.labanovich.model.services.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "AuthorisationController", value = AppConstant.AUTHORIZATION_CONTROLLER)
public class AuthorisationController extends AbstractController {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter(AppConstant.LOGIN_LABEL);
        String password = request.getParameter(AppConstant.PASSWORD_LABEL);
        try {
            User user = userService.authorisation(login, password);
            if (Objects.nonNull(user)) {
                HttpSession session = request.getSession();
                session.setAttribute(AppConstant.USER_ATTR, user);
                session.setAttribute("userID", user.getId());
                redirect(request, response, AppConstant.INDEX_JSP);
            } else {
                jumpMessage(request, response, AppConstant.LOGIN_JSP, AppConstant.INVALID_AUTH_MESSAGE);
            }
        } catch (ServiceException e) {
            e.printStackTrace();
            jumpMessage(request, response, AppConstant.LOGIN_JSP, e.getMessage());
        }


    }
}
