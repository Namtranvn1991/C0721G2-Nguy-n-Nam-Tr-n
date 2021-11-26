package com.codegym.service;

import com.codegym.model.BillDetail;
import com.codegym.repository.IBillDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BillDetailService implements IBillDetailService {

    @Autowired
    IBillDetailRepository iBillDetailRepository;

    @Override
    public Iterable<BillDetail> findAll() {
        return null;
    }

    @Override
    public Optional<BillDetail> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public BillDetail findPById(Integer id) {
        return null;
    }

    @Override
    public BillDetail save(BillDetail billDetail) {
        return iBillDetailRepository.save(billDetail);
    }
}
