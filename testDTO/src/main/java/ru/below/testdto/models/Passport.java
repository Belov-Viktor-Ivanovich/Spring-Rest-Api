package ru.below.testdto.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Passport {
    private Long id;
    private String surname;
    private String firstname;
    private String secondname;
    private Address addressOfBirth;
    private Address addressOfReg;
}
