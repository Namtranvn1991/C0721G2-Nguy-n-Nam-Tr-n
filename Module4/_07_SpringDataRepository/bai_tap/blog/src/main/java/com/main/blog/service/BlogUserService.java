package com.main.blog.service;



import com.main.blog.model.BlogUser;
import com.main.blog.repository.IBlogUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogUserService implements IBlogUserService {

    @Autowired
    private IBlogUserRepository iBlogUserRepository;

    @Override
    public List<BlogUser> findAll() {
        return iBlogUserRepository.findAll();
    }

    @Override
    public BlogUser findById(Integer id) {
        return iBlogUserRepository.findById(id).orElse(null);
    }

    @Override
    public void save(BlogUser blogUser) {
        iBlogUserRepository.save(blogUser);
    }

    @Override
    public void remove(Integer id) {
        iBlogUserRepository.deleteById(id);
    }

    @Override
    public Page<BlogUser> findAll(Pageable pageable) {
        return iBlogUserRepository.findAll(pageable);
    }

}
