package dev.miage.inf2.course.bookstore.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;


@Entity
@DiscriminatorValue("ITBook")
public class ItBook extends Book {

    @ElementCollection(fetch = FetchType.EAGER)
    // Eager fetching is used as an example; you can choose the fetching strategy based on your needs
    private Set<String> languages = new HashSet<>();  // Collection of programming languages

    public Set<String> getLanguages() {
        return languages;
    }

    @Override
    public String getTitle() {
        return "[IT]" + super.getTitle();
    }

}
