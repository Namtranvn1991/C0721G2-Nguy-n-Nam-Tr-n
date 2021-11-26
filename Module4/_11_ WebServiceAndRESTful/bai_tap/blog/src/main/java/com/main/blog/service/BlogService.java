package com.main.blog.service;


import com.main.blog.model.Blog;
import com.main.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {

    @Autowired
    IBlogRepository iBlogRepository;

    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public Blog findById(Integer id) {
        return iBlogRepository.findById(id).orElse(null);
    }

    @Override
    public Blog save(Blog blog) {
        return iBlogRepository.save(blog);
    }

    @Override
    public void remove(Integer id) {
        Blog blog = iBlogRepository.getById(id);
        iBlogRepository.delete(blog);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return iBlogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> findAllByTime(Pageable pageable) {
        return iBlogRepository.findAllSortByTime(pageable);
    }

    @Override
    public Page<Blog> findBlogByUser(String name,Pageable pageable) {
        return iBlogRepository.findBlogByUserName(name, pageable);
    }
}
