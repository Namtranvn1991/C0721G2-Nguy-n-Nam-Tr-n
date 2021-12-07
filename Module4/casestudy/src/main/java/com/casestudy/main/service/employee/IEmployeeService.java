package com.casestudy.main.service.employee;


import com.casestudy.main.dto.EmployeeDTO;
import com.casestudy.main.model.employee.Employee;
import com.casestudy.main.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService extends IGeneralService<Employee> {
    Page<Employee> findAll(Pageable pageable);

    void saveDTO(EmployeeDTO employeeDTO);
}
