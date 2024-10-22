package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RecruiterRepository extends JpaRepository<Recruiter, Long> {
    Recruiter findByEmail(String email); // Method to find recruiter by email
}

