package controller;

import model.Contract;
import model.Customer;
import repository.impl.ContractRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ContractServlet", urlPatterns = {"/contract_servlet"})
public class ContractServlet extends HttpServlet {
    ContractRepository contractRepository = new ContractRepository();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action_customer_post");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":

                    break;
                case "edit":

                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action_customer_get");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create":

                    break;
                case "edit":

                    break;
                case "delete":

                    break;
                case "detail":

                    break;
                default:
                    listContract(request,response);
                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }

    }

    private void listContract(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Contract> contractList = contractRepository.selectAllContracts();
        request.setAttribute("contractList",contractList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("contract/list.jsp");
        dispatcher.forward(request, response);

    }
}
