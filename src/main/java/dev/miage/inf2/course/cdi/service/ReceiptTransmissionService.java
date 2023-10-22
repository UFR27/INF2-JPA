package dev.miage.inf2.course.cdi.service;

import dev.miage.inf2.course.cdi.model.CustomerDTO;
import dev.miage.inf2.course.cdi.model.ReceiptDTO;

public interface ReceiptTransmissionService<T> {

    void sendReceipt(CustomerDTO customer, ReceiptDTO<T> receipt);
}
