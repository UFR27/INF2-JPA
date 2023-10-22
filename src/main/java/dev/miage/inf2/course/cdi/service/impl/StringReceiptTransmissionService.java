package dev.miage.inf2.course.cdi.service.impl;

import dev.miage.inf2.course.cdi.model.BookDTO;
import dev.miage.inf2.course.cdi.model.CustomerDTO;
import dev.miage.inf2.course.cdi.model.ReceiptDTO;
import dev.miage.inf2.course.cdi.service.ReceiptTransmissionService;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

@Dependent
@Named("ReceiptGoodForBookStore")
public class StringReceiptTransmissionService implements ReceiptTransmissionService<BookDTO> {

    private static final StringBuilder stringBuilder = new StringBuilder();

    @Override
    public void sendReceipt(CustomerDTO customer, ReceiptDTO receipt) {
        stringBuilder.append("Merci d'avoir acheté " + receipt.item().toString() + " pour un montant de " + receipt.price()).append("\n");
    }
}
