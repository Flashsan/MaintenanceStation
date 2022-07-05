package com.it.academy.maintenancestation.service;


import com.it.academy.maintenancestation.dto.OrdersDto;

import java.util.List;

/**
 * AdministratorService
 *
 * @author Alexander Grigorovich
 * @version 22.05.2022
 */
public interface OrdersService {

    /**
     * service - show all administrators
     *
     * @return all orders
     */
    List<OrdersDto> listAllOrders();
}
////
////    /**
////     * service - find administrator by id
////     *
////     * @param administratorId
////     * @return administrator by id
////     */
////    Administrator findAdministratorById(Integer administratorId);
////
////    /**
////     * service - create administrator
////     *
////     * @param administratorDto
////     */
////    void newAdministrator(AdministratorDto administratorDto);
////
////    /**
////     * service - delete administrator by id
////     *
////     * @param administratorId
////     */
////    void deleteAdministratorById(Integer administratorId);
//
//}
//