package com.it.academy.maintenancestation.controller;

import com.it.academy.maintenancestation.dto.AdministratorDto;
import com.it.academy.maintenancestation.service.AdministratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.it.academy.maintenancestation.controller.constant.AllControllerConstant.*;

/**
 * Administrator controller
 *
 * @author Alexander Grigorovich
 * @version 12.07.2022
 */

@Controller
@RequestMapping("/administrator")
@RequiredArgsConstructor
public class AdministratorController {

    /**
     *
     */
    private final AdministratorService administratorService;

    /**
     * @param model
     * @return
     */
    @GetMapping("/")
    public String listAdministrators(Model model) {
        model.addAttribute(ADMINISTRATOR_DTO_LIST, administratorService.listAllAdministrators());
        return ADMINISTRATOR;
    }

    /**
     * @param model
     * @param administratorDto
     * @return
     */
    @GetMapping("/saveAdministrator")
    public String showCreateEditFormNewAdministrator(Model model,
                                                     AdministratorDto administratorDto) {
        model.addAttribute(ADMINISTRATOR_DTO, administratorDto);
        return ADMINISTRATOR_ADD_EDIT;
    }

    /**
     * @param administratorDto
     * @return
     */
    @PostMapping("/saveAdministrator")
    public String saveAdministrator(@ModelAttribute(ADMINISTRATOR_DTO)
                                    @Valid AdministratorDto administratorDto,
                                    BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ADMINISTRATOR_ADD_EDIT;
        }
        administratorService.addAdministrator(administratorDto);
        return REDIRECT_ADMINISTRATOR;
    }

    /**
     * @param administratorId
     * @param model
     * @return
     */
    @GetMapping("/editAdministrator/{id}")
    public String showEditFormAdministrator(@PathVariable(name = ID) Integer administratorId,
                                            Model model) {
        AdministratorDto administrator = administratorService.findAdministratorById(administratorId);
        model.addAttribute(ADMINISTRATOR_DTO, administrator);
        return ADMINISTRATOR_ADD_EDIT;
    }

    /**
     * @param administratorId
     * @return
     */
    @GetMapping("/deleteAdministrator/{id}")
    public String deleteAdministrator(@PathVariable(name = ID) Integer administratorId) {
        administratorService.deleteAdministratorById(administratorId);
        return REDIRECT_ADMINISTRATOR;
    }

    /**
     * @param byAdministratorId
     * @param model
     * @return
     */
    @GetMapping("/acceptedOrders/{id}")
    public String listAcceptedOrders(@PathVariable(name = ID) Integer byAdministratorId,
                                     Model model) {
        model.addAttribute(ACCEPTED_ORDERS_DTO_BY_ADMINISTRATOR_LIST,
                administratorService.listAcceptedOrdersByAdministrator(byAdministratorId));
        return ADMINISTRATOR_ACCEPTED_LIST_ORDERS;
    }
}


