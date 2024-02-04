package com.example.task.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mainController {
    @GetMapping("/")
    public String home(Model model){
        String login = SecurityContextHolder.getContext().getAuthentication().getName();

        model.addAttribute("login", login);

        return "home";
    }

}
