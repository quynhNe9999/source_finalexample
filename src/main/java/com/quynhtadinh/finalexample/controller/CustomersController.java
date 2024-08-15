package com.quynhtadinh.finalexample.controller;

import com.quynhtadinh.finalexample.entity.Customers;
import com.quynhtadinh.finalexample.entity.User;
import com.quynhtadinh.finalexample.service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class CustomersController {
	@Autowired
	private CustomersService customersService;
			
	@GetMapping("/customers")
	public String getStringCustomers( Model model) {
		List<Customers> listCustomers = customersService.getAllCustomers();
//        System.out.println(users);
		model.addAttribute("listUsers",listCustomers);
		return "customers";
	}

	@GetMapping("/add-customers")
	public String showCreateForm(Model model) {
		model.addAttribute("customers", new Customers());
		return "add-customers";
	}

	@PostMapping("/add-customers")
	public String createCustomers(@ModelAttribute("customers") Customers customers) {
		customersService.saveCustomers(customers);
		return "redirect:/customers";
	}

	@GetMapping("/edit-customers/{id}")
	public String showEditForm(@PathVariable Long id, Model model) {
		Optional<Customers> customers = Optional.ofNullable(customersService.getCustomersById(id));
		if (customers.isPresent()) {
			model.addAttribute("customers", customers.get());
			return "edit-customers";
		} else {
			return "redirect:/customers";
		}
	}

	@PostMapping("/edit-customers/{id}")
	public String updatecustomers(@PathVariable Long id, @ModelAttribute("customers") Customers newCustomers) {
		customersService.updateCustomers(id,newCustomers);
		return "redirect:/customers";
	}

	@GetMapping("/delete-customers/{id}")
	public String deletecustomers(@PathVariable Long id) {
		customersService.deleteCustomersById(id);
		return "redirect:/customers";
	}
}
