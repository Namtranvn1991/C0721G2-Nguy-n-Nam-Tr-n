package com.example.demo.service;

import java.util.List;

public interface IGeneralServiceT<T> {
    List<T> findAll();

    T findById(String id);

    void save(T t);

    void remove(String id);
}
