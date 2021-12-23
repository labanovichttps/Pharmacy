package com.labanovich.controllers;

import com.labanovich.model.entities.Order;
import com.labanovich.model.entities.User;
import com.labanovich.model.services.OrderService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MyOrdersController", value = "/my_orders")
public class MyOrdersController extends HttpServlet {
    private OrderService orderService;

    @Override
    public void init() throws ServletException {
        orderService = new OrderService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        List<Order> userOrders = orderService.getByUserId(user.getId() + "");
        request.setAttribute("userOrders", userOrders);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
