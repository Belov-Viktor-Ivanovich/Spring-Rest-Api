package ru.below.testdto.services;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import ru.below.testdto.dto.AuthorDto;
import ru.below.testdto.dto.BookDto;
import ru.below.testdto.dto.UserDTO;
import ru.below.testdto.entity.AuthorEntity;
import ru.below.testdto.entity.BookEntity;
import ru.below.testdto.models.User;

@Service
public class UserService {
    private final ModelMapper modelMapper;
    private Converter<String, String> isbnRemover = (src) -> src.getSource().replaceAll("ISBN: ", "");
    @Autowired
    public UserService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.modelMapper.createTypeMap(BookEntity.class, BookDto.class)
                //.addMappings(BookEntity::getComment, BookDto::setReview)//из поля соменты в ревиев
                .addMappings(
                maper->maper.using(isbnRemover).map(BookEntity::getIndex,BookDto::setIndex)
        );
        this.modelMapper.createTypeMap(AuthorEntity.class, AuthorDto.class);
    }

    public User convertUserDTOToUser(UserDTO userDTO) {

        return modelMapper.map(userDTO, User.class);
    }
}
