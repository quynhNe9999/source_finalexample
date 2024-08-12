package com.quynhtadinh.finalexample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class EmployeesController {

	@GetMapping("/employees")
	public String getStringEmployees() {
		return "employees";
	}
	
}
