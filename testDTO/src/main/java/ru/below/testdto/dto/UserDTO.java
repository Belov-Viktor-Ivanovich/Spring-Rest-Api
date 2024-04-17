package ru.below.testdto.dto;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String login;
    private String password;
    private Long passportId;
    private String passportSurname;
    private String passportFirstname;
    private String passportSecondname;
    private String passportAddressOfRegCountry;
    private String passportAddressOfRegCity;
    private String passportAddressOfRegStreet;
    private String passportAddressOfRegNumberOfHouse;
    private String passportAddressOfBirthCountry;
    private String passportAddressOfBirthCity;

}
