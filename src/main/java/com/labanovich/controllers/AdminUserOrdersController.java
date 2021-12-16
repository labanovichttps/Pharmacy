package com.labanovich.controllers;

import com.labanovich.model.entities.Cure;
import com.labanovich.model.entities.Order;
import com.labanovich.model.exceptions.ServiceException;
import com.labanovich.model.services.BasketService;
import com.labanovich.model.services.CureService;
import com.labanovich.model.services.OrderService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminUserOrdersController", value = "/admin_user_orders")
public class AdminUserOrdersController extends HttpServlet {
    private CureService cureService;

    @Override
    public void init() throws ServletException {
        cureService = new CureService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user_admin_order = request.getParameter("user_admin_order");
        String orderDate = request.getParameter("ordDate");
        List<Cure> userAdminOrders = cureService.getAllUserAdmin(user_admin_order, orderDate);
        request.getSession().setAttribute("userAdminOrders", userAdminOrders);
        request.getRequestDispatcher("/adminMore.jsp")
                .forward(request, response);
    }
}
