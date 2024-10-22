package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminDashboardController {

    @GetMapping("/admin/dashboard")
    public String adminDashboard() {
        return "admin_dashboard"; // This should match the name of your HTML file without the .html extension
    }
}
