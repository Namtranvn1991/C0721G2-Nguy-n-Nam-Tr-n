package com.casestudy.main.service.employee;

import com.casestudy.main.model.employee.Division;
import com.casestudy.main.repository.employee.IDivisionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionService implements IDivisionService {
    @Autowired
    IDivisionRepo iDivisionRepo;

    @Override
    public List<Division> findAll() {
        return iDivisionRepo.findAll();
    }

    @Override
    public Division findById(Integer id) {
        return iDivisionRepo.findById(id).orElse(null);
    }

    @Override
    public void save(Division division) {

    }

    @Override
    public void remove(Integer id) {

    }
}
