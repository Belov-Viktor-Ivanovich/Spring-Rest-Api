package ru.below.testdto.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.below.testdto.convertor.BookConvertor;
import ru.below.testdto.repositories.BookRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    private final BookRepository bookRepository;
    private final BookConvertor bookConvertor;

    @GetMapping
    public List findAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(bookConvertor::convertToDto)
                .collect(Collectors.toList());
    }
}
