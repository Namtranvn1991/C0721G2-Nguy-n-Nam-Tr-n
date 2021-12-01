package com.casestudy.main.model.user;

import com.casestudy.main.model.employee.Employee;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @Column(columnDefinition = "VARCHAR(255)")
    private String userName;

    @Column(columnDefinition = "VARCHAR(255)")
    private String password;

    @OneToOne(mappedBy = "userName")
    private Employee employee;

    @ManyToMany(mappedBy = "users")
    private List<Role> roles;

    public User() {
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String username) {
        this.userName = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
