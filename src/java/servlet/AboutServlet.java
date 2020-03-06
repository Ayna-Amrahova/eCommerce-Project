package servlet;

import DAO.DB;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.About;

public class AboutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DB db = new DB();
        List<About> about = db.getAbout();
        request.setAttribute("about", about);

        RequestDispatcher dispatcher = request.getRequestDispatcher("about.jsp");
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
