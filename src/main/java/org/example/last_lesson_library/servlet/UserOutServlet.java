package org.example.last_lesson_library.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.last_lesson_library.entity.User;

import java.io.IOException;

import static org.example.last_lesson_library.config.DBConfig.entityManager;

@WebServlet(name = "outUser",value = "/user/out")
public class UserOutServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class, id);
        user.setStatus("out");
        entityManager.getTransaction().commit();
        resp.sendRedirect("/employer/employer.jsp");

    }
}
