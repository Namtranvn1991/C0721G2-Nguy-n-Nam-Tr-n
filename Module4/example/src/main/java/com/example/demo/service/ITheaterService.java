package com.example.demo.service;

import com.example.demo.model.Theater;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITheaterService extends IGeneralServiceT<Theater> {

    Page<Theater> findAll(Pageable pageable);
    Page<Theater> findAllByMovie(Integer id, Pageable pageable);

}
