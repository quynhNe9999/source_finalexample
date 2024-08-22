//package com.quynhtadinh.finalexample.servive.impl;
//
//import com.quynhtadinh.finalexample.entity.Category;
//import com.quynhtadinh.finalexample.repository.CategoryRepository;
//import com.quynhtadinh.finalexample.service.CategoryService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//
//import java.util.Collections;
//import java.util.List;
//import java.util.Optional;
//@Service
//public class CategoryServiceImpl implements CategoryService {
//    private CategoryRepository categoryRepository;
//
//    @Autowired
//    public CategoryServiceImpl(CategoryRepository categoryRepository) {
//        this.categoryRepository = categoryRepository;
//    }
//
//    @Override
//    public Category getCategoryById(Long id) {
//        Optional<Category> category = categoryRepository.findById(id);
//        return category.orElse(null); // Hoặc xử lý trường hợp không tìm thấy theo cách khác
//    }
//
//    @Override
//    public Category updateCategory(Category category) {
//        if (categoryRepository.existsById(category.getCategory_id())) {
//            return categoryRepository.save(category);
//        } else {
//            throw new IllegalArgumentException("Category not found");
//        }
//    }
//
//    @Override
//    public void deleteCategoryById(Long id) {
//        if (categoryRepository.existsById(id)) {
//            categoryRepository.deleteById(id);
//        } else {
//            throw new IllegalArgumentException("Category not found");
//        }
//    }
//
//    @Override
//    public List<Category> getAllCategory() {
//        return categoryRepository.findAll();
//    }
//
//    @Override
//    public Category saveCategory(Category category) {
//        return categoryRepository.save(category);
//    }
//
//    @Override
//    public Page<Category> searchCategories(String searchTerm, Pageable pageable) {
//        return categoryRepository.searchCategories(searchTerm, pageable);
//    }
//}
