package com.casestudy.main.repository.employee;

import com.casestudy.main.model.customer.Customer;
import com.casestudy.main.model.employee.EducationDegree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEduDegreeRepo  extends JpaRepository<EducationDegree,Integer> {
}
