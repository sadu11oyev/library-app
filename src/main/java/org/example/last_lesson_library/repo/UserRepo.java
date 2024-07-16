package org.example.last_lesson_library.repo;

import jakarta.persistence.TypedQuery;
import org.example.last_lesson_library.entity.Book;
import org.example.last_lesson_library.entity.User;

import java.util.List;

import static org.example.last_lesson_library.config.DBConfig.entityManager;

public class UserRepo {
    public static List<User> findAll(int page,String search) {
        TypedQuery<User> typedQuery = entityManager.createQuery("select t from User t where t.userName ilike:search order by id", User.class);
        typedQuery.setParameter("search","%" + search + "%");
        typedQuery.setMaxResults(10);
        typedQuery.setFirstResult((page-1)*10);
        return typedQuery.getResultList();
    }
    public static int totalPageCount(String search) {
        TypedQuery<Long> typedQuery = entityManager.createQuery("select count (t) from User t where t.userName ilike : search", Long.class);
        typedQuery.setParameter("search","%" + search + "%");
        return (int)Math.ceil(typedQuery.getSingleResult()/10.0);
    }

    public static Book findBookById(Integer bookId) {
        return entityManager.createQuery("select t from Book t where t.id=:bookId", Book.class)
                .setParameter("bookId",bookId).getSingleResult();
    }

    public static User findAllById(Integer id) {
        return entityManager.createQuery("select t from User t where t.id=:id", User.class)
                .setParameter("id",id).getSingleResult();
    }

    public static List<Book> findAllBooks() {
        return entityManager.createQuery("from Book", Book.class).getResultList();
    }

}
