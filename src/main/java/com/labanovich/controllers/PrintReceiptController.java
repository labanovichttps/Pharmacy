package com.labanovich.controllers;

import com.labanovich.model.entities.Cure;
import com.labanovich.model.entities.Order;
import com.labanovich.model.exceptions.ServiceException;
import com.labanovich.model.services.CureService;
import com.labanovich.model.services.OrderService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.List;

@WebServlet(name = "PrintReceiptController", value = "/print_receipt")
public class PrintReceiptController extends HttpServlet {
    private OrderService orderService;
    private CureService cureService;

    @Override
    public void init() throws ServletException {
        orderService = new OrderService();
        cureService = new CureService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idForPrint = request.getParameter("order_print");
        List<Order> order = null;
        try {
            order = orderService.getAll();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        Timestamp date = Timestamp.valueOf(request.getParameter("ordDate"));
        Order ordera = order.stream()
                .filter(ord -> ord.getId() == Integer.parseInt(idForPrint))
                .findFirst()
                .get();
        System.out.println(ordera);
        List<Cure> allUserAdmin = cureService.getAllUserAdmin(request.getParameter("user_admin_order"), date.toString());
        Path newFilePath = Paths.get("/Users/tsimafeilabanovich/Documents/Projects/TRPO PRJECT/Pharmacy/src/main/resources/word/" + LocalTime.now() + ".txt");
        Files.createFile(newFilePath);
        Files.writeString(newFilePath, "ЗАКАЗ\n" +
                                       ordera + "\n" + "содержит заказы " + allUserAdmin + "\n" + ordera.getTotal());
        request.getRequestDispatcher("/")
                .forward(request, response);
    }
}
