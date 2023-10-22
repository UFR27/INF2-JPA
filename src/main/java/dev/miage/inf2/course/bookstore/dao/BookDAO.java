package dev.miage.inf2.course.bookstore.dao;

import dev.miage.inf2.course.bookstore.entity.Book;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import javax.swing.text.html.parser.Entity;

@ApplicationScoped
public class BookDAO {

    @Inject
    EntityManager em;
    public Book getBookFromISBN(String isbn){
        return em.createQuery("SELECT book from Book book where book.isbn=?1",Book.class).setMaxResults(1).setParameter(1,isbn).getSingleResult();


    }
}
