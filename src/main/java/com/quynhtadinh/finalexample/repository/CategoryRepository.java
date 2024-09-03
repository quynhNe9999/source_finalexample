package com.quynhtadinh.finalexample.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.quynhtadinh.finalexample.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> ,CrudRepository<Category, Long> {
    @Query("SELECT e FROM Category e WHERE e.name LIKE %:keyword% ")
    Page<Category> FindAllByUserName(Optional<String> keyword, Pageable pageable);

    @Query("SELECT p FROM Category p WHERE p.name LIKE %:keyword%")
    List<Category> searchCategory(@Param("keyword") String keyword);

    Page<Category> findByNameContainingOrDescriptionContaining(String name,String description, Pageable pageable);

    @Query("SELECT COUNT(u) FROM Category u")
    long countAllCategory();

}
