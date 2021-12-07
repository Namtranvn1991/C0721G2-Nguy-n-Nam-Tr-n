package com.casestudy.main.repository.service;

import com.casestudy.main.model.service.RentType;
import com.casestudy.main.model.service.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IServiceTypeRepo extends JpaRepository<ServiceType,Integer> {
}
