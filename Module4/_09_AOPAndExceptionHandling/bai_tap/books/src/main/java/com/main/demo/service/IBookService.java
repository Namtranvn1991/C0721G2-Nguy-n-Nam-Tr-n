package com.main.demo.service;

import com.main.demo.model.Book;

import java.util.List;

public interface IBookService {
    public List<Book> findAll();
    public Book findById(Integer id);
    public void borrowBook(Integer id);
    public void returnBook(Integer id);
}
