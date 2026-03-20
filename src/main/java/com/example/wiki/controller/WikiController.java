package com.example.wiki.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.wiki.entity.WikiPage;
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

    @GetMapping("/pages/new")
    public String newPageForm(Model model) {
        model.addAttribute("page", new WikiPage());
        return "new";
    }

    @PostMapping("/pages")
    public String createPage(WikiPage page) {
        service.save(page);
        return "redirect:/";
    }
}
