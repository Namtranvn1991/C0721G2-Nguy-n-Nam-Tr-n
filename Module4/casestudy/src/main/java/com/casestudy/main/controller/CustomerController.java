package com.casestudy.main.controller;

import com.casestudy.main.model.customer.Customer;
import com.casestudy.main.model.customer.CustomerType;
import com.casestudy.main.repository.employee.IUserRepo;
import com.casestudy.main.service.customer.ICustomerService;
import com.casestudy.main.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "customer")
public class CustomerController {
    @Autowired
    ICustomerService iCustomerService;

    @Autowired
    ICustomerTypeService iCustomerTypeService;

    @Autowired
    IUserRepo iUserRepo;

    @ModelAttribute("customerType")
    public List<CustomerType> customerTypes(){
        return iCustomerTypeService.findAll();
    }


//    @GetMapping(value = "")
//    public String getListPage(Model model){
//        model.addAttribute("customerList",iCustomerService.findAll());
//        return "customer/list";
//    }

    @GetMapping(value = "")
    public String getListPage(Model model,@PageableDefault(size = 5) Pageable pageable){
//        Page<Customer> customers;
//        customers = iCustomerService.findAll(pageable);

        model.addAttribute("customerList",iCustomerService.findAll(pageable));
        return "customer/list";
    }

    @GetMapping(value = "create")
    public String getCreatePage(Model model){
        model.addAttribute("customer",new Customer());
        return "customer/create";
    }

    @PostMapping(value = "create")
    public String createCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult,RedirectAttributes redirectAttributes){
        new Customer().validate(customer,bindingResult);
        if (bindingResult.hasErrors()){
            return "customer/create";
        }
        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("msg","create success");
        return "redirect:/customer";
    }

    @GetMapping(value = "edit/{id}")
    public String getEditPage(@PathVariable("id") Integer id,Model model){
        model.addAttribute("customer",iCustomerService.findById(id));
        return "customer/edit";
    }

    @PostMapping(value = "edit")
    public String editCustomer(@Valid @ModelAttribute Customer customer, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        new Customer().validate(customer,bindingResult);
        if (bindingResult.hasErrors()){
            return "customer/edit";
        }
        redirectAttributes.addFlashAttribute("msg","edit success");
        iCustomerService.save(customer);
        return "redirect:/customer";
    }
}
