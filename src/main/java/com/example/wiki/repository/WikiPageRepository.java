package com.example.wiki.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.wiki.entity.WikiPage;

public interface WikiPageRepository extends JpaRepository<WikiPage, Long> {
}