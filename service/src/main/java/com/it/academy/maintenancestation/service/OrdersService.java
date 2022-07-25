package com.it.academy.maintenancestation.service;


import com.it.academy.maintenancestation.dto.OrdersDto;

import java.util.List;

/**
 * OrdersService
 *
 * @author Alexander Grigorovich
 * @version 12.07.2022
 */

public interface OrdersService {

    /**
     * service - show all orders
     *
     * @return all orders
     */
    List<OrdersDto> listAllOrders();

    /**
     * service - find order by id
     *
     * @param orderId
     * @return order by id
     */
    OrdersDto findOrderById(Integer orderId);

    /**
     * service - create order
     *
     * @param ordersDto
     */
    void addOrder(OrdersDto ordersDto);

    /**
     * service - delete order by id
     *
     * @param orderId
     */
    void deleteOrdersById(Integer orderId);
}
