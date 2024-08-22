package com.quynhtadinh.finalexample.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.quynhtadinh.finalexample.entity.Employees;

public interface EmployeesRepository  extends JpaRepository<Employees, Long>{
    Page<Employees> findByNameContaining(String name, Pageable pageable);

}
