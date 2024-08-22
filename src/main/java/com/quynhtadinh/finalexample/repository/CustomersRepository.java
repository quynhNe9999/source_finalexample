package com.quynhtadinh.finalexample.repository;

import com.quynhtadinh.finalexample.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.quynhtadinh.finalexample.entity.Customers;

public interface CustomersRepository extends JpaRepository<Customers, Long>{
    Page<Customers> findByNameContaining(String keyword, Pageable pageable);

}
