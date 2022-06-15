package com.example.spring_book_app_beks.dto.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Azat Ibraev
 */
@Getter
@Setter
public class BookSaveRequest {

    private String name;

    private String author;

    private int price;
}
