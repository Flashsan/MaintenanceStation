package com.it.academy.maintenancestation.converter.impl;

import com.it.academy.maintenancestation.converter.Converter;
import com.it.academy.maintenancestation.dto.OrdersDto;
import com.it.academy.maintenancestation.entity.Orders;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * AdministratorConverter
 *
 * @author Alexander Grigorovich
 * @version 12.07.2022
 */

@Component
@RequiredArgsConstructor
public class OrdersConverter implements Converter<Orders, OrdersDto> {

    /**
     *
     */
    private final ModelMapper modelMapper;
    private final AdministratorConverter administratorConverter;

    /**
     *
     */
    private final AdministratorConverter administratorConverter;

    /**
     * Orders convert to OrdersDto
     * @param entity
     * @return
     */
    @Override
    public OrdersDto entityToDto(Orders entity) {
        OrdersDto ordersDto = modelMapper.map(entity, OrdersDto.class);
        ordersDto.setAdministrator(administratorConverter.entityToDto(entity.getAdministrator()));
        return ordersDto;
    }

    /**
     * OrdersDto convert to Orders
     * @param dto
     * @return
     */
    @Override
    public Orders dtoToEntity(OrdersDto dto) {
        Orders orders = modelMapper.map(dto, Orders.class);
        orders.setAdministrator(administratorConverter.dtoToEntity(dto.getAdministrator()));
        return orders;
    }
}
