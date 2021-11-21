package com.main.blog.controller;


import com.main.blog.model.BlogUser;
import com.main.blog.service.IBlogUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    IBlogUserService iBlogUserService;


    @GetMapping(value = "")
    public String getUserListPage(Model model){
        List<BlogUser> blogUsers = iBlogUserService.findAll();
        model.addAttribute("blogUsers",blogUsers);
        return "/user/list";
    }

    @GetMapping(value = "/create")
    public String getUserCreatePage(Model model){
        model.addAttribute("newBlogUser", new BlogUser());
        return "user/create";
    }

    @PostMapping(value = "/create")
    public String createUser(@ModelAttribute(value = "newBlogUser") BlogUser blogUser){
        iBlogUserService.save(blogUser);
        return "redirect:/user";
    }

    @GetMapping(value = "/edit/{id}")
    public String getEditUserPage(@PathVariable("id") Integer id, Model model){
        model.addAttribute("blogUser",iBlogUserService.findById(id));
        return "user/edit";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        iBlogUserService.remove(id);
        return "redirect:/user";
    }

    @PostMapping(value = "/edit")
    public String editUser(@ModelAttribute(value = "blogUser") BlogUser blogUser){
        iBlogUserService.save(blogUser);
        return "redirect:/user";
    }
}
