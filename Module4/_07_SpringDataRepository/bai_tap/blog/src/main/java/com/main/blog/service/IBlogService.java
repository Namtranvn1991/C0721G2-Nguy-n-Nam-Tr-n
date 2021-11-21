package com.main.blog.service;


import com.main.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService extends IGeneralService<Blog> {
    Page<Blog> findAllByTime(Pageable pageable);

    Page<Blog> findBlogByUser(String name,Pageable pageable);
}
