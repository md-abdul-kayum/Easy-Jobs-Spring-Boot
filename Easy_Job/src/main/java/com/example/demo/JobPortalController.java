package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JobPortalController {

    @GetMapping("/")
    public String landingPage() {
        return "index"; // maps to src/main/resources/templates/index.html
    }

    @GetMapping("/job_seeker/login")
    public String jobSeekerLogin() {
        return "job_seeker_login"; // maps to src/main/resources/templates/job_seeker_login.html
    }

    @GetMapping("/job_seeker/register")
    public String jobSeekerRegister() {
        return "job_seeker_register"; // maps to src/main/resources/templates/job_seeker_register.html
    }

    @GetMapping("/job_seeker/dashboard")
    public String jobSeekerDashboard() {
        return "job_seeker_dashboard"; // maps to src/main/resources/templates/job_seeker_dashboard.html
    }

    @GetMapping("/recruiter/login")
    public String recruiterLogin() {
        return "recruiter_login"; // maps to src/main/resources/templates/recruiter_login.html
    }

    @GetMapping("/recruiter/register")
    public String recruiterRegister() {
        return "recruiter_register"; // maps to src/main/resources/templates/recruiter_register.html
    }

    @GetMapping("/recruiter/dashboard")
    public String recruiterDashboard() {
        return "recruiter_dashboard"; // maps to src/main/resources/templates/recruiter_dashboard.html
    }
}
