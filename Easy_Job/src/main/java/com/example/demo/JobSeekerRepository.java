package com.example.demo;

//import com.example.demo.model.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSeekerRepository extends JpaRepository<JobSeeker, Long> {
    JobSeeker findByEmail(String email); // Method to find job seeker by email
}

