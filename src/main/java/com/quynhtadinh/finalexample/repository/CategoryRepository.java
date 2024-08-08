package com.quynhtadinh.finalexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quynhtadinh.finalexample.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
}
