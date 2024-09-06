package com.quynhtadinh.finalexample.controller;

import com.quynhtadinh.finalexample.entity.Category;

import com.quynhtadinh.finalexample.entity.Suppliers;
import com.quynhtadinh.finalexample.service.CategoryService;
import com.quynhtadinh.finalexample.service.SuppliersService;
import net.bytebuddy.asm.Advice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.*;

import static java.lang.Integer.parseInt;

//
//@Controller
//public class CategoryController {
//
//	@Autowired
//	private CategoryService categoryService;
//	@Autowired
//	private SuppliersService suppliersService;
//    @Autowired
//    private CategoryRepository categoryRepository;
//
//
//	@RequestMapping(value = "/category", method = RequestMethod.GET)
//	public ModelAndView home(@RequestParam(required = false, name = "keyword" )String keyword,
//							 @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size, Model model
//			, Pageable pageable) throws IOException {
//		pageable = PageRequest.of(page, size);
//
//		Page<Category> listCategories;
//
//		if (keyword != null && !keyword.isEmpty()) {
//			listCategories =  categoryService.searchCategories(Optional.of(keyword), pageable);
//		} else {
//			listCategories = categoryService.findAll(pageable);
//		}
//
//		Page<Category> categories = categoryService.findAll(pageable);
//		long countAllUsers = categoryRepository.count();
//		model.addAttribute("totalRecords", countAllUsers);
//		model.addAttribute("category", categories.getContent());
//		model.addAttribute("page", categories);
//		model.addAttribute("keyword", keyword);
//		Map<String, Object> modelMap = new HashMap<>();
//		modelMap.put("listCategories", listCategories);
//		return new ModelAndView("category", modelMap);
//	}
//
//	@GetMapping("/add-category")
//	public String showAddCategoryForm(Model model) {
//		Category category = new Category();
//		Page<Suppliers> suppliers = suppliersService.findAll(Pageable.unpaged());
//		model.addAttribute("category", category);
//		model.addAttribute("suppliers", suppliers);
//		return "add-category";
//	}
//
//	@PostMapping("/add-category")
//	public String addCategory(@Valid @ModelAttribute("category") Category category,
//							  BindingResult bindingResult, Model model) {
//		if (bindingResult.hasErrors()) {
//			Page<Suppliers> suppliers = suppliersService.findAll(Pageable.unpaged());
//			model.addAttribute("suppliers", suppliers);
//			return "add-category";
//		}
//
//		categoryService.saveCategory(category);
//		return "redirect:/category";
//	}
////	@RequestMapping(value = "/add-category", method = RequestMethod.GET)
////	public String categoryAdd(Model model,Pageable pageable) {
////		model.addAttribute("category", new Category());
////	    model.addAttribute("suppliers", suppliersService.findAll(pageable)); // Lấy danh sách tất cả các suppliers
////
////		return "add-category";
////	}
////
////	@RequestMapping(value = "/add-category", method = RequestMethod.POST)
////	public String registrations(@ModelAttribute("category") Category category, BindingResult bindingResult, Model model) {
////
////		if (bindingResult.hasErrors()) {
////			return "add-category";
////		}
////		categoryService.save(category);
////		return "redirect:/category";
////	}
//
//	@GetMapping("/edit-category/{id}")
//	public String showEditForm(@PathVariable Long id, Model model) {
//		Optional<Category> category = categoryService.getCategoryById(id);
//		if (category.isPresent()) {
//			model.addAttribute("category", category.get());
//			return "edit-category";
//		} else {
//			return "redirect:/category";
//		}
//	}
//	@PostMapping("/edit-category/{id}")
//	public String updateCategorys(@PathVariable Long id, @ModelAttribute("category") Category newCategory, BindingResult result, Model model) {
//		if (result.hasErrors()) {
//			model.addAttribute("message", "Có lỗi xảy ra khi cập nhật người dùng");
//			return "edit-category"; // Hoặc trang lỗi tương ứng
//		}
//
//		try {
//			Category existingCategory = categoryService.getCategoryById(id)
//					.orElseThrow(() -> new IllegalArgumentException("Người dùng không tồn tại: " + id));
//
//			existingCategory.setName(newCategory.getName());
//			existingCategory.setDescription(newCategory.getDescription());
//			existingCategory.setPrice(newCategory.getPrice());
//			existingCategory.setStock(newCategory.getStock());
//			existingCategory.setImage(newCategory.getImage());
//			existingCategory.setSupplier(newCategory.getSupplier());
//
//			categoryService.update(existingCategory);
//			return "redirect:/category";
//		} catch (Exception e) {
//			model.addAttribute("message", "Có lỗi xảy ra khi cập nhật người dùng: " + e.getMessage());
//			return "edit-category"; // Hoặc trang lỗi tương ứng
//		}
//	}
//
//	@GetMapping("/delete-category/{id}")
//	public String deleteCategory(@PathVariable Long id) {
//		categoryService.deleteCategoryById(id);
//		return "redirect:/category";
//	}
//}

@SuppressWarnings("UastIncorrectMimeTypeInspection")
@Controller
public class CategoryController {

	@Value("${uploadDir}")
	private String uploadFolder;

	@Autowired
	private CategoryService categoryService;

	private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SuppliersService suppliersService;

//	@GetMapping(value = {"/add-category"})
//	public String addProductPage(Model map) {
//
//		map.addAttribute("suppliers", suppliersService.getAllActiveSuppliers());
//
//		return "add-category";
//	}

	@GetMapping("/add-category")
	public String showAddCategoryForm(Model model) {
		model.addAttribute("category", new Category());
		model.addAttribute("suppliers", suppliersService.getAllActiveSuppliers());
		return "add-category";  // Tên template Thymeleaf
	}
	@PostMapping(value = { "/add-category"})
	public String addCategoryPages(@ModelAttribute("category") Category category) {
		categoryService.saveCategory(category);
		return "redirect:/category";
	}

	@PostMapping("/category/saveCategoryDetails")
	public @ResponseBody ResponseEntity<?> createProduct(@RequestParam("name") String name,
			@RequestParam("price") double price, @RequestParam("description") String description,
			@RequestParam("stock") Integer stock, @RequestParam("suppliers") Suppliers suppliers,
			Model model, HttpServletRequest request, final @RequestParam("image") MultipartFile file) {
		try {
			//String uploadDirectory = System.getProperty("user.dir") + uploadFolder;
			String uploadDirectory = request.getServletContext().getRealPath(uploadFolder);
			log.info("uploadDirectory:: " + uploadDirectory);
			String fileName = file.getOriginalFilename();
			String filePath = Paths.get(uploadDirectory, fileName).toString();
			log.info("FileName: " + file.getOriginalFilename());
			if (fileName == null || fileName.contains("..")) {
				model.addAttribute("invalid", "Sorry! Filename contains invalid path sequence \" + fileName");
				return new ResponseEntity<>("Sorry! Filename contains invalid path sequence " + fileName, HttpStatus.BAD_REQUEST);
			}
			String[] names = name.split(",");
			String[] descriptions = description.split(",");
			Date createDate = new Date();
			log.info("Name: " + names[0]+" "+filePath);
			log.info("description: " + descriptions[0]);
			log.info("price: " + price);
			log.info("stock: " + stock);
			log.info("suppliers: " + suppliers);
			log.info("createDate: " + createDate);
			try {
				File dir = new File(uploadDirectory);
				if (!dir.exists()) {
					log.info("Folder Created");
					dir.mkdirs();
				}
				// Save the file locally
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
				stream.write(file.getBytes());
				stream.close();
			} catch (Exception e) {
				log.info("in catch");
				e.printStackTrace();
			}
			byte[] image = file.getBytes();
			Category category = new Category();
			category.setName(names[0]);
			category.setImage(image);
			category.setPrice(price);
			category.setDescription(descriptions[0]);
			category.setStock(stock);
			category.setCreateDate(createDate);
			suppliers.setName(name);
			suppliersService.getAllActiveSuppliers();

			categoryService.saveCategory(category);

			log.info("HttpStatus===" + new ResponseEntity<>(HttpStatus.OK));
			return new ResponseEntity<>("Category Saved With File - " + fileName, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception: " + e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/category/display/{id}")
	@ResponseBody
	void showImage(@PathVariable("id") Long id, HttpServletResponse response, Optional<Category> category)
			throws ServletException, IOException {
		log.info("Id :: " + id);
		category = categoryService.getCategoryById(id);
		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
		response.getOutputStream().write(category.get().getImage());
		response.getOutputStream().close();
	}

	@GetMapping("/category/imageDetails")
	String showProductDetails(@RequestParam("id") Long id, Optional<Category> category, Model model) {
		try {
			log.info("Id :: " + id);
			if (id != 0) {
				category = categoryService.getCategoryById(id);

				log.info("products :: " + category);
				if (category.isPresent()) {
					model.addAttribute("id", category.get().getId());
					model.addAttribute("description", category.get().getDescription());
					model.addAttribute("name", category.get().getName());
					model.addAttribute("price", category.get().getPrice());
					return "imagedetails";
				}
				return "redirect:/category";
			}
			return "redirect:/category";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/category";
		}
	}

	@GetMapping("/category")
	String show(Model map) {
		List<Category> categoryList = categoryService.getAllActiveCategory();
		map.addAttribute("category", categoryList);
		return "category";
	}
}
