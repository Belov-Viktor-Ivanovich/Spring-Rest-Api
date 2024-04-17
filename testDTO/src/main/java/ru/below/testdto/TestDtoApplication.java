package ru.below.testdto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.below.testdto.entity.AuthorEntity;
import ru.below.testdto.entity.BookEntity;
import ru.below.testdto.repositories.AuthorRepository;
import ru.below.testdto.repositories.BookRepository;

import java.util.List;

@SpringBootApplication
public class TestDtoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestDtoApplication.class, args);
    }

}
