package dev.miage.inf2.course.bookstore.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class Book {
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;


    public Set<Author> getAuthors() {
        return authors;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<Author> authors = new HashSet<>();

    public Set<Theme> getThemes() {
        return themes;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "book_theme",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "theme_id")
    )
    private Set<Theme> themes = new HashSet<>();

    private String title;
    private String isbn;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
