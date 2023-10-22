package dev.miage.inf2.course.bookstore.service.impl;

import dev.miage.inf2.course.bookstore.dao.AuthorDAO;
import dev.miage.inf2.course.bookstore.annotation.MiageDB;
import dev.miage.inf2.course.bookstore.dao.ThemeDAO;
import dev.miage.inf2.course.bookstore.entity.Author;
import dev.miage.inf2.course.bookstore.entity.Book;
import dev.miage.inf2.course.bookstore.entity.Theme;
import dev.miage.inf2.course.bookstore.model.BookDTO;
import dev.miage.inf2.course.bookstore.service.InventoryService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@ApplicationScoped
@MiageDB
public class BookInventoryService implements InventoryService<BookDTO> {

    @Inject
    EntityManager entityManager;

    @Inject
    AuthorDAO authorDAO;

    @Inject
    ThemeDAO themeDAO;

    @Transactional
    @Override
    public void addToInventory(BookDTO bookDTO) {
        Set<Author> authors =
                bookDTO.authors().stream().map(a -> {
                    Author author = authorDAO.addNewAuthor(a);
                    if (author == null) {
                        author = authorDAO.getAuthorFromName(a);
                    }
                    return author;
                }).collect(Collectors.toSet());

        Set<Theme> themes =
                bookDTO.themes().stream().map(a -> {
                    Theme theme = themeDAO.addNewTheme(a);
                    if (theme == null) {
                        theme = themeDAO.getThemeFromName(a);
                    }
                    return theme;
                }).collect(Collectors.toSet());

        Book book = new Book();
        book.setTitle(bookDTO.title());
        book.setIsbn(bookDTO.isbn());
        book.getAuthors().addAll(authors);
        book.getThemes().addAll(themes);
        entityManager.persist(book);


    }

    @Override
    @Transactional
    public BookDTO takeFromInventory() {
        Book book = (Book) entityManager.createNativeQuery("SELECT * FROM Book ORDER BY RAND() LIMIT 1", Book.class).getSingleResult();
        entityManager.remove(book);
        return new BookDTO(book.getAuthors().stream().map(a -> a.getName()).collect(Collectors.toSet()), book.getTitle(), book.getIsbn(),book.getThemes().stream().map(a -> a.getName()).collect(Collectors.toSet()));
    }

    @Override
    @Transactional
    public BookDTO takeFromInventory(String isbn) {
        Book book = entityManager.createQuery("SELECT book from Book book where book.isbn=?1", Book.class).setMaxResults(1).setParameter(1, isbn).getSingleResult();
        entityManager.remove(book);
        return new BookDTO(book.getAuthors().stream().map(a -> a.getName()).collect(Collectors.toSet()), book.getTitle(), book.getIsbn(),book.getThemes().stream().map(a -> a.getName()).collect(Collectors.toSet()));
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
                .map(b -> new BookDTO(((Book) b).getAuthors().stream().map(a -> a.getName()).collect(Collectors.toSet()), ((Book) b).getTitle(), ((Book) b).getIsbn(),((Book) b).getThemes().stream().map(a -> a.getName()).collect(Collectors.toSet())))
                .collect(Collectors.toList());
    }


}
