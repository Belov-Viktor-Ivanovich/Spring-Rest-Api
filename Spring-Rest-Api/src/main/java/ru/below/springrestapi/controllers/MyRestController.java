package ru.below.springrestapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MyRestController {
    @ResponseBody
    @GetMapping("/sayHello")
    public String sayHello() {

        return "Hello World";
    }
}
