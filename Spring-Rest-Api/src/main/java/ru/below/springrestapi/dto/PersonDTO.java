package ru.below.springrestapi.dto;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import ru.below.springrestapi.models.Role;

@Data
public class PersonDTO {
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2,max = 30,message = "Name should be between 2 and 30 characters")
    private String usernamePerson;
    @Column(name = "year_of_birth", nullable = false)
    @Min(value = 1900,message = "yearOfBirth should be greater than 1900")
    private int yearOfBirth;
    @NotEmpty(message = "Password should not be empty")
    private String password;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Role role;
}
