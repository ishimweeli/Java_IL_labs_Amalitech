package com.onlineExamination.userService.repository;

import com.onlineExamination.userService.model.QuestionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<QuestionModel, Long> {
}