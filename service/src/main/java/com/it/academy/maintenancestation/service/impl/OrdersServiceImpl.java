package com.it.academy.maintenancestation.service.impl;

import com.it.academy.maintenancestation.converter.MapperConfiguration;
import com.it.academy.maintenancestation.converter.impl.OrdersConverter;
import com.it.academy.maintenancestation.dto.OrdersDto;
import com.it.academy.maintenancestation.entity.Orders;
import com.it.academy.maintenancestation.repository.OrdersRepository;
import com.it.academy.maintenancestation.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * OrdersService
 *
 * @author Alexander Grigorovich
 * @version 12.07.2022
 */

@Service
@RequiredArgsConstructor
public class OrdersServiceImpl
        implements OrdersService {
    /**
     *
     */
    private final OrdersRepository ordersRepository;

    /**
     *
     */
    private final OrdersConverter ordersConverter;

    /**
     * service - show all ordersDto
     *
     * @return all ordersDto
     */
    @Override
    public List<OrdersDto> listAllOrders() {
        List<Orders> ordersList = ordersRepository.findAll();
        return MapperConfiguration.convertList(ordersList, ordersConverter::entityToDto);
    }

    /**
     * method -  find orders by id from db
     *
     * @param orderId
     * @return ordersDto by id
     */
    @Override
    public OrdersDto findOrderById(Integer orderId) {
        return ordersConverter.entityToDto(ordersRepository.findById(orderId).orElse(null));
    }

    /**
     * method - add orders in db
     *
     * @param ordersDto
     */
    @Override
    public void addOrder(OrdersDto ordersDto) {
        ordersRepository.save(ordersConverter.dtoToEntity(ordersDto));
    }

    /**
     * method - delete order from db by id
     *
     * @param orderId
     */
    @Override
    public void deleteOrdersById(Integer orderId) {
        ordersRepository.deleteById(orderId);
    }
}




