package com.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertController {


    @GetMapping("/")
    public String show(Model model){
        return "index";
    }

    @PostMapping("/convert")
    public String convert(@RequestParam double usd, Model model){
        double result =  usd*220000;
        model.addAttribute("result",result);
        model.addAttribute("usd",usd);
        return "index";
    }
}
