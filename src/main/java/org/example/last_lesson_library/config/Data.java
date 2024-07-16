package org.example.last_lesson_library.config;

import jakarta.persistence.Persistence;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import static org.example.last_lesson_library.config.DBConfig.entityManager;
import static org.example.last_lesson_library.config.DBConfig.entityManagerFactory;
@WebListener
public class Data implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        entityManagerFactory = Persistence.createEntityManagerFactory("LIBRARY");
        entityManager = entityManagerFactory.createEntityManager();
        ServletContextListener.super.contextInitialized(sce);
    }
}
