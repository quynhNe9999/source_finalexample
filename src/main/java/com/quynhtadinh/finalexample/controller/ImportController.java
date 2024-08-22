//package com.quynhtadinh.finalexample.controller;
//
//import com.quynhtadinh.finalexample.entity.Import;
//import com.quynhtadinh.finalexample.entity.Import;
//import com.quynhtadinh.finalexample.service.ImportService;
//import com.quynhtadinh.finalexample.service.ImportService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.io.IOException;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Optional;
//
//import static org.springframework.util.ClassUtils.isPresent;
//
//@Controller
//@RequestMapping("/import")
//public class ImportController {
//
//	@Autowired
//	private ImportService importService;
//
//	@GetMapping
//	public String listProducts(@RequestParam(name = "keyword", required = false) String keyword,
//							   @RequestParam(name = "page", defaultValue = "0") int page,
//							   Model model) {
//		Page<Import> listCategories = importService.searchImport(keyword, page, 10);
//		if (listCategories == null || listCategories.getContent().isEmpty()) {
//			model.addAttribute("errorMessage", "No categories found.");
//		}
//		model.addAttribute("listCategories", listCategories);
//		return "kho";
//	}
//
//	@GetMapping("/add")
//	public String showAddImportForm(Model model) {
//		model.addAttribute("kho", new Import());
//		return "add-kho";
//	}
//
//	@PostMapping("/save")
//	public String saveImport(@ModelAttribute("kho") Import imports) {
//		importService.saveImport(imports);
//		return "redirect:/kho";
//	}
//
//	@GetMapping("/edit/{id}")
//	public String showEditImportForm(@PathVariable("id") Long id, Model model) {
//		Import Import = importService.getImportById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Import Id:" + id));
//		model.addAttribute("kho", Import);
//		return "edit-kho";
//	}
//
//	@PostMapping("/update/{id}")
//	public String updateImport(@PathVariable("id") Long id, @ModelAttribute("kho") Import imports) {
//		importService.updateImport(imports);
//		return "redirect:/kho";
//	}
//
//	@GetMapping("/delete/{id}")
//	public String deleteImport(@PathVariable("id") Long id) {
//		importService.deleteImport(id);
//		return "redirect:/kho";
//	}
//}
