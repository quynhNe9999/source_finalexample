package com.quynhtadinh.finalexample.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.*;

import com.quynhtadinh.finalexample.entity.Role;
import com.quynhtadinh.finalexample.repository.RoleRepository;
import com.quynhtadinh.finalexample.repository.UserRepository;
import com.quynhtadinh.finalexample.util.RoleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.quynhtadinh.finalexample.entity.User;
import com.quynhtadinh.finalexample.security.SecurityService;
import com.quynhtadinh.finalexample.service.UserService;
import com.quynhtadinh.finalexample.validator.UserValidator;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserRepository userRepository;

    public UserController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Tên người dùng và mật khẩu của bạn không hợp lệ.");

        if (logout != null)
            model.addAttribute("message", "Bạn đã đăng xuất thành công.");

        return "login";
    }

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String welcome(Model model , Principal principal) {
        model.addAttribute("username", securityService.findLoggedInUsername());
        UserDetails loginedUser = (UserDetails) ((Authentication) principal).getPrincipal();

        return "index";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
	public ModelAndView home(@RequestParam(required = false, name = "keyword" )String keyword,
//                             @RequestParam(name = "keyword") Optional<String> keyword,
//                             @RequestParam(required = false) String keyword,
                             @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size, Model model
			, Pageable pageable) throws IOException {
        pageable = PageRequest.of(page, size);

        Page<User> listUsers;
        // = userService.getAllUser(page,size);
        // tìm kiếm
//        if (keyword.isPresent()) {
            if (keyword != null && !keyword.isEmpty()) {
                listUsers =  userService.searchUser(Optional.of(keyword), pageable);
        } else {
            listUsers = userService.findAll(pageable);
        }
//        Page<User> result = searchUser(Optional.of("john"), PageRequest.of(0, 10));

        Page<User> userPage = userService.findAll(pageable);
        long countAllUsers = userRepository.count();
        model.addAttribute("totalRecords", countAllUsers);
        model.addAttribute("users", userPage.getContent());
        model.addAttribute("page", userPage);
        model.addAttribute("keyword", keyword);
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("listUsers", listUsers);
        return new ModelAndView("user", modelMap);
		}

    @RequestMapping(value = "/add-user", method = RequestMethod.GET)
    public String ssssss(Model model) {
        model.addAttribute("user", new User());

        return "add-user";
    }

    @RequestMapping(value = "/add-user", method = RequestMethod.POST)
    public String registrations(@ModelAttribute("user") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "add-user";
        }
        userService.save(userForm);
        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());
        return "redirect:/user";
    }

    @GetMapping("/edit-user/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<User> user = userService.getUserById(id);
        if (user.isPresent()) {
            model.addAttribute("user", user.get());
            return "edit-user";
        } else {
            return "redirect:/user";
        }
    }
    @PostMapping("/edit-user/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute("user") User newUser, @RequestParam("roleId") Long roleId, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("message", "Có lỗi xảy ra khi cập nhật người dùng");
            return "user-form"; // Hoặc trang lỗi tương ứng
        }

        try {
            Role selectedRole = roleRepository.findById(roleId)
                    .orElseThrow(() -> new IllegalArgumentException("Quyền không hợp lệ: " + roleId));

            User existingUser = userService.getUserById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Người dùng không tồn tại: " + id));

            existingUser.setUsername(newUser.getUsername());
            existingUser.setEmail(newUser.getEmail());
            existingUser.setDateTao(newUser.getDateTao());
            existingUser.setEmployee(newUser.getEmployee());

            if (newUser.getPassword() != null && !newUser.getPassword().isEmpty()) {
                existingUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
            }

            existingUser.setRoles(Collections.singleton(selectedRole));
            existingUser.setStatus(newUser.getStatus());

            userService.updateUser(existingUser);
            return "redirect:/user";
        } catch (Exception e) {
            model.addAttribute("message", "Có lỗi xảy ra khi cập nhật người dùng: " + e.getMessage());
            return "user-form"; // Hoặc trang lỗi tương ứng
        }
    }


//    @PostMapping("/edit-user/{id}")
//    public String updateUser(@PathVariable Long id, @ModelAttribute("user") User newUser, @RequestParam Long roleId) {
//        Role selectedRole = roleRepository.findById(roleId)
//                .orElseThrow(() -> new IllegalArgumentException("Quyền không hợp lệ: " + roleId));
//
//        // Gán quyền duy nhất cho người dùng
//        newUser.setRoles(Collections.singleton(selectedRole));
//
//        User existingUser = userService.getUserById(id).orElseThrow(() -> new IllegalArgumentException("User không tồn tại: " + id));
//
//        // Cập nhật thông tin người dùng
//        existingUser.setUsername(newUser.getUsername());
//        existingUser.setEmail(newUser.getEmail());
//        existingUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
//        existingUser.setRoles(newUser.getRoles());
//        existingUser.setStatus(newUser.getStatus());
//
//        userService.updateUser(id, existingUser);
//        return "redirect:/user";
//    }


    @GetMapping("/delete-user/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return "redirect:/user";
    }

}

