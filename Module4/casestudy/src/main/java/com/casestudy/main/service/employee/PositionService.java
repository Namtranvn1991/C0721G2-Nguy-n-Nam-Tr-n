package com.casestudy.main.service.employee;

import com.casestudy.main.model.employee.Position;
import com.casestudy.main.repository.employee.IPositionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PositionService implements IPositionService {
    @Autowired
    IPositionRepo iPositionRepo;

    @Override
    public List<Position> findAll() {
        return iPositionRepo.findAll();
    }

    @Override
    public Position findById(Integer id) {
        return iPositionRepo.findById(id).orElse(null);
    }

    @Override
    public void save(Position position) {

    }

    @Override
    public void remove(Integer id) {

    }
}
