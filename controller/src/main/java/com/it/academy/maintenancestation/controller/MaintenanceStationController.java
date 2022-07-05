package com.it.academy.maintenancestation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MaintenanceStationController {

    @RequestMapping("/")
    public String listAdministrators(Model model) {
        return "index";
    }


}
