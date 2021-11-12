package com.main.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Controller
public class SandwichController {


    @GetMapping(value = "")
    public String getPageIndex(){
        return "index";
    }

    @GetMapping(value = "/save")
    public String saveSandwich(@RequestParam(value = "condiments") String[] condiments, Model model){
        System.out.println(Arrays.toString(condiments));
        model.addAttribute("condiments",condiments);
        return "save";
    }
}
