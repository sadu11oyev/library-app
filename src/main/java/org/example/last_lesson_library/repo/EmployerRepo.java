package org.example.last_lesson_library.repo;

import org.example.last_lesson_library.entity.Employer;

import static org.example.last_lesson_library.config.DBConfig.entityManager;

public class EmployerRepo {

    public static Employer findByNameAndPassword(String userName, String password) {
        return entityManager.createQuery("select t from Employer t where t.userName=:userName and t.password=:password", Employer.class)
                .setParameter("userName", userName)
                .setParameter("password", password)
                .getSingleResult();
    }
}
