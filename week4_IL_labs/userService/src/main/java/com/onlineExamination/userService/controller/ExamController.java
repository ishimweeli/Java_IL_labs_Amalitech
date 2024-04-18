package com.onlineExamination.userService.controller;

import com.onlineExamination.userService.model.ExamModel;
import com.onlineExamination.userService.service.ExamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/exams")
public class ExamController {
    private final ExamService examService;

    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @PostMapping
    public ResponseEntity<ExamModel> createExam(@RequestBody ExamModel exam) {
        ExamModel savedExam = examService.createExam(exam);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedExam);
    }

    @GetMapping
    public ResponseEntity<List<ExamModel>> getExams() {
        List<ExamModel> exams = examService.getExams();
        return ResponseEntity.ok(exams);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExamModel> getExamById(@PathVariable Long id) {
        Optional<ExamModel> optionalExam = examService.getExamById(id);
        return optionalExam.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExamModel> updateExam(@PathVariable Long id, @RequestBody ExamModel exam) {
        ExamModel updatedExam = examService.updateExam(id, exam);
        return ResponseEntity.ok(updatedExam);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExam(@PathVariable Long id) {
        examService.deleteExam(id);
        return ResponseEntity.ok("deleted successfully");
    }
}