package controller;

import common.CheckExist;
import common.MenuException;
import common.Validate;
import model.Customer;
import model.Employee;
import service.IEmployeeService;
import service.impl.EmployeeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = {"/employee_servlet"})
public class EmployeeServlet extends HttpServlet {
    private IEmployeeService iEmployeeService = new EmployeeService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action_employee_post");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertEmployee(request, response);
                    break;
                case "edit":
                    editEmployee(request,response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void editEmployee (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        String code = request.getParameter("code");
//        if(CheckExist.checkEmployee(code)){
//            String messenger = "Employee code is exist";
//            request.setAttribute("error_messenger",messenger);
//            request.getRequestDispatcher("404_error.jsp").forward(request,response);
//        }
        String name = request.getParameter("name");
        String id_card = request.getParameter("id_card");
        String phone_number = request.getParameter("phone_number");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        int position = Integer.parseInt(request.getParameter("position"));
        int degree = Integer.parseInt(request.getParameter("degree"));
        int department = Integer.parseInt(request.getParameter("department"));
        double salary = Double.parseDouble(request.getParameter("salary"));

        try {
            Date birthday = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birthday"));
            Employee employee = new Employee(id,code, name, birthday, id_card, phone_number, address, email, position, degree, department, salary);
            try {
                Validate.validateEmployee(employee);
                iEmployeeService.updateEmployee(employee);
            } catch (MenuException e) {
                String messenger = e.getMessage();
                request.setAttribute("error_messenger",messenger);
                request.getRequestDispatcher("404_error.jsp").forward(request,response);
                e.printStackTrace();
            }
        } catch (ParseException e) {
            String messenger = "ParseException: validate Birthday failed";
            request.setAttribute("error_messenger",messenger);
            request.getRequestDispatcher("404_error.jsp").forward(request,response);
            e.printStackTrace();
        }
        listEmployee(request, response);
    }

    private void insertEmployee(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String code = request.getParameter("code");
        if(CheckExist.checkEmployee(code)){
            String messenger = "Employee code is exist";
            request.setAttribute("error_messenger",messenger);
            request.getRequestDispatcher("404_error.jsp").forward(request,response);
        }
        String name = request.getParameter("name");
        String id_card = request.getParameter("id_card");
        String phone_number = request.getParameter("phone_number");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        int position = Integer.parseInt(request.getParameter("position"));
        int degree = Integer.parseInt(request.getParameter("degree"));
        int department = Integer.parseInt(request.getParameter("department"));
        double salary = Double.parseDouble(request.getParameter("salary"));

        try {
            Date birthday = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birthday"));
            Employee employee = new Employee(code, name, birthday, id_card, phone_number, address, email, position, degree, department, salary);
            try {
                Validate.validateEmployee(employee);
                iEmployeeService.insertEmployee(employee);
            } catch (MenuException e) {
                String messenger = e.getMessage();
                request.setAttribute("error_messenger",messenger);
                request.getRequestDispatcher("404_error.jsp").forward(request,response);
                e.printStackTrace();
            }
        } catch (ParseException e) {
            String messenger = "ParseException: validate Birthday failed";
            request.setAttribute("error_messenger",messenger);
            request.getRequestDispatcher("404_error.jsp").forward(request,response);
            e.printStackTrace();
        }
        listEmployee(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action_employee_get");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create":
                    showCreateForm(request, response);
                    break;
                case "edit":
                    showEditForm(request,response);
                    break;
                case "delete":
                    deleteEmployee(request,response);
                    break;
                case "detail":
                    showDetail(request, response);
                    break;
                default:
                    listEmployee(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = iEmployeeService.selectEmployee(id);
        request.setAttribute("employee", employee);
        request.getRequestDispatcher("employee/edit.jsp").forward(request, response);
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        iEmployeeService.deleteEmployee(id);
        try {
            listEmployee(request,response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("employee/create.jsp");
    }

    private void showDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = iEmployeeService.selectEmployee(id);
        request.setAttribute("employee", employee);
        request.getRequestDispatcher("employee/detail.jsp").forward(request, response);
    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Employee> employeeList = iEmployeeService.selectAllEmployees();
        request.setAttribute("employeeList", employeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/list.jsp");
        dispatcher.forward(request, response);
    }
}
