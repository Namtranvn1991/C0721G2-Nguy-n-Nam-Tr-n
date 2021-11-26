package com.main.blog.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IGeneralService<T> {
    List<T> findAll();

    T findById(Integer id);

    T save(T t);

    void remove(Integer id);

    Page<T> findAll(Pageable pageable);
}