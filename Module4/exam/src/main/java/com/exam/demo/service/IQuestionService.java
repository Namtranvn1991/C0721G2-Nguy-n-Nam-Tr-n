package com.exam.demo.service;

import com.exam.demo.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IQuestionService extends IGeneralService<Question> {
    Page<Question> findAll(Pageable pageable);
    Page<Question> findAllByType(Integer id,Pageable pageable);
    Page<Question> findAllByTitle(String keyword, Pageable pageable);
}
