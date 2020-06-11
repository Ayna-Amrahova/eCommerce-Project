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
import model.ProductInfo;

@WebServlet(urlPatterns = {"/ShopServlet"})

public class ShopServlet extends HttpServlet {

    DB db = new DB();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String sortBy = request.getParameter("sortBy");
        String categoryId = request.getParameter("categoryId");
        String infoId = request.getParameter("infoId");
        List<ProductCategory> category = db.getProductCategories();
        List<ProductInfo> info = db.getProductInfos();
        List<Product> products = null;

        if (categoryId == null && infoId == null) {
            products = db.getProducts(sortBy);
        } else if (categoryId != null && infoId == null) {
            products = db.getAllProductByCategoryId(categoryId, sortBy);
        } else if (categoryId == null && infoId != null) {
            products = db.getAllProductByInfoId(infoId, sortBy);
        }

        request.setAttribute("products", products);
        request.setAttribute("category", category);
        request.setAttribute("info", info);

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

        String prod_name = request.getParameter("ad");
        String prod_price = request.getParameter("qiymet");
        String prod_img = request.getParameter("shekil");
        double actualPrice = Double.valueOf(prod_price);

        if (prod_name != null && prod_price != null && prod_img != null) {
            try {
                db.saveProducts(prod_img, prod_name, actualPrice);
                response.getWriter().write("{\"inserted\": true}");
            } catch (Exception ex) {
                Logger.getLogger(ShopServlet.class.getName()).log(Level.SEVERE, null, ex);
                response.getWriter().write("{\"inserted\": false}");
            }
        }

    }
}
