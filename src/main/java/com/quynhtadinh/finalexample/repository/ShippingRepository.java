package com.quynhtadinh.finalexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quynhtadinh.finalexample.entity.Shipping;

@Repository
public interface ShippingRepository extends JpaRepository<Shipping,Long> {
}
