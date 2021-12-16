package com.labanovich.controllers;

import com.labanovich.constants.AppConstant;
import com.labanovich.model.exceptions.ServiceException;
import com.labanovich.model.services.BasketService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "DeleteCureFromBasketController", value = "/delete_cure")
public class DeleteCureFromBasketController extends AbstractController {
    private BasketService basketService;

    @Override
    public void init() throws ServletException {
        basketService = new BasketService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("cure_id_for_delete");
        try {
            basketService.deleteById(id);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        jump(request, response, "basket.jsp");
    }
}
