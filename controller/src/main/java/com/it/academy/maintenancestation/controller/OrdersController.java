package com.it.academy.maintenancestation.controller;

import com.it.academy.maintenancestation.dto.AdministratorDto;
import com.it.academy.maintenancestation.dto.OrdersDto;
import com.it.academy.maintenancestation.service.AdministratorService;
import com.it.academy.maintenancestation.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static com.it.academy.maintenancestation.controller.constant.AllControllerConstant.*;

/**
 * OrdersController
 *
 * @author Alexander Grigorovich
 * @version 12.07.2022
 */

@Controller
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrdersController {

    /**
     *
     */
    private final OrdersService ordersService;

    /**
     *
     */
    private final AdministratorService administratorService;

    /**
     *
     * @param model
     * @return
     */
    @GetMapping("/")
    public String listOrders(Model model) {
        model.addAttribute(ORDERS_DTO_LIST, ordersService.listAllOrders());
        return ORDERS;
    }

    /**
     *
     * @param model
     * @param ordersDto
     * @return
     */
    @GetMapping("/saveOrder")
    public String showCreateFormNewOrders(Model model, OrdersDto ordersDto) {
        model.addAttribute(ADMINISTRATOR_DTO_LIST, administratorService.listAllAdministrators());
        model.addAttribute(ORDERS_DTO, ordersDto);
        return ORDERS_ADD_EDIT;
    }

    /**
     *
     * @param ordersDto
     * @param administratorId
     * @return
     */
    @PostMapping("/saveOrder")
    public String saveOrders(@ModelAttribute(ORDERS_DTO)
                                     OrdersDto ordersDto,
                             @RequestParam(ADMINISTRATOR_ID) Integer administratorId) {
        AdministratorDto administratorDtoToOrder = administratorService.findAdministratorById(administratorId);
        ordersDto.setAdministrator(administratorDtoToOrder);
        ordersService.addOrder(ordersDto);
        return REDIRECT_ORDERS;
    }

    /**
     *
     * @param orderId
     * @param model
     * @return
     */
    @GetMapping("/editOrders/{id}")
    public String showEditFormOrders(@PathVariable(name = ID) Integer orderId,
                                     Model model) {
        model.addAttribute(ORDERS_DTO, ordersService.findOrderById(orderId));
        return ORDERS_ADD_EDIT;
    }

    /**
     *
     * @param orderId
     * @return
     */
    @GetMapping("/deleteOrders/{id}")
    public String deleteOrders(@PathVariable(name = ID) Integer orderId) {
        ordersService.deleteOrdersById(orderId);
        return REDIRECT_ORDERS;
    }

}
