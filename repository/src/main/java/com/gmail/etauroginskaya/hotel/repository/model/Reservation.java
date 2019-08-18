package com.gmail.etauroginskaya.hotel.repository.model;

import org.springframework.data.annotation.Id;

public class Reservation {
    @Id
    private Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}