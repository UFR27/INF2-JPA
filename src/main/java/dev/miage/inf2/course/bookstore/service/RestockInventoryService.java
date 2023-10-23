package dev.miage.inf2.course.bookstore.service;

import dev.miage.inf2.course.bookstore.domain.BookShop;
import dev.miage.inf2.course.bookstore.model.BookDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class RestockInventoryService {

    @Inject
    BookShop shop;

    public void restockBook(BookDTO book) {
        //pretend we order the book somewhere
        BookDTO newBook = new BookDTO(book.authors(), book.title() + " (restocked) ", book.isbn(),book.themes(), book.isIt());
        shop.stock(newBook);
    }

}
