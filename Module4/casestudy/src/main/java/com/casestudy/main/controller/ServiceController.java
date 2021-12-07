package com.casestudy.main.controller;


import com.casestudy.main.model.service.RentType;
import com.casestudy.main.model.service.Service;
import com.casestudy.main.model.service.ServiceType;
import com.casestudy.main.service.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "service")
public class ServiceController {
    @Autowired
    IServiceService serviceService;

    @Autowired
    IServiceTypeService serviceTypeService;

    @Autowired
    IRentTypeService rentTypeService;

    @ModelAttribute("serviceType")
    public List<ServiceType> serviceTypes(){
        return serviceTypeService.findAll();
    }

    @ModelAttribute("rentType")
    public List<RentType> rentTypes(){
        return rentTypeService.findAll();
    }

    @GetMapping("")
    public String viewServicePage(Model model) {
        return getListPage(1, "serviceId", "asc", model);
    }

    @GetMapping(value = "{pageNo}")
    public String getListPage(@PathVariable(value = "pageNo") int pageNo,
                              @RequestParam("sortField") String sortField,
                              @RequestParam("sortDir") String sortDir,
                              Model model){
        int pageSize = 5;

        Page<Service> page = serviceService.findAll(pageNo, pageSize, sortField, sortDir);
        List<Service> serviceList = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("serviceList", serviceList);
        return "service/list";
    }





}
