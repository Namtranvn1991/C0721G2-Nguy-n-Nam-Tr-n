package com.main.demo.service;

import com.main.demo.model.BorrowBook;

import java.util.List;

public interface IBorrowBookService {
    public List<BorrowBook> findAll();
    public BorrowBook findById(Integer id);
    public void borrowBook(BorrowBook borrowBook);
    public void returnBook(Integer id);
    public void saveBorrowBook(BorrowBook borrowBook);
}
