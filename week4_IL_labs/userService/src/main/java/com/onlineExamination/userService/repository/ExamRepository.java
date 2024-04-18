package com.onlineExamination.userService.repository;

import com.onlineExamination.userService.model.ExamModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<ExamModel, Long> {
}