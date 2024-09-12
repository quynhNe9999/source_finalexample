package com.quynhtadinh.finalexample.controller;

import com.quynhtadinh.finalexample.entity.*;
import com.quynhtadinh.finalexample.repository.StoreRepository;
import com.quynhtadinh.finalexample.service.StoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.*;

@Controller
//@RequestMapping("/store")
public class StoreController {
	@Autowired
	private StoreService storeService;
	@Autowired
	private StoreRepository storeRepository;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/store")
	String showStore(Model map) {
		List<Store> store = storeService.getAllActiveStore();
		map.addAttribute("store", store);
		return "store";
	}

	@GetMapping(value = { "/add-store"})
	public String addStore(Model model) {
		model.addAttribute("store", new Store());
		return "add-store";
	}

	@PostMapping(value = { "/saveStore"})
	public String addStorePages(@ModelAttribute("store") Store store) {
		storeService.saveStore(store);
		return "redirect:/store";
	}

	@RequestMapping("/edit-store/{id}")
	public ModelAndView showEditStorePage(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("edit-store");
		Store store = storeService.getStoreById(id).get();
		mav.addObject("store", store);
		return mav;
	}

	@GetMapping("/delete-store/{id}")
	public String deleteStore(@PathVariable Long id) {
		storeService.deleteStore(id);
		return "redirect:/store";
	}

}
