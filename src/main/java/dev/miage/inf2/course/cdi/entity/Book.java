package dev.miage.inf2.course.cdi.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "LIVRE", indexes = @Index(name = "index_author", columnList = "author"))
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


    private String author;
    @Column(nullable = false, length = 50)
    private String title;

    @Column(unique = true, length = 13, nullable = false)
    private String isbn;


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

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
