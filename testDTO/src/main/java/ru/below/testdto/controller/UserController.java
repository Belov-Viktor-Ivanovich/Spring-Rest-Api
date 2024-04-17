package ru.below.testdto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.below.testdto.dto.UserDTO;
import ru.below.testdto.models.User;
import ru.below.testdto.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {


    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping
    public User createUser(@RequestBody UserDTO userDto) {
        return userService.convertUserDTOToUser(userDto);
    }
}
