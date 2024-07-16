package org.example.last_lesson_library.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.last_lesson_library.entity.User;

import java.io.IOException;

import static org.example.last_lesson_library.config.DBConfig.entityManager;

@WebServlet(name = "returnBook",value = "/book/return")
public class BookReturnServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer userId = Integer.parseInt(req.getParameter("id"));
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class, userId);
        user.setBookId(null);
        entityManager.getTransaction().commit();
        resp.sendRedirect("/employer/employer.jsp");
    }
}
