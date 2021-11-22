package com.main.blog.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.UUID;

@Entity
public class BlogUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique=true)
    @Size(min=6,max=10,message = "Username length 6-10 characters")
    @Pattern(regexp = "[A-Za-z0-9]*",message = "Username does not contain special characters")
    private String userName;

    @Size(min=6,max=10,message = "Password length 6-10 characters")
    @Pattern(regexp = "[A-Za-z0-9]*",message = "Password does not contain special characters")
    private String password;

    @OneToMany(mappedBy = "blogUser",cascade = CascadeType.ALL)
    private List<Blog> blogList;

    public BlogUser() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Blog> getBlogList() {
        return blogList;
    }

    public void setBlogList(List<Blog> blogList) {
        this.blogList = blogList;
    }
}
