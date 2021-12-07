package com.casestudy.main.repository.employee;

import com.casestudy.main.model.customer.Customer;
import com.casestudy.main.model.employee.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDivisionRepo  extends JpaRepository<Division,Integer> {
}
