package servlet;

import DAO.DB;
import java.io.*;

import java.util.*;

import java.sql.*;

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
        db.close();
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
        System.out.println(name);

        System.out.println(price);

        if (name.equals("") && price.equals("")) {
            pw.print("{\"error\" : \"false\"}");
        } else {
            pw.print("{\"success\" : \"true\"}");
        }

        PreparedStatement ps;
        try {
            String connectionURL = "jdbc:mysql://localhost:3306/travel_and_shop?useEncoding=true&characterEncoding-UTF8", username, password;

            Connection connection = null;
            ResultSet rs;
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(connectionURL, "root", "123456");

            ps = connection.prepareStatement("insert into selected_products(name, actual_price) values (?, ?)");
            ps.setString(1, name);
            ps.setDouble(2, actualPrice);
            ps.execute();
            rs = ps.getResultSet();

        } catch (Exception ex) {
            System.out.println(ex.toString());

        }

        Cookie cookie1 = new Cookie(name, price);
//        Cookie cookie2 = new Cookie("actualPrice", price);

        cookie1.setPath("/MatrixProject");
        response.addCookie(cookie1);
//
//        cookie2.setPath("/MatrixProject");
//        response.addCookie(cookie2);
    }
}
