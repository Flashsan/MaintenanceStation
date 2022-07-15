package com.it.academy.maintenancestation.converter.impl;

import com.it.academy.maintenancestation.dto.OrdersDto;
import com.it.academy.maintenancestation.entity.Orders;
import org.springframework.stereotype.Component;

@Component
public class OrdersConverter
        extends AbstractMapper<Orders, OrdersDto> {
    public OrdersConverter() {
        super(Orders.class, OrdersDto.class);
    }
}
