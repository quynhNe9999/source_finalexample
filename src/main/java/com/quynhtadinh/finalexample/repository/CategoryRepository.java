package com.quynhtadinh.finalexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quynhtadinh.finalexample.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
