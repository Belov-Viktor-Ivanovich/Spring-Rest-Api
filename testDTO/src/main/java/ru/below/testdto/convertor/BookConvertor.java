package ru.below.testdto.convertor;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.below.testdto.dto.BookDto;
import ru.below.testdto.entity.BookEntity;


@Component
public class BookConvertor {
    private final ModelMapper modelMapper;

    public BookConvertor(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public BookDto convertToDto(BookEntity bookEntity) {
        return modelMapper.map(bookEntity, BookDto.class);
    }
}
