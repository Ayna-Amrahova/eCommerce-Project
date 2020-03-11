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
import model.HomeFooter;
import model.HomeMiddle;
import model.Product;

public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String sortBy = request.getParameter("sortBy");
        DB db = new DB();
        List<Home> home = db.getHome();

        List<Product> products = db.getProducts(sortBy);
        request.setAttribute("home", home);
        request.setAttribute("products", products);

        List<HomeFooter> homeFooter = db.getHomeFooter();
        request.setAttribute("homeFooter", homeFooter);

        List<HomeMiddle> homeMiddle = db.getHomeMiddle();
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
