package com.casestudy.main.service.employee;

import com.casestudy.main.model.employee.EducationDegree;
import com.casestudy.main.repository.employee.IEduDegreeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EduDegreeService implements IEduDegreeService {
    @Autowired
    IEduDegreeRepo iEduDegreeRepo;

    @Override
    public List<EducationDegree> findAll() {
        return iEduDegreeRepo.findAll();
    }

    @Override
    public EducationDegree findById(Integer id) {
        return iEduDegreeRepo.findById(id).orElse(null);
    }

    @Override
    public void save(EducationDegree educationDegree) {

    }

    @Override
    public void remove(Integer id) {

    }
}
