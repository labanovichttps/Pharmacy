package com.labanovich.controllers;

import com.labanovich.model.entities.Cure;
import com.labanovich.model.exceptions.ServiceException;
import com.labanovich.model.services.CureService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListCureController", value = "/cures")
public class ListCureController extends HttpServlet {
    private CureService cureService;

    @Override
    public void init() throws ServletException {
        cureService = new CureService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Cure> curess = null;
        try {
            curess = cureService.getAll();
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        request.setAttribute("cures", curess);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
