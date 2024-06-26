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

	@RequestMapping(value = "/welcome", method=RequestMethod.GET)
	public String Welcome() {
		System.out.println("name welcome");
		return "welcome";
	}

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

	@RequestMapping(value = "/icon-tabler", method=RequestMethod.GET)
	public String Icontabler() {
		System.out.println("name icon-tabler");
		return "icon-tabler";
	}

	@RequestMapping(value = "/sample-page", method=RequestMethod.GET)
	public String Samplepage() {
		System.out.println("name sample-page");
		return "sample-page";
	}

	@RequestMapping(value = "/ui-alerts", method=RequestMethod.GET)
	public String Uialerts() {
		System.out.println("name ui-alerts");
		return "ui-alerts";
	}

	@RequestMapping(value = "/ui-buttons", method=RequestMethod.GET)
	public String Uibuttons() {
		System.out.println("name ui-buttons");
		return "ui-buttons";
	}

	@RequestMapping(value = "/ui-card", method=RequestMethod.GET)
	public String Uicard() {
		System.out.println("name ui-card");
		return "ui-card";
	}

	@RequestMapping(value = "/ui-forms", method=RequestMethod.GET)
	public String Uiforms() {
		System.out.println("name ui-forms");
		return "ui-forms";
	}

	@RequestMapping(value = "/ui-typography", method=RequestMethod.GET)
	public String Uitypography() {
		System.out.println("name ui-typography");
		return "ui-typography";
	}
	
	@RequestMapping(value = "/table", method=RequestMethod.GET)
	public String Table( Model map) {
//		List<ImageGallery> images = imageGalleryService.getAllActiveImages();
//		map.addAttribute("images", images);
		System.out.println("name table");
		return "table";
	}

	@RequestMapping(value = "/add-products", method=RequestMethod.GET)
	public String AddProducts() {
		System.out.println("name add-products");
		return "add-products";
	}
	
}
