package controller;

import beam.Book;
import beam.BorrowBook;
import beam.Student;
import repository.impl.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "BorrowServlet", urlPatterns = "/borrow_servlet")
public class BorrowServlet extends HttpServlet {
    IBookRepository iBookRepository = new BookRepository();
    IStudentRepository iStudentRepository = new StudentRepository();
    IBorrowBookRepository iBorrowBookRepository = new BorrowBookRepository();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action_borrow_post");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    createBorrow(request,response);
                    break;
                case "edit":

                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    public void createBorrow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String code_borrow = request.getParameter("code_borrow");
        int id_book = Integer.parseInt(request.getParameter("id_book"));
        int id_student = Integer.parseInt(request.getParameter("id_student"));
        String date_borrow = request.getParameter("date_borrow");
        String date_give_back = request.getParameter("date_give_back");
        Book book = iBookRepository.selectBook(id_book);
        Student student = iStudentRepository.selectStudent(id_student);

        BorrowBook borrowBook = new BorrowBook(code_borrow,book,student,date_borrow,date_give_back);
        iBorrowBookRepository.insertBorrowBook(borrowBook);

        listBorrow(request,response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action_borrow_get");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    showCreateForm(request, response);
                    break;
                default:
                    listBorrow(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void  showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        Book book = iBookRepository.selectBook(id);
        List<Student> studentList = iStudentRepository.selectAllStudents();
        request.setAttribute("book",book);
        request.setAttribute("studentList",studentList);
        request.getRequestDispatcher("borrow.jsp").forward(request,response);
    }


    private void listBorrow(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<BorrowBook> borrowBooks = iBorrowBookRepository.selectAllBorrowBooks();
        request.setAttribute("borrowBooks", borrowBooks);
        RequestDispatcher dispatcher = request.getRequestDispatcher("borrow_list.jsp");
        dispatcher.forward(request, response);
    }

}
