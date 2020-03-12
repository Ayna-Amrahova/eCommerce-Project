package servlet;

import DAO.DB;
import java.io.IOException;
import java.util.List;
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

        String sortBy = request.getParameter("sortBy");
        List<Product> products = db.getProducts(sortBy);

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
        db.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");

    }
}
