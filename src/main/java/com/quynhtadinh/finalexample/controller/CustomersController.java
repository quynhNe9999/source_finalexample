package com.quynhtadinh.finalexample.controller;

import com.quynhtadinh.finalexample.entity.Customers;

import com.quynhtadinh.finalexample.entity.ImageGallery;
import com.quynhtadinh.finalexample.repository.CustomersRepository;
import com.quynhtadinh.finalexample.service.CustomersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class CustomersController {

	@Autowired
	private CustomersService customersService;
	@Autowired
	private CustomersRepository customersRepository;

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@GetMapping("/customers")
	String show(Model map) {
		List<Customers> customers = customersService.getAllActiveCustomers();
		map.addAttribute("customers", customers);
		return "customers";
	}

	@GetMapping(value = { "/add-customers"})
	public String addCustomersPage(Model model) {
	model.addAttribute("customers", new Customers());
		return "add-customers";
	}
	@PostMapping(value = { "/add-customers"})
	public String addCustomersPages(@ModelAttribute("customers") Customers customers) {
	customersService.saveCustomers(customers);
		return "redirect:/customers";
	}


	@GetMapping("/delete-customers/{id}")
	public String deleteCustomers(@PathVariable Long id) {
		customersService.deleteCustomers(id);
		return "redirect:/customers";
	}
}
