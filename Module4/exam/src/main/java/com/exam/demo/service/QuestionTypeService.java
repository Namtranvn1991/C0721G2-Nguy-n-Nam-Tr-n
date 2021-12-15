package com.exam.demo.service;

import com.exam.demo.model.QuestionType;
import com.exam.demo.repository.IQuestionTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionTypeService implements IQuestionTypeService {
    @Autowired
    IQuestionTypeRepo iQuestionTypeRepo;

    @Override
    public List<QuestionType> findAll() {
        return iQuestionTypeRepo.findAll();
    }

    @Override
    public QuestionType findById(Integer id) {
        return iQuestionTypeRepo.findById(id).orElse(null);
    }

    @Override
    public void save(QuestionType questionType) {

    }

    @Override
    public void remove(Integer id) {

    }
}
