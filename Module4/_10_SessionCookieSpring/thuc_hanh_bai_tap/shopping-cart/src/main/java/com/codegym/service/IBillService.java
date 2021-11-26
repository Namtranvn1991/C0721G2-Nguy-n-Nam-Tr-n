package com.codegym.service;

import com.codegym.model.Bill;
import com.codegym.model.Product;

import java.util.Optional;

public interface IBillService {
    Iterable<Bill> findAll();
    Optional<Bill> findById(Integer id);
    Bill findPById(Integer id);
    Bill findPByName(String name);
    Bill save(Bill bill);
}
