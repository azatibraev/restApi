package com.example.spring_book_app_beks.exceptions;

/**
 * @author Azat Ibraev
 */
public class BookNotFoundException extends  RuntimeException{

    public BookNotFoundException() {
        super();
    }

    public BookNotFoundException(String message) {
        super(message);
    }
}
