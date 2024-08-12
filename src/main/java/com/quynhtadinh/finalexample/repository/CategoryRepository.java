package com.quynhtadinh.finalexample.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.quynhtadinh.finalexample.entity.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("SELECT c FROM Category c WHERE "
            + "c.name LIKE %:searchTerm% OR "
            + "c.description LIKE %:searchTerm% ")
//            + "c.price LIKE %:searchTerm%") // Thay `otherField` bằng các trường khác trong bảng của bạn
    Page<Category> searchCategories(@Param("searchTerm") String searchTerm, Pageable pageable);

}
