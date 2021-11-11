package com.main.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DictionaryRepositoryImpl implements DictionaryRepository {
    private static Map<String,String> dicMap = new HashMap<>();

    static {
        dicMap.put("cat","meo");
        dicMap.put("dog","cho");
        dicMap.put("house","nha");
        dicMap.put("money","tien");
        dicMap.put("bird","chim");
        dicMap.put("lion","ho");
    }

    @Override
    public String search(String word) {
        if (dicMap.containsKey(word)){
            return dicMap.get(word);
        }else {
            return null;
        }
    }
}
