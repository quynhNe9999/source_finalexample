package com.quynhtadinh.finalexample.controller;

import com.quynhtadinh.finalexample.entity.Product;
import com.quynhtadinh.finalexample.entity.Role;
import com.quynhtadinh.finalexample.entity.Store;
import com.quynhtadinh.finalexample.entity.User;
import com.quynhtadinh.finalexample.repository.StoreRepository;
import com.quynhtadinh.finalexample.service.StoreService;
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
@RequestMapping("/store")
public class StoreController {
	@Autowired
	private StoreService storeService;
	@Autowired
	private StoreRepository storeRepository;
	@GetMapping
	public String listStores(@RequestParam(name = "keyword", required = false) String keyword,
							   @RequestParam(name = "page", defaultValue = "0") int page,
							   Model model) {
		Page<Store> listStores = storeService.searchStores(keyword, page, 10);
		model.addAttribute("listStores", listStores);
		return "store";
	}
//
//	@RequestMapping(value = "/user", method = RequestMethod.GET)
//	public ModelAndView home(@RequestParam(required = false, name = "keyword" )String keyword,
////                             @RequestParam(name = "keyword") Optional<String> keyword,
////                             @RequestParam(required = false) String keyword,
//							 @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size, Model model
//			, Pageable pageable) throws IOException {
//		pageable = PageRequest.of(page, size);
//
//		Page<User> listUsers;
//		// = userService.getAllUser(page,size);
//		// tìm kiếm
////        if (keyword.isPresent()) {
//		if (keyword != null && !keyword.isEmpty()) {
//			listUsers =  storeService.searchStores(Optional.of(keyword), pageable);
//		} else {
//			listUsers = storeService.findAll(pageable);
//		}
////        Page<User> result = searchUser(Optional.of("john"), PageRequest.of(0, 10));
//
//		Page<User> userPage = storeService.findAll(pageable);
////		long countAllUsers = storeRepository.count();
////		model.addAttribute("totalRecords", countAllUsers);
//		model.addAttribute("store", userPage.getContent());
//		model.addAttribute("page", userPage);
//		model.addAttribute("keyword", keyword);
//		Map<String, Object> modelMap = new HashMap<>();
//		modelMap.put("listUsers", listUsers);
//		return new ModelAndView("user", modelMap);
//	}






	@GetMapping("/add")
	public String showAddStoreForm(Model model) {
		model.addAttribute("store", new Store());
		return "add-store";
	}

	@PostMapping("/save")
	public String saveStore(@ModelAttribute("stores") Store store) {
		System.out.println("Store: " + store.toString());
		storeService.saveStore(store);
		return "redirect:/store";
	}

	@GetMapping("/edit/{id}")
	public String showEditStoreForm(@PathVariable("id") Long id, Model model) {
		Store store = storeService.getStoreById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Store Id:" + id));
		model.addAttribute("store", store);
		return "add-store";
	}

	@PostMapping("/update/{id}")
	public String updateStore(@PathVariable("id") Long id, @ModelAttribute("store") Store store) {
		storeService.updateStore(store);
		return "redirect:/store";
	}

	@GetMapping("/delete/{id}")
	public String deleteStore(@PathVariable("id") Long id) {
		storeService.deleteStore(id);
		return "redirect:/store";
	}
}
