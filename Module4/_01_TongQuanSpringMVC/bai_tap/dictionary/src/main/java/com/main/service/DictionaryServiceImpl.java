package com.main.service;

import com.main.repository.DictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryServiceImpl implements DictionaryService {
    @Autowired
    private DictionaryRepository dictionaryRepository;

    @Override
    public String search(String word) {
        return dictionaryRepository.search(word);
    }
}
