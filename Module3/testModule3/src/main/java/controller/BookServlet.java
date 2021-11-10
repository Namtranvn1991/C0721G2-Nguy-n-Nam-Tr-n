package controller;

import beam.Book;
import repository.impl.BookRepository;
import repository.impl.IBookRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookServlet",urlPatterns = "/book_servlet")
public class BookServlet extends HttpServlet {
        IBookRepository iBookRepository = new BookRepository();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> bookList = iBookRepository.selectAllBooks();
        request.setAttribute("bookList",bookList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("book/list.jsp");
        dispatcher.forward(request, response);
    }
}
