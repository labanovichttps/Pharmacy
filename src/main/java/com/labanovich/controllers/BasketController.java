package com.labanovich.controllers;

import com.labanovich.constants.AppConstant;
import com.labanovich.model.entities.Cure;
import com.labanovich.model.exceptions.ServiceException;
import com.labanovich.model.services.BasketService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "BasketController", value = "/basket")
public class BasketController extends AbstractController {
    private BasketService basketService;

    @Override
    public void init() throws ServletException {
        basketService = new BasketService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (Objects.isNull(session.getAttribute("userID"))) {
            jumpMessage(request, response, "/basket.jsp", AppConstant.USER_NOT_AUTHORISED);
        } else {
            String userID = String.valueOf(session.getAttribute("userID"));
            String cureID = request.getParameter("cure_id");

            try {
                basketService.add(userID, cureID);
            } catch (ServiceException e) {
                e.printStackTrace();
            }

            jump(request, response, "/");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (Objects.isNull(session.getAttribute("userID"))) {
            jumpMessage(request, response, "/basket.jsp", AppConstant.USER_NOT_AUTHORISED);
        } else {

            String userID = String.valueOf(session.getAttribute("userID"));

            List<Cure> cures = null;
            try {
                cures = basketService.getAllByUserId(userID);
            } catch (ServiceException e) {
                e.printStackTrace();
            }
            session.setAttribute("cures", cures);
            jump(request, response, "/basket.jsp");
        }
    }
}
