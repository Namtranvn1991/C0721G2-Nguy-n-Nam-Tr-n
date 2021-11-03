package service.impl;

import model.Employee;
import repository.IEmployeeRepository;
import repository.impl.EmployeeRepository;
import service.IEmployeeService;

import java.sql.SQLException;
import java.util.List;

public class EmployeeService implements IEmployeeService {
    private IEmployeeRepository iEmployeeRepository = new EmployeeRepository();

    @Override
    public boolean insertEmployee(Employee employee) throws SQLException {
        return iEmployeeRepository.insertEmployee(employee);
    }

    @Override
    public Employee selectEmployee(int id) {
        return iEmployeeRepository.selectEmployee(id);
    }

    @Override
    public List<Employee> selectAllEmployees() {
        return iEmployeeRepository.selectAllEmployees();
    }

    @Override
    public boolean deleteEmployee(int id) {
        return iEmployeeRepository.deleteEmployee(id);
    }

    @Override
    public boolean updateEmployee(Employee employee) throws SQLException {
        return iEmployeeRepository.updateEmployee(employee);
    }
}
