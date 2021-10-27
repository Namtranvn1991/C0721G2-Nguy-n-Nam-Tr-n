import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "sumServlet", urlPatterns = "/sumServlet")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            double n1 = Double.parseDouble(request.getParameter("no_1"));
            double n2 = Double.parseDouble(request.getParameter("no_2"));
            double result = n1 + n2;
            request.setAttribute("resultFromServlet", result);
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }catch(Exception e){
            String alert = "input number";
            request.setAttribute("resultFromServlet", alert);
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
    }
}
