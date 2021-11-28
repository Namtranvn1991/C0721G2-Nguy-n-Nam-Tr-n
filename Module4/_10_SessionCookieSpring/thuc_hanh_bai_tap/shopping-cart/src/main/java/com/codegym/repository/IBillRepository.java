package com.codegym.repository;

import com.codegym.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBillRepository extends JpaRepository<Bill, Integer> {

    @Query
    Bill findBillByCustomerNameContaining(String name);

//
//    static String query = "";
//
//    @Query(value = query, nativeQuery = true)
//    List<Bill> findAllBills();
}
