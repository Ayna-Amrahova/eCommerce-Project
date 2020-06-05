package servlet;

import DAO.DB;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.ProcessBuilder.Redirect.from;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/ContactServlet"})

public class ContactServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("contact.jsp");
        if (dispatcher != null) {
            dispatcher.forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");

        String name = request.getParameter("ad");
        String email = request.getParameter("mail");
        String subject = request.getParameter("movzu");
        String message = request.getParameter("mesaj");

        
        DB db = new DB();
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

        if (name != null && email != null && subject != null && message != null) {
            try {
                db.saveContact(name, email, subject, message);
                response.getWriter().write("{\"inserted\": true}");
            } catch (Exception ex) {
                System.out.println(ex.toString());
                response.getWriter().write("{\"inserted\": false}");
            }
        }

    }
}
