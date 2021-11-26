package com.main.blog.controller;


import com.main.blog.model.Blog;
import com.main.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/blogs")
public class BlogRestController {

    @Autowired
    private IBlogService iBlogService;

    @GetMapping
    public ResponseEntity<Iterable<Blog>> findAllBlog() {
        List<Blog> blogs = iBlogService.findAll();
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> findBlogById(@PathVariable Integer id) {
        Optional<Blog> blog = Optional.ofNullable(iBlogService.findById(id));
        if (!blog.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog.get(), HttpStatus.OK);
//        Blog blog = iBlogService.findById(id);
//        if (blog==null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Blog> saveCustomer(@RequestBody Blog blog) {
        return new ResponseEntity<>(iBlogService.save(blog), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Blog> updateCustomer(@PathVariable Integer id, @RequestBody Blog blog) {
        Optional<Blog> customerOptional = Optional.ofNullable(iBlogService.findById(id));
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blog.setId(customerOptional.get().getId());
        return new ResponseEntity<>(iBlogService.save(blog), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Blog> deleteCustomer(@PathVariable Integer id) {
        Optional<Blog> customerOptional = Optional.ofNullable(iBlogService.findById(id));
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iBlogService.remove(id);
        return new ResponseEntity<>(customerOptional.get(), HttpStatus.NO_CONTENT);
    }
}
