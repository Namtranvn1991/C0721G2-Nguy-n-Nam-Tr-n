package com.codegym.service;

import com.codegym.model.Bill;
import com.codegym.repository.IBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BillService implements IBillService {
    @Autowired
    IBillRepository iBillRepository;

    @Override
    public Iterable<Bill> findAll() {
        return null;
    }

    @Override
    public Optional<Bill> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Bill findPById(Integer id) {
        return null;
    }

    @Override
    public Bill findPByName(String name) {
        return iBillRepository.findBillByCustomerNameContaining(name);
    }

    @Override
    public Bill save(Bill bill) {
        return iBillRepository.save(bill);
    }
}
