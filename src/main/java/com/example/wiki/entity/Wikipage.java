package com.example.wiki.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Wikipage {

	@Id
	@GeneratedValue
	private Long id;
	
	private String title;
	
	@Lob
	private String content;
	
}
