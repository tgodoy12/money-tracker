package com.tracker.money_tracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContentController {

    @GetMapping("/home")
    public String handleWelcome() {
        return "home";
    }

    @GetMapping("/admin/home")
    public String handleAdminHome() {
        return "home_admin";
    }

    @GetMapping("/user/home")
    public String handleUserHome() {
        return "home_user.html";
    }

    @GetMapping("/login")
    public String handleLogin() {
        return "custom_login";
    }
}
