package com.onlineExamination.userService.controller;

import com.onlineExamination.userService.model.UserModel;
import com.onlineExamination.userService.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String hello() {
        return "hello";
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserModel user) {
        userService.registerUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<UserModel> loginUser(@RequestBody LoginRequest loginRequest) {

        UserModel user = userService.loginUser(loginRequest.getUsername(), loginRequest.getPassword(), null);
   System.out.println(user);
        return ResponseEntity.ok(user);
    }

    @Data
    private static class LoginRequest {
        private String username;
        private String password;
    }
}