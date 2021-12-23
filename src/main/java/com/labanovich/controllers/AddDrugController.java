package com.labanovich.controllers;

import com.labanovich.model.services.CureService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddDrugController", value = "/add_drug")
public class AddDrugController extends HttpServlet {
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
        String cname = request.getParameter("cname");
        String ctype = request.getParameter("ctype");
        String count = request.getParameter("count");
        String country = request.getParameter("country");
        String delDate = request.getParameter("cDate");
        String cost = request.getParameter("cost");

        cureService.add(cname,count, delDate, "", ctype, cost, country);
        request.getRequestDispatcher("/admin_panelAllDrugs.jsp")
                .forward(request, response);
    }
}
