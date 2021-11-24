package com.casestudy.main.service.customer;

import com.casestudy.main.model.customer.CustomerType;
import com.casestudy.main.repository.customer.ICustomerTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {

    @Autowired
    ICustomerTypeRepo iCustomerTypeRepo;

    @Override
    public List<CustomerType> findAll() {
        return iCustomerTypeRepo.findAll();
    }

    @Override
    public CustomerType findById(Integer id) {
        return iCustomerTypeRepo.findById(id).orElse(null);
    }

    @Override
    public void save(CustomerType customerType) {

    }

    @Override
    public void remove(Integer id) {

    }
}
