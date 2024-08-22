package com.quynhtadinh.finalexample.controller;

import com.quynhtadinh.finalexample.entity.Suppliers;
import com.quynhtadinh.finalexample.service.SuppliersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/suppliers")
public class SuppliersController {

    @Autowired
    private SuppliersService suppliersService;


    @GetMapping
    public String listProducts(@RequestParam(name = "keyword", required = false) String keyword,
                               @RequestParam(name = "page", defaultValue = "0") int page,
                               Model model) {
        Page<Suppliers> SuppliersPage = suppliersService.searchSuppliers(keyword, page, 10);
        model.addAttribute("listSuppliers", SuppliersPage);
        return "suppliers";
    }

    @GetMapping("/add")
    public String showAddSuppliersForm(Model model) {
        model.addAttribute("suppliers", new Suppliers());
        return "add_suppliers";
    }

    @PostMapping("/save")
    public String saveSuppliers(@ModelAttribute("Suppliers") Suppliers suppliers) {
        suppliersService.saveSuppliers(suppliers);
        return "redirect:/suppliers";
    }

    @GetMapping("/edit/{id}")
    public String showEditSuppliersForm(@PathVariable("id") Long id, Model model) {
        Suppliers suppliers = suppliersService.getSuppliersById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Suppliers Id:" + id));
        model.addAttribute("suppliers", suppliers);
        return "edit-suppliers";
    }

    @PostMapping("/update/{id}")
    public String updateSuppliers(@PathVariable("id") Long id, @ModelAttribute("suppliers") Suppliers suppliers) {
        suppliersService.updateSuppliers(suppliers);
        return "redirect:/suppliers";
    }

    @GetMapping("/delete/{id}")
    public String deleteSuppliers(@PathVariable("id") Long id) {
        suppliersService.deleteSuppliers(id);
        return "redirect:/suppliers";
    }

}

