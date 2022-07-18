package com.it.academy.maintenancestation.controller;

import com.it.academy.maintenancestation.dto.CarDto;
import com.it.academy.maintenancestation.dto.MechanicDto;
import com.it.academy.maintenancestation.service.MechanicService;
import com.it.academy.maintenancestation.service.OrdersService;
import com.it.academy.maintenancestation.service.СarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/mechanic")
public class MechanicController {

    @Autowired
    private MechanicService mechanicService;

    @GetMapping("/")
    public String listMechanics(Model model) {
        model.addAttribute("mechanicDtoList", mechanicService.listAllMechanics());
        return "mechanic";
    }

    @GetMapping("/saveMechanic")
    public String showCreateEditFormNewMechanic(Model model,
                                           MechanicDto mechanicDto) {
        model.addAttribute("mechanicDto", mechanicDto);
        return "mechanicAddEdit";
    }

    @PostMapping("/saveMechanic")
    public String saveMechanic(@ModelAttribute("mechanicDto")
                                  MechanicDto mechanicDto) {
        mechanicService.addMechanic(mechanicDto);
        return "redirect:/mechanic/";
    }

    @GetMapping("/editMechanic/{id}")
    public String showEditFormMechanic(@PathVariable(name = "id") Integer mechanicId,
                                  Model model) {
        MechanicDto mechanicDto = mechanicService.findMechanicById(mechanicId);
        model.addAttribute("mechanicDto", mechanicService.findMechanicById(mechanicId));
        return "mechanicAddEdit";
    }

    @GetMapping("/deleteMechanic/{id}")
    public String deleteMechanic(@PathVariable(name = "id") Integer mechanicId) {
        mechanicService.deleteMechanicById(mechanicId);
        return "redirect:/mechanic/";
    }
}
