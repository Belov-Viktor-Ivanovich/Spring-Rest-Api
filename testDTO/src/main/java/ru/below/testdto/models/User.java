package ru.below.testdto.models;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class User {
    private Long id;
    private String login;
    private String password;
    private Passport passport;
}
