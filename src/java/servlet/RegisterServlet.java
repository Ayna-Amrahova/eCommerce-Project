package servlet;

import DAO.DB;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
        if (dispatcher != null) {
            dispatcher.forward(request, response);
        }
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username + "  ///  " + password);
        DB db = new DB();
        if (request.getParameter("username") != null && request.getParameter("password") != null) {
            if (!(request.getParameter("username").equals("")) && !(request.getParameter("password").equals(""))) {
                try {
                    db.saveUser(username, password);
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        db.checkLogin(username, password);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");

        PrintWriter pw = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        DB db = new DB();
        if (request.getParameter("username") != null && request.getParameter("password") != null) {
            if (!(request.getParameter("username").equals("")) && !(request.getParameter("password").equals(""))) {
                try {
                    db.saveUser(username, password);
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        db.checkLogin(username, password);
    }
}
