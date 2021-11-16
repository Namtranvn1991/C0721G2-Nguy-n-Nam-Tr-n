package com.main.controller;

import com.main.model.Product;
import com.main.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    IService iService;


    @GetMapping(value = "/create")
    public String getCreatePage(Model model){
        model.addAttribute("product",new Product());
        return "create";
    }

    @GetMapping(value = "/")
    public String getListPage(Model model){
        model.addAttribute("products",iService.allProduct());
        return "list";
    }

    @GetMapping(value = "/detail/{id}")
    public String getDetailPage(@PathVariable("id") Integer id,Model model){
        model.addAttribute("product",iService.findById(id));
        return "detail";
    }

    @GetMapping(value = "/edit/{id}")
    public String getEditPage(@PathVariable("id") Integer id,Model model){
        model.addAttribute("product",iService.findById(id));
        return "edit";
    }

    @PostMapping(value = "/edit")
    public String edit(Product product, RedirectAttributes redirectAttributes){
        iService.edit(product);
        redirectAttributes.addFlashAttribute("massage","Edit successfully!");
        return "redirect:/";
    }

    @PostMapping(value = "/create")
    public String saveProduct(@ModelAttribute("product") Product product,RedirectAttributes redirectAttributes){
        product.setId((int) (Math.random() * 10000));
        iService.add(product);
        redirectAttributes.addFlashAttribute("massage","Create successfully!");
        return "redirect:/";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteProduct(@PathVariable Integer id,RedirectAttributes redirectAttributes){
        iService.delete(id);
        redirectAttributes.addFlashAttribute("massage","Delete successfully!");
        return "redirect:/";
    }
}
