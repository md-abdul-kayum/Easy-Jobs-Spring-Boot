//package com.example.demo;
//
////import com.example.demo.model.Recruiter;
////import com.example.demo.repository.RecruiterRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class RecruiterService {
//
//    @Autowired
//    private RecruiterRepository recruiterRepository;
//
//    public Recruiter registerRecruiter(Recruiter recruiter) {
//        // Validate and save the recruiter
//        return recruiterRepository.save(recruiter);
//    }
//
//    public Recruiter login(String email, String password) {
//        Recruiter recruiter = recruiterRepository.findByEmail(email);
//        if (recruiter != null && recruiter.getPassword().equals(password)) {
//            return recruiter; // Return recruiter if credentials match
//        }
//        return null; // Invalid credentials
//    }
//}
//
package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecruiterService {

    @Autowired
    private RecruiterRepository recruiterRepository;

    public Recruiter registerRecruiter(Recruiter recruiter) {
        // Validate and save the recruiter
        return recruiterRepository.save(recruiter);
    }

    public Recruiter login(String email, String password) {
        Recruiter recruiter = recruiterRepository.findByEmail(email);
        if (recruiter != null) {
            if (recruiter.isBlocked()) {
                throw new RuntimeException("Your account is blocked. Please contact support.");
            }
            if (recruiter.getPassword().equals(password)) {
                return recruiter; // Return recruiter if credentials match
            }
        }
        return null; // Invalid credentials
    }
}

