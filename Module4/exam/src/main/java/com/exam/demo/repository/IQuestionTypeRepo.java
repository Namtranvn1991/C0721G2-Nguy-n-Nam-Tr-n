package com.exam.demo.repository;

import com.exam.demo.model.QuestionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuestionTypeRepo extends JpaRepository<QuestionType,Integer> {
}
