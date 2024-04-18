package com.onlineExamination.userService.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "exam_question")
@Data
@NoArgsConstructor
public class ExamQuestionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "exam_id") //Corrected join column name
    private ExamModel exam;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private QuestionModel question;

    public ExamQuestionModel(ExamModel exam, QuestionModel question) {
        this.exam = exam;
        this.question = question;
    }
}
