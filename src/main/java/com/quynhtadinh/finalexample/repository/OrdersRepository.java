package com.quynhtadinh.finalexample.repository;

import com.quynhtadinh.finalexample.entity.Employees;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.quynhtadinh.finalexample.entity.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Long>{

//    Page<Orders> findByNameContaining(String name, Pageable pageable);

}
