package dev.miage.inf2.course.bookstore.entity;

import jakarta.persistence.*;

import java.util.Set;
import java.util.UUID;

@Entity
public class Theme {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;

    @ManyToMany(mappedBy = "themes")
    private Set<Book> books;
}
