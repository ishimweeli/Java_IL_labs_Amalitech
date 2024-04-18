package com.onlineExamination.userService.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class QuestionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    @Enumerated(EnumType.STRING)
    private QuestionType type;

    private String correctAnswer;
    private String possibleAnswers;

    @Enumerated(EnumType.STRING)
    private Lesson lesson;

    private String section;

}