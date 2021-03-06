package service;



import model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface IEmployeeService {
    public boolean insertEmployee(Employee employee) throws SQLException;

    public Employee selectEmployee(int id);

    public List<Employee> selectAllEmployees();

    public boolean deleteEmployee(int id);

    public boolean updateEmployee(Employee employee) throws SQLException;

    public List<Employee> searchEmployee(String name, String phone, String address);
}
