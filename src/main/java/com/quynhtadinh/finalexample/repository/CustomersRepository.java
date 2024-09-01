package com.quynhtadinh.finalexample.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.quynhtadinh.finalexample.entity.Customers;

public interface CustomersRepository extends JpaRepository<Customers, Long>{
    @Query("SELECT e FROM Customers e WHERE e.name LIKE %:keyword% ")
    Page<Customers> FindAllByUserName(Optional<String> keyword, Pageable pageable);

    @Query("SELECT p FROM Customers p WHERE p.name LIKE %:keyword%")
    List<Customers> searchCustomers(@Param("keyword") String keyword);

    Page<Customers> findByNameContainingOrEmailContainingOrAddressContainingOrPhoneContaining(String name,String email,String phone,String address, Pageable pageable);

    @Query("SELECT COUNT(u) FROM Customers u")
    long countAllCustomers();

}
