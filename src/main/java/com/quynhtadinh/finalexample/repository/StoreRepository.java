package com.quynhtadinh.finalexample.repository;

import com.quynhtadinh.finalexample.entity.Store;
import com.quynhtadinh.finalexample.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StoreRepository extends JpaRepository<Store, Long> {

    Page<Store> findByNameContaining(String name, Pageable pageable);

    @Query("SELECT e FROM Store e WHERE e.name LIKE %:keyword% ")
    Page<Store> FindAllByName(Optional<String> keyword, Pageable pageable);

    @Query("SELECT p FROM Store p WHERE p.name LIKE %:keyword%")
    List<Store> searchUser(@Param("keyword") String keyword);

    Page<Store> findByNameContainingOrAddressContaining(String name, String address, Pageable pageable);

    @Query("SELECT COUNT(u) FROM Store u")
    long countAllStore();
}
