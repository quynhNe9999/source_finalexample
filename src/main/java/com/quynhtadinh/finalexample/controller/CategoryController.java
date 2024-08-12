package com.quynhtadinh.finalexample.controller;

import com.quynhtadinh.finalexample.entity.Category;
import com.quynhtadinh.finalexample.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.model.IModel;

import java.util.List;

@Controller
public class CategoryController {
	@Autowired
	private final CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@GetMapping("/category")
	public String getStringCategory(Model model) {
		List<Category> listCategories = categoryService.getAllCategory();
		model.addAttribute("listCategories", listCategories);
		return "category";
	}
	@GetMapping("/add-category")
	public String showNewCategoryPage(Model model) {
		Category category = new Category();
		model.addAttribute("category", category);
		return "add-category";
	}
	@PostMapping("/add-category")
	public String saveProduct(@ModelAttribute("category") Category category) {
		categoryService.saveCategory(category);
		return "redirect:/category";
	}
	@GetMapping("/edit-category/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name = "category_id") Long category_id, Model model) {
		ModelAndView mav = new ModelAndView("edit_category");
		Category category = categoryService.getCategoryById(category_id);
		mav.addObject("category", category);
		return mav;
	}

	@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "category_id") Long category_id) {
		categoryService.deleteCategoryById(category_id);;
		return "redirect:/category";
	}
}
