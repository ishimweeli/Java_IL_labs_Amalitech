package com.calculator.calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class DefaultController {
    @GetMapping("/welcome to our calculator")
    public String returnString() {
        return "Welcome to Eliab Calculator! This is the best calculator ever.";
    }
}
