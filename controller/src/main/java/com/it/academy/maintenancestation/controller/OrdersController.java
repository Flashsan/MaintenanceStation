package com.it.academy.maintenancestation.controller;

import com.it.academy.maintenancestation.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

//    @RequestMapping("/listOrders")
//    public String listOrders(Model model) {
//        model.addAttribute("orders", ordersService.listAllOrders());
//        return "orders";
//    }


}
