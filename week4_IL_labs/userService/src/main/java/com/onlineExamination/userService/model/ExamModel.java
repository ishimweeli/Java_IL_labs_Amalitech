package com.onlineExamination.userService.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class ExamModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private String author;

    @Enumerated(EnumType.STRING)
    private Lesson lesson;

    @Enumerated(EnumType.STRING)
    private Level level;

    @OneToMany(mappedBy = "exam", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ExamQuestionModel> examQuestions = new ArrayList<>();


}