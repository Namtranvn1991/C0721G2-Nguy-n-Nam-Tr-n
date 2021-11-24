package com.main.demo.service;

import com.main.demo.model.BorrowBook;
import com.main.demo.repository.IBookRepo;
import com.main.demo.repository.IBorrowBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BorrowBookService implements IBorrowBookService {

    @Autowired
    IBorrowBookRepo iBorrowBookRepo;
    @Autowired
    IBookRepo iBookRepo;

    @Override
    public List<BorrowBook> findAll() {
        return iBorrowBookRepo.findAll();
    }

    @Override
    public BorrowBook findById(Integer id) {
        return iBorrowBookRepo.findById(id).orElse(null);
    }

    @Override
    public void borrowBook(BorrowBook borrowBook) {
        iBorrowBookRepo.save(borrowBook);
        iBookRepo.borrowBook(borrowBook.getBook().getBookId());
    }

    @Override
    public void returnBook(Integer id) {
        iBorrowBookRepo.returnBook(id);
        BorrowBook borrowBook = iBorrowBookRepo.findById(id).orElse(null);
        iBookRepo.returnBook(borrowBook.getBook().getBookId());
    }

    @Override
    public void saveBorrowBook(BorrowBook borrowBook) {
        iBorrowBookRepo.save(borrowBook);
    }
}
