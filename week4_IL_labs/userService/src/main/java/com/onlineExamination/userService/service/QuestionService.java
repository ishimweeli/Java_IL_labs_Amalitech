package com.onlineExamination.userService.service;

import com.onlineExamination.userService.model.ExamModel;
import com.onlineExamination.userService.model.ExamQuestionModel;
import com.onlineExamination.userService.model.QuestionModel;
import com.onlineExamination.userService.repository.ExamRepository;
import com.onlineExamination.userService.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final ExamRepository examRepository;

    public QuestionService(QuestionRepository questionRepository, ExamRepository examRepository) {
        this.questionRepository = questionRepository;
        this.examRepository = examRepository;
    }

    public QuestionModel createQuestion(QuestionModel question) {
        return questionRepository.save(question);
    }

    public List<QuestionModel> getQuestions() {
        return questionRepository.findAll();
    }

    public Optional<QuestionModel> getQuestionById(Long id) {
        return questionRepository.findById(id);
    }

    public QuestionModel updateQuestion(Long id, QuestionModel question) {
        Optional<QuestionModel> optionalQuestion = questionRepository.findById(id);
        if (optionalQuestion.isPresent()) {
            QuestionModel existingQuestion = optionalQuestion.get();
            // Update the existing question with the new data
            existingQuestion.setText(question.getText());
            existingQuestion.setType(question.getType());
            existingQuestion.setCorrectAnswer(question.getCorrectAnswer());
            existingQuestion.setPossibleAnswers(question.getPossibleAnswers());
            existingQuestion.setLesson(question.getLesson());
            existingQuestion.setSection(question.getSection());
            return questionRepository.save(existingQuestion);
        }
        return null;
    }

    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
    }

    public void addQuestionToExam(Long examId, Long questionId) {
        Optional<ExamModel> optionalExam = examRepository.findById(examId);
        Optional<QuestionModel> optionalQuestion = questionRepository.findById(questionId);

        if (optionalExam.isPresent() && optionalQuestion.isPresent()) {
            ExamModel exam = optionalExam.get();
            QuestionModel question = optionalQuestion.get();
            ExamQuestionModel examQuestion = new ExamQuestionModel(exam, question);
            exam.getExamQuestions().add(examQuestion);
            examRepository.save(exam);
        }
    }
}