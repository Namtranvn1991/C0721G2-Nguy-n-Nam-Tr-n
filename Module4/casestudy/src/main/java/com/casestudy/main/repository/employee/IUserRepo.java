package com.casestudy.main.repository.employee;

import com.casestudy.main.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepo extends JpaRepository<User,Integer> {

//
//    @Modifying
//    @Transactional

    User findByUserName(String userName);

    Boolean existsByUserName(String userName);

    @Query(value = "select role_name from user " +
            "join user_role on user_role.user_name = user.user_name " +
            "join role on role.role_id = user_role.role_id " +
            "where user_role.user_name like :name ;",
            nativeQuery = true)
    List<String> roleList (@Param("name") String userName);


}
