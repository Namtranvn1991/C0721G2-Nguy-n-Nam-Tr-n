package com.main.blog.controller;


import com.main.blog.model.Blog;
import com.main.blog.model.BlogUser;
import com.main.blog.service.IBlogService;
import com.main.blog.service.IBlogUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BlogController {

    @Autowired
    IBlogService iBlogService;
    @Autowired
    IBlogUserService iBlogUserService;

    @ModelAttribute("users")
    public List<BlogUser> blogUsers(){
        return iBlogUserService.findAll();
    }


    @GetMapping(value = "")
    public String getListPage(@PageableDefault() Pageable pageable, Model model){
        Page<Blog> blogs =iBlogService.findAll(pageable);
//        List<BlogUser> users = iBlogUserService.findAll();
        model.addAttribute("blogs",blogs);
//        model.addAttribute("users",users);
        model.addAttribute("newBlog",new Blog());
        model.addAttribute("userBlog",new BlogUser());
        return "blog/list";
    }

    @PostMapping(value = "/create")
    public String createBlog(@ModelAttribute(value = "newBlog") Blog blog, RedirectAttributes redirectAttributes){
        if(blog.getUser()==null){
            redirectAttributes.addFlashAttribute("msg","choose user");
            List<Blog> blogs =iBlogService.findAll();
            redirectAttributes.addFlashAttribute("blogs",blogs);
            return "redirect:/";
        }
        iBlogService.save(blog);
        List<Blog> blogs =iBlogService.findAll();
        redirectAttributes.addFlashAttribute("blogs",blogs);
        return "redirect:/";

    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        iBlogService.remove(id);
        List<Blog> blogs =iBlogService.findAll();
        redirectAttributes.addFlashAttribute("blogs",blogs);
        return "redirect:/";
    }

    @GetMapping(value = "/edit/{id}")
    public String getEditPage(@PathVariable Integer id, Model model){
        Blog blog = iBlogService.findById(id);
        model.addAttribute("blog",blog);
        return "/blog/edit";
    }

    @PostMapping(value = "/edit")
    public String edit(@ModelAttribute(value = "blog") Blog blog, RedirectAttributes redirectAttributes){
        iBlogService.save(blog);
        List<Blog> blogs =iBlogService.findAll();
        redirectAttributes.addFlashAttribute("blogs",blogs);
        return "redirect:/";
    }
}
