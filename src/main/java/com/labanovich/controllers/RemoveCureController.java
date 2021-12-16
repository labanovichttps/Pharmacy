package com.labanovich.controllers;

import com.labanovich.model.services.CureService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RemoveCureController", value = "/remove_cure")
public class RemoveCureController extends HttpServlet {
    private CureService cureService;

    @Override
    public void init() throws ServletException {
        cureService = new CureService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cureID = request.getParameter("deleteCureID");
        boolean delete = cureService.delete(cureID);
        request.getRequestDispatcher("/index.jsp")
                .forward(request, response);
    }
}
