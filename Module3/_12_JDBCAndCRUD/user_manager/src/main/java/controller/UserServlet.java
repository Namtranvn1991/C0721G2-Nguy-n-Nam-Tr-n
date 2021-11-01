package controller;



import beam.User;
import repository.impl.UserDAO;
import service.IUserDAOService;
import service.impl.UserDAOService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UserServlet", urlPatterns = {"/users",""})
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IUserDAOService iUserDAOService;

    public void init() {
        iUserDAOService = new UserDAOService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertUser(request, response);
                    break;
                case "edit":
                    updateUser(request, response);
                    break;
                case "search":
                    listSearchUser(request,response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listSearchUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String name = request.getParameter("name");
        String messenger = name + " is not found";
        List<User> listSearchUser = iUserDAOService.selectUsersByName(name);
        if(listSearchUser.isEmpty()){
            request.setAttribute("messenger", messenger);
        }
        request.setAttribute("listSearchUser", listSearchUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/search.jsp");
        dispatcher.forward(request, response);
    }




    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteUser(request, response);
                    break;
                case "search":
                    showSearchForm(request,response);
                    break;
                case "sort":
                    sortList(request,response);
                    break;
                case "permision":
                    addUserPermision(request, response);
                    break;
                case "test-without-tran":
                    testWithoutTran(request, response);
                    break;
                case "test-use-tran":
                    testUseTran(request, response);
                    break;
                case "add_user_tran":
                    addUseTran(request, response);
                    break;
                default:
                    listUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void addUseTran(HttpServletRequest request, HttpServletResponse response) {
        iUserDAOService.addUserTransaction();
    }


    private void testUseTran(HttpServletRequest request, HttpServletResponse response) {
        iUserDAOService.insertUpdateUseTransaction();

    }

    private void testWithoutTran(HttpServletRequest request, HttpServletResponse response) {
        iUserDAOService.insertUpdateWithoutTransaction();
    }

    private void addUserPermision(HttpServletRequest request, HttpServletResponse response) {

        User user = new User("quan", "quan.nguyen@codegym.vn", "vn");

        int[] permision = {1, 2, 4};

        iUserDAOService.addUserTransaction(user, permision);

    }

    private void sortList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> listUser = iUserDAOService.sortByName();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showSearchForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/search.jsp");
        dispatcher.forward(request, response);
    }


    private void listUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<User> listUser = iUserDAOService.selectAllUsers();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User existingUser = iUserDAOService.getUserById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/edit.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);

    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User newUser = new User(name, email, country);
        iUserDAOService.insertUserStore(newUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/create.jsp");
        dispatcher.forward(request, response);
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");

        User book = new User(id, name, email, country);
        iUserDAOService.updateUser(book);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        iUserDAOService.deleteUser(id);

        List<User> listUser = iUserDAOService.selectAllUsers();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
        dispatcher.forward(request, response);
    }
}