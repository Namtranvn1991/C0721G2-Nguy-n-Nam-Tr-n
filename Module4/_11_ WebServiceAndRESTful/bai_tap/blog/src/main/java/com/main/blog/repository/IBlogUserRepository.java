package com.main.blog.repository;

import com.main.blog.model.Blog;
import com.main.blog.model.BlogUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogUserRepository extends JpaRepository<BlogUser,Integer> {
    boolean existsBlogUserByUserName(String username);
}
