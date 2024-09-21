package com.quynhtadinh.finalexample.controller;

import com.quynhtadinh.finalexample.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


@Controller
public class MainController {
	@GetMapping("/405")
	public String Get405 () {
		return "error_405";
	}

//	@Autowired
//	private StorageService storageService;
//	@GetMapping("/uploadImage")
//	public String uploadImage(@RequestParam("file") MultipartFile file, Model model) {
//
//	}
//
}
