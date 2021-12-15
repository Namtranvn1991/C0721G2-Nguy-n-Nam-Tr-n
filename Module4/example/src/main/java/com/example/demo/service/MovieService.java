package com.example.demo.service;

import com.example.demo.model.Movie;
import com.example.demo.repository.IMovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService implements IMovieService {

    @Autowired
    IMovieRepo iMovieRepo;

    @Override
    public List<Movie> findAll() {
        return iMovieRepo.findAll();
    }

    @Override
    public Movie findById(Integer id) {
        return iMovieRepo.findById(id).orElse(null);
    }

    @Override
    public void save(Movie movie) {

    }

    @Override
    public void remove(Integer id) {

    }
}
