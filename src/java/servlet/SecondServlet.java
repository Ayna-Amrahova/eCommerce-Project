package servlet;

import DAO.DB;
import java.io.*;

import java.util.*;


import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.*;
import model.Product;

@WebServlet(urlPatterns = {"/SecondServlet"})

public class SecondServlet extends HttpServlet {

    private ServletConfig config;

    String page2 = "second.jsp";

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        DB db = new DB();
        List<Product> selectedProducts = db.getSelectedProducts();

        request.setAttribute("selectedProducts", selectedProducts);

        RequestDispatcher dispatcher = request.getRequestDispatcher(page2);
        if (dispatcher != null) {
            dispatcher.forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");

        PrintWriter pw = response.getWriter();

        String name = request.getParameter("name");
        String price = request.getParameter("price");
        double actualPrice = Double.valueOf(price);

        DB db = new DB();
        db.saveProducts(name, actualPrice);

        System.out.println(name);
        System.out.println(price);

        if (name.equals("") && price.equals("")) {
            pw.print("{\"error\" : \"false\"}");
        } else {
            pw.print("{\"success\" : \"true\"}");
        }

    }

}
