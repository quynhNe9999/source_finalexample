package com.quynhtadinh.finalexample.controller;

import com.quynhtadinh.finalexample.entity.Category;

import com.quynhtadinh.finalexample.entity.Store;
import com.quynhtadinh.finalexample.entity.Suppliers;
import com.quynhtadinh.finalexample.service.CategoryService;
import com.quynhtadinh.finalexample.service.SuppliersService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SuppliersService suppliersService;

	@GetMapping("/category")
	String showCategory(Model map) {
		List<Category> category = categoryService.getAllActiveCategory();
		map.addAttribute("category", category);
		return "category";
	}

	@GetMapping(value = { "/add-category"})
	public String addCategory(Model model) {
		model.addAttribute("category", new Category());
		return "add-category";
	}

	@PostMapping(value = { "/saveCategory"})
	public String addCategoryPages(@ModelAttribute("category") Category category) {
		categoryService.saveCategory(category);
		return "redirect:/category";
	}

	@RequestMapping("/edit-category/{id}")
	public ModelAndView showEditCategoryPage(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("edit-category");
		Category category = categoryService.getCategoryById(id).get();
		mav.addObject("category", category);
		return mav;
	}

	@GetMapping("/delete-category/{id}")
	public String deleteCategory(@PathVariable Long id) {
		categoryService.deleteCategory(id);
		return "redirect:/category";
	}
}
