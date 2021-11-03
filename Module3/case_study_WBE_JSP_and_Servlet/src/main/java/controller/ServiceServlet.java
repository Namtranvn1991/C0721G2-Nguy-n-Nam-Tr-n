package controller;

import model.Employee;
import model.Service;
import model.TypeOfRent;
import model.TypeOfService;
import repository.IServiceRepository;
import repository.impl.ServiceRepository;
import repository.impl.TypeOfRentRepository;
import repository.impl.TypeOfServiceRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ServiceServlet", urlPatterns = {"/service_servlet"})
public class ServiceServlet extends HttpServlet {
    IServiceRepository iServiceRepository = new ServiceRepository();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action_service_get");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    showCreateForm(request,response);
                    break;
                case "edit":

                    break;
                case "delete":

                    break;
                default:
                    listEmployee(request, response);
                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }


    public void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TypeOfServiceRepository typeOfServiceRepository = new TypeOfServiceRepository();
        List<TypeOfService> typeOfServiceList = typeOfServiceRepository.selectAllTypeOfService();
        TypeOfRentRepository typeOfRentRepository = new TypeOfRentRepository();
        List<TypeOfRent> typeOfRentList = typeOfRentRepository.selectAllTypeOfRent();
        for (TypeOfService t: typeOfServiceList) {
            System.out.println(t);
        }
        for (TypeOfRent t: typeOfRentList) {
            System.out.println(t);
        }



        request.setAttribute("typeOfServiceList",typeOfServiceList);
        request.setAttribute("typeOfRentList",typeOfRentList);
        request.getRequestDispatcher("service/create.jsp").forward(request,response);
    }


    public void listEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Service> serviceList = iServiceRepository.selectAllServices();
        request.setAttribute("serviceList", serviceList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("service/list.jsp");
        dispatcher.forward(request, response);
    }
}
