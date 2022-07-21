package com.it.academy.maintenancestation.controller;

import com.it.academy.maintenancestation.dto.ClientDto;
import com.it.academy.maintenancestation.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * ClientController
 *
 * @author Alexander Grigorovich
 * @version 12.07.2022
 */

@Controller
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {

    /**
     * Constant(ClientController)
     */
    public static final String CLIENT_DTO_LIST = "clientDtoList";
    public static final String CLIENT = "client";
    public static final String CLIENT_DTO = "clientDto";
    public static final String CLIENT_ADD_EDIT = "clientAddEdit";
    public static final String REDIRECT_CLIENT = "redirect:/client/";
    public static final String ID = "id";
    public static final String CLIENT_OWN_CARS = "clientOwnCars";
    public static final String OWN_CARS_LIST = "ownCarsList";
    /**
     *
     */
    private final ClientService clientService;

    /**
     * @param model
     * @return
     */
    @GetMapping("/")
    public String listClient(Model model) {
        model.addAttribute(CLIENT_DTO_LIST, clientService.listAllClients());
        return CLIENT;
    }

    /**
     * @param model
     * @param clientDto
     * @return
     */
    @GetMapping("/saveClient")
    public String showCreateEditFormNewClient(Model model,
                                              ClientDto clientDto) {
        model.addAttribute(CLIENT_DTO, clientDto);
        return CLIENT_ADD_EDIT;
    }

    /**
     * @param clientDto
     * @return
     */
    @PostMapping("/saveClient")
    public String saveClient(@ModelAttribute(CLIENT_DTO)
                                     ClientDto clientDto) {
        clientService.addClient(clientDto);
        return REDIRECT_CLIENT;
    }

    /**
     * @param clientId
     * @param model
     * @return
     */
    @GetMapping("/editClient/{id}")
    public String showEditFormClient(@PathVariable(name = ID) Integer clientId,
                                     Model model) {
        model.addAttribute(CLIENT_DTO, clientService.findClientById(clientId));
        return CLIENT_ADD_EDIT;
    }

    /**
     * @param clientId
     * @return
     */
    @GetMapping("/deleteClient/{id}")
    public String deleteClient(@PathVariable(name = ID) Integer clientId) {
        clientService.deleteClientById(clientId);
        return REDIRECT_CLIENT;
    }

    /**
     * @param byClientId
     * @param model
     * @return
     */
    @GetMapping("/ownCars/{id}")
    public String listOwnCars(@PathVariable(name = ID) Integer byClientId,
                              Model model) {
        model.addAttribute(OWN_CARS_LIST,
                clientService.listOwnCars(byClientId));
        return CLIENT_OWN_CARS;
    }
}


