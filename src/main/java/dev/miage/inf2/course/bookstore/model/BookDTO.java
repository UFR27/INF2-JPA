package dev.miage.inf2.course.bookstore.model;

import java.util.Set;
import java.util.UUID;

/**
 * An instance of a particular physical copy of a book
 *
 * @param authors name of the book's author
 * @param title   title of the book
 * @param isbn    International Standard Book Number
 */
public record BookDTO(Set<String> authors, String title, String isbn, Set<String> themes,boolean isIt) {
}
