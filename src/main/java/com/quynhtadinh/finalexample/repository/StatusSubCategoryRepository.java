package com.quynhtadinh.finalexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quynhtadinh.finalexample.entity.StatusSubCategory;

@Repository
public interface StatusSubCategoryRepository extends JpaRepository<StatusSubCategory,Integer> {
}
