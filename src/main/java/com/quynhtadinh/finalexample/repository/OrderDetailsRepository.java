package com.quynhtadinh.finalexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quynhtadinh.finalexample.entity.OrderDetails;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long>{

}
