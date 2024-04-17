package ru.below.springrestapi.util;

public class PersonNotCreatedExeption extends RuntimeException {
    public PersonNotCreatedExeption(String message) {
        super(message);
    }
}
