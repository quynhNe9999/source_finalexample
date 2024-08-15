package com.quynhtadinh.finalexample.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

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
//
//    @RequestMapping(value = "/user", method = RequestMethod.GET)
//    public String UserList(Model model) {
//        model.addAttribute("userForm", new User());
//
//        return "user";
//    }
//    @RequestMapping(value = "/user", method = RequestMethod.GET)
//	public ModelAndView home(@RequestParam(name = "keyword") Optional<String> keyword,
//			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size, Model model
//			,Pageable pageable) throws IOException {
//
//			 pageable = PageRequest.of(page, size);
//			Page<User> listUsers;
//			// = userService.getAllUser(page,size);
//			// tìm kiếm
//			if (keyword.isPresent()) {
//				listUsers =  userService.searchSinhVien(keyword, pageable);
//
//				// listUsers = userService.findAllByFirstNameContaining(firstName.get(),
//				// pageable);
//			} else {
//				listUsers = userService.findAll(pageable);
//			}
//			Map<String, Object> modelMap = new HashMap<>();
//			modelMap.put("users", listUsers);
//			return new ModelAndView("user", modelMap);
//		}
	
    @GetMapping("/user")
    public String home(Model model){
        List<User> listUsers = userService.findAll();
//        System.out.println(users);
        model.addAttribute("listUsers",listUsers);
        return "user"; // return file 
    }
//    @GetMapping("/{id}")
//    public String getUserById(@PathVariable Long id, Model model) {
//        Optional<User> user = userService.getUserById(id);
//        if (user.isPresent()) {
//            model.addAttribute("user", user.get());
//            return "users/detail";
//        } else {
//            return "redirect:/user";
//        }
//    }

    // Hiển thị form thêm người dùng
    @GetMapping("/add-user")
    public String showAddUserForm(Model model) {
        // Tạo một đối tượng User trống và truyền vào model để binding với form
        model.addAttribute("user", new User());
        return "add-user"; // Tên của template Thymeleaf (ví dụ add-user.html)
    }

    @PostMapping("/add-user")
    public String addUser(@ModelAttribute("user") User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-user";
        }

        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            result.rejectValue("password", "error.user", "Password cannot be null or empty");
            return "add-user";
        }

        if (!user.getPassword().equals(user.getPasswordConfirm())) {
            result.rejectValue("passwordConfirm", "error.user", "Passwords do not match");
            return "add-user";
        }

        userService.save(user);
        return "redirect:/users";
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
    public String updateUser(@PathVariable Long id, @ModelAttribute("user") User newUser) {
        userService.updateUser(id, newUser);
        return "redirect:/user";
    }

    @GetMapping("/delete-user/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return "redirect:/user";
    }
    
//    //them sv
//    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
//    public String  viewAddUser()
//    {
//        return "addUser";
//    }
//
//    @RequestMapping(value = "/insertUser", method = RequestMethod.POST)
//    public String insertUser(@ModelAttribute("insertUser") User user){
//    	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//	    String encodedPassword = passwordEncoder.encode(user.getPassword());
//	    user.setPassword(encodedPassword);
//        userService.insert(user);
//        return "redirect:/user";
//    }
//
//    //update sv
////    @PostMapping("/editUser/updateUser")
//    @RequestMapping(value = "/editUser/updateUser", method = RequestMethod.POST)
//
//    public String updateUser( @ModelAttribute("user") User user){
//        userService.update( user);
//        return "redirect:/user";
//    }
////    @GetMapping("/editUser/{id}")
//    @RequestMapping(value = "/editUser/{id}", method = RequestMethod.GET)
//    public String  viewUpdateUser(@PathVariable("id") Long id,User user, Model model)
//    {
//
//        model.addAttribute("user", userService.findById(id));
//        return "updateUser";
//
//    }
//
//    //xoa sv
////    @GetMapping("/deleteUser/{id}")
//    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET)
//    public String deleteUser(@PathVariable("id") Long id){
//        userService.delete(id);
//        return "redirect:/user";
//    }
    
}
    
