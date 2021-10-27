import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculateServlet", urlPatterns = "/servlet")
public class CalculateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double no_1 = Double.parseDouble(request.getParameter("no_1"));
        double no_2 = Double.parseDouble(request.getParameter("no_2"));
        String operator = request.getParameter("operator");
        double result;
        String resultStr = "";
        switch (operator) {
            case "1":
                result = no_1 + no_2;
                resultStr = no_1 + " + " + no_2 + " = " + result;
                break;
            case "2":
                result = no_1 - no_2;
                resultStr = no_1 + " - " + no_2 + " = " + result;
                break;
            case "3":
                result = no_1 * no_2;
                resultStr = no_1 + " x " + no_2 + " = " + result;
                break;
            case "4":
                if(no_2!=0){
                    result = no_1 / no_2;
                    resultStr = no_1 + " / " + no_2 + " = " + result;
                }else {
                    resultStr = "can't divide zero";
                }
                break;
        }
        request.setAttribute("result", resultStr);
        request.getRequestDispatcher("calculate.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
