package com.onlineExamination.userService.service;

import com.onlineExamination.userService.model.ExamModel;
import com.onlineExamination.userService.model.ExamQuestionModel;
import com.onlineExamination.userService.repository.ExamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamService {
    private final ExamRepository examRepository;

    public ExamService(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    public ExamModel createExam(ExamModel exam) {
        return examRepository.save(exam);
    }

    public List<ExamModel> getExams() {
        return examRepository.findAll();
    }

    public Optional<ExamModel> getExamById(Long id) {
        return examRepository.findById(id);
    }

    public ExamModel updateExam(Long id, ExamModel exam) {
        Optional<ExamModel> optionalExam = examRepository.findById(id);
        if (optionalExam.isPresent()) {
            ExamModel existingExam = optionalExam.get();
            // Update the existing exam with the new data
            existingExam.setDate(exam.getDate());
            existingExam.setAuthor(exam.getAuthor());
            existingExam.setLesson(exam.getLesson());
            existingExam.setLevel(exam.getLevel());
            existingExam.getExamQuestions().clear(); // Remove existing exam-question associations
            for (ExamQuestionModel examQuestion : exam.getExamQuestions()) {
                ExamQuestionModel newExamQuestion = new ExamQuestionModel(existingExam, examQuestion.getQuestion());
                existingExam.getExamQuestions().add(newExamQuestion);
            }
            return examRepository.save(existingExam);
        }
        return null;
    }

    public void deleteExam(Long id) {
        examRepository.deleteById(id);
    }
}