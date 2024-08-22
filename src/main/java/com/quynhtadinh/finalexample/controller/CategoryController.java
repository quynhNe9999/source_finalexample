package com.quynhtadinh.finalexample.controller;

import com.quynhtadinh.finalexample.entity.Category;
import com.quynhtadinh.finalexample.service.CategoryService;
import com.quynhtadinh.finalexample.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping
	public String listProducts(@RequestParam(name = "keyword", required = false) String keyword,
							   @RequestParam(name = "page", defaultValue = "0") int page,
							   Model model) {
		Page<Category> listCategories = categoryService.searchCategory(keyword, page, 10);
		if (listCategories == null || listCategories.getContent().isEmpty()) {
			model.addAttribute("errorMessage", "No categories found.");
		}
		model.addAttribute("listCategories", listCategories);
		return "category";
	}

	@GetMapping("/add")
	public String showAddCategoryForm(Model model) {
		model.addAttribute("category", new Category());
		return "add-category";
	}

	@PostMapping("/save")
	public String saveCategory(@ModelAttribute("category") Category category) {
		categoryService.saveCategory(category);
		return "redirect:/category";
	}

	@GetMapping("/edit/{id}")
	public String showEditCategoryForm(@PathVariable("id") Long id, Model model) {
		Category category = categoryService.getCategoryById(id).orElseThrow(() -> new IllegalArgumentException("Invalid category Id:" + id));
		model.addAttribute("category", category);
		return "edit-category";
	}

	@PostMapping("/update/{id}")
	public String updateCategory(@PathVariable("id") Long id, @ModelAttribute("category") Category category) {
		categoryService.updateCategory(category);
		return "redirect:/category";
	}

	@GetMapping("/delete/{id}")
	public String deleteCategory(@PathVariable("id") Long id) {
		categoryService.deleteCategory(id);
		return "redirect:/category";
	}
}
