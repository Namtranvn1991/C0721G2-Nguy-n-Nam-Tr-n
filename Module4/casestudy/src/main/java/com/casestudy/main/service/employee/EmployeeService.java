package com.casestudy.main.service.employee;

import com.casestudy.main.dto.EmployeeDTO;
import com.casestudy.main.model.employee.Employee;
import com.casestudy.main.model.user.User;
import com.casestudy.main.repository.employee.IEmployeeRepository;
import com.casestudy.main.repository.employee.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    IEmployeeRepository iEmployeeRepository;

    @Autowired
    IUserRepo iUserRepo;

    @Override
    public List<Employee> findAll() {
        return iEmployeeRepository.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        return iEmployeeRepository.getById(id);
    }

    @Override
    public void save(Employee employee) {
        iEmployeeRepository.save(employee) ;
    }



    @Override
    public void remove(Integer id) {
        iEmployeeRepository.deleteById(id);
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return iEmployeeRepository.findAll(pageable);
    }

    @Override
    public void saveDTO(EmployeeDTO employeeDTO) {
        Employee employee =new Employee();
        User user = new User();
        employee.setEmployeeName(employeeDTO.getEmployeeName());
        employee.setEmployeeBirthday(employeeDTO.getEmployeeBirthday());
        employee.setEmployeeIdCard(employeeDTO.getEmployeeIdCard());
        employee.setEmployeeSalary(employeeDTO.getEmployeeSalary());
        employee.setEmployeePhone(employeeDTO.getEmployeePhone());
        employee.setEmployeeEmail(employeeDTO.getEmployeeEmail());
        employee.setEmployeeAddress(employeeDTO.getEmployeeAddress());
        employee.setPosition(employeeDTO.getPosition());
        employee.setDivision(employeeDTO.getDivision());
        employee.setEducationDegree(employeeDTO.getEducationDegree());

        user.setUsername(employeeDTO.getUserName());

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(employeeDTO.getPassword()));

        iUserRepo.save(user);

        employee.setUserName(user);
        save(employee);
    }
}
