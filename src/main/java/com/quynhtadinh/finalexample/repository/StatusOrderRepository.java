package com.quynhtadinh.finalexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quynhtadinh.finalexample.entity.StatusOrder;

@Repository
public interface StatusOrderRepository extends JpaRepository<StatusOrder,Integer> {
}
