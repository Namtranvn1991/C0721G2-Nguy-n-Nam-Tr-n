package com.casestudy.main.controller;

import com.casestudy.main.model.customer.Customer;
import com.casestudy.main.model.customer.CustomerType;
import com.casestudy.main.service.customer.ICustomerService;
import com.casestudy.main.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "customer")
public class CustomerController {
    @Autowired
    ICustomerService iCustomerService;

    @Autowired
    ICustomerTypeService iCustomerTypeService;

    @ModelAttribute("customerType")
    public List<CustomerType> customerTypes(){
        return iCustomerTypeService.findAll();
    }

    @GetMapping(value = "")
    public String getListPage(Model model){
        model.addAttribute("customerList",iCustomerService.findAll());
        return "customer/list";
    }

    @GetMapping(value = "create")
    public String getCreatePage(Model model){
        model.addAttribute("customer",new Customer());
        return "customer/create";
    }

    @PostMapping(value = "create")
    public String createCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult){
        new Customer().validate(customer,bindingResult);
        if (bindingResult.hasErrors()){
            return "customer/create";
        }
        iCustomerService.save(customer);
        return "redirect:/customer";
    }
}
