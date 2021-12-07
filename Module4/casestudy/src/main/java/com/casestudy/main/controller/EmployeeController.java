package com.casestudy.main.controller;


import com.casestudy.main.dto.EmployeeDTO;
import com.casestudy.main.model.customer.Customer;
import com.casestudy.main.model.customer.CustomerType;
import com.casestudy.main.model.employee.Division;
import com.casestudy.main.model.employee.EducationDegree;
import com.casestudy.main.model.employee.Employee;
import com.casestudy.main.model.employee.Position;
import com.casestudy.main.repository.employee.IEmployeeRepository;
import com.casestudy.main.repository.employee.IRoleRepo;
import com.casestudy.main.repository.employee.IUserRepo;
import com.casestudy.main.service.employee.IDivisionService;
import com.casestudy.main.service.employee.IEduDegreeService;
import com.casestudy.main.service.employee.IEmployeeService;
import com.casestudy.main.service.employee.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "employee")
public class EmployeeController {
    @Autowired
    IEmployeeService iEmployeeService;

    @Autowired
    IDivisionService iDivisionService;

    @Autowired
    IEduDegreeService iEduDegreeService;

    @Autowired
    IPositionService iPositionService;

    @Autowired
    IUserRepo iUserRepo;

    @ModelAttribute("division")
    public List<Division> divisions(){
        return iDivisionService.findAll();
    }

    @ModelAttribute("eduDegree")
    public List<EducationDegree> eduDegrees(){
        return iEduDegreeService.findAll();
    }

    @ModelAttribute("position")
    public List<Position> positions(){
        return iPositionService.findAll();
    }

    @GetMapping(value = "")
    public String getListPage(Model model, @PageableDefault(size = 5) Pageable pageable){
        model.addAttribute("employeeList",iEmployeeService.findAll(pageable));
        return "employee/list";
    }


    @GetMapping(value = "create")
    public String getCreatePage(Model model){
        model.addAttribute("employee",new EmployeeDTO());
        return "employee/create";
    }
    @PostMapping(value = "create")
    public String createEmployee(@Valid @ModelAttribute("employee") EmployeeDTO employee, BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes,Model model) {
        new EmployeeDTO().validate(employee,bindingResult);
        if (bindingResult.hasErrors()){
            if(iUserRepo.existsByUserName(employee.getUserName())){
                model.addAttribute("msg","User name is exits");
            }
            return "employee/create";
        }
        if(iUserRepo.existsByUserName(employee.getUserName())){
            model.addAttribute("msg","User name is exits");
            return "employee/create";
        }
        iEmployeeService.saveDTO(employee);
        redirectAttributes.addFlashAttribute("msg","create success");
        return "redirect:/employee";
    }



    @GetMapping(value = "edit/{id}")
    public String getEditPage(@PathVariable("id") Integer id, Model model){
        model.addAttribute("employee",iEmployeeService.findById(id));
        return "employee/edit";
    }

    @PostMapping(value = "edit")
    public String editCustomer(@Valid @ModelAttribute EmployeeDTO employee, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){
        new EmployeeDTO().validate(employee,bindingResult);
        if (bindingResult.hasErrors()){
            return "employee/edit";
        }
        try {
            iEmployeeService.saveDTO(employee);
        } catch (DuplicateKeyException e){
            model.addAttribute("msg","Duplicate");
            return "employee/edit";
        }
        redirectAttributes.addFlashAttribute("msg","edit success");

        return "redirect:/employee";
    }
}
