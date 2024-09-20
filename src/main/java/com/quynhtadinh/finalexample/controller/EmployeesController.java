package com.quynhtadinh.finalexample.controller;

import com.quynhtadinh.finalexample.entity.Employees;
import com.quynhtadinh.finalexample.entity.Role;
import com.quynhtadinh.finalexample.entity.Store;
import com.quynhtadinh.finalexample.entity.User;
import com.quynhtadinh.finalexample.repository.EmployeesRepository;
import com.quynhtadinh.finalexample.repository.RoleRepository;
import com.quynhtadinh.finalexample.repository.StoreRepository;
import com.quynhtadinh.finalexample.repository.UserRepository;
import com.quynhtadinh.finalexample.service.EmployeesService;
import com.quynhtadinh.finalexample.service.RoleService;
import com.quynhtadinh.finalexample.service.StoreService;
import com.quynhtadinh.finalexample.service.UserService;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Controller
//@RequestMapping("/employees")
public class EmployeesController {

	@Autowired
	private EmployeesService employeesService;
	@Autowired
	private StoreService storeService;
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private StoreRepository storeRepository;
	@Autowired
	private RoleRepository roleRepository;


	@Autowired
	private EmployeesRepository employeesRepository;


	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/employees")
	String showEmployees(Model map) {
		List<Employees> employees = employeesService.getAllActiveEmployees();
		map.addAttribute("employees", employees);
		return "employees";
	}

	@GetMapping(value = { "/add-employees"})
	public String addEmployees(Model model) {
		model.addAttribute("employees", new Employees());
		List<Store> stores = storeService.getAllActiveStore();
		model.addAttribute("stores", stores);
		List<User> users =userService.getAllActiveUsers();
		model.addAttribute("users", users);
		List<Role> roles =roleService.getAllActiveRole();
		model.addAttribute("roles", roles);
		return "add-employees";
	}

	@PostMapping(value = { "/saveEmployees"})
	public String addEmployeesPages(@ModelAttribute("employees") Employees employees) {
		employeesService.saveEmployees(employees);
		Role role = roleRepository.findById(employees.getRole().getId()).orElseThrow(() -> new RuntimeException("Role not found"));
		Store store = storeRepository.findById(employees.getStore().getId()).orElseThrow(() -> new RuntimeException("Store not found"));
		User user = userRepository.findById(employees.getUser().getId()).orElseThrow(() -> new RuntimeException("User not found"));

		employees.setRole(role);
		employees.setStore(store);
		employees.setUser(user);
		return "redirect:/employees";
	}

	@RequestMapping("/edit-employees/{id}")
	public ModelAndView showEditEmployeesPage(@PathVariable(name = "id") Long id, Model model) {
		ModelAndView mav = new ModelAndView("edit-employees");
		Employees employees = employeesService.getEmployeesById(id).get();
		model.addAttribute("employees", new Employees());
		List<Store> stores = storeService.getAllActiveStore();
		model.addAttribute("stores", stores);
		List<User> users =userService.getAllActiveUsers();
		model.addAttribute("users", users);
		List<Role> roles =roleService.getAllActiveRole();
		model.addAttribute("roles", roles);
		mav.addObject("employees", employees);
		return mav;
	}

	@GetMapping("/delete-employees/{id}")
	public String deleteEmployees(@PathVariable Long id) {
		employeesService.deleteEmployees(id);
		return "redirect:/employees";
	}


}

