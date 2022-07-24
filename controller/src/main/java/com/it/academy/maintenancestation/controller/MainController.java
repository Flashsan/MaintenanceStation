package com.it.academy.maintenancestation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    /**
     * @return
     */
    @GetMapping("/")
    public String mainPage() {
        return "main";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
}
