package com.main.controller;

import com.main.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class DictionaryController {
    @Autowired
    private DictionaryService dictionaryService;

    @GetMapping("/")
    public String homePage(){
        return "index";
    }

    @GetMapping("/search")
    public String search(@RequestParam String input, Model model){
        String output = dictionaryService.search(input);
        if (output!=null){
            model.addAttribute("output",output);
            return "index";
        }else {
            model.addAttribute("input",input);
            model.addAttribute("error",1);
            return "index";
        }
    }
}
