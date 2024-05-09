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
	
	@RequestMapping(value = "/index", method=RequestMethod.GET)
	public String index() {
		System.out.println("name index");
		return "index";
	}
	//layout
	@RequestMapping(value = "/boxed", method=RequestMethod.GET)
	public String layoutBoxed() {
		System.out.println("name boxed");
		return "boxed";
	}	

	@RequestMapping(value = "/fixed-header-boxed", method=RequestMethod.GET)
	public String layoutFixedheaderboxed() {
		System.out.println("name fixed-header-boxed");
		return "fixed-header-boxed";
	}
	
	@RequestMapping(value = "/fixed-header-fixed-mini-sidebar", method=RequestMethod.GET)
	public String fixedheaderfixedminisidebar() {
		System.out.println("name fixed-header-fixed-mini-sidebar");
		return "fixed-header-fixed-mini-sidebar";
	}
	
	@RequestMapping(value = "/fixed-header-menu", method=RequestMethod.GET)
	public String fixedheadermenu() {
		System.out.println("name fixed-header-menu");
		return "fixed-header-menu";
	}
	

	
		
}
