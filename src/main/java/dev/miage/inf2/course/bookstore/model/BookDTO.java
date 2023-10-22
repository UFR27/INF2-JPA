package dev.miage.inf2.course.bookstore.model;

import java.util.UUID;

/**
 * An instance of a particular physical copy of a book
 *
 * @param author name of the book's author
 * @param title  title of the book
 * @param isbn   International Standard Book Number
 */
public record BookDTO(String author, String title, String isbn) {
}
