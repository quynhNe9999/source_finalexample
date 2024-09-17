package com.quynhtadinh.finalexample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {
	@GetMapping("/405")
	public String Get405 () {
		return "error_405";
	}
	
}
