package controller;

import common.CheckExist;
import common.MenuException;
import common.Validate;
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
import java.util.List;

@WebServlet(name = "ServiceServlet", urlPatterns = {"/service_servlet"})
public class ServiceServlet extends HttpServlet {
    IServiceRepository iServiceRepository = new ServiceRepository();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action_service_post");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    createService(request,response);
                    break;
                case "edit":
                    updateService(request, response);
                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    public void createService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name_service");
        if(CheckExist.checkService(name)){
            String messenger = "Service name is exist";
            request.setAttribute("error_messenger",messenger);
            request.getRequestDispatcher("service/create.jsp").forward(request,response);
            return;
        }
        int area = Integer.parseInt(request.getParameter("area"));
        int floor = Integer.parseInt(request.getParameter("floor"));
        int max_people = Integer.parseInt(request.getParameter("max_people"));
        int typeOfRent = Integer.parseInt(request.getParameter("idTypeOfRent"));
        int typeOfService = Integer.parseInt(request.getParameter("idTypeOfService"));
        String status = request.getParameter("status");
        Service service = new Service(name,area,floor,max_people,status,new TypeOfRent(typeOfRent),new TypeOfService(typeOfService));
        try {
            Validate.validateService(service);
            iServiceRepository.insertService(service);
        } catch (MenuException e) {
            String messenger = e.getMessage();
            e.printStackTrace();
            request.setAttribute("error_messenger",messenger);
            request.getRequestDispatcher("404_error.jsp").forward(request,response);
        }
        listService(request,response);
    }

    public void updateService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name_service");
        int area = Integer.parseInt(request.getParameter("area"));
        int floor = Integer.parseInt(request.getParameter("floor"));
        int max_people = Integer.parseInt(request.getParameter("max_people"));
        int typeOfRent = Integer.parseInt(request.getParameter("idTypeOfRent"));
        int typeOfService = Integer.parseInt(request.getParameter("idTypeOfService"));
        String status = request.getParameter("status");
        Service service = new Service(id,name,area,floor,max_people,status,new TypeOfRent(typeOfRent),new TypeOfService(typeOfService));
        try {
            Validate.validateService(service);
            iServiceRepository.updateService(service);
        } catch (MenuException e) {
            String messenger = e.getMessage();
            e.printStackTrace();
            request.setAttribute("error_messenger",messenger);
            request.getRequestDispatcher("404_error.jsp").forward(request,response);
        }
        listService(request,response);
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
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteService(request, response);
                    break;
                default:
                    listService(request, response);
                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    public void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Service service = iServiceRepository.selectService(id);
        TypeOfServiceRepository typeOfServiceRepository = new TypeOfServiceRepository();
        List<TypeOfService> typeOfServiceList = typeOfServiceRepository.selectAllTypeOfService();
        TypeOfRentRepository typeOfRentRepository = new TypeOfRentRepository();
        List<TypeOfRent> typeOfRentList = typeOfRentRepository.selectAllTypeOfRent();
        request.setAttribute("typeOfServiceList",typeOfServiceList);
        request.setAttribute("typeOfRentList",typeOfRentList);
        request.setAttribute("service",service);
        request.getRequestDispatcher("service/edit.jsp").forward(request,response);
    }


    public void deleteService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        iServiceRepository.deleteService(id);
        listService(request,response);
    }

    public void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TypeOfServiceRepository typeOfServiceRepository = new TypeOfServiceRepository();
        List<TypeOfService> typeOfServiceList = typeOfServiceRepository.selectAllTypeOfService();
        TypeOfRentRepository typeOfRentRepository = new TypeOfRentRepository();
        List<TypeOfRent> typeOfRentList = typeOfRentRepository.selectAllTypeOfRent();
        request.setAttribute("typeOfServiceList",typeOfServiceList);
        request.setAttribute("typeOfRentList",typeOfRentList);
        request.getRequestDispatcher("service/create.jsp").forward(request,response);
    }


    public void listService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Service> serviceList = iServiceRepository.selectAllServices();
        request.setAttribute("serviceList", serviceList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("service/list.jsp");
        dispatcher.forward(request, response);
    }
}
