package repository;

import model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface IEmployeeRepository {
    public boolean insertEmployee(Employee employee);

    public Employee selectEmployee(int id);

    public List<Employee> selectAllEmployees();

    public boolean deleteEmployee(int id);

    public boolean updateEmployee(Employee employee);

    public List<Employee> searchEmployee(String name, String phone, String address);
}
