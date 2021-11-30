package com.main.blog.repository;


import com.main.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog,Integer> {

    @Query(value="select * from blog join blog_user where blog.blog_user_id = blog_user.id and blog_user.user_name=:nameU order by creation_time",nativeQuery=true)
    Page<Blog> findBlogByUserName(@Param("nameU") String name, Pageable pageable);

    @Query(value="select * from blog join blog_user where blog.blog_user_id = blog_user.id order by creation_time DESC",nativeQuery=true)
    Page<Blog> findAllSortByTime(Pageable pageable);

    Page<Blog> findAllByDescriptionContaining(String description,Pageable pageable );

    List<Blog> findAllByDescriptionContaining(String description);

}
