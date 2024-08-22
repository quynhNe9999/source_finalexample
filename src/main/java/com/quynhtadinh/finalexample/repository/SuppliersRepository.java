package com.quynhtadinh.finalexample.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.quynhtadinh.finalexample.entity.Suppliers;

public interface SuppliersRepository extends JpaRepository<Suppliers, Long>{
    Page<Suppliers> findByNameContaining(String name, Pageable pageable);

}
