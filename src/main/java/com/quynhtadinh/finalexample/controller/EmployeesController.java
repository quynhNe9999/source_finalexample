package com.quynhtadinh.finalexample.controller;

import com.quynhtadinh.finalexample.entity.Employees;
import com.quynhtadinh.finalexample.repository.EmployeesRepository;
import com.quynhtadinh.finalexample.service.EmployeesService;
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
import java.util.Map;
import java.util.Optional;


@Controller
//@RequestMapping("/employees")
public class EmployeesController {

	@Autowired
	private EmployeesService employeesService;
	@Autowired
	private EmployeesRepository employeesRepository;

	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public ModelAndView home(@RequestParam(required = false, name = "keyword" )String keyword,
							 @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size, Model model
			, Pageable pageable) throws IOException {
		pageable = PageRequest.of(page, size);

		Page<Employees> listEmployees;

		if (keyword != null && !keyword.isEmpty()) {
			listEmployees =  employeesService.searchEmployees(Optional.of(keyword), pageable);
		} else {
			listEmployees = employeesService.findAll(pageable);
		}

		Page<Employees> employees = employeesService.findAll(pageable);
		long countAllUsers = employeesRepository.count();
		model.addAttribute("totalRecords", countAllUsers);
		model.addAttribute("employees", employees.getContent());
		model.addAttribute("page", employees);
		model.addAttribute("keyword", keyword);
		Map<String, Object> modelMap = new HashMap<>();
		modelMap.put("listEmployees", listEmployees);
		return new ModelAndView("employees", modelMap);
	}

	@RequestMapping(value = "/add-employees", method = RequestMethod.GET)
	public String EmployeesAdd(Model model) {
		model.addAttribute("employees", new Employees());

		return "add-employees";
	}

	@RequestMapping(value = "/add-employees", method = RequestMethod.POST)
	public String registrations(@ModelAttribute("employees") Employees employees, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "add-employees";
		}
		employeesService.save(employees);
		return "redirect:/employees";
	}

	@GetMapping("/edit-employees/{id}")
	public String showEditForm(@PathVariable Long id, Model model) {
		Optional<Employees> employees = employeesService.getEmployeesById(id);
		if (employees.isPresent()) {
			model.addAttribute("Employees", employees.get());
			return "edit-employees";
		} else {
			return "redirect:/employees";
		}
	}
	@PostMapping("/edit-employees/{id}")
	public String updateEmployeess(@PathVariable Long id, @ModelAttribute("employees") Employees newEmployees, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("message", "Có lỗi xảy ra khi cập nhật người dùng");
			return "edit-employees"; // Hoặc trang lỗi tương ứng
		}

		try {
			Employees existingEmployees = employeesService.getEmployeesById(id)
					.orElseThrow(() -> new IllegalArgumentException("Người dùng không tồn tại: " + id));
			existingEmployees.setEmployee_id(newEmployees.getEmployee_id());
			existingEmployees.setName(newEmployees.getName());
			existingEmployees.setAddress(newEmployees.getAddress());
			existingEmployees.setEmail(newEmployees.getEmail());
			existingEmployees.setPhone(newEmployees.getPhone());
			existingEmployees.setDateOfBirth(newEmployees.getDateOfBirth());
			existingEmployees.setStore(newEmployees.getStore());
			existingEmployees.setPosition(newEmployees.getPosition());

			employeesService.update(existingEmployees);
			return "redirect:/employees";
		} catch (Exception e) {
			model.addAttribute("message", "Có lỗi xảy ra khi cập nhật người dùng: " + e.getMessage());
			return "edit-employees"; // Hoặc trang lỗi tương ứng
		}
	}

	@GetMapping("/delete-employees/{id}")
	public String deleteEmployees(@PathVariable Long id) {
		employeesService.deleteEmployeesById(id);
		return "redirect:/employees";
	}


}

