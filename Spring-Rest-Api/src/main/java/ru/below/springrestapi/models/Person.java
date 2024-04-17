package ru.below.springrestapi.models;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.beans.factory.annotation.Value;


import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "username", nullable = false,unique = true)
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2,max = 30,message = "Name should be between 2 and 30 characters")
    private String username;

    @Column(name = "year_of_birth", nullable = false)
    @Min(value = 1900,message = "yearOfBirth should be greater than 1900")
    private int yearOfBirth;

    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    @NotNull
    private Role role;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    @Column(name = "created_who")
    @NotEmpty
    private String createdWho;

    public Person(String tom, int i, String number) {
        this.username = tom;
        this.yearOfBirth = i;
        this.password = number;
    }
    public Person(String tom, int i) {
        this.username = tom;
        this.yearOfBirth = i;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return yearOfBirth == person.yearOfBirth && Objects.equals(id, person.id) && Objects.equals(username, person.username) && Objects.equals(password, person.password);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", userName='" + username + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", password='" + password + '\'' +
                ", role='" + role.toString() + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, yearOfBirth, password);

    }
}
