//package com.example.demo;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/recruiters")
//@CrossOrigin(origins = "http://localhost:3000") // Adjust based on your frontend
//public class RecruiterController {
//    @Autowired
//    private RecruiterService recruiterService;
//
//    @PostMapping("/register")
//    public ResponseEntity<Recruiter> register(@RequestBody Recruiter recruiter) {
//        Recruiter registeredRecruiter = recruiterService.registerRecruiter(recruiter);
//        return ResponseEntity.status(HttpStatus.CREATED).body(registeredRecruiter); // Return created status
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestParam String email, @RequestParam String password) {
//        Recruiter recruiter = recruiterService.login(email, password);
//        if (recruiter != null) {
//            return ResponseEntity.ok(recruiter); // Successful login
//        }
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials"); // Unauthorized response
//    }
//    @Autowired
//    private ApplicationService applicationService;
//
//    @GetMapping("/job/{jobId}/applications")
//    public List<Application> getApplicationsForJob(@PathVariable Long jobId) {
//        return applicationService.getApplicationsForJob(jobId); // Return applications for the specified job
//    }
//}
//
package com.example.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recruiters")
@CrossOrigin(origins = "http://localhost:3000") // Adjust based on your frontend
public class RecruiterController {
    
    @Autowired
    private RecruiterService recruiterService;

    @Autowired
    private ApplicationService applicationService;

    @PostMapping("/register")
    public ResponseEntity<Recruiter> register(@RequestBody Recruiter recruiter) {
        Recruiter registeredRecruiter = recruiterService.registerRecruiter(recruiter);
        return ResponseEntity.status(HttpStatus.CREATED).body(registeredRecruiter); // Return created status
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String email, @RequestParam String password) {
        try {
            Recruiter recruiter = recruiterService.login(email, password);
            if (recruiter != null) {
                return ResponseEntity.ok(recruiter); // Successful login
            }
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage()); // Blocked account
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials"); // Unauthorized response
    }

    @GetMapping("/job/{jobId}/applications")
    public List<Application> getApplicationsForJob(@PathVariable Long jobId) {
        return applicationService.getApplicationsForJob(jobId); // Return applications for the specified job
    }
}

