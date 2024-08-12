package com.quynhtadinh.finalexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quynhtadinh.finalexample.entity.Employees;

public interface EmployeesRepository  extends JpaRepository<Employees, Long>{

}
