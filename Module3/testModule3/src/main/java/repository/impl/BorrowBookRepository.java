package repository.impl;

import beam.BaseRepository;
import beam.Book;
import beam.BorrowBook;
import beam.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class BorrowBookRepository implements IBorrowBookRepository {
    IBookRepository iBookRepository = new BookRepository();
    IStudentRepository iStudentRepository = new StudentRepository();

    private static final String INSERT_BORROW_SQL = "INSERT INTO test_module_3.borrow_book (code_borrow_book, id_book, id_student, day_borrow, day_give_back) VALUES (?, ?, ?, ?, ?);";
    private static final String SELECT_BORROW_BY_ID = "SELECT * FROM test_module_3.borrow_book where id_borrow_book = ?;";
    private static final String SELECT_ALL_BORROWS = "SELECT * FROM test_module_3.borrow_book;";

    @Override
    public void insertBorrowBook(BorrowBook BorrowBook) throws SQLException {
        try {
            Connection connection = BaseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BORROW_SQL);
            preparedStatement.setString(1,BorrowBook.getCode_borrow_book());
            preparedStatement.setInt(2,BorrowBook.getBook().getId_book());
            preparedStatement.setInt(3,BorrowBook.getStudent().getId_student());

            preparedStatement.setString(4,BorrowBook.getDate_borrow());
            preparedStatement.setString(5,BorrowBook.getDate_give_back());

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            printSQLException(throwables);
            throwables.printStackTrace();
        }
    }

    @Override
    public BorrowBook selectBorrowBook(int id_borrow_book) {
        BorrowBook borrowBook = null;

        try {
            Connection connection = BaseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BORROW_BY_ID);
            preparedStatement.setInt(1,id_borrow_book);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id_borrow_book");
                String code_borrow_book = resultSet.getString("code_borrow_book");
                int id_book = resultSet.getInt("id_book");
                int id_student = resultSet.getInt("id_student");
                boolean status = resultSet.getBoolean("status_borrow_book");
                String day_borrow = resultSet.getString("day_borrow");
                String day_give_back = resultSet.getString("day_give_back");
                Book book = iBookRepository.selectBook(id_book);
                Student student = iStudentRepository.selectStudent(id_student);

                borrowBook = new BorrowBook(id_borrow_book,code_borrow_book,book,student,status,day_borrow,day_give_back);

            }
        } catch (SQLException throwables) {
            printSQLException(throwables);
            throwables.printStackTrace();
        }
        return borrowBook;
    }

    @Override
    public List<BorrowBook> selectAllBorrowBooks() {
        List<BorrowBook> borrowBooks = new ArrayList<>();
        try {
            Connection connection = BaseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BORROWS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id_borrow_book = resultSet.getInt("id_borrow_book");
                String code_borrow_book = resultSet.getString("code_borrow_book");
                int id_book = resultSet.getInt("id_book");
                int id_student = resultSet.getInt("id_student");
                boolean status = resultSet.getBoolean("status_borrow_book");
                String day_borrow = resultSet.getString("day_borrow");
                String day_give_back = resultSet.getString("day_give_back");
                Book book = iBookRepository.selectBook(id_book);
                Student student = iStudentRepository.selectStudent(id_student);
                BorrowBook borrowBook = new BorrowBook(id_borrow_book,code_borrow_book,book,student,status,day_borrow,day_give_back);
                borrowBooks.add(borrowBook);
            }
        } catch (SQLException throwables) {
            printSQLException(throwables);
            throwables.printStackTrace();
        }
        return borrowBooks;
    }

    public static void main(String[] args) {
        BorrowBookRepository borrowBookRepository = new BorrowBookRepository();
        List<BorrowBook> books = borrowBookRepository.selectAllBorrowBooks();
        for (BorrowBook book:books) {
            System.out.println(book);
        }
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
