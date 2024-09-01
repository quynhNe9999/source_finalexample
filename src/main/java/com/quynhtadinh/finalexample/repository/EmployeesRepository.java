package com.quynhtadinh.finalexample.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.quynhtadinh.finalexample.entity.Employees;

public interface EmployeesRepository  extends JpaRepository<Employees, Long>{
    @Query("SELECT e FROM Employees e WHERE e.name LIKE %:keyword% ")
    Page<Employees> FindAllByUserName(Optional<String> keyword, Pageable pageable);

    @Query("SELECT p FROM Employees p WHERE p.name LIKE %:keyword%")
    List<Employees> searchEmployees(@Param("keyword") String keyword);

    Page<Employees> findByNameContainingOrEmailContaining(String name,String email, Pageable pageable);

    @Query("SELECT COUNT(u) FROM Employees u")
    long countAllEmployees();

}
