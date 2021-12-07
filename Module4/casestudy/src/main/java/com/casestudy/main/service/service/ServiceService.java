package com.casestudy.main.service.service;

import com.casestudy.main.model.service.Service;
import com.casestudy.main.repository.service.IServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


import java.util.List;

@org.springframework.stereotype.Service
public class ServiceService implements IServiceService {
    @Autowired
    IServiceRepository iServiceRepository;

    @Override
    public List<Service> findAll() {
        return null;
    }

    @Override
    public Service findById(Integer id) {
        return iServiceRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Service service) {
        iServiceRepository.save(service);
    }

    @Override
    public void remove(Integer id) {
        iServiceRepository.deleteById(id);
    }

    @Override
    public Page<Service> findAll(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.iServiceRepository.findAll(pageable);
    }
}
