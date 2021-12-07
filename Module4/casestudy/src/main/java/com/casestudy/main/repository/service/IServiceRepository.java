package com.casestudy.main.repository.service;

import com.casestudy.main.model.service.RentType;
import com.casestudy.main.model.service.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IServiceRepository extends JpaRepository<Service,Integer> {
}
