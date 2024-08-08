package com.quynhtadinh.finalexample.repository;

import com.quynhtadinh.finalexample.entity.Brand;
import com.quynhtadinh.finalexample.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
