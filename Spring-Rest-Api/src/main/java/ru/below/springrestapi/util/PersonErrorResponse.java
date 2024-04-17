package ru.below.springrestapi.util;

import lombok.Data;

@Data
public class PersonErrorResponse {
    private String message;
    private Long timestamp;

    public PersonErrorResponse(String message, Long timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }

}
