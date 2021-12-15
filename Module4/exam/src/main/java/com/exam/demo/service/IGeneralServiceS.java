package com.exam.demo.service;

import java.util.List;

public interface IGeneralServiceS<T> {
    List<T> findAll();

    T findById(String id);

    void save(T t);

    void remove(String id);
}
