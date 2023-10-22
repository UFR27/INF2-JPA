package dev.miage.inf2.course.bookstore.domain;

import dev.miage.inf2.course.bookstore.AuthorDAO;
import dev.miage.inf2.course.bookstore.annotation.MiageDB;
import dev.miage.inf2.course.bookstore.dao.BookDAO;
import dev.miage.inf2.course.bookstore.entity.Author;
import dev.miage.inf2.course.bookstore.entity.Book;
import dev.miage.inf2.course.bookstore.exception.OutOfStockException;
import dev.miage.inf2.course.bookstore.model.BookDTO;
import dev.miage.inf2.course.bookstore.model.CustomerDTO;
import dev.miage.inf2.course.bookstore.model.ReceiptDTO;
import dev.miage.inf2.course.bookstore.service.InventoryService;
import dev.miage.inf2.course.bookstore.service.ReceiptTransmissionService;

import io.smallrye.common.annotation.Blocking;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;

import java.util.Collection;
import java.util.Random;

@ApplicationScoped
public class BookShop implements Shop<BookDTO> {

    @Inject
    BookDAO bookDAO;

    @Inject
    AuthorDAO authorDAO;

    @Inject
    Event<BookCreatedEvent> event;

    @Inject
    @MiageDB
    protected InventoryService<BookDTO> inventoryService;
    @Inject
    @Named("ReceiptGoodForBookStore")
    protected ReceiptTransmissionService<BookDTO> receiptTransmissionService;

    public BookShop() {
    }


    public long countBooks() {
        return this.inventoryService.countItemsInInventory();
    }


    @Override
    public BookDTO sell(CustomerDTO customer) throws OutOfStockException {
        var soldBook = this.inventoryService.takeFromInventory();
        ReceiptDTO<BookDTO> receipt = new ReceiptDTO<BookDTO>(soldBook, new Random().nextInt(0, 30), 0.055);
        receiptTransmissionService.sendReceipt(customer, receipt);

        return soldBook;

    }

    @Override
    public BookDTO sell(CustomerDTO customer, String id) {
        return this.inventoryService.takeFromInventory(id);
    }


    @Override
    public void stock(BookDTO book) {

        this.inventoryService.addToInventory(book);
        event.fire(new BookCreatedEvent(book));
    }

    @Override

    public Collection<BookDTO> getAllItems() {
        return this.inventoryService.listAllItems();
    }

    @Transactional
    public void updateBookAuthorName(String isbn, String newAuthorName) {
         Book book = bookDAO.getBookFromISBN(isbn);
        Author author = authorDAO.getAuthorFromName(newAuthorName);
        if (author == null) {
            author = authorDAO.addNewAuthor(newAuthorName);
        }
        book.setAuthor(author);
    }
}
