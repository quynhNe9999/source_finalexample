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
public class EmployeesController {

	@Autowired
	private final EmployeesService employeesService;

	public EmployeesController(EmployeesService employeesService) {
		this.employeesService = employeesService;
	}

	@GetMapping("/employees")
	public String getStringEmployees() {
		return "employees";
	}

	@GetMapping("/add-employees")
	public String showNewEmployeeForm(Model model) {
		// create model attribute to bind form data
		Employees employees = new Employees();
		model.addAttribute("employees", employees);
		return "add_employees";
	}

	@PostMapping("/add-employees")
	public String saveEmployees(@ModelAttribute("employees") Employees employees) {
		employeesService.saveEmployees(employees);
		return "redirect:/employees";
	}

	@GetMapping("/edit-employees/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {

		// get employee from the service
		Employees employees = employeesService.getEmployeesById(id);

		// set employee as a model attribute to pre-populate the form
		model.addAttribute("employees", employees);
		return "edit_employees";
	}
	@PostMapping("/edit-employees/{id}")
	public String EditEmployees(@ModelAttribute("employees") Employees employees) {
		// save employee to database
		employeesService.saveEmployees(employees);
		return "redirect:/employees";
	}

	@GetMapping("/deleteEmployees/{id}")
	public String deleteEmployees(@PathVariable (value = "id") long id) {

		// call delete employee method
		this.employeesService.deleteEmployeesById(id);
		return "redirect:/employees";
	}



	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
								@RequestParam("sortField") String sortField,
								@RequestParam("sortDir") String sortDir,
								Model model) {
		int pageSize = 5;

		Page<Employees> page = employeesService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Employees> listEmployees = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());

		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

		model.addAttribute("listEmployees", listEmployees);
		return "employees";
	}
	
}

