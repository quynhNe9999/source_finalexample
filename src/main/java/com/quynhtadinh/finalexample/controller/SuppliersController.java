package com.quynhtadinh.finalexample.controller;

import com.quynhtadinh.finalexample.entity.Suppliers;
import com.quynhtadinh.finalexample.entity.Suppliers;
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
//@RequestMapping("/suppliers")
public class SuppliersController {

    @Autowired
    private SuppliersService suppliersService;


    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/suppliers")
    String showSuppliers(Model map) {
        List<Suppliers> suppliers = suppliersService.getAllActiveSuppliers();
        map.addAttribute("suppliers", suppliers);
        return "suppliers";
    }

    @GetMapping(value = { "/add-suppliers"})
    public String addSuppliers(Model model) {
        model.addAttribute("suppliers", new Suppliers());
        return "add-suppliers";
    }

    @PostMapping(value = { "/saveSuppliers"})
    public String addSuppliersPages(@ModelAttribute("suppliers") Suppliers suppliers) {
        suppliersService.saveSuppliers(suppliers);
        return "redirect:/suppliers";
    }

    @RequestMapping("/edit-suppliers/{id}")
    public ModelAndView showEditSuppliersPage(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit-suppliers");
        Suppliers suppliers = suppliersService.getSuppliersById(id).get();
        mav.addObject("suppliers", suppliers);
        return mav;
    }

    @GetMapping("/delete-suppliers/{id}")
    public String deleteSuppliers(@PathVariable Long id) {
        suppliersService.deleteSuppliers(id);
        return "redirect:/suppliers";
    }

}

