package servlet;

import DAO.DB;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Home;
import model.Product;

public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DB db = new DB();

        List<Product> products = db.getProductsByCatId();

        request.setAttribute("products", products);

        List<Home> home = db.getHome();
        request.setAttribute("home", home);

        List<Home> homeFooter = db.getHomeFooter();
        request.setAttribute("homeFooter", homeFooter);

        List<Home> homeMiddle = db.getHomeMiddle();
        request.setAttribute("homeMiddle", homeMiddle);

        RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
        if (dispatcher != null) {
            dispatcher.forward(request, response);
        }

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println(username + " uname /// pass " + password);
        if (request.getParameter("username") != null && request.getParameter("password") != null) {
            if (!(request.getParameter("username").equals(" ")) && !(request.getParameter("password").equals(" "))) {
                try {
                    db.saveUser(username, password);
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(HomeServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        db.checkLogin(username, password);

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
        DB db = new DB();
        PrintWriter pw = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (request.getParameter("username") != null && request.getParameter("password") != null) {
            if (!(request.getParameter("username").equals(" ")) && !(request.getParameter("password").equals(" "))) {
                try {
                    db.saveUser(username, password);
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(HomeServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        db.checkLogin(username, password);

    }
}
