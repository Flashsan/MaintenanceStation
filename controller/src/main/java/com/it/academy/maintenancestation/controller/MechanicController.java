package com.it.academy.maintenancestation.controller;

import com.it.academy.maintenancestation.dto.MechanicDto;
import com.it.academy.maintenancestation.service.MechanicService;
import com.it.academy.maintenancestation.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("mechanic")
public class MechanicController {

    @Autowired
    private MechanicService mechanicService;

    @GetMapping("/")
    public String listMechanics(Model model) {
        model.addAttribute("MechanicDtoList", mechanicService.listAllMechanics());
        return "mechanic";
    }

}
