package repository.impl;

import beam.BaseRepository;
import beam.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookRepository implements IBookRepository {
    private static final String SELECT_BOOK_BY_ID = "SELECT * FROM test_module_3.book where id_book = ?;";
    private static final String SELECT_ALL_BOOKS = "SELECT * FROM test_module_3.book;";
    private static final String UPDATE_BOOK = "UPDATE test_module_3.book SET quantity = ? WHERE (id_book = ?);";

    @Override
    public Book selectBook(int id_book) {
        Book book = null;
        try {
            Connection connection = BaseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOK_BY_ID);
            preparedStatement.setInt(1,id_book);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id_book");
                String code_book = resultSet.getString("code_book");
                String name_book = resultSet.getString("name_book");
                String author = resultSet.getString("author");
                String description = resultSet.getString("description_book");
                int quantity = resultSet.getInt("quantity");
                book = new Book(id_book,code_book,name_book,author,description,quantity);

            }
        } catch (SQLException throwables) {
            printSQLException(throwables);
            throwables.printStackTrace();
        }
        return book;
    }

    @Override
    public List<Book> selectAllBooks() {
        List<Book> books = new ArrayList<>();
        try {
            Connection connection = BaseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOKS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id_book = resultSet.getInt("id_book");
                String code_book = resultSet.getString("code_book");
                String name_book = resultSet.getString("name_book");
                String author = resultSet.getString("author");
                String description = resultSet.getString("description_book");
                int quantity = resultSet.getInt("quantity");
                Book book = new Book(id_book,code_book,name_book,author,description,quantity);
                books.add(book);
            }
        } catch (SQLException throwables) {
            printSQLException(throwables);
            throwables.printStackTrace();
        }
        return books;
    }

    public static void main(String[] args) {
        BookRepository bookRepository = new BookRepository();
        List<Book> books = bookRepository.selectAllBooks();
        for (Book book:books) {
            System.out.println(book);
        }
    }

    @Override
    public void updateBook(int id_book, int new_quantity) {
        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BOOK);){

            preparedStatement.setInt(2,id_book);
            preparedStatement.setInt(1,new_quantity);
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
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
