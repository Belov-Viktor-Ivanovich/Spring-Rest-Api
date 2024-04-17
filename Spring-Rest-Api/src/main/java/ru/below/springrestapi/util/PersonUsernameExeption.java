package ru.below.springrestapi.util;

public class PersonUsernameExeption extends RuntimeException {
    public PersonUsernameExeption(String message) {
        super(message);
    }
}
