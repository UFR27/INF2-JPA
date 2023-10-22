package dev.miage.inf2.course.bookstore.service;

import dev.miage.inf2.course.bookstore.model.CustomerDTO;
import dev.miage.inf2.course.bookstore.model.ReceiptDTO;

public interface ReceiptTransmissionService<T> {

    void sendReceipt(CustomerDTO customer, ReceiptDTO<T> receipt);
}
