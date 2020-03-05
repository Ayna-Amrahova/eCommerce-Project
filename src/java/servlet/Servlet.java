package servlet;

import DAO.DB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product;

@WebServlet(urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {

    String name;
    String price;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.setContentType("text/html;charset=UTF-8");

        String name = request.getParameter("name");
        String price = request.getParameter("price");

        Cookie cookie1 = new Cookie("name", name);
        Cookie cookie2 = new Cookie("price", price);

        response.addCookie(cookie1);
        response.addCookie(cookie2);

        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName());
            System.out.println(cookie.getValue());
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");

        PrintWriter pw = response.getWriter();

        name = request.getParameter("name");
        price = request.getParameter("price");

        System.out.println(name);
        System.out.println(price);

        if (name.equals("") && price.equals("")) {
            pw.print("{\"error\" : \"false\"}");
        } else {
            processRequest(request, response);
            pw.print("{\"success\" : \"true\"}");
        }

    }

}
