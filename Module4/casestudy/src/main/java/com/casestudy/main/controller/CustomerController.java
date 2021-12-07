package com.casestudy.main.controller;

import com.casestudy.main.model.customer.Customer;
import com.casestudy.main.model.customer.CustomerType;
import com.casestudy.main.model.service.Service;
import com.casestudy.main.repository.employee.IUserRepo;
import com.casestudy.main.service.customer.ICustomerService;
import com.casestudy.main.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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

//    @GetMapping(value = "")
//    public String getListPage(Model model,@PageableDefault(size = 1)Pageable pageable){
//        return getListPageCustomer(model,pageable, "null");
//    }

    @GetMapping(value = "")
    public String getListPageCustomer(Model model,@PageableDefault(size = 1) Pageable pageable,@RequestParam ("keyword") Optional<String> keyword){
        if (keyword.isPresent()){
            model.addAttribute("customerList",iCustomerService.search(keyword.get(),pageable));
            model.addAttribute("keyword",keyword);
        } else {
            model.addAttribute("customerList",iCustomerService.findAll(pageable));
        }
        return "customer/list";
    }

//    @GetMapping(value = "search")
//    public String search(@RequestParam("keyword") String keyword,@PageableDefault(size = 5) Pageable pageable,Model model ){
//        model.addAttribute("customerList",iCustomerService.search(keyword,pageable));
//        return "customer/list";
//    }

    @GetMapping(value = "create")
    public String getCreatePage(Model model){
        model.addAttribute("customer",new Customer());
        return "customer/create";
    }

    @PostMapping(value = "create")
    public String createCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes, Model model) {
        new Customer().validate(customer,bindingResult);
        if (bindingResult.hasErrors()){
            return "customer/create";
        }
        try {
            iCustomerService.save(customer);
        } catch (DuplicateKeyException e){
            if(iCustomerService.existsByCustomerEmail(customer.getCustomerEmail())){
                model.addAttribute("msg","Duplicate Email");
            }
            if(iCustomerService.existsByCustomerPhone(customer.getCustomerPhone())){
                model.addAttribute("msg","Duplicate Phone");
            }
            if(iCustomerService.existsByCustomerIdCard(customer.getCustomerIdCard())){
                model.addAttribute("msg","Duplicate IdCard");
            }
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
    public String editCustomer(@Valid @ModelAttribute Customer customer, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){
        new Customer().validate(customer,bindingResult);
        if (bindingResult.hasErrors()){
            return "customer/edit";
        }
        try {
            iCustomerService.save(customer);
        } catch (DuplicateKeyException e){
            model.addAttribute("msg","Duplicate");
            return "customer/edit";
        }
        redirectAttributes.addFlashAttribute("msg","edit success");

        return "redirect:/customer";
    }

    @GetMapping(value = "detail/{id}")
    public ModelAndView detail(@PathVariable("id") Integer id){
        ModelAndView modelAndView = new ModelAndView("customer/detail");
        Customer customer = iCustomerService.findById(id);
        modelAndView.addObject("customer",customer);
        return modelAndView;
    }


    @GetMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") Integer id,RedirectAttributes redirectAttributes){
        iCustomerService.remove(id);
        redirectAttributes.addFlashAttribute("msg","delete success");
        return "redirect:/customer";
    }
//    @ExceptionHandler(DuplicateKeyException.class)
//    public ModelAndView showInputNotAcceptable(DuplicateKeyException e) {
//        e.printStackTrace();
//        return new ModelAndView("/error");
//    }


}
