package com.labanovich.controllers;

import com.labanovich.model.entities.Cure;
import com.labanovich.model.exceptions.ServiceException;
import com.labanovich.model.services.CureService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EditCureController", value = "/edit_cure")
public class EditCureController extends HttpServlet {
    private CureService cureService;

    @Override
    public void init() throws ServletException {
        cureService = new CureService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cure c = null;
        try {
            List<Cure> all = cureService.getAll();
             c = all.stream()
                    .filter(cure -> cure.getId() == Integer.parseInt(request.getParameter("cureId")))
                    .findFirst()
                    .get();
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        request.setAttribute("cureEdit", c);
        request.getRequestDispatcher("/changingDrug.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idC = request.getParameter("idC");
        String cname = request.getParameter("cname");
        String ctype = request.getParameter("ctype");
        String count = request.getParameter("count");
        String country = request.getParameter("country");
        String delDate = request.getParameter("cDate");
        String cost = request.getParameter("cost");


        cureService.edit(idC, cname,count, delDate, "", ctype, cost, country);
        request.getRequestDispatcher("/admin_panelAllDrugs.jsp")
                .forward(request, response);
    }
}
