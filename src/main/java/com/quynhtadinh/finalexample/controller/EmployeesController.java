package com.quynhtadinh.finalexample.controller;

import com.quynhtadinh.finalexample.entity.Employees;
import com.quynhtadinh.finalexample.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/employees")
public class EmployeesController {

	@Autowired
	private EmployeesService employeesService;


	@GetMapping
	public String listProducts(@RequestParam(name = "keyword", required = false) String keyword,
							   @RequestParam(name = "page", defaultValue = "0") int page,
							   Model model) {
		Page<Employees> employeesPage = employeesService.searchEmployees(keyword, page, 10);
		model.addAttribute("listEmployees", employeesPage);
		return "employees";
	}

	@GetMapping("/add")
	public String showAddEmployeesForm(Model model) {
		model.addAttribute("employees", new Employees());
		return "add_employees";
	}

	@PostMapping("/save")
	public String saveEmployees(@ModelAttribute("employees") Employees employees) {
		employeesService.saveEmployees(employees);
		return "redirect:/employees";
	}

	@GetMapping("/edit/{id}")
	public String showEditEmployeesForm(@PathVariable("id") Long id, Model model) {
		Employees employees = employeesService.getEmployeesById(id).orElseThrow(() -> new IllegalArgumentException("Invalid employees Id:" + id));
		model.addAttribute("employees", employees);
		return "edit-employees";
	}

	@PostMapping("/update/{id}")
	public String updateEmployees(@PathVariable("id") Long id, @ModelAttribute("employees") Employees employees) {
		employeesService.updateEmployees(employees);
		return "redirect:/employees";
	}

	@GetMapping("/delete/{id}")
	public String deleteEmployees(@PathVariable("id") Long id) {
		employeesService.deleteEmployees(id);
		return "redirect:/employees";
	}
	
}

