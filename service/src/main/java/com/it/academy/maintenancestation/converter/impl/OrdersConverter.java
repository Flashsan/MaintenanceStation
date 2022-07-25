package com.it.academy.maintenancestation.converter.impl;

import com.it.academy.maintenancestation.converter.Converter;
import com.it.academy.maintenancestation.dto.OrdersDto;
import com.it.academy.maintenancestation.entity.Orders;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrdersConverter implements Converter<Orders, OrdersDto> {

    private final ModelMapper modelMapper;

    @Override
    public OrdersDto entityToDto(Orders entity) {
        OrdersDto ordersDto = modelMapper.map(entity, OrdersDto.class);
        return ordersDto;
    }

    @Override
    public Orders dtoToEntity(OrdersDto dto) {
        Orders orders = modelMapper.map(dto, Orders.class);
        return orders;
    }
}
