package com.casestudy.main.repository.customer;

import com.casestudy.main.model.customer.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerTypeRepo extends JpaRepository<CustomerType,Integer> {
}
