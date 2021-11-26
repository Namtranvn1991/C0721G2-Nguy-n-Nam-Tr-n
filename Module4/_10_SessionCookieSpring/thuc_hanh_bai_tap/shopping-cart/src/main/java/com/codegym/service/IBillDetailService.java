package com.codegym.service;

import com.codegym.model.BillDetail;
import com.codegym.model.Product;

import java.util.Optional;

public interface IBillDetailService {
    Iterable<BillDetail> findAll();
    Optional<BillDetail> findById(Integer id);
    BillDetail findPById(Integer id);
    BillDetail save(BillDetail billDetail);

}
