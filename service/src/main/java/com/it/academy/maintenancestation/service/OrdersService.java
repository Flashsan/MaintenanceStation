package com.it.academy.maintenancestation.service;


import com.it.academy.maintenancestation.dto.OrdersDto;

import java.util.List;

public interface OrdersService {

    List<OrdersDto> listAllOrders();

    OrdersDto findOrderById(Integer orderId);

    void addOrder(OrdersDto ordersDto);

    void deleteOrdersById(Integer orderId);
}
