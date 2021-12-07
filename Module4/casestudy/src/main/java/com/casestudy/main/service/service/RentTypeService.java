package com.casestudy.main.service.service;

import com.casestudy.main.model.service.RentType;
import com.casestudy.main.repository.service.IRentTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeService implements IRentTypeService {
    @Autowired
    IRentTypeRepo iRentTypeRepo;

    @Override
    public List<RentType> findAll() {
        return iRentTypeRepo.findAll();
    }

    @Override
    public RentType findById(Integer id) {
        return iRentTypeRepo.getById(id);
    }

    @Override
    public void save(RentType rentType) {

    }

    @Override
    public void remove(Integer id) {

    }
}
