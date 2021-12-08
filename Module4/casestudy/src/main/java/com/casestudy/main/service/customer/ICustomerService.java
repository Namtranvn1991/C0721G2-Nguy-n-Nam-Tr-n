package com.casestudy.main.service.customer;

import com.casestudy.main.model.customer.Customer;
import com.casestudy.main.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService extends IGeneralService<Customer> {
    Page<Customer> findAll(Pageable pageable);
    Page<Customer> findAllByNameContaining(String name, Pageable pageable);
    Page<Customer> findAllByCustomerType(Integer id, Pageable pageable);
    Page<Customer> search(String keyword,Pageable pageable);

    Boolean existsByCustomerEmail(String email);
    Boolean existsByCustomerPhone(String phone);
    Boolean existsByCustomerIdCard(String idCard);
}
