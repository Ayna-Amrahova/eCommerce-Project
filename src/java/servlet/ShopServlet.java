package servlet;

import DAO.DB;
import java.io.*;

import java.util.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.*;
import model.Product;
import model.ProductCategory;

@WebServlet(urlPatterns = {"/ShopServlet"})

public class ShopServlet extends HttpServlet {

    DB db = new DB();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String sortBy = request.getParameter("sortBy");
        String categoryId = request.getParameter("categoryId");
        List<ProductCategory> category = db.getProductCategories();
        List<Product> products;

        if (categoryId == null) {
            products = db.getProducts(sortBy);
        } else {
            products = db.getAllProductByCategoryId(categoryId, sortBy);
        }

        request.setAttribute("products", products);
        request.setAttribute("category", category);
        RequestDispatcher dispatcher = request.getRequestDispatcher("shop.jsp");

        if (dispatcher != null) {
            dispatcher.forward(request, response);
        }

        String msg = request.getParameter("msg");
        if (request.getParameter("msg") != null) {
            if (!(request.getParameter("msg").equals(" "))) {
                try {
                    db.saveChat(msg);
                } catch (Exception ex) {
                    Logger.getLogger(HomeServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        String prod_name = request.getParameter("productName");
        String prod_price = request.getParameter("productPrice");
        String prod_img = request.getParameter("productImage");
        double actualPrice = Double.valueOf(prod_price);
        System.out.println(prod_name + "  ///  " + prod_price);
        System.out.println(prod_name + "  ///  " + prod_price + " ///  " + prod_img);
        if (prod_name != null && prod_price != null && prod_img != null) {
            try {
                System.out.println(prod_name + "  ///  " + prod_price + " ///  " + prod_img);
                db.saveProducts(prod_img, prod_name, actualPrice);
            } catch (Exception ex) {
                Logger.getLogger(ShopServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
