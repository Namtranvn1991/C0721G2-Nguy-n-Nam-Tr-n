package com.exam.demo.controller;

import com.exam.demo.model.Question;
import com.exam.demo.model.QuestionType;
import com.exam.demo.service.IQuestionService;
import com.exam.demo.service.IQuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
public class QuestionController {
    @Autowired
    IQuestionService iQuestionService;

    @Autowired
    IQuestionTypeService iQuestionTypeService;

    @ModelAttribute("questionType")
    public List<QuestionType> questionTypes() {
        return iQuestionTypeService.findAll();
    }

    @GetMapping(value = "")
    public String getListPage(Model model, @PageableDefault(size = 1) Pageable pageable,@RequestParam ("keyword") Optional<String> keyword,@RequestParam ("qType") Optional<Integer> questionType) {
        if (!keyword.isPresent()||keyword.get().equals("")){
            if (questionType.isPresent()){
                model.addAttribute("list",iQuestionService.findAllByType(questionType.get(),pageable));
                model.addAttribute("qType",questionType.get());
            }else {
                Sort sort = Sort.by("dateCreate").ascending();
                Pageable p = PageRequest.of(pageable.getPageNumber(), 1, sort);
                model.addAttribute("list",iQuestionService.findAll(p));
            }
        } else {
            model.addAttribute("list",iQuestionService.findAllByTitle(keyword.get(),pageable));
            model.addAttribute("keyword",keyword.get());
            model.addAttribute("qType",questionType.get());
        }


//        model.addAttribute("list", iQuestionService.findAll(pageable));
        return "list";
    }

    @GetMapping(value = "create")
    public String getCreatePage(Model model) {
        model.addAttribute("questionObj", new Question());
        return "create";
    }

    @PostMapping(value = "create")
    public String create(@Valid @ModelAttribute("questionObj") Question question, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes, Model model) {
        System.out.println(question.getQuestionType());
        if (bindingResult.hasErrors()) {
            return "create";
        }
        question.setDateCreate(LocalDate.now());
        question.setStatus(true);
        iQuestionService.save(question);
        redirectAttributes.addFlashAttribute("msg", "create success");
        return "redirect:/";
    }


    @GetMapping(value = "edit/{id}")
    public String getEditPage(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("questionObj", iQuestionService.findById(id));
        return "edit";
    }

    @PostMapping(value = "edit123")
    public String edit(@Valid @ModelAttribute Question question, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        if(!question.getAnswer().equals("")){
            question.setStatus(false);
        }
        iQuestionService.save(question);
        redirectAttributes.addFlashAttribute("msg", "edit success");
        return "redirect:/";
    }

    @GetMapping(value = "detail/{id}")
    public ModelAndView detail(@PathVariable("id") Integer id){
        ModelAndView modelAndView = new ModelAndView("detail");
        Question q = iQuestionService.findById(id);
        modelAndView.addObject("questionObj",q);
        return modelAndView;
    }

    @GetMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") Integer id,RedirectAttributes redirectAttributes){
        iQuestionService.remove(id);
        redirectAttributes.addFlashAttribute("msg","delete success");
        return "redirect:/";
    }

}
