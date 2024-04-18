package com.onlineExamination.userService.service;

import com.onlineExamination.userService.model.ExamModel;
import com.onlineExamination.userService.model.ExamQuestionModel;
import com.onlineExamination.userService.model.Lesson;
import com.onlineExamination.userService.model.Level;
import com.onlineExamination.userService.repository.ExamRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ExamServiceTest {

    @Mock
    private ExamRepository examRepository;

    @InjectMocks
    private ExamService examService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateExam() {
        ExamModel exam = new ExamModel();
        exam.setDate(LocalDate.now());
        exam.setAuthor("John Doe");
        exam.setLesson(Lesson.MATHEMATICS);
        exam.setLevel(Level.LOWER_PRIMARY);

        when(examRepository.save(exam)).thenReturn(exam);

        ExamModel savedExam = examService.createExam(exam);

        assertNotNull(savedExam);
        assertEquals(exam.getDate(), savedExam.getDate());
        assertEquals(exam.getAuthor(), savedExam.getAuthor());
        assertEquals(exam.getLesson(), savedExam.getLesson());
        assertEquals(exam.getLevel(), savedExam.getLevel());

        verify(examRepository, times(1)).save(exam);
    }

    @Test
    void testGetExams() {
        List<ExamModel> exams = new ArrayList<>();
        ExamModel exam1 = new ExamModel();
        exam1.setDate(LocalDate.now());
        exam1.setAuthor("John Doe");
        exam1.setLesson(Lesson.MATHEMATICS);
        exam1.setLevel(Level.LOWER_PRIMARY);
        exams.add(exam1);

        ExamModel exam2 = new ExamModel();
        exam2.setDate(LocalDate.now().minusDays(1));
        exam2.setAuthor("Jane Doe");
        exam2.setLesson(Lesson.ENGLISH);
        exam2.setLevel(Level.UPPER_PRIMARY);
        exams.add(exam2);

        when(examRepository.findAll()).thenReturn(exams);

        List<ExamModel> retrievedExams = examService.getExams();

        assertNotNull(retrievedExams);
        assertEquals(2, retrievedExams.size());
        assertEquals(exam1.getDate(), retrievedExams.get(0).getDate());
        assertEquals(exam1.getAuthor(), retrievedExams.get(0).getAuthor());
        assertEquals(exam1.getLesson(), retrievedExams.get(0).getLesson());
        assertEquals(exam1.getLevel(), retrievedExams.get(0).getLevel());
        assertEquals(exam2.getDate(), retrievedExams.get(1).getDate());
        assertEquals(exam2.getAuthor(), retrievedExams.get(1).getAuthor());
        assertEquals(exam2.getLesson(), retrievedExams.get(1).getLesson());
        assertEquals(exam2.getLevel(), retrievedExams.get(1).getLevel());

        verify(examRepository, times(1)).findAll();
    }

    @Test
    void testGetExamById() {
        Long examId = 1L;
        ExamModel exam = new ExamModel();
        exam.setId(examId);
        exam.setDate(LocalDate.now());
        exam.setAuthor("John Doe");
        exam.setLesson(Lesson.MATHEMATICS);
        exam.setLevel(Level.UPPER_PRIMARY);

        when(examRepository.findById(examId)).thenReturn(Optional.of(exam));

        Optional<ExamModel> retrievedExam = examService.getExamById(examId);

        assertTrue(retrievedExam.isPresent());
        assertEquals(examId, retrievedExam.get().getId());
        assertEquals(exam.getDate(), retrievedExam.get().getDate());
        assertEquals(exam.getAuthor(), retrievedExam.get().getAuthor());
        assertEquals(exam.getLesson(), retrievedExam.get().getLesson());
        assertEquals(exam.getLevel(), retrievedExam.get().getLevel());

        verify(examRepository, times(1)).findById(examId);
    }

    @Test
    void testUpdateExam() {
        Long examId = 1L;
        ExamModel existingExam = new ExamModel();
        existingExam.setId(examId);
        existingExam.setDate(LocalDate.now());
        existingExam.setAuthor("John Doe");
        existingExam.setLesson(Lesson.MATHEMATICS);
        existingExam.setLevel(Level.UPPER_PRIMARY);
        existingExam.getExamQuestions().add(new ExamQuestionModel(existingExam, null));

        ExamModel updatedExam = new ExamModel();
        updatedExam.setDate(LocalDate.now().plusDays(1));
        updatedExam.setAuthor("Jane Doe");
        updatedExam.setLesson(Lesson.MATHEMATICS);
        updatedExam.setLevel(Level.UPPER_PRIMARY);
        updatedExam.getExamQuestions().add(new ExamQuestionModel(updatedExam, null));

        when(examRepository.findById(examId)).thenReturn(Optional.of(existingExam));
        when(examRepository.save(any(ExamModel.class))).thenReturn(updatedExam);

        ExamModel result = examService.updateExam(examId, updatedExam);

        assertNotNull(result);
        assertEquals(updatedExam.getDate(), result.getDate());
        assertEquals(updatedExam.getAuthor(), result.getAuthor());
        assertEquals(updatedExam.getLesson(), result.getLesson());
        assertEquals(updatedExam.getLevel(), result.getLevel());
        assertEquals(1, result.getExamQuestions().size());

        verify(examRepository, times(1)).findById(examId);
        verify(examRepository, times(1)).save(any(ExamModel.class));
    }

    @Test
    void testDeleteExam() {
        Long examId = 1L;

        doNothing().when(examRepository).deleteById(examId);

        examService.deleteExam(examId);

        verify(examRepository, times(1)).deleteById(examId);
    }
}