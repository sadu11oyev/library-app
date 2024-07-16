package org.example.last_lesson_library.config;

import jakarta.persistence.Embeddable;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.last_lesson_library.entity.Employer;

import java.io.IOException;

@WebFilter
public class SecurityFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        var resp = (HttpServletResponse)servletResponse;
        var req = (HttpServletRequest)servletRequest;
        HttpSession session = req.getSession();
        Employer currentEmployer = (Employer) session.getAttribute("currentEmployer");
        if (currentEmployer!=null){
            filterChain.doFilter(req,resp);
        }else {
            resp.sendRedirect("/login.jsp");
        }
    }
}
