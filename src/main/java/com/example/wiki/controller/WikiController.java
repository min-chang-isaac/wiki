package com.example.wiki.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.wiki.entity.WikiPage;
import com.example.wiki.service.WikiService;

import jakarta.validation.Valid;

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

    @GetMapping("/pages/new")
    public String newPageForm(Model model) {
        model.addAttribute("page", new WikiPage());
        return "new";
    }

    @PostMapping("/pages")
    public String createPage(@Valid WikiPage page, BindingResult result) {
        if(result.hasErrors()) {
        	return "new";
        }
        service.save(page);
        return "redirect:/";
    }
    
    @GetMapping("/pages/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
    	WikiPage page = service.findById(id);
    	model.addAttribute("page", page);
    	return "edit";

    }
    
    @PostMapping("/pages/{id}")
    public String updatePage(@PathVariable Long id, WikiPage page) {
        page.setId(id);
        service.save(page);
        return "redirect:/";
    }
    
    @PostMapping("/pages/{id}/delete")
    public String deletePage(@PathVariable Long id, WikiPage page) {
    	service.deleteById(id);
    	return "redirect:/";
    	
    }
    @GetMapping("/pages/{id}")
    public String detail(@PathVariable Long id, Model model) {
    	WikiPage page = service.findById(id);
    	model.addAttribute("page", page);
    	return "detail";
    	
    }
}
