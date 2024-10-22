package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService {

    @Autowired
    private UserRepository userRepository;

    public UserProfile getUserProfileByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
