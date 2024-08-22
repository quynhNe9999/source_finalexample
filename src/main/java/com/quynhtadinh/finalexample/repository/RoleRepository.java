package com.quynhtadinh.finalexample.repository;


import com.quynhtadinh.finalexample.entity.Employees;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.quynhtadinh.finalexample.entity.Role;


public interface RoleRepository extends JpaRepository<Role, Long>{
   // Role findByUsername(String name);

}
