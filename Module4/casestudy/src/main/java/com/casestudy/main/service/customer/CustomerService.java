package com.casestudy.main.service.customer;

import com.casestudy.main.model.customer.Customer;
import com.casestudy.main.repository.customer.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    ICustomerRepository iCustomerRepository;

    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public Customer findById(Integer id) {
        return iCustomerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) throws DuplicateKeyException {
        try{
            iCustomerRepository.save(customer);
        } catch (DataIntegrityViolationException e){
            throw new DuplicateKeyException("Duplicate Error",e);
        }

    }

    @Override
    public void remove(Integer id) {
        iCustomerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return iCustomerRepository.findAll(pageable);
    }

    @Override
    public Page<Customer> findAllByNameContaining(String name, Pageable pageable) {
        return iCustomerRepository.findAllByCustomerNameContaining(name, pageable);
    }

    @Override
    public Page<Customer> findAllByCustomerType(Integer id, Pageable pageable) {
        return iCustomerRepository.findCustomersByCustomerType(id,pageable);
    }


    @Override
    public Page<Customer> search(String keyword, Pageable pageable) {
        return iCustomerRepository.search(keyword,pageable);
    }

    @Override
    public Boolean existsByCustomerEmail(String email) {
        return iCustomerRepository.existsByCustomerEmail(email);
    }

    @Override
    public Boolean existsByCustomerPhone(String phone) {
        return iCustomerRepository.existsByCustomerPhone(phone);
    }

    @Override
    public Boolean existsByCustomerIdCard(String idCard) {
        return iCustomerRepository.existsByCustomerIdCard(idCard);
    }
}
