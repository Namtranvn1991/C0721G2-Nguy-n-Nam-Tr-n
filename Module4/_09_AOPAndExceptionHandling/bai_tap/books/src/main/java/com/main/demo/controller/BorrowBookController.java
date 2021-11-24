package com.main.demo.controller;

import com.main.demo.model.Book;
import com.main.demo.model.BorrowBook;
import com.main.demo.service.IBookService;
import com.main.demo.service.IBorrowBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Controller
public class BorrowBookController {
    @Autowired
    IBookService iBookService;

    @Autowired
    IBorrowBookService iBorrowBookService;


    @GetMapping(value = "")
    public String getBookList(Model model){
       model.addAttribute("books",iBookService.findAll());
       return "bookList";
    }

    @GetMapping(value = "/borrowlist")
    public String getBorrowList(Model model){
        model.addAttribute("borrows",iBorrowBookService.findAll());
        return "borrowList";
    }

    @GetMapping(value = "/borrowbook/{id}")
    public String getBorrowForm(@PathVariable("id") Integer id, Model model){
        Book book = iBookService.findById(id);
        BorrowBook borrowBook = new BorrowBook();
        borrowBook.setBook(book);
        model.addAttribute("borrow",borrowBook);
        return "borrowForm";
    }

    @PostMapping(value = "/borrowbook")
    public String borrowBook(@ModelAttribute("borrow")BorrowBook borrowBook){
        borrowBook.setDate_borrow(java.sql.Date.valueOf(LocalDate.now()));
        borrowBook.setStatus(true);
        if(borrowBook.getBook().getQuantity()<=0){
            return "404";
        }
        iBorrowBookService.borrowBook(borrowBook);
        return "redirect:/borrowlist";
    }

    @GetMapping(value = "/return/{id}")
    public String returnBook(@PathVariable("id") Integer id){
//        BorrowBook borrowBook = iBorrowBookService.findById(id);
//        borrowBook.setStatus(false);
        iBorrowBookService.returnBook(id);
        return "redirect:/borrowlist";
    }
}
