package com.quynhtadinh.finalexample.controller;

import com.quynhtadinh.finalexample.entity.Category;
import com.quynhtadinh.finalexample.entity.Import;
import com.quynhtadinh.finalexample.entity.Product;
import com.quynhtadinh.finalexample.entity.Suppliers;
import com.quynhtadinh.finalexample.service.CategoryService;
import com.quynhtadinh.finalexample.service.ImportService;
import com.quynhtadinh.finalexample.service.ProductService;
import com.quynhtadinh.finalexample.service.SuppliersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class ImportController {

	@Autowired
	private ImportService importService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;
    @Autowired
    private SuppliersService suppliersService;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/imports")
    String showImport(Model map) {
        List<Import> imports = importService.getAllActiveImport();
        map.addAttribute("imports", imports);
        return "imports";
    }

    @GetMapping(value = { "/add-imports"})
    public String addImport(Model model) {
        model.addAttribute("imports", new Import());
        List<Suppliers> suppliers = suppliersService.getAllActiveSuppliers();
        model.addAttribute("suppliers", suppliers);
        List<Product> products = productService.getAllActiveProduct();
        model.addAttribute("product", products);
        return "add-imports";
    }

    @PostMapping(value = { "/saveImports"})
    public String addImportPages(@ModelAttribute("imports") Import imports) {
        importService.saveImport(imports);
        return "redirect:/imports";
    }

    @RequestMapping("/edit-imports/{id}")
    public ModelAndView showEditImportPage(@PathVariable(name = "id") Long id, Model model) {
        ModelAndView mav = new ModelAndView("edit-imports");
        Import imports = importService.getImportById(id).get();
        List<Suppliers> suppliers = suppliersService.getAllActiveSuppliers();
        model.addAttribute("suppliers", suppliers);
        List<Product> products = productService.getAllActiveProduct();
        model.addAttribute("product", products);
        mav.addObject("imports", imports);
        return mav;
    }

    @GetMapping("/delete-imports/{id}")
    public String deleteImport(@PathVariable Long id) {
        importService.deleteImport(id);
        return "redirect:/imports";
    }
}
