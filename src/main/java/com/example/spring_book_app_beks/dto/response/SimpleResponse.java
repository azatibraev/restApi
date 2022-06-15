package com.example.spring_book_app_beks.dto.response;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Azat Ibraev
 */
@Getter
@Setter
public class SimpleResponse {
    private  String status;
    private  String message;

    public SimpleResponse() {
    }

    public SimpleResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }
}
