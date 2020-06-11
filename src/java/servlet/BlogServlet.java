package servlet;

import DAO.DB;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Blog;

@WebServlet(urlPatterns = {"/BlogServlet"})

public class BlogServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DB db = new DB();

        List<Blog> blog = db.getBlog();
        request.setAttribute("blog", blog);

        RequestDispatcher dispatcher = request.getRequestDispatcher("blog.jsp");
        if (dispatcher != null) {
            dispatcher.forward(request, response);
        }

        String msg = request.getParameter("msg");

        if (msg != null) {
            if (!(msg.equals(" "))) {
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

        String comment = request.getParameter("comment");
        String blog_id = request.getParameter("blog_comment_id");
        blog_id = blog_id.replace("comment", "");

        if (comment != null) {
            if (!(comment.equals(" "))) {
                try {
                    response.getWriter().write("{\"inserted\": true}");
                    db.saveComment(comment, Integer.parseInt(blog_id));
                } catch (Exception ex) {
                    response.getWriter().write("{\"inserted\": false}");
                    Logger.getLogger(HomeServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
