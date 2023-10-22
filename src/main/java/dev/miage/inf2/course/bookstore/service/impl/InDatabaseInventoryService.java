package dev.miage.inf2.course.bookstore.service.impl;

import dev.miage.inf2.course.bookstore.service.InventoryService;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.Collection;
import java.util.Collections;

@Dependent
public class InDatabaseInventoryService<T> implements InventoryService<T> {

    @Inject
    EntityManager em;

    @Override
    public void addToInventory(T t) {

    }

    @Override
    public T takeFromInventory() {
        //SELECT FROM
        return null;
    }

    @Override
    public T takeFromInventory(String id) {
        //SELECT + UPDATE
        return null;
    }

    @Override
    public long countItemsInInventory() {
        // SELECT COUNT(*) FROM...
        return 0;
    }

    @Override
    public Collection<T> listAllItems() {
        //select * from

        return Collections.EMPTY_LIST;
    }
}
