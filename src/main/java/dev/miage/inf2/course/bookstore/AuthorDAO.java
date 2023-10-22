package dev.miage.inf2.course.bookstore;

import dev.miage.inf2.course.bookstore.entity.Author;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class AuthorDAO {

    @Inject
    EntityManager em;

    /**
     * Get an author by its name
     *
     * @param authorName the name of the author to look for
     * @return the author or null if not found
     */
    public Author getAuthorFromName(String authorName) {
        try {
            Query query = em.createQuery("SELECT author from Author author where author.name=?1", Author.class);
            query = query.setParameter(1, authorName);
            return (Author) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    

    @Transactional
    public Author addNewAuthor(String authorName) {
        Author author = new Author();
        author.setName(authorName);
        em.persist(author);
        return author;

    }
}
