package com.withstudy.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

    @GetMapping("/")
    public String viewHome() {
        return "withStudy";
    }

    @GetMapping("/studyList")
    public String viewPost() {
        return "studyListPage";
    }

    @GetMapping("/login")
    public String login() {
        return "loginPage";
    }

    @GetMapping("/community")
    public String communityView() {
        return "communityPage";
    }

    @GetMapping("/signUp")
    public String singUpView() {
        return "signUpPage";
    }
}
