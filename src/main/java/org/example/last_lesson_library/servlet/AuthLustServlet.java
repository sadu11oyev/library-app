package org.example.last_lesson_library.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.last_lesson_library.entity.Employer;

import java.io.IOException;

@WebServlet(name = "lustLogin",value = "/auth/login/lust")
public class AuthLustServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String parol = session.getAttribute("parol").toString();
        String password = req.getParameter("password");
        if (password.equals(parol)){
            Employer employer = (Employer) session.getAttribute("abstractEmployer");
            session.setAttribute("currentEmployer",employer);
            resp.sendRedirect("/employer/employer.jsp");
        }else {
            resp.sendRedirect("/lustLogin.jsp");
        }
    }
}
