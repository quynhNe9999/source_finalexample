package com.quynhtadinh.finalexample.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.quynhtadinh.finalexample.entity.ImageGallery;
import com.quynhtadinh.finalexample.service.ImageGalleryService;

@Controller
public class AdminController {
	
	private ImageGalleryService imageGalleryService;



	@RequestMapping(value = "/authentication-login", method=RequestMethod.GET)
	public String Authenticationlogin() {
		System.out.println("name authentication-login");
		return "authentication-login";
	}

	@RequestMapping(value = "/authentication-register", method=RequestMethod.GET)
	public String Authenticationregister() {
		System.out.println("name authentication-register");
		return "authentication-register";
	}


	@RequestMapping(value = "/add-products", method=RequestMethod.GET)
	public String AddProducts() {
		System.out.println("name add-products");
		return "add-products";
	}
	
}
