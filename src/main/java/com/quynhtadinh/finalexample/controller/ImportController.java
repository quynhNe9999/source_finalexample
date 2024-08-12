package com.quynhtadinh.finalexample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ImportController {
	@GetMapping("/kho")
	public String getStringKho() {
		return "kho";
	}
	

}
