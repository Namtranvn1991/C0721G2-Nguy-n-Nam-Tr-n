package com.main.test.repository;

import com.main.test.model.Medical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMedicalRepository extends JpaRepository<Medical,String> {
}
