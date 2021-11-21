package com.main.blog.model;


import javax.persistence.*;

@Entity
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String description;
    private String context;

    @ManyToOne(targetEntity = BlogUser.class)
    private BlogUser blogUser;


    public Blog() {
    }


    public BlogUser getUser() {
        return blogUser;
    }

    public void setUser(BlogUser blogUser) {
        this.blogUser = blogUser;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
