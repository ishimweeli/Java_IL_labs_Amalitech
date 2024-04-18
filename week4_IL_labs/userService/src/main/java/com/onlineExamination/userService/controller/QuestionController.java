package com.onlineExamination.userService.controller;

import com.onlineExamination.userService.model.QuestionModel;
import com.onlineExamination.userService.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {
    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping
    public ResponseEntity<QuestionModel> createQuestion(@RequestBody QuestionModel question) {
        QuestionModel savedQuestion = questionService.createQuestion(question);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedQuestion);
    }

    @GetMapping
    public ResponseEntity<List<QuestionModel>> getQuestions() {
        List<QuestionModel> questions = questionService.getQuestions();
        return ResponseEntity.ok(questions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionModel> getQuestionById(@PathVariable Long id) {
        Optional<QuestionModel> optionalQuestion = questionService.getQuestionById(id);
        return optionalQuestion.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuestionModel> updateQuestion(@PathVariable Long id, @RequestBody QuestionModel question) {
        QuestionModel updatedQuestion = questionService.updateQuestion(id, question);
        return ResponseEntity.ok(updatedQuestion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestion(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/add-to-exam")
    public ResponseEntity<Void> addQuestionToExam(@RequestParam Long examId, @RequestParam Long questionId) {
        questionService.addQuestionToExam(examId, questionId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}