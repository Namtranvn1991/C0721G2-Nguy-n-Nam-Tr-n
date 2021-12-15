package com.exam.demo.service;

import com.exam.demo.model.Question;
import com.exam.demo.repository.IQuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService implements IQuestionService {
    @Autowired
    IQuestionRepo iQuestionRepo;

    @Override
    public List<Question> findAll() {
        return null;
    }

    @Override
    public Question findById(Integer id) {
        return iQuestionRepo.findById(id).orElse(null);
    }

    @Override
    public void save(Question question) {
        iQuestionRepo.save(question);
    }

    @Override
    public void remove(Integer id) {
        iQuestionRepo.deleteById(id);
    }

    @Override
    public Page<Question> findAll(Pageable pageable) {
        return iQuestionRepo.findAll(pageable);
    }

    @Override
    public Page<Question> findAllByType(Integer id, Pageable pageable) {
        return iQuestionRepo.findAllByType(id,pageable);
    }

    @Override
    public Page<Question> findAllByTitle(String keyword, Pageable pageable) {
        return iQuestionRepo.findAllByTitleContaining(keyword,pageable);
    }
}
