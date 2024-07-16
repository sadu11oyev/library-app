package org.example.last_lesson_library.servlet;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.last_lesson_library.entity.Employer;
import org.example.last_lesson_library.repo.EmployerRepo;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

@WebServlet(name = "auth",value = "/auth/login")
public class AuthServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        Employer employer = EmployerRepo.findByNameAndPassword(userName,password);
        if (employer!=null){
            int randomNum=new Random().nextInt(1000,9999);
            sendMessage(userName,randomNum+"");
            HttpSession session = req.getSession();
            session.setAttribute("parol",randomNum);
            session.setAttribute("abstractEmployer",employer);
            resp.sendRedirect("/lustLogin.jsp");
        }else {
            
            resp.sendRedirect("/");
        }
    }
    public static void sendMessage(String sendToEmail, String text) {
        try {
            Properties properties =new Properties();
            properties.put("mail.smtp.host","smtp.gmail.com");
            properties.put("mail.smtp.port","465");
            properties.put("mail.smtp.ssl.enable","true");
            properties.put("mail.smtp.auth","true");
            String companyEmail = "baxtisadulloyev@gmail.com";
            String companyPassword = "odek ldzn nxwr qpgh";

            Session session = Session.getInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(companyEmail, companyPassword);
                }
            });
            Message message= new MimeMessage(session);
            message.setSubject("Your code: ");
            message.setText(text);

            message.setFrom(new InternetAddress(companyEmail));
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(sendToEmail));

            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
