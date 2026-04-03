package com.example.wiki.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.wiki.entity.WikiPage;
import com.example.wiki.repository.WikiPageRepository;

@Service
public class WikiService {

    private final WikiPageRepository repo;

    public WikiService(WikiPageRepository repo) {
        this.repo = repo;
    }

    public List<WikiPage> findAll() {
        return repo.findAll();
    }

    public WikiPage save(WikiPage page) {
        return repo.save(page);
    }
    
    public WikiPage findById(Long id) {
    	return repo.findById(id).orElseThrow();
    }
    
    public void deleteById(Long id) {
    	repo.deleteById(id);
    }
    
    
    
}