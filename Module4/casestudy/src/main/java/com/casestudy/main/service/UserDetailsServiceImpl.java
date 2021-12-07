package com.casestudy.main.service;


import com.casestudy.main.model.user.Role;
import com.casestudy.main.model.user.User;
import com.casestudy.main.repository.employee.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    IUserRepo iUserRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = iUserRepo.findByUserName(username);
        if(user ==null){
            System.out.println("User not found! " + username);
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }
        System.out.println("Found User: " + user);


        List<String> roleList = iUserRepo.roleList(username);
        List<GrantedAuthority> grantList = new ArrayList<>();
        if(roleList != null){
            for(Role role :user.getRoles()){
                GrantedAuthority authority = new SimpleGrantedAuthority(role.getRoleName());
                grantList.add(authority);
            }
        }


//        if(roleList != null){
//            for(String role: roleList){
//                GrantedAuthority authority = new SimpleGrantedAuthority(role);
//                grantList.add(authority);
//            }
//        }

        UserDetails userDetails = (UserDetails) new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(), grantList);


        return userDetails;
    }
}
