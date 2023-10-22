package dev.miage.inf2.course.bookstore.dao;

import dev.miage.inf2.course.bookstore.entity.Author;
import dev.miage.inf2.course.bookstore.entity.Theme;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ThemeDAO {

    @Inject
    EntityManager em;


    public Theme getThemeFromName(String themeName) {
        try {
            return em.createQuery("SELECT theme from Theme theme where theme.name=?1", Theme.class).setParameter(1, themeName).getSingleResult();

        } catch (NoResultException nre) {
            return null;
        }
    }


    @Transactional
    public Theme addNewTheme(String themeName) {
        Theme theme = new Theme();
        theme.setName(themeName);
        em.persist(theme);
        return theme;

    }
}
