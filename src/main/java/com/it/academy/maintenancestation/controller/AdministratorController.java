package com.it.academy.maintenancestation.controller;

import com.it.academy.maintenancestation.entity.Administrator;
import com.it.academy.maintenancestation.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    @RequestMapping("/")
    public String viewAllAdministrator(Model model) {
        List<Administrator> administratorList =
                administratorService.listAllAdministrators();
        model.addAttribute("administratorList", administratorList);
        return "index";
    }

}
