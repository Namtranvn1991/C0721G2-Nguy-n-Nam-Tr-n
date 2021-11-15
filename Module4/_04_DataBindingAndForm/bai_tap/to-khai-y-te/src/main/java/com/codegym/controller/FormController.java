package com.codegym.controller;

import com.codegym.model.MedicalDeclarationForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormController {
    @GetMapping("")
    public String getFormPage(Model model){
        String[] countries = new String[]{"VN","USA","JP","CN"};
        String[] gender = new String[]{"male","female"};
        String[] transferBy= new String[]{"Tau bay","Tau thuyen", "O to", "Khac"};
        String[] province = new String[]{"DN","TP.HCM","HN"};
        Boolean[] booleans = new Boolean[]{true,false};

        model.addAttribute("gender",gender);
        model.addAttribute("countries",countries);
        model.addAttribute("transferBy",transferBy);
        model.addAttribute("province",province);
        model.addAttribute("medicalDeclarationForm",new MedicalDeclarationForm());

        return "index";
    }

    @PostMapping("/send_declaration")
    public String createForm(@ModelAttribute("medicalDeclarationForm") MedicalDeclarationForm medicalDeclarationForm,Model model){
        model.addAttribute("medicalDeclarationForm",medicalDeclarationForm);
        return "show";
    }

}
