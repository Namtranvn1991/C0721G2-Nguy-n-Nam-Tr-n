package com.casestudy.main.service.service;

import com.casestudy.main.model.service.ServiceType;
import com.casestudy.main.repository.service.IServiceTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeService implements IServiceTypeService {
    @Autowired
    IServiceTypeRepo iServiceTypeRepo;

    @Override
    public List<ServiceType> findAll() {
        return iServiceTypeRepo.findAll();
    }

    @Override
    public ServiceType findById(Integer id) {
        return iServiceTypeRepo.getById(id);
    }

    @Override
    public void save(ServiceType serviceType) {

    }

    @Override
    public void remove(Integer id) {

    }
}
