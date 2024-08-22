package com.quynhtadinh.finalexample.controller;

import com.quynhtadinh.finalexample.entity.Customers;

import com.quynhtadinh.finalexample.repository.CustomersRepository;
import com.quynhtadinh.finalexample.service.CustomersService;
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
import java.util.Map;
import java.util.Optional;

@Controller
public class CustomersController {

	@Autowired
	private CustomersService customersService;
	@Autowired
	private CustomersRepository customersRepository;

	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public ModelAndView home(@RequestParam(required = false, name = "keyword" )String keyword,
							 @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size, Model model
			, Pageable pageable) throws IOException {
		pageable = PageRequest.of(page, size);

		Page<Customers> listCustomers;

		if (keyword != null && !keyword.isEmpty()) {
			listCustomers =  customersService.searchCustomers(Optional.of(keyword), pageable);
		} else {
			listCustomers = customersService.findAll(pageable);
		}

		Page<Customers> customers = customersService.findAll(pageable);
		long countAllUsers = customersRepository.count();
		model.addAttribute("totalRecords", countAllUsers);
		model.addAttribute("customers", customers.getContent());
		model.addAttribute("page", customers);
		model.addAttribute("keyword", keyword);
		Map<String, Object> modelMap = new HashMap<>();
		modelMap.put("listCustomers", listCustomers);
		return new ModelAndView("customers", modelMap);
	}

	@RequestMapping(value = "/add-customers", method = RequestMethod.GET)
	public String customersAdd(Model model) {
		model.addAttribute("customers", new Customers());

		return "add-customers";
	}

	@RequestMapping(value = "/add-customers", method = RequestMethod.POST)
	public String customersaddp(@ModelAttribute("customers") Customers customers, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "add-customers";
		}
		customersService.save(customers);
		return "redirect:/customers";
	}

	@GetMapping("/edit-customers/{id}")
	public String showEditForm(@PathVariable Long id, Model model) {
		Optional<Customers> customers = customersService.getCustomersById(id);
		if (customers.isPresent()) {
			model.addAttribute("customers", customers.get());
			return "edit-customers";
		} else {
			return "redirect:/customers";
		}
	}
	@PostMapping("/edit-customers/{id}")
	public String updateCustomersString(@PathVariable Long id, @ModelAttribute("customers") Customers newCustomers, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("message", "Có lỗi xảy ra khi cập nhật người dùng");
			return "edit-customers"; // Hoặc trang lỗi tương ứng
		}

		try {
			Customers existingCustomers = customersService.getCustomersById(id)
					.orElseThrow(() -> new IllegalArgumentException("Người dùng không tồn tại: " + id));

			existingCustomers.setName(newCustomers.getName());
			existingCustomers.setEmail(newCustomers.getEmail());
			existingCustomers.setAddress(newCustomers.getAddress());
			existingCustomers.setPhone(newCustomers.getPhone());

			customersService.update(existingCustomers);
			return "redirect:/customers";
		} catch (Exception e) {
			model.addAttribute("message", "Có lỗi xảy ra khi cập nhật người dùng: " + e.getMessage());
			return "edit-customers"; // Hoặc trang lỗi tương ứng
		}
	}

	@GetMapping("/delete-customers/{id}")
	public String deleteCustomers(@PathVariable Long id) {
		customersService.deleteCustomersById(id);
		return "redirect:/customers";
	}
}
