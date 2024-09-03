package com.quynhtadinh.finalexample.controller;

import com.quynhtadinh.finalexample.entity.Category;
import com.quynhtadinh.finalexample.entity.Role;
import com.quynhtadinh.finalexample.entity.User;
import com.quynhtadinh.finalexample.repository.CategoryRepository;
import com.quynhtadinh.finalexample.service.CategoryService;
import com.quynhtadinh.finalexample.service.ProductService;
import com.quynhtadinh.finalexample.service.SuppliersService;
import com.quynhtadinh.finalexample.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	@Autowired
	private SuppliersService suppliersService;
    @Autowired
    private CategoryRepository categoryRepository;
    

	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public ModelAndView home(@RequestParam(required = false, name = "keyword" )String keyword,
							 @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size, Model model
			, Pageable pageable) throws IOException {
		pageable = PageRequest.of(page, size);

		Page<Category> listCategories;

		if (keyword != null && !keyword.isEmpty()) {
			listCategories =  categoryService.searchCategories(Optional.of(keyword), pageable);
		} else {
			listCategories = categoryService.findAll(pageable);
		}

		Page<Category> categories = categoryService.findAll(pageable);
		long countAllUsers = categoryRepository.count();
		model.addAttribute("totalRecords", countAllUsers);
		model.addAttribute("category", categories.getContent());
		model.addAttribute("page", categories);
		model.addAttribute("keyword", keyword);
		Map<String, Object> modelMap = new HashMap<>();
		modelMap.put("listCategories", listCategories);
		return new ModelAndView("category", modelMap);
	}

	@RequestMapping(value = "/add-category", method = RequestMethod.GET)
	public String categoryAdd(Model model,Pageable pageable) {
		model.addAttribute("category", new Category());
	    model.addAttribute("suppliers", suppliersService.findAll(pageable)); // Lấy danh sách tất cả các suppliers

		return "add-category";
	}

	@RequestMapping(value = "/add-category", method = RequestMethod.POST)
	public String registrations(@ModelAttribute("category") Category category, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "add-category";
		}
		categoryService.save(category);
		return "redirect:/category";
	}

	@GetMapping("/edit-category/{id}")
	public String showEditForm(@PathVariable Long id, Model model) {
		Optional<Category> category = categoryService.getCategoryById(id);
		if (category.isPresent()) {
			model.addAttribute("category", category.get());
			return "edit-category";
		} else {
			return "redirect:/category";
		}
	}
	@PostMapping("/edit-category/{id}")
	public String updateCategorys(@PathVariable Long id, @ModelAttribute("category") Category newCategory, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("message", "Có lỗi xảy ra khi cập nhật người dùng");
			return "edit-category"; // Hoặc trang lỗi tương ứng
		}

		try {
			Category existingCategory = categoryService.getCategoryById(id)
					.orElseThrow(() -> new IllegalArgumentException("Người dùng không tồn tại: " + id));

			existingCategory.setName(newCategory.getName());
			existingCategory.setDescription(newCategory.getDescription());
			existingCategory.setPrice(newCategory.getPrice());
			existingCategory.setStock(newCategory.getStock());
			existingCategory.setImage(newCategory.getImage());
			existingCategory.setSupplier(newCategory.getSupplier());

			categoryService.update(existingCategory);
			return "redirect:/category";
		} catch (Exception e) {
			model.addAttribute("message", "Có lỗi xảy ra khi cập nhật người dùng: " + e.getMessage());
			return "edit-category"; // Hoặc trang lỗi tương ứng
		}
	}

	@GetMapping("/delete-category/{id}")
	public String deleteCategory(@PathVariable Long id) {
		categoryService.deleteCategoryById(id);
		return "redirect:/category";
	}
}
