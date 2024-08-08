package com.quynhtadinh.finalexample.service;

import com.quynhtadinh.finalexample.entity.Role;
import com.quynhtadinh.finalexample.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}
