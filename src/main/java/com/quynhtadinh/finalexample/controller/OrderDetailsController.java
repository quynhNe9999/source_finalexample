package com.quynhtadinh.finalexample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderDetailsController {
	@GetMapping("/orderDetails")
	public String getStringOrderDetails() {
		return "orderDetails";
	}
}
