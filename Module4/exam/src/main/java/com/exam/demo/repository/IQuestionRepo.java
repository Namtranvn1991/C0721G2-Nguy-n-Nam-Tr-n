package com.exam.demo.repository;

import com.exam.demo.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuestionRepo extends JpaRepository<Question,Integer> {

    Page<Question> findAllByTitleContaining(String t, Pageable p);

    @Query(value="select * FROM question join question_type on question.question_type_id = question_type.question_type_id where question.question_type_id = :id ", nativeQuery=true)
    Page<Question> findAllByType(@Param("id") Integer id, Pageable pageable);

}
