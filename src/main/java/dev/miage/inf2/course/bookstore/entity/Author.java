package dev.miage.inf2.course.bookstore.entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Set;
import java.util.UUID;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    private String name;

    public Set<Book> getBooks() {
        return books;
    }



    @ManyToMany(mappedBy = "authors")
    private Set<Book> books;
}
