package dev.miage.inf2.course.bookstore.service.impl;

import dev.miage.inf2.course.bookstore.AuthorDAO;
import dev.miage.inf2.course.bookstore.annotation.MiageDB;
import dev.miage.inf2.course.bookstore.entity.Author;
import dev.miage.inf2.course.bookstore.entity.Book;
import dev.miage.inf2.course.bookstore.model.BookDTO;
import dev.miage.inf2.course.bookstore.service.InventoryService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.Collection;
import java.util.stream.Collectors;

@ApplicationScoped
@MiageDB
public class BookInventoryService implements InventoryService<BookDTO> {

    @Inject
    EntityManager entityManager;

    @Inject
    AuthorDAO authorDAO;

    @Transactional
    @Override
    public void addToInventory(BookDTO bookDTO) {
        Author author = authorDAO.getAuthorFromName(bookDTO.author());
        if (author == null) {
            author = authorDAO.addNewAuthor(bookDTO.author());
        }
        Book book = new Book();
        book.setTitle(bookDTO.title());
        book.setIsbn(bookDTO.isbn());
        book.setAuthor(author);
        entityManager.persist(book);


    }

    @Override
    @Transactional
    public BookDTO takeFromInventory() {
        Book book = (Book) entityManager.createNativeQuery("SELECT * FROM Book ORDER BY RAND() LIMIT 1", Book.class).getSingleResult();
        entityManager.remove(book);
        return new BookDTO(book.getAuthor().getName(), book.getTitle(), book.getIsbn());
    }

    @Override
    @Transactional
    public BookDTO takeFromInventory(String isbn) {
        Book book = entityManager.createQuery("SELECT book from Book book where book.isbn=?1", Book.class).setMaxResults(1).setParameter(1, isbn).getSingleResult();
        entityManager.remove(book);
        return new BookDTO(book.getAuthor().getName(), book.getTitle(), book.getIsbn());
    }



    @Override
    public long countItemsInInventory() {
        return (Long) entityManager.createQuery("select count(book) from Book book").getSingleResult();
    }

    @Override

    public Collection<BookDTO> listAllItems() {
        return (Collection<BookDTO>) entityManager
                .createQuery("select book from Book book").getResultList()
                .stream()
                .map(b -> new BookDTO(((Book) b).getAuthor().getName(), ((Book) b).getTitle(), ((Book) b).getIsbn()))
                .collect(Collectors.toList());
    }


}
