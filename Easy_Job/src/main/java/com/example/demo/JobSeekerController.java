//package com.example.demo;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/job-seekers")
//@CrossOrigin(origins = "http://localhost:3000") // Adjust based on your frontend
//public class JobSeekerController {
//    @Autowired
//    private JobSeekerService jobSeekerService;
//
//    @PostMapping("/register")
//    public ResponseEntity<JobSeeker> register(@RequestBody JobSeeker jobSeeker) {
//        JobSeeker registeredJobSeeker = jobSeekerService.registerJobSeeker(jobSeeker);
//        return ResponseEntity.status(HttpStatus.CREATED).body(registeredJobSeeker); // Return created status
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestParam String email, @RequestParam String password) {
//        JobSeeker jobSeeker = jobSeekerService.login(email, password);
//        if (jobSeeker != null) {
//            return ResponseEntity.ok(jobSeeker); // Successful login
//        }
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials"); // Unauthorized response
//    }
//}

package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/job-seekers")
@CrossOrigin(origins = "http://localhost:3000") // Adjust based on your frontend
public class JobSeekerController {
    
    @Autowired
    private JobSeekerService jobSeekerService;

    @PostMapping("/register")
    public ResponseEntity<JobSeeker> register(@RequestBody JobSeeker jobSeeker) {
        JobSeeker registeredJobSeeker = jobSeekerService.registerJobSeeker(jobSeeker);
        return ResponseEntity.status(HttpStatus.CREATED).body(registeredJobSeeker); // Return created status
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String email, @RequestParam String password) {
        try {
            JobSeeker jobSeeker = jobSeekerService.login(email, password);
            if (jobSeeker != null) {
                return ResponseEntity.ok(jobSeeker); // Successful login
            }
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage()); // Blocked account
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials"); // Unauthorized response
    }
}

