package com.codegym.repository;

import com.codegym.model.BillDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBillDetailRepository extends JpaRepository<BillDetail,Integer> {
}
