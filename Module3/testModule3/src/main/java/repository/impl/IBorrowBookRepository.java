package repository.impl;

import beam.BorrowBook;

import java.sql.SQLException;
import java.util.List;

public interface IBorrowBookRepository {
    public void insertBorrowBook(BorrowBook BorrowBook) throws SQLException;

    public BorrowBook selectBorrowBook(int id);

    public List<BorrowBook> selectAllBorrowBooks();
}
