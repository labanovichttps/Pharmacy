package com.labanovich.controllers;

import com.labanovich.model.entities.Type;
import com.labanovich.model.services.CureService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AllTypesController", value = "/all_types")
public class AllTypesController extends HttpServlet {
    private CureService cureService;

    @Override
    public void init() throws ServletException {
        cureService = new CureService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Type> types = cureService.getAllTypes();
        request.setAttribute("types", types);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
