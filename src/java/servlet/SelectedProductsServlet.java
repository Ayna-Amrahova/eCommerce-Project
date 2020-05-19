package servlet;

import DAO.DB;
import java.io.*;

import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.*;
import model.Product;

@WebServlet(urlPatterns = {"/SecondServlet"})

public class SelectedProductsServlet extends HttpServlet {

    private ServletConfig config;

    String page2 = "selectedProducts.jsp";

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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


    }

}
