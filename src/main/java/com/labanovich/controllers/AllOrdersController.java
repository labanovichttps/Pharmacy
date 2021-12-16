package com.labanovich.controllers;

import com.labanovich.model.entities.Order;
import com.labanovich.model.exceptions.ServiceException;
import com.labanovich.model.services.OrderService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AllOrdersController", value = "/all_orders")
public class AllOrdersController extends HttpServlet {
    private OrderService orderService;

    @Override
    public void init() throws ServletException {
        orderService = new OrderService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Order> adminOrders = orderService.getAll();
            HttpSession session = request.getSession();
            session.setAttribute("adminOrders", adminOrders);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
