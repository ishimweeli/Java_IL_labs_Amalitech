package com.onlineExamination.userService.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String phoneNumber;

    private String email;

    private String school;

    @Enumerated(EnumType.STRING)
    private UserRole role;

}
