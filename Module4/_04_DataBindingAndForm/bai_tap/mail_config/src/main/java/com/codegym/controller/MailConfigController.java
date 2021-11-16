package com.codegym.controller;

import com.codegym.model.MailConfig;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MailConfigController {


    @GetMapping(value = "")
    public String getHomePage(){
        return "home";
    }

    @GetMapping(value = "/mail_config")
    public ModelAndView getConfigPage(Model model){
        ModelAndView modelAndView = new ModelAndView("index");
        String[] languageList = new String[]{"English","Vietnamese","Japanese","Chinese"};
        model.addAttribute("languageList",languageList);
        Integer[] pageSizeList = new Integer[]{10,25,50};
        model.addAttribute("pageSizeList",pageSizeList);

        modelAndView.addObject("languageList",languageList);
        modelAndView.addObject("pageSizeList",pageSizeList);
        modelAndView.addObject("mailConfig",new MailConfig());
       return modelAndView;
    }

    @PostMapping(value = "/save_config")
    public String saveConfig(@ModelAttribute("mailConfig")MailConfig mailConfig, Model model){
        model.addAttribute("mailConfig",mailConfig);
        return "show_config";
    }

    @PostMapping(value = "/edit")
    public String edit(@ModelAttribute("mailConfig")MailConfig mailConfig, Model model){

        String[] languageList = new String[]{"English","Vietnamese","Japanese","Chinese"};
        model.addAttribute("languageList",languageList);
        Integer[] pageSizeList = new Integer[]{10,25,50};
        model.addAttribute("pageSizeList",pageSizeList);


        model.addAttribute("mailConfig",mailConfig);
        return "edit";
    }


}
