package com.quynhtadinh.finalexample.service;

import com.quynhtadinh.finalexample.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    Category getCategoryById(Long id);

    Category updateCategory(Category category);

    void deleteCategoryById(Long id);

    List<Category> getAllCategory();

    Category saveCategory(Category category);

    Page<Category> searchCategories(String searchTerm, Pageable pageable);

}
