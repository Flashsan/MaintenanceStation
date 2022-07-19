package com.it.academy.maintenancestation.controller;

import com.it.academy.maintenancestation.dto.AdministratorDto;
import com.it.academy.maintenancestation.service.AdministratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/administrator")
@RequiredArgsConstructor
public class AdministratorController {

    private final AdministratorService administratorService;

    @GetMapping("/")
    public String listAdministrators(Model model) {
        model.addAttribute("administratorDtoList", administratorService.listAllAdministrators());
        return "administrator";
    }

    @GetMapping("/saveAdministrator")
    public String showCreateEditFormNewAdministrator(Model model,
                                                     AdministratorDto administratorDto) {
        model.addAttribute("administratorDto", administratorDto);
        return "administratorAddEdit";
    }

    @PostMapping("/saveAdministrator")
    public String saveAdministrator(@ModelAttribute("administratorDto")
                                            AdministratorDto administratorDto) {
        administratorService.addAdministrator(administratorDto);
        return "redirect:/administrator/";
    }

    @GetMapping("/editAdministrator/{id}")
    public String showEditFormAdministrator(@PathVariable(name = "id") Integer administratorId,
                                            Model model) {
        AdministratorDto administrator = administratorService.findAdministratorById(administratorId);
        administrator.toString();
        model.addAttribute("administratorDto", administratorService.findAdministratorById(administratorId));
        return "administratorAddEdit";
    }

    @GetMapping("/deleteAdministrator/{id}")
    public String deleteAdministrator(@PathVariable(name = "id") Integer administratorId) {
        administratorService.deleteAdministratorById(administratorId);
        return "redirect:/administrator/";
    }

    @GetMapping("/acceptedOrders/{id}")
    public String listAcceptedOrders(@PathVariable(name = "id") Integer byAdministratorId,
                                     Model model) {
        model.addAttribute("acceptedOrdersDtoByAdministratorList", administratorService.listAcceptedOrdersByAdministrator(byAdministratorId));
        return "acceptedOrdersByAdministrator";
    }
}


