package com.it.academy.maintenancestation.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/administrator")
//@SessionAttributes("administrator")
public class AdministratorController {

    @GetMapping("/showAllAdministrator")
    public String showAllAdministrator(Model model){
//        model.addAttribute("administrators" );
        return null;
    }

}
