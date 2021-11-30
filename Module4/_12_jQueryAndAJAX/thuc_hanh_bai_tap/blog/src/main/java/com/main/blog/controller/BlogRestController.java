package com.main.blog.controller;


import com.main.blog.model.Blog;
import com.main.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

    @GetMapping("/search/{description}")
    public ModelAndView searchBlog(@PathVariable("description") String description) {
        ModelAndView modelAndView = new ModelAndView("/blog/search");
//        model.addAttribute("blogs", iBlogService.findAllBlogByDescription(description));
//        model.addAttribute("description",description);
        modelAndView.addObject("blogs",iBlogService.findAllBlogByDescription(description));
        modelAndView.addObject("description",description);
        return modelAndView;
    }

    @GetMapping("/{page}")
    public String loadMoreBlogs(@PathVariable(value = "page") int page,
                                Model model) {
        Sort sort = Sort.by("creationTime").ascending();
        int pageSize = 5;
        Page<Blog> blogs = iBlogService.findAll(PageRequest.of(page, pageSize, sort));
        model.addAttribute("blogs",blogs.getContent());
        return "blog/search";

    }
}
