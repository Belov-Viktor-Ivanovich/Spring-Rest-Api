package ru.below.springrestapi.controllers;


import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import ru.below.springrestapi.dto.PersonDTO;
import ru.below.springrestapi.models.Person;
import ru.below.springrestapi.services.PeopleService;
import ru.below.springrestapi.util.PersonErrorResponse;
import ru.below.springrestapi.util.PersonNotCreatedExeption;
import ru.below.springrestapi.util.PersonNotFoundExeption;
import ru.below.springrestapi.util.PersonUsernameExeption;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/people")
public class PeopleContriller {
    private final PeopleService peopleService;
    private final ModelMapper modelMapper;
    @Autowired
    public PeopleContriller(PeopleService peopleService, ModelMapper modelMapper) {
        this.peopleService = peopleService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getPerson(@PathVariable String name) {
        try {
            return new ResponseEntity<>(convertToPersonDTO(peopleService.getPeopleByName(name)), HttpStatus.OK);
        }
        catch (PersonNotFoundExeption e) {
            return new ResponseEntity<>(new PersonErrorResponse("Person with this id wasn't found!",System.currentTimeMillis()), HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping
    public List<PersonDTO> getAllPeople() {
        return peopleService.getAllPeople().stream().map(this::convertToPersonDTO).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<HttpStatus> createPeople(@RequestBody @Valid PersonDTO personDTO,
                                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder errorMsg = new StringBuilder();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                errorMsg.append(fieldError.getField()).append(" - ").append(fieldError.getDefaultMessage())
                        .append(";").append("\n");
            }
            throw new PersonNotCreatedExeption(errorMsg.toString());
        }
        peopleService.savePeople(convertToPerson(personDTO));
        return ResponseEntity.ok(HttpStatus.CREATED);


    }
    //из PersonDTO в Person
    private Person convertToPerson(PersonDTO personDTO) {

        return modelMapper.map(personDTO, Person.class);
    }

    private PersonDTO convertToPersonDTO(Person person) {
        return modelMapper.map(person, PersonDTO.class);
    }





    @ExceptionHandler
    private ResponseEntity<PersonErrorResponse> handleExeption(PersonNotCreatedExeption e) {
        PersonErrorResponse response = new PersonErrorResponse(
                e.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    private ResponseEntity<PersonErrorResponse> handleExeption(PersonUsernameExeption e) {
        PersonErrorResponse response = new PersonErrorResponse(
                e.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }



    //либо ловим методом handleExeption все исключения PersonNotFoundExeption в программе
    /*@GetMapping("/{name}")
    public Person getPerson(@PathVariable String name) {
        return peopleService.getPeopleByName(name);
    }
    @ExceptionHandler
    private ResponseEntity<PersonErrorResponse> handleExeption(PersonNotFoundExeption e) {
        PersonErrorResponse response = new PersonErrorResponse(
                "Person with this id wasn't found!",
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }*/


}
