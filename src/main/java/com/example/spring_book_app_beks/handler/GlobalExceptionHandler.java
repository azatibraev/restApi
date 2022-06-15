package com.example.spring_book_app_beks.handler;

import com.example.spring_book_app_beks.exceptions.BookNotFoundException;
import com.example.spring_book_app_beks.exceptions.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Azat Ibraev
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BookNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handlerBookNotFoundException(BookNotFoundException e) {
        return  new ExceptionResponse(
                HttpStatus.NOT_FOUND,
                e.getClass().getSimpleName(),
                e.getMessage());
    }
}
