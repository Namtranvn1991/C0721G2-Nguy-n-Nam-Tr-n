package service.impl;

import model.Customer;
import repository.impl.CustomerRepository;
import repository.ICustomerRepository;
import service.ICustomerService;

import java.sql.SQLException;
import java.util.List;

public class CustomerService implements ICustomerService {

    private ICustomerRepository customerRepository = new CustomerRepository();

    @Override
    public void insertCustomer(Customer customer) throws SQLException {
        customerRepository.insertCustomer(customer);
    }

    @Override
    public Customer selectCustomer(int id) {
        return customerRepository.selectCustomer(id);
    }

    @Override
    public List<Customer> selectAllCustomers() {
        return customerRepository.selectAllCustomers();
    }

    @Override
    public boolean deleteCustomer(int id){
        return customerRepository.deleteCustomer(id);
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
        return customerRepository.updateCustomer(customer);
    }
}
