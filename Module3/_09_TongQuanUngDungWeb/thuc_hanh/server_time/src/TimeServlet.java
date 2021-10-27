import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;

@WebServlet(name = "TimeServlet", urlPatterns = "/timeServlet")
public class TimeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LocalDateTime now = LocalDateTime.now();
        String s = now.toString();
        request.setAttribute("nowTime",s);
        request.getRequestDispatcher("server_time.jsp").forward(request,response);
    }
}
