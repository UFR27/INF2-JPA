package dev.miage.inf2.course.cdi.service;

import dev.miage.inf2.course.cdi.domain.BookShop;
import dev.miage.inf2.course.cdi.exception.OutOfStockException;
import dev.miage.inf2.course.cdi.model.BookDTO;
import dev.miage.inf2.course.cdi.model.CustomerDTO;
import jakarta.annotation.Priority;
import jakarta.decorator.Decorator;
import jakarta.decorator.Delegate;
import jakarta.enterprise.inject.Any;
import jakarta.inject.Inject;

@Priority(1)
@Decorator
public class RestockInventoryDecorator extends BookShop {

    @Inject
    @Any
    @Delegate
    BookShop delegate;

    @Inject
    RestockInventoryService restockInventoryService;

    public BookDTO sell(CustomerDTO customer, String isbn) throws OutOfStockException {
        var book = delegate.sell(customer, isbn);
        restockIfNeeded(book);

        return book;
    }

    public BookDTO sell(CustomerDTO customer) throws OutOfStockException {
        var book = delegate.sell(customer);
        restockIfNeeded(book);

        return book;
    }

    private void restockIfNeeded(BookDTO book) {
        if (!delegate.getAllItems().contains(book)) {
            restockInventoryService.restockBook(book);
        }
    }
}
