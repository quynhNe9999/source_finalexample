package com.quynhtadinh.finalexample.repository;


import com.quynhtadinh.finalexample.entity.Role;
import com.quynhtadinh.finalexample.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SupplierRepository extends JpaRepository<Supplier, Long>{

}