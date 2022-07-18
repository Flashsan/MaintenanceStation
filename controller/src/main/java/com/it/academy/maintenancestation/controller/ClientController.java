package com.it.academy.maintenancestation.controller;

import com.it.academy.maintenancestation.dto.ClientDto;
import com.it.academy.maintenancestation.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/")
    public String listClient(Model model) {
        model.addAttribute("clientDtoList", clientService.listAllClients());
        return "client";
    }

    @GetMapping("/saveClient")
    public String showCreateEditFormNewClient(Model model,
                                              ClientDto clientDto) {
        model.addAttribute("clientDto", clientDto);
        return "clientAddEdit";
    }

    @PostMapping("/saveClient")
    public String saveClient(@ModelAttribute("clientDto")
                                     ClientDto clientDto) {
        clientService.addClient(clientDto);
        return "redirect:/client/";
    }

    @GetMapping("/editClient/{id}")
    public String showEditFormClient(@PathVariable(name = "id") Integer clientId,
                                     Model model) {
        ClientDto client = clientService.findClientById(clientId);
        model.addAttribute("clientDto", clientService.findClientById(clientId));
        return "clientAddEdit";
    }

    @GetMapping("/deleteClient/{id}")
    public String deleteClient(@PathVariable(name = "id") Integer clientId) {
        clientService.deleteClientById(clientId);
        return "redirect:/client/";
    }
}


