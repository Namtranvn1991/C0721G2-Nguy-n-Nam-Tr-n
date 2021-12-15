package com.example.demo.service;

import com.example.demo.model.Theater;
import com.example.demo.repository.ITheaterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheaterService implements ITheaterService {
    @Autowired
    ITheaterRepo iTheaterRepo;

    @Override
    public List<Theater> findAll() {
        return iTheaterRepo.findAll();
    }

    @Override
    public Theater findById(String id) {
        return iTheaterRepo.findById(id).orElse(null);
    }

    @Override
    public void save(Theater theater) throws DuplicateKeyException  {
        try{
            iTheaterRepo.save(theater);
        } catch (DataIntegrityViolationException e){
            throw new DuplicateKeyException("Duplicate Error",e);
        }
    }

    @Override
    public void remove(String id) {
        iTheaterRepo.deleteById(id);
    }

    @Override
    public Page<Theater> findAll(Pageable pageable) {
        return iTheaterRepo.findAll(pageable);
    }

    @Override
    public Page<Theater> findAllByMovie(Integer id, Pageable pageable) {
        return iTheaterRepo.findTheatersByMovie_MovieId(id,pageable);
    }
}
