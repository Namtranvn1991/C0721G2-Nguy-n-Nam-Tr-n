package com.casestudy.main.repository.service;

import com.casestudy.main.model.service.RentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRentTypeRepo extends JpaRepository<RentType,Integer> {
}
