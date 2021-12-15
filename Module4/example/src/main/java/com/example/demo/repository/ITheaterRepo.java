package com.example.demo.repository;

import com.example.demo.model.Theater;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITheaterRepo extends JpaRepository<Theater,String> {

    Page<Theater> findTheatersByMovie_MovieId(Integer id, Pageable pageable);
}
