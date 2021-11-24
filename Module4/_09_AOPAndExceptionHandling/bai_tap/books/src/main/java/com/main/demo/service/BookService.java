package com.main.demo.service;

import com.main.demo.model.Book;
import com.main.demo.repository.IBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {

    @Autowired
    IBookRepo iBookRepo;

    @Override
    public List<Book> findAll() {
        return iBookRepo.findAll();
    }

    @Override
    public Book findById(Integer id) {
        return iBookRepo.findById(id).orElse(null);
    }

    @Override
    public void borrowBook(Integer id) {
        iBookRepo.borrowBook(id);
    }

    @Override
    public void returnBook(Integer id) {
        iBookRepo.returnBook(id);
    }
}
