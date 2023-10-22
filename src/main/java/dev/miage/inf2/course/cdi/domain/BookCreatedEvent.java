package dev.miage.inf2.course.cdi.domain;

import dev.miage.inf2.course.cdi.model.BookDTO;

public class BookCreatedEvent {
    final private BookDTO book;

    public BookCreatedEvent(BookDTO book) {
        this.book = book;
    }

    public BookDTO getBook() {
        return book;
    }
}
