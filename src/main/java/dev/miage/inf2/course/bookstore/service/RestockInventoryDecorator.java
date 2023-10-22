package dev.miage.inf2.course.bookstore.service;

import dev.miage.inf2.course.bookstore.domain.BookShop;
import dev.miage.inf2.course.bookstore.exception.OutOfStockException;
import dev.miage.inf2.course.bookstore.model.BookDTO;
import dev.miage.inf2.course.bookstore.model.CustomerDTO;
import jakarta.annotation.Priority;
import jakarta.decorator.Decorator;
import jakarta.decorator.Delegate;
import jakarta.enterprise.inject.Any;
import jakarta.inject.Inject;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

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

    private static ScheduledThreadPoolExecutor executorService = new ScheduledThreadPoolExecutor(1);

    private void restockIfNeeded(BookDTO book) {
        if (!delegate.getAllItems().contains(book)) {

            executorService.schedule(() -> restockInventoryService.restockBook(book), 1, TimeUnit.MINUTES);

        }
    }
}
