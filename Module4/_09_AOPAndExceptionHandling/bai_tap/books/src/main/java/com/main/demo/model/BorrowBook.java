package com.main.demo.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class BorrowBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_borrow_book;
    private String code_borrow_book;
    private String studentName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date_borrow;

    @Column(columnDefinition = "boolean default true")
    private Boolean status;

    @ManyToOne(targetEntity = Book.class)
    @JoinColumn(name = "bookId")
    private Book book;

    public BorrowBook() {
    }

    public Integer getId_borrow_book() {
        return id_borrow_book;
    }

    public void setId_borrow_book(Integer id_borrow_book) {
        this.id_borrow_book = id_borrow_book;
    }

    public String getCode_borrow_book() {
        return code_borrow_book;
    }

    public void setCode_borrow_book(String code_borrow_book) {
        this.code_borrow_book = code_borrow_book;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Date getDate_borrow() {
        return date_borrow;
    }

    public void setDate_borrow(Date date_borrow) {
        this.date_borrow = date_borrow;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
