package com.example.wiki.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.wiki.service.WikiService;

@Controller
public class WikiController {

	private final WikiService service;
	
	public WikiController(WikiService service) {
		this.service = service;
	}
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("pages", service.findAll());
		return "index";
		
	}
}
