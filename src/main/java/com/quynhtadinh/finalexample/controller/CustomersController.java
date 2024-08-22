package com.quynhtadinh.finalexample.controller;

import com.quynhtadinh.finalexample.entity.Customers;
import com.quynhtadinh.finalexample.entity.Customers;
import com.quynhtadinh.finalexample.entity.User;
import com.quynhtadinh.finalexample.service.CustomersService;
import com.quynhtadinh.finalexample.service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomersController {

	@Autowired
	private CustomersService customersService;

	@GetMapping
	public String listProducts(@RequestParam(name = "keyword", required = false) String keyword,
							   @RequestParam(name = "page", defaultValue = "0") int page,
							   Model model) {
		Page<Customers> listCategories = customersService.searchCustomers(keyword, page, 10);
		if (listCategories == null || listCategories.getContent().isEmpty()) {
			model.addAttribute("errorMessage", "No categories found.");
		}
		model.addAttribute("listCategories", listCategories);
		return "customers";
	}

	@GetMapping("/add")
	public String showAddCustomersForm(Model model) {
		model.addAttribute("customers", new Customers());
		return "add-customers";
	}

	@PostMapping("/save")
	public String saveCustomers(@ModelAttribute("customers") Customers customers) {
		customersService.saveCustomers(customers);
		return "redirect:/customers";
	}

	@GetMapping("/edit/{id}")
	public String showEditCustomersForm(@PathVariable("id") Long id, Model model) {
		Customers Customers = customersService.getCustomersById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Customers Id:" + id));
		model.addAttribute("Customers", Customers);
		return "edit-Customers";
	}

	@PostMapping("/update/{id}")
	public String updateCustomers(@PathVariable("id") Long id, @ModelAttribute("Customers") Customers customers) {
		customersService.updateCustomers(customers);
		return "redirect:/Customers";
	}

	@GetMapping("/delete/{id}")
	public String deleteCustomers(@PathVariable("id") Long id) {
		customersService.deleteCustomers(id);
		return "redirect:/Customers";
	}
}
