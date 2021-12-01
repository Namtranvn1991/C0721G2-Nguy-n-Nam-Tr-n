package com.casestudy.main.repository.employee;

import com.casestudy.main.model.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepo extends JpaRepository<Role,Integer> {
}
