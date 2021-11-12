package com.main.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @GetMapping("/")
    public String getPageIndex(){
        return "index";
    }

    @GetMapping(value = "/cal")
    public String calculate(@RequestParam String number1, @RequestParam String number2, @RequestParam String cal, Model model){
        if(number1==""|number2==""){
            model.addAttribute("result","input again");
            return "index";
        }
        double num1;
        double num2;
        try {
            num1 = Double.parseDouble(number1);
            num2 = Double.parseDouble(number2);
        } catch (Exception e){
            model.addAttribute("result","input number");
            return "index";
        }
        double result;
        switch (cal){
            case "add":
               result = num1+num2;
               break;
            case "sub":
                result = num1-num2;
                break;
            case "multi":
                result = num1*num2;
                break;
            case "div":
                if (num2 == 0){
                    model.addAttribute("result","Cant div zero");
                    return "index";
                } else {
                    result = num1/num2;
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + cal);
        }
        model.addAttribute("result",result);
        return "index";
    }

}
