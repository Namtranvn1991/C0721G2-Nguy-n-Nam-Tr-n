package com.blog.controller;


import com.blog.model.Blog;
import com.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BlogController {

    @Autowired
    IBlogService iBlogService;

    @GetMapping(value = "")
    public String getListPage(Model model){
        List<Blog> blogs =iBlogService.findAll();
        model.addAttribute("blogs",blogs);
        model.addAttribute("newBlog",new Blog());
        return "/blog/list";
    }

    @PostMapping(value = "/create")
    public String createBlog(@ModelAttribute(value = "newBlog") Blog blog, RedirectAttributes redirectAttributes){
        iBlogService.save(blog);
        List<Blog> blogs =iBlogService.findAll();
        redirectAttributes.addFlashAttribute("blogs",blogs);
        return "redirect:/";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable Integer id,RedirectAttributes redirectAttributes){
        iBlogService.remove(id);
        List<Blog> blogs =iBlogService.findAll();
        redirectAttributes.addFlashAttribute("blogs",blogs);
        return "redirect:/";
    }

    @GetMapping(value = "/edit/{id}")
    public String getEditPage(@PathVariable Integer id,Model model){
        Blog blog = iBlogService.findById(id);
        model.addAttribute("blog",blog);
        return "/blog/edit";
    }

    @PostMapping(value = "/edit")
    public String edit(@ModelAttribute(value = "blog") Blog blog,RedirectAttributes redirectAttributes){
        iBlogService.save(blog);
        List<Blog> blogs =iBlogService.findAll();
        redirectAttributes.addFlashAttribute("blogs",blogs);
        return "redirect:/";
    }
}
