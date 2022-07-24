package com.it.academy.maintenancestation.controller;

import com.it.academy.maintenancestation.dto.MechanicDto;
import com.it.academy.maintenancestation.service.MechanicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static com.it.academy.maintenancestation.controller.constant.AllControllerConstant.*;

/**
 * MechanicController
 *
 * @author Alexander Grigorovich
 * @version 12.07.2022
 */

@Controller
@RequestMapping("/mechanic")
public class MechanicController {

    /**
     *
     */
    @Autowired
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

    /**
     *
     * @param byMechanicId
     * @param model
     * @return
     */
    @GetMapping("/acceptedWorkList/{id}")
    public String listAcceptedOrders(@PathVariable(name = ID) Integer byMechanicId,
                                     Model model) {
        model.addAttribute(ACCEPTED_WORK_LIST,
                mechanicService.listPinnedWorkList(byMechanicId));
        return MECHANIC_WORK_LIST;
    }
}
