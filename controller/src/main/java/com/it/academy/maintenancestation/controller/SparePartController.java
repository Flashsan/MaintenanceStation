package com.it.academy.maintenancestation.controller;

import com.it.academy.maintenancestation.dto.AdministratorDto;
import com.it.academy.maintenancestation.dto.MechanicDto;
import com.it.academy.maintenancestation.dto.SparePartDto;
import com.it.academy.maintenancestation.dto.WorkListDto;
import com.it.academy.maintenancestation.service.AdministratorService;
import com.it.academy.maintenancestation.service.MechanicService;
import com.it.academy.maintenancestation.service.SparePartService;
import com.it.academy.maintenancestation.service.WorkListService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/sparePart")
@RequiredArgsConstructor
public class SparePartController {


    private final SparePartService sparePartService;

    @GetMapping("/")
    public String listSparePart(Model model) {
        model.addAttribute("sparePartDtoList", sparePartService.listAllSparePart());
        return "sparePart";
    }

    @GetMapping("/saveSparePart")
    public String showCreateEditFormNewSparePart(Model model,
                                                 SparePartDto sparePartDto) {
        model.addAttribute("sparePartDto", sparePartDto);
        return "sparePartAddEdit";
    }

    @PostMapping("/saveSparePart")
    public String saveSparePart(@ModelAttribute("sparePartDto")
                                        SparePartDto sparePartDto) {
        sparePartService.addSparePart(sparePartDto);
        return "redirect:/sparePart/";
    }

    @GetMapping("/editSparePart/{id}")
    public String showEditFormSparePart(@PathVariable(name = "id") Integer sparePartId,
                                            Model model) {
        SparePartDto sparePartDto = sparePartService.findSparePartById(sparePartId);
        model.addAttribute("sparePartDto", sparePartService.findSparePartById(sparePartId));
        return "sparePartAddEdit";
    }

    @GetMapping("/deleteSparePart/{id}")
    public String deleteSparePart(@PathVariable(name = "id") Integer sparePartId) {
        sparePartService.deleteSparePartById(sparePartId);
        return "redirect:/sparePart/";
    }
}


