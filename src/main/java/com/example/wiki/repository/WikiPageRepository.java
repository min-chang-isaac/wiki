package com.example.wiki.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;

import com.example.wiki.entity.WikiPage;

public interface WikiPageRepository extends JpaRepository<WikiPage, Long>{

}
