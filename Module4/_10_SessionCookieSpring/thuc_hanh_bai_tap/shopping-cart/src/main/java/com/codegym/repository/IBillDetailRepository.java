package com.codegym.repository;

import com.codegym.model.Bill;
import com.codegym.model.BillDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBillDetailRepository extends JpaRepository<BillDetail,Integer> {

//    static String query = "";
//
//    @Query(value = query, nativeQuery = true)
//    List<Bill> findAllBillsDetail();
}
