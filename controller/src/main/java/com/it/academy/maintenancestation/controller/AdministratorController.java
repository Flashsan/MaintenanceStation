package com.it.academy.maintenancestation.controller;

import com.it.academy.maintenancestation.dto.AdministratorDto;
import com.it.academy.maintenancestation.service.AdministratorService;
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

    @GetMapping("/")
    public String listAdministrators(Model model) {
        model.addAttribute("administratorDtoList", administratorService.listAllAdministrators());
        return "administrator";
    }

    @GetMapping("/addFormAdministrator")
    public String showCreateFormNewAdministrator(Model model) {
        model.addAttribute("AddEditAdministratorDto", new AdministratorDto());
        return "administratorAddEdit";
    }

    @PostMapping("/saveAdministrator")
    public String saveAdministrator(@ModelAttribute("newAdministrator")
                                    @Valid AdministratorDto administratorDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "administratorAddEdit";
        }
        administratorService.addAdministrator(administratorDto);
        return "redirect:/administrator/";
    }

    @GetMapping("/editAdministrator/{id}")
    public String showEditFormAdministrator(@PathVariable(name = "id") Integer administratorId,
                                            Model model,
                                            @Valid AdministratorDto administratorDto, BindingResult bindingResult) {
        administratorDto = administratorService.findAdministratorById(administratorId);
        if (bindingResult.hasErrors()) {
            return "administratorAddEdit";
        }
        model.addAttribute("AddEditAdministratorDto", administratorDto);
        return "administratorAddEdit";
    }

    @GetMapping("/deleteAdministrator/{id}")
    public String deleteAdministrator(@PathVariable(name = "id") Integer administratorId) {
        administratorService.deleteAdministratorById(administratorId);
        return "redirect:/administrator/";
    }
}


