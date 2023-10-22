package dev.miage.inf2.course.bookstore.domain;

import dev.miage.inf2.course.bookstore.model.BookDTO;

public class BookCreatedEvent {
    final private BookDTO book;

    public BookCreatedEvent(BookDTO book) {
        this.book = book;
    }

    public BookDTO getBook() {
        return book;
    }
}
