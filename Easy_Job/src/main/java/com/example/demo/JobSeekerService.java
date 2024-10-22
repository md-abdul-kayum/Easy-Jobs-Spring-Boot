//package com.example.demo;
//
////import com.example.demo.model.JobSeeker;
////import com.example.demo.repository.JobSeekerRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class JobSeekerService {
//
//    @Autowired
//    private JobSeekerRepository jobSeekerRepository;
//
//    public JobSeeker registerJobSeeker(JobSeeker jobSeeker) {
//        // Validate and save the job seeker
//        return jobSeekerRepository.save(jobSeeker);
//    }
//
//    public JobSeeker login(String email, String password) {
//        JobSeeker jobSeeker = jobSeekerRepository.findByEmail(email);
//        if (jobSeeker != null && jobSeeker.getPassword().equals(password)) {
//            return jobSeeker; // Return job seeker if credentials match
//        }
//        return null; // Invalid credentials
//    }
//}
//
package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobSeekerService {

    @Autowired
    private JobSeekerRepository jobSeekerRepository;

    public JobSeeker registerJobSeeker(JobSeeker jobSeeker) {
        // Validate and save the job seeker
        return jobSeekerRepository.save(jobSeeker);
    }

    public JobSeeker login(String email, String password) {
        JobSeeker jobSeeker = jobSeekerRepository.findByEmail(email);
        if (jobSeeker != null) {
            if (jobSeeker.isBlocked()) {
                throw new RuntimeException("Your account is blocked. Please contact support.");
            }
            if (jobSeeker.getPassword().equals(password)) {
                return jobSeeker; // Return job seeker if credentials match
            }
        }
        return null; // Invalid credentials
    }
}


