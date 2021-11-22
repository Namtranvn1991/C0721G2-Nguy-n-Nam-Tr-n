package com.main.formregister.controller;


import com.main.formregister.model.Account;
import com.main.formregister.model.FormRegister;
import com.main.formregister.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class FormRegisterController {

    @Autowired
    IAccountService iAccountService;

    @GetMapping(value = "")
    public String getForm(Model model){
        model.addAttribute("formRegister",new FormRegister());
        return "form";
    }

    @GetMapping(value = "/list")
    public String getListPage(Model model){
        model.addAttribute("listAcc",iAccountService.findAll());
        return "list";
    }

    @PostMapping(value = "/create_acc")
    public String createAcc(@Valid @ModelAttribute("formRegister") FormRegister formRegister, BindingResult bindingResult, Model model){
        new FormRegister().validate(formRegister,bindingResult);
        if(bindingResult.hasErrors()){
            model.addAttribute("formRegister",formRegister);
            return "form";
        }
        Account account = new Account(formRegister.getFirstName(),formRegister.getLastName(),formRegister.getPhoneNumber(),formRegister.getAge(),formRegister.getEmail());
        iAccountService.saveAcc(account);
        model.addAttribute("listAcc",iAccountService.findAll());
        return "redirect:/list";
    }

}
