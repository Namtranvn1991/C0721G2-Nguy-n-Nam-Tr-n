package com.blog.model;

import javax.persistence.*;

@Entity
@Table (name = "blog")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String description;
    private String context;

    public Blog() {
    }

    public Blog(String description, String context) {
        this.description = description;
        this.context = context;
    }

    @Override
    public String toString() {
        return String.format("Blog[id=%d, description='%s', context='%s']", id, description, context);
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
