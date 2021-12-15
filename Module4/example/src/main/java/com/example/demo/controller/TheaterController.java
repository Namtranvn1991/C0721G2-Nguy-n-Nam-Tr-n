package com.example.demo.controller;

import com.example.demo.model.Movie;
import com.example.demo.model.Theater;
import com.example.demo.service.IMovieService;
import com.example.demo.service.ITheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class TheaterController {

    @Autowired
    IMovieService iMovieService;

    @Autowired
    ITheaterService iTheaterService;

    @ModelAttribute("movies")
    public List<Movie> movies() {
        return iMovieService.findAll();
    }

    @GetMapping(value = "")
    public String getListPage(Model model, @PageableDefault(size = 2) Pageable pageable, @RequestParam("movie") Optional<Integer> movie) {
        if (movie.isPresent()) {
            model.addAttribute("theaterList", iTheaterService.findAllByMovie(movie.get(),pageable));
            model.addAttribute("movie", movie.get());
        } else {
            model.addAttribute("theaterList", iTheaterService.findAll(pageable));
        }

        return "list";
    }

    @GetMapping(value = "create")
    public String getCreatePage(Model model){
        model.addAttribute("theater",new Theater());
        return "create";
    }

    @PostMapping(value = "create")
    public String createCustomer(@Valid @ModelAttribute("theater") Theater theater, BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes, Model model) {
        new Theater().validate(theater,bindingResult);
        if (bindingResult.hasErrors()){
            return "create";
        }
        try {
            iTheaterService.save(theater);
        } catch (DuplicateKeyException e){
            model.addAttribute("msg","Duplicate ID");
            return "create";
        }
        redirectAttributes.addFlashAttribute("msg","create success");
        return "redirect:/";
    }

    @GetMapping(value = "edit/{id}")
    public String getEditPage(@PathVariable("id") String id, Model model){
        model.addAttribute("theater",iTheaterService.findById(id));
        return "edit";
    }

    @PostMapping(value = "edit")
    public String editCustomer(@Valid @ModelAttribute Theater theater, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){
        new Theater().validate(theater,bindingResult);
        if (bindingResult.hasErrors()){
            return "edit";
        }
        iTheaterService.save(theater);
        redirectAttributes.addFlashAttribute("msg","edit success");
        return "redirect:/";
    }



    @GetMapping(value = "delete/{id}")
    public String delete(@PathVariable("id") String id,RedirectAttributes redirectAttributes){
        iTheaterService.remove(id);
        redirectAttributes.addFlashAttribute("msg","delete success");
        return "redirect:/";
    }



}
