package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @GetMapping("/{email}")  // Using email to fetch the user profile
    public UserProfile getUserProfile(@PathVariable String email) {
        return userProfileService.getUserProfileByEmail(email);
    }
}
