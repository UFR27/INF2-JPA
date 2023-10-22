package dev.miage.inf2.course.bookstore.model;

public record ReceiptDTO<T>(T item, double price, double vat) {


}
