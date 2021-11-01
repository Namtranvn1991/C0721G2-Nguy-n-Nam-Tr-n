package repository;

import model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerRepository {
    public void insertCustomer(Customer customer) throws SQLException;

    public Customer selectCustomer(int id);

    public List<Customer> selectAllCustomers();

    public List<Customer> selectAll();

    public boolean deleteCustomer(int id);

    public boolean updateCustomer(Customer customer) throws SQLException;
}
