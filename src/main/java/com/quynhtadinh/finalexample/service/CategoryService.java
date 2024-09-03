package com.quynhtadinh.finalexample.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.quynhtadinh.finalexample.entity.Category;
import com.quynhtadinh.finalexample.entity.Suppliers;
import com.quynhtadinh.finalexample.repository.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    public void save(Category category ) { 
        categoryRepository.save(category);
    }


    public Page<Category> findAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    public Category insert(Category Category) {
        return categoryRepository.save(Category);
    }

    public boolean delete(long id) {
        Optional<Category> Category = categoryRepository.findById(id);
        if (Category.isPresent()) {
            categoryRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Category update(Category Category) {
        Category updateCategory = categoryRepository.findById(Category.getCategory_id()).orElse(null);
        if (updateCategory != null) {
            updateCategory.setName(Category.getName());
            updateCategory.setDescription(Category.getDescription());
            // Thêm các phần khác của update nếu cần thiết
            return categoryRepository.save(updateCategory);
        }
        return null;
    }

    public List<Category> getAllCategorys() {
        return categoryRepository.findAll();
    }

    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    public Category saveCategory(Category Category) {
        return categoryRepository.save(Category);
    }

    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }
    @Transactional
    public Category updateCategory(Category newCategory) {
        try {
            return categoryRepository.findById(newCategory.getCategory_id())
                    .map(existingCategory -> {
                        existingCategory.setCategory_id(newCategory.getCategory_id());
                        existingCategory.setName(newCategory.getName());
                        existingCategory.setDescription(newCategory.getDescription());

                        return categoryRepository.save(existingCategory);
                    })
                    .orElseGet(() -> {
                        newCategory.setCategory_id(newCategory.getCategory_id());
                        return categoryRepository.save(newCategory);
                    });
        } catch (Exception e) {
            // Ghi log lỗi để kiểm tra
            System.err.println("Lỗi khi cập nhật người dùng: " + e.getMessage());
            // Hoặc dùng logger
            // logger.error("Lỗi khi cập nhật người dùng", e);
            throw new RuntimeException("Có lỗi xảy ra khi cập nhật người dùng", e);
        }
    }


    public Page<Category> searchCategories(Optional<String> keyword, Pageable pageable) {
        String searchKeyword = keyword.orElse("");
        return categoryRepository.findByNameContainingOrDescriptionContaining(searchKeyword,searchKeyword, pageable);
    }
}
