package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @PostMapping("/apply")
    public Application applyForJob(@RequestParam("jobId") Long jobId,
                                   @RequestParam("name") String name,
                                   @RequestParam("email") String email,
                                   @RequestParam("phone") String phone,
                                   @RequestParam("cv") MultipartFile cv) {
        Application application = new Application();
        application.setJobId(jobId);
        application.setName(name);
        application.setEmail(email);
        application.setPhone(phone);

        return applicationService.applyForJob(application, cv);
    }

    @GetMapping("/applications/{jobId}")
    public List<Application> getApplications(@PathVariable Long jobId) {
        return applicationService.getApplicationsForJob(jobId);
    }
}
