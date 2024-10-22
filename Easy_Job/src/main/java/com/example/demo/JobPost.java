package com.example.demo;


import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "job_posts")
public class JobPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Long recruiterId;
    private String category; // "IT" or "Non-IT"
    private Date datePosted;

    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getRecruiterId() {
		return recruiterId;
	}
	public void setRecruiterId(Long recruiterId) {
		this.recruiterId = recruiterId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Date getDatePosted() {
		return datePosted;
	}
	public void setDatePosted(Date datePosted) {
		this.datePosted = datePosted;
	}

    // Getters and setters
}

