package com.labanovich.controllers;

import com.labanovich.model.entities.Order;
import com.labanovich.model.services.OrderService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserOrdersController", value = "/user_orders")
public class UserOrdersController extends AbstractController {
    private OrderService orderService;

    @Override
    public void init() throws ServletException {
        orderService = new OrderService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String userID = String.valueOf(session.getAttribute("userID"));
        List<Order> userOrders = orderService.getByUserId(userID);
        request.setAttribute("userOrders", userOrders);
        jump(request, response, "/");
    }
}
