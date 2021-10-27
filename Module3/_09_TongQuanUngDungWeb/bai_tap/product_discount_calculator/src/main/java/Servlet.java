import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet", urlPatterns = "/product_discount_calculator")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("description");
        String price = request.getParameter("price");
        String discount = request.getParameter("discount");
        try {
            double pride_d = Double.parseDouble(price);
            double discount_d = Double.parseDouble(discount);
            double discount_amount = pride_d*discount_d*0.01;
            double price_after_discount = pride_d - discount_amount;
            request.setAttribute("description",description);
            request.setAttribute("discount_amount",discount_amount);
            request.setAttribute("price_after_discount",price_after_discount);
            request.getRequestDispatcher("index.jsp").forward(request,response);
        } catch (Exception e){
            PrintWriter writer = response.getWriter();
            writer.println("<html>");
            writer.println("<h1> input Error </h1>");
            writer.println("</html>");
        }
    }
}
