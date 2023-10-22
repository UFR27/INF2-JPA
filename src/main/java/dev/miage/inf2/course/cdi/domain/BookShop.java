package dev.miage.inf2.course.cdi.domain;

import dev.miage.inf2.course.cdi.exception.OutOfStockException;
import dev.miage.inf2.course.cdi.model.BookDTO;
import dev.miage.inf2.course.cdi.model.CustomerDTO;
import dev.miage.inf2.course.cdi.model.ReceiptDTO;
import dev.miage.inf2.course.cdi.service.InventoryService;
import dev.miage.inf2.course.cdi.service.ReceiptTransmissionService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.Collection;
import java.util.Random;

@ApplicationScoped
public class BookShop implements Shop<BookDTO> {

    @Inject
    Event<BookCreatedEvent> event;

    @Inject
    @Named("InventoryGoodForBookStore")
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
}
