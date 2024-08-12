package com.quynhtadinh.finalexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quynhtadinh.finalexample.entity.Customers;

public interface CustomersRepository extends JpaRepository<Customers, Long>{

}
