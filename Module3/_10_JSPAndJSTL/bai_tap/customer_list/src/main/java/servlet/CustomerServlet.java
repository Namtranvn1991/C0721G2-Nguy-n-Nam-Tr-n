package servlet;

import beam.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "")
public class CustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = new ArrayList<>();
        int number = 0;

        customerList.add(new Customer("Mai Văn Hoàng", new Date(1983 - 1900, 7, 20), "Hà Nội", "https://cdn.icon-icons.com/icons2/2643/PNG/512/male_boy_person_people_avatar_icon_159358.png"));
        customerList.add(new Customer("Nguyễn Văn Nam", new Date(1983 - 1900, 7, 21), "Bắc Giang", "https://cdn.icon-icons.com/icons2/2643/PNG/512/male_boy_person_people_avatar_icon_159358.png"));
        customerList.add(new Customer("Nguyễn Thái Hòa", new Date(1983 - 1900, 7, 22), "Nam Định", "https://cdn.icon-icons.com/icons2/2643/PNG/512/male_boy_person_people_avatar_icon_159358.png"));
        customerList.add(new Customer("Trần Đăng Khoa", new Date(1983 - 1900, 7, 17), "Hà Tây", "https://cdn.icon-icons.com/icons2/2643/PNG/512/male_boy_person_people_avatar_icon_159358.png"));
        customerList.add(new Customer("Nguyễn Đình Thi", new Date(1983 - 1900, 7, 19), "Hà Nội", "https://cdn.icon-icons.com/icons2/2643/PNG/512/male_boy_person_people_avatar_icon_159358.png"));

        request.setAttribute("customerListServlet", customerList);
        request.setAttribute("number", number);
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    static String dateToString(Date date) {
        String dateStr = (date.getYear() + 1900) + "-" + (date.getMonth() + 1) + "-" + date.getDay();
        return dateStr;
    }
}
