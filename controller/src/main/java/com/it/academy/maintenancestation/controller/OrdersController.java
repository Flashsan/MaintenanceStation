package com.it.academy.maintenancestation.controller;

import com.it.academy.maintenancestation.dto.AdministratorDto;
import com.it.academy.maintenancestation.dto.OrdersDto;
import com.it.academy.maintenancestation.service.AdministratorService;
import com.it.academy.maintenancestation.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrdersController {


    private final OrdersService ordersService;
    private final AdministratorService administratorService;

    @GetMapping("/")
    public String listOrders(Model model) {
        List<OrdersDto> ordersList = ordersService.listAllOrders();
        model.addAttribute("ordersDtoList", ordersService.listAllOrders());
        return "orders";
    }

    @GetMapping("/saveOrder")
    public String showCreateFormNewOrders(Model model, OrdersDto ordersDto, AdministratorDto administratorDto) {

        model.addAttribute("administratorDtoList", administratorService.listAllAdministrators());
        model.addAttribute("ordersDto", ordersDto);
        return "ordersAddEdit";
    }

//    @ModelAttribute("administratorDto")
//    AdministratorDto administratorDto,

    @PostMapping("/saveOrder")
    public String saveOrders(@ModelAttribute("ordersDto")
                                     OrdersDto ordersDto,
                             @RequestParam("administratorId") Integer administratorId) {
        AdministratorDto administratorDtoToOrder = administratorService.findAdministratorById(administratorId);
        ordersDto.setAdministrator(administratorDtoToOrder);
        ordersService.addOrder(ordersDto);
        return "redirect:/orders/";
    }

    @GetMapping("/editOrders/{id}")
    public String showEditFormOrders(@PathVariable(name = "id") Integer orderId,
                                     Model model) {
        model.addAttribute("ordersDto", ordersService.findOrderById(orderId));
        return "ordersAddEdit";
    }

    @GetMapping("/deleteOrders/{id}")
    public String deleteOrders(@PathVariable(name = "id") Integer orderId) {
        ordersService.deleteOrdersById(orderId);
        return "redirect:/orders/";
    }

}
