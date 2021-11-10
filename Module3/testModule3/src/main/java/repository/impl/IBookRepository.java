package repository.impl;

import beam.Book;

import java.util.List;

public interface IBookRepository {
    public Book selectBook(int id_book);

    public List<Book> selectAllBooks();

    public void updateBook(int id_book, int new_quantity);
}
