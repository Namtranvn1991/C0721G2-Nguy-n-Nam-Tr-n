package com.main.demo.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;

    private String code_book;
    private String name_book;
    private String author;
    private String description;

    private Integer quantity;

    @OneToMany(mappedBy = "book")
    private List<BorrowBook> borrowBooks;

    public Book() {
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getCode_book() {
        return code_book;
    }

    public void setCode_book(String code_book) {
        this.code_book = code_book;
    }

    public String getName_book() {
        return name_book;
    }

    public void setName_book(String name_book) {
        this.name_book = name_book;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public List<BorrowBook> getBorrowBooks() {
        return borrowBooks;
    }

    public void setBorrowBooks(List<BorrowBook> borrowBooks) {
        this.borrowBooks = borrowBooks;
    }
}
