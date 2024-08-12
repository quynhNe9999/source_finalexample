package com.quynhtadinh.finalexample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class SuppliersController {
@GetMapping("/suppliers")
public String getStringSuppliers() {
    return "suppliers";
}

}
