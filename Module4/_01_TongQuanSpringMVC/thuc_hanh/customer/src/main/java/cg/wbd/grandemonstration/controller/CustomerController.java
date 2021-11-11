package cg.wbd.grandemonstration.controller;

import cg.wbd.grandemonstration.model.Customer;
import cg.wbd.grandemonstration.service.CustomerService;
import cg.wbd.grandemonstration.service.CustomerServiceFactory;
import cg.wbd.grandemonstration.service.impl.SimpleCustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Parameter;
import java.util.List;

@Controller
public class CustomerController {
//    private CustomerService customerService = CustomerServiceFactory.getInstance();

    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public String showList(Model model) {
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "customers/list";
    }

    @GetMapping("/info")
    public String showInfo(Model model,HttpServletRequest request){
        long id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.findOne(id);
        model.addAttribute("customer",customer);
        return "customers/info";
    }

    @PostMapping("/customerUpdate")
    public String updateInfo(Model model, HttpServletRequest request, HttpServletResponse response){
        long id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(id,name,email,address);
        customer = customerService.save(customer);
//        model.addAttribute("customer",customer);
        return "redirect:/";
    }


//    @RequestMapping(value = "/customers", method = RequestMethod.GET)
//    public ModelAndView showList() {
//        ModelAndView modelAndView = new ModelAndView("customers/list");
//        List<Customer> customers = customerService.findAll();
//        modelAndView.addObject("customers", customers);
//        return modelAndView;
//    }

}