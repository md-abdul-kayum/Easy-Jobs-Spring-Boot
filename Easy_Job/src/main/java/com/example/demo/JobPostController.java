package com.example.demo;

//import com.example.demo.model.Application; // Adjust the import based on your package structure
//import com.example.demo.model.JobPost; // Adjust the import based on your package structure
//import com.example.demo.service.ApplicationService; // Adjust the import based on your package structure
//import com.example.demo.service.JobPostService; // Adjust the import based on your package structure
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/job-posts")
public class JobPostController {
    
    @Autowired
    private JobPostService jobPostService;

    @Autowired
    private ApplicationService applicationService; // Add this line to inject ApplicationService

    @PostMapping("/post")
    public JobPost postJob(@RequestBody JobPost jobPost) {
        return jobPostService.postJob(jobPost);
    }

    @GetMapping("/")
    public List<JobPost> getAllJobs() {
        return jobPostService.getAllJobs();
    }

    @GetMapping("/{jobPostId}/applicants")
    public List<Application> getApplicantsForJobPost(@PathVariable Long jobPostId) {
        return applicationService.getApplicationsForJob(jobPostId); // Update to call the correct method
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJobPost(@PathVariable Long id) {
        jobPostService.deleteJobPost(id);
        return ResponseEntity.noContent().build();
    }
}
