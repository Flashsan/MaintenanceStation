package com.it.academy.maintenancestation.controller;

import com.it.academy.maintenancestation.dto.AdministratorDetailsDto;
import com.it.academy.maintenancestation.dto.AdministratorDto;
import com.it.academy.maintenancestation.entity.Administrator;
import com.it.academy.maintenancestation.entity.AdministratorDetails;
import com.it.academy.maintenancestation.service.AdministratorDetailsService;
import com.it.academy.maintenancestation.service.AdministratorService;
import com.it.academy.maintenancestation.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/administrator")
@RequiredArgsConstructor
public class AdministratorController {

    private final AdministratorService administratorService;
    private final AdministratorDetailsService administratorDetailsService;
    private final OrdersService ordersService;

    @GetMapping("/")
    public String listAdministrators(Model model) {
        model.addAttribute("administratorDtoList", administratorService.listAllAdministrators());
        return "administrator";
    }

    @GetMapping("/saveAdministrator")
    public String showCreateFormNewAdministrator(Model model,
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
        model.addAttribute("editAdministratorDto", administratorService.findAdministratorById(administratorId));
        return "administratorEdit";
    }

    @GetMapping("/deleteAdministrator/{id}")
    public String deleteAdministrator(@PathVariable(name = "id") Integer administratorId) {
        administratorService.deleteAdministratorById(administratorId);
        return "redirect:/administrator/";
    }
}


