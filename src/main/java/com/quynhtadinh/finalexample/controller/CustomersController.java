package com.quynhtadinh.finalexample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomersController {
	@GetMapping("/customers")
	public String getStringCustomers() {
		return "customers";
	}

}
