package controller;

import model.Customer;
import service.impl.CustomerService;
import service.ICustomerService;

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

@WebServlet(name = "CustomerServlet", urlPatterns = {"/customer_servlet"})
public class CustomerServlet extends HttpServlet {
    private ICustomerService iCustomerService = new CustomerService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action_customer_post");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertCustomer(request,response);
                    break;
                case "edit":
                    editCustomer(request,response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String name = request.getParameter("name");
        String id_card = request.getParameter("id_card");
        String phone_number = request.getParameter("phone_number");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        int type_customer = Integer.parseInt(request.getParameter("type_customer"));
        int id = Integer.parseInt(request.getParameter("id"));

        try {
            Date birthday = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birthday"));
            Customer customer = new Customer(id,name,birthday,id_card,phone_number,address,email,type_customer);
            iCustomerService.updateCustomer(customer);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        listCustomer(request,response);
    }

    private void insertCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String name = request.getParameter("name");
        String id_card = request.getParameter("id_card");
        String phone_number = request.getParameter("phone_number");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        int type_customer = Integer.parseInt(request.getParameter("type_customer"));

//        String date = request.getParameter("birthday");

        try {
            Date birthday = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birthday"));
            Customer customer = new Customer(name,birthday,id_card,phone_number,address,email,type_customer);
            iCustomerService.insertCustomer(customer);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        listCustomer(request,response);
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action_customer_get");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create":
                    showCreateForm(request,response);
                    break;
                case "edit":
                    showEditForm(request,response);
                    break;
                case "delete":
                    deleteCustomer(request,response);
                    break;
                case "detail":
                    showDetail(request,response);
                    break;
                default:
                    listCustomer(request,response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }

    }

    private void  showEditForm (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = iCustomerService.selectCustomer(id);
        request.setAttribute("customer",customer);
        request.getRequestDispatcher("customer/edit.jsp").forward(request,response);
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        iCustomerService.deleteCustomer(id);
        try {
            listCustomer(request,response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }



    private void  showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.sendRedirect("customer/create.jsp");
    }

    private void  showDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = iCustomerService.selectCustomer(id);
        request.setAttribute("customer",customer);
        request.getRequestDispatcher("customer/detail.jsp").forward(request,response);
    }



    private void listCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Customer> customerList =iCustomerService.selectAllCustomers();
        request.setAttribute("customerList",customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
        dispatcher.forward(request, response);
    }
}
