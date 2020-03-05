package servlet;

import DAO.DB;
import java.io.*;

import java.util.*;

import java.sql.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.*;
import model.Product;
import model.SelectedProducts;

@WebServlet(urlPatterns = {"/SecondServlet"})

public class SecondServlet extends HttpServlet {

    private ServletConfig config;

    String page2 = "second.jsp";

    public void init(ServletConfig config)
            throws ServletException {

        this.config = config;

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        DB db = new DB();
//        List<SelectedProducts> selectedProducts = db.getSelectedProducts();
//        request.setAttribute("selectedProducts", selectedProducts);
//
//        RequestDispatcher dispatcher = request.getRequestDispatcher(page2);
//        if (dispatcher != null) {
//            dispatcher.forward(request, response);
//        }

        PrintWriter out = response.getWriter();
        String connectionURL = "jdbc:mysql://localhost:3306/travel_and_shop?useEncoding=true&characterEncoding-UTF8", username, password;

        Connection connection = null;
        ResultSet rs;
        response.setContentType("text/html");

        List selectedProducts = new ArrayList();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(connectionURL, "root", "123456");
            String sql = "select * from selected_products";
            Statement s = connection.createStatement();
            s.executeQuery(sql);
            rs = s.getResultSet();
            while (rs.next()) {
                selectedProducts.add(rs.getInt("id"));
                selectedProducts.add(rs.getString("name"));
                selectedProducts.add(rs.getDouble("actual_price"));
            }
            rs.close();
            s.close();
        } catch (Exception e) {
            System.out.println("Exception is ;" + e);
        }
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
//        String imgPath = request.getParameter("imgPath");
        double actualPrice = Double.valueOf(price);
        System.out.println(name);

        System.out.println(price);

//        System.out.println(imgPath);
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
//            ps.setString(3, imgPath);
            ps.execute();
            rs = ps.getResultSet();

        } catch (Exception ex) {
            System.out.println(ex.toString());

        }
    }

}
