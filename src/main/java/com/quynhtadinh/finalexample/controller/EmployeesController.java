package com.quynhtadinh.finalexample.controller;

import com.quynhtadinh.finalexample.entity.Employees;
import com.quynhtadinh.finalexample.repository.EmployeesRepository;
import com.quynhtadinh.finalexample.service.EmployeesService;
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
//@RequestMapping("/employees")
public class EmployeesController {

	@Autowired
	private EmployeesService employeesService;
	@Autowired
	private EmployeesRepository employeesRepository;


	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/employees")
	String showEmployees(Model map) {
		List<Employees> employees = employeesService.getAllActiveEmployees();
		map.addAttribute("employees", employees);
		return "employees";
	}

	@GetMapping(value = { "/add-employees"})
	public String addEmployees(Model model) {
		model.addAttribute("employees", new Employees());
		return "add-employees";
	}

	@PostMapping(value = { "/saveEmployees"})
	public String addEmployeesPages(@ModelAttribute("employees") Employees employees) {
		employeesService.saveEmployees(employees);
		return "redirect:/employees";
	}

	@RequestMapping("/edit-employees/{id}")
	public ModelAndView showEditEmployeesPage(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("edit-employees");
		Employees employees = employeesService.getEmployeesById(id).get();
		mav.addObject("employees", employees);
		return mav;
	}

	@GetMapping("/delete-employees/{id}")
	public String deleteEmployees(@PathVariable Long id) {
		employeesService.deleteEmployees(id);
		return "redirect:/employees";
	}


}

