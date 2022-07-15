package com.it.academy.maintenancestation.controller;

import com.it.academy.maintenancestation.dto.AdministratorDto;
import com.it.academy.maintenancestation.dto.OrdersDto;
import com.it.academy.maintenancestation.service.AdministratorService;
import com.it.academy.maintenancestation.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrdersController {


    private final OrdersService ordersService;

    @GetMapping("/")
    public String listOrders(Model model) {
        model.addAttribute("ordersDtoList", ordersService.listAllOrders());
        return "orders";
    }

    @GetMapping("/saveOrders")
    public String showCreateFormNewOrders(Model model,
                                          OrdersDto ordersDto) {
        model.addAttribute("ordersDto", ordersDto);
        return "ordersAddEdit";
    }

    @PostMapping("/saveOrders")
    public String saveOrders(@ModelAttribute("ordersDto")
                                     OrdersDto ordersDto) {
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
