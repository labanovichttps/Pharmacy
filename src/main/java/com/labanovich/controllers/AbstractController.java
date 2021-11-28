package com.labanovich.controllers;

import com.labanovich.constants.AppConstant;
import com.labanovich.model.services.UserService;
import com.labanovich.model.util.PropertiesUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AbstractController")
public abstract class AbstractController extends HttpServlet {

    protected void jump(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException {
        request.getRequestDispatcher(url)
                .forward(request, response);
    }

    protected void jumpMessage(HttpServletRequest request, HttpServletResponse response, String url, String message) throws ServletException, IOException {
        request.setAttribute(AppConstant.MESSAGE_ATTR, message);
        jump(request, response, url);
    }

    protected void redirect(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException {
        response.sendRedirect(getServletContext().getContextPath() + url);
    }
}
