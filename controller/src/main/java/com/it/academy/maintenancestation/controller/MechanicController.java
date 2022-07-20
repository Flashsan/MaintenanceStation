package com.it.academy.maintenancestation.controller;

import com.it.academy.maintenancestation.dto.CarDto;
import com.it.academy.maintenancestation.dto.MechanicDto;
import com.it.academy.maintenancestation.service.MechanicService;
import com.it.academy.maintenancestation.service.OrdersService;
import com.it.academy.maintenancestation.service.СarService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * MechanicController
 *
 * @author Alexander Grigorovich
 * @version 12.07.2022
 */

@Controller
@RequestMapping("/mechanic")
@RequiredArgsConstructor
public class MechanicController {

    /**
     * Constant(MechanicController)
     */
    public static final String MECHANIC = "mechanic";
    public static final String MECHANIC_DTO_LIST = "mechanicDtoList";
    public static final String MECHANIC_DTO = "mechanicDto";
    public static final String MECHANIC_ADD_EDIT = "mechanicAddEdit";
    public static final String REDIRECT_MECHANIC = "redirect:/mechanic/";
    public static final String ID = "id";

    /**
     *
     */
    private MechanicService mechanicService;

    /**
     *
     * @param model
     * @return
     */
    @GetMapping("/")
    public String listMechanics(Model model) {
        model.addAttribute(MECHANIC_DTO_LIST, mechanicService.listAllMechanics());
        return MECHANIC;
    }

    /**
     *
     * @param model
     * @param mechanicDto
     * @return
     */
    @GetMapping("/saveMechanic")
    public String showCreateEditFormNewMechanic(Model model,
                                                MechanicDto mechanicDto) {
        model.addAttribute(MECHANIC_DTO, mechanicDto);
        return MECHANIC_ADD_EDIT;
    }

    /**
     *
     * @param mechanicDto
     * @return
     */
    @PostMapping("/saveMechanic")
    public String saveMechanic(@ModelAttribute(MECHANIC_DTO)
                                       MechanicDto mechanicDto) {
        mechanicService.addMechanic(mechanicDto);
        return REDIRECT_MECHANIC;
    }

    /**
     *
     * @param mechanicId
     * @param model
     * @return
     */
    @GetMapping("/editMechanic/{id}")
    public String showEditFormMechanic(@PathVariable(name = ID) Integer mechanicId,
                                       Model model) {
        model.addAttribute(MECHANIC_DTO, mechanicService.findMechanicById(mechanicId));
        return MECHANIC_ADD_EDIT;
    }

    /**
     *
     * @param mechanicId
     * @return
     */
    @GetMapping("/deleteMechanic/{id}")
    public String deleteMechanic(@PathVariable(name = ID) Integer mechanicId) {
        mechanicService.deleteMechanicById(mechanicId);
        return REDIRECT_MECHANIC;
    }
}
