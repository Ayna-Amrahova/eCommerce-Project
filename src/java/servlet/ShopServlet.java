package servlet;

import DAO.DB;
import java.io.*;

import java.util.*;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.*;
import model.Product;
import model.ProductCategory;

@WebServlet(urlPatterns = {"/ShopServlet"})

public class ShopServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        Cookie[] cookies = request.getCookies();
//        for (Cookie cookie : cookies) {
//            System.out.println(cookie.getName());
//            System.out.println(cookie.getValue());
//        }
        String sortBy = request.getParameter("sortBy");
        String categoryId = request.getParameter("categoryId");
        String prod_name = request.getParameter("productName");
        String prod_price = request.getParameter("productPrice");
//        double actualPrice = Double.valueOf(prod_price);
        System.out.println(prod_name + "-------name");
        System.out.println(prod_price + "-------price");
        DB db = new DB();
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

        db.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");

        PrintWriter pw = response.getWriter();

        String prod_name = request.getParameter("productName");
        String prod_price = request.getParameter("productPrice");
//        double actualPrice = Double.valueOf(prod_price);
        System.out.println(prod_name + "-------name");
        System.out.println(prod_price + "-------price");

        DB db = new DB();
//        db.saveProducts(prod_name, actualPrice);
//        PreparedStatement ps;
//        try {
//            String connectionURL = "jdbc:mysql://localhost:3306/travel_and_shop?useEncoding=true&characterEncoding-UTF8", username, password;
//
//            Connection connection = null;
//            ResultSet rs;
//            Class.forName("com.mysql.jdbc.Driver");
//            connection = DriverManager.getConnection(connectionURL, "root", "123456");
//
//            ps = connection.prepareStatement("insert into selected_products(name, actual_price) values (?, ?)");
//            ps.setString(1, prod_name);
//            ps.setDouble(2, actualPrice);
//            ps.execute();
//            rs = ps.getResultSet();
//
//        } catch (Exception ex) {
//            System.out.println(ex.toString());
//
//        }
    }
}
