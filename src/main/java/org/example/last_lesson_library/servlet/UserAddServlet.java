package org.example.last_lesson_library.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.last_lesson_library.entity.User;

import java.io.IOException;

import static org.example.last_lesson_library.config.DBConfig.entityManager;

@WebServlet(name = "addUser",value = "/user/add")
public class UserAddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        User user = new User();
        user.setUserName(username);
        user.setStatus("out");
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        resp.sendRedirect("/employer/employer.jsp");
    }
}
