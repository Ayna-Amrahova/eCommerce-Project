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

        String name = request.getParameter("name");
        String toEmail = request.getParameter("email");
        String subject = request.getParameter("subject");
        String message = request.getParameter("message");
        System.out.println(name + "  ///  " + toEmail + "  ///  " + subject + "  ///  " + message);
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

        String fromEmail = "emrahova.a00@gmail.com";
        String username = "emrahova.a00";
        String password = "16071808";

        if (request.getParameter("name") != null && request.getParameter("email") != null
                && request.getParameter("subject") != null && request.getParameter("message") != null) {
            if (!(request.getParameter("name").equals("")) && !(request.getParameter("email").equals(""))
                    && !(request.getParameter("subject").equals("")) && !(request.getParameter("message").equals(""))) {
                try {
                    db.saveContact(name, toEmail, subject, message);

                } catch (Exception ex) {
                    System.out.println(ex.toString());
                }
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");

        PrintWriter pw = response.getWriter();

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String subject = request.getParameter("subject");
        String message = request.getParameter("message");
        System.out.println(name + "  ///  " + email + "  ///  " + subject + "  ///  " + message);
        DB db = new DB();

        if (request.getParameter("name") != null && request.getParameter("email") != null
                && request.getParameter("subject") != null && request.getParameter("message") != null) {
            if (!(request.getParameter("name").equals("")) && !(request.getParameter("email").equals(""))
                    && !(request.getParameter("subject").equals("")) && !(request.getParameter("message").equals(""))) {
                try {
                    db.saveContact(name, email, subject, message);

                } catch (Exception ex) {
                    System.out.println(ex.toString());
                }
            }
        }
        System.out.println(name + "  ///  " + email + "  ///  " + subject + "  ///  " + message);

    }
}
