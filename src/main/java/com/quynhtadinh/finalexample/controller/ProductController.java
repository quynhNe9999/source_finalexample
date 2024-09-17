package com.quynhtadinh.finalexample.controller;

import com.quynhtadinh.finalexample.entity.Product;
import com.quynhtadinh.finalexample.entity.Store;
import com.quynhtadinh.finalexample.service.ProductService;
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
        return "add-products";
    }

    @PostMapping(value = { "/saveProducts"})
    public String addProductPages(@ModelAttribute("products") Product products) {
        productService.saveProduct(products);
        return "redirect:/products";
    }

    @RequestMapping("/edit-products/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit-products");
        Product products = productService.getProductById(id).get();
        mav.addObject("products", products);
        return mav;
    }

    @GetMapping("/delete-products/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }
}
