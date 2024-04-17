package ru.below.testdto.dto;


import lombok.Data;
import ru.below.testdto.entity.AuthorEntity;

@Data
public class BookDto {
        private String bookName;
        private AuthorDto author;
        private Integer pages;
        private String index;
}
