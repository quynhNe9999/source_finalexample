package com.quynhtadinh.finalexample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

	@RequestMapping(value = "/dashboard", method=RequestMethod.GET)
	public String MENUdashboard() {
		System.out.println("name dashboard");
		return "dashboard";
	}
}
