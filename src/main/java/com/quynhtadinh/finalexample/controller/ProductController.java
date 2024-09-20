package com.quynhtadinh.finalexample.controller;

import com.quynhtadinh.finalexample.entity.Category;
import com.quynhtadinh.finalexample.entity.Product;
import com.quynhtadinh.finalexample.entity.Store;
import com.quynhtadinh.finalexample.entity.Suppliers;
import com.quynhtadinh.finalexample.repository.CategoryRepository;
import com.quynhtadinh.finalexample.repository.SuppliersRepository;
import com.quynhtadinh.finalexample.service.CategoryService;
import com.quynhtadinh.finalexample.service.ProductService;
import com.quynhtadinh.finalexample.service.StoreService;
import com.quynhtadinh.finalexample.service.SuppliersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
//@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private SuppliersService suppliersService;

    @Autowired
    private SuppliersRepository suppliersRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/products")
    String showStore(Model map) {
        List<Product> products = productService.getAllActiveProduct();
        map.addAttribute("products", products);
        return "products";
    }

    @GetMapping(value = { "/add-products"})
    public String addProduct(Model model) {
        model.addAttribute("products", new Product());
        List<Suppliers> suppliers = suppliersService.getAllActiveSuppliers();
        model.addAttribute("suppliers", suppliers);
        List<Category> categories = categoryService.getAllActiveCategory();
        model.addAttribute("categories", categories);
        return "add-products";
    }

    @PostMapping(value = { "/saveProducts"})
    public String addProductPages(@ModelAttribute("products") Product products) {
        // Gọi service để lưu product
        productService.saveProduct(products);

        // Tìm supplier và category theo ID
        Suppliers suppliers = suppliersRepository.findById(products.getSupplier().getId())
                .orElseThrow(() -> new RuntimeException("Suppliers not found"));
        Category category = categoryRepository.findById(products.getCategory().getId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        // Sử dụng setter để gán supplier và category cho product
        products.setSupplier(suppliers);
        products.setCategory(category);

        // Lưu lại product với các thông tin đã được gán
        productService.saveProduct(products);  // Nếu cần lưu lại sau khi gán

        return "redirect:/products";
    }


    @RequestMapping("/edit-products/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") Long id, Model model) {
        ModelAndView mav = new ModelAndView("edit-products");
        Product products = productService.getProductById(id).get();
        List<Suppliers> suppliers = suppliersService.getAllActiveSuppliers();
        model.addAttribute("suppliers", suppliers);
        List<Category> categories = categoryService.getAllActiveCategory();
        model.addAttribute("categories", categories);
        mav.addObject("products", products);
        return mav;
    }

    @GetMapping("/delete-products/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }
}
