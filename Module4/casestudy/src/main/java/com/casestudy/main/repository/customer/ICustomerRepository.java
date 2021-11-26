package com.casestudy.main.repository.customer;

import com.casestudy.main.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
    Page<Customer> findAllByCustomerNameContaining(String name, Pageable pageable);
}
