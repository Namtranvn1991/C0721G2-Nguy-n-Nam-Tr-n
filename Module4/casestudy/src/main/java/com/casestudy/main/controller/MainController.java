package com.casestudy.main.controller;


import com.casestudy.main.repository.employee.IRoleRepo;
import com.casestudy.main.repository.employee.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLDataException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Optional;

@Controller
public class MainController {

//    @RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
//    public String welcomePage(Model model) {
//        model.addAttribute("title", "Welcome");
//        model.addAttribute("message", "This is welcome page!");
//        return "welcomePage";
//    }

    @Autowired
    IUserRepo iUserRepo;

    @Autowired
    IRoleRepo iRoleRepo;

    @GetMapping(value = "sign_in")
    public String signInPage(Model model){
        model.addAttribute("users",iUserRepo.findAll());
        model.addAttribute("roles",iRoleRepo.findAll());
        return "home/signIn";
    }

    @PostMapping(value = "sign_in")
    public String addUserRole(@RequestParam("user") Optional<String> userName, @RequestParam("role") Optional<Integer> roleId,Model model){
        if(userName.get().equals("")||roleId.get()==0){
            return signInPage(model);
        }
        iUserRepo.addUserRole(userName.get(),roleId.get());
        return "home/signIn";
    }



    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {
        return "loginPage";
    }

    @GetMapping(value = "")
    public String homePage(){
        return "home/home";
    }

//    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
//    public String logoutSuccessfulPage(Model model) {
//        model.addAttribute("title", "Logout");
//        return "logoutSuccessfulPage";
//    }

//    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
//    public String userInfo(Model model, Principal principal) {
//
//        // Sau khi user login thanh cong se co principal
//        String userName = principal.getName();
//
//        System.out.println("User Name: " + userName);
//
//        User loginedUser = (User) ((Authentication) principal).getPrincipal();
//
//        String userInfo = WebUtils.toString(loginedUser);
//        model.addAttribute("userInfo", userInfo);
//
//        return "userInfoPage";
//    }
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ModelAndView showInputNotAcceptable(SQLIntegrityConstraintViolationException e) {
        e.printStackTrace();
        ModelAndView modelAndView = new ModelAndView("home/signIn");
        modelAndView.addObject("msg","DuplicateKeyException");
        return modelAndView;

    }
}