package com.quynhtadinh.finalexample.repository;


import com.quynhtadinh.finalexample.entity.Store;
import com.quynhtadinh.finalexample.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StoreRepository extends JpaRepository<Store, Long>{

}