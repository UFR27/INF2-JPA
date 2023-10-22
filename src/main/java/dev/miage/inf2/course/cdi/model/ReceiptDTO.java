package dev.miage.inf2.course.cdi.model;

public record ReceiptDTO<T>(T item, double price, double vat) {


}
