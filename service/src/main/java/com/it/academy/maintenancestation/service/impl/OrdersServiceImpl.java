package com.it.academy.maintenancestation.service.impl;


import com.it.academy.maintenancestation.converter.impl.OrdersConverter;
import com.it.academy.maintenancestation.dto.OrdersDto;
import com.it.academy.maintenancestation.dto.WorkListDto;
import com.it.academy.maintenancestation.entity.Administrator;
import com.it.academy.maintenancestation.entity.Orders;
import com.it.academy.maintenancestation.repository.OrdersRepository;
import com.it.academy.maintenancestation.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class OrdersServiceImpl
        implements OrdersService {

    private final OrdersRepository ordersRepository;
    private final OrdersConverter ordersConverter;

    @Override
    public List<OrdersDto> listAllOrders() {
        return (ordersRepository.findAll()).stream()
                .map(ordersConverter::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrdersDto findOrderById(Integer orderId) {
        return ordersConverter.toDto(
                ordersRepository
                        .findById(orderId)
                        .orElse(null));
    }

    @Override
    public void addOrder(OrdersDto ordersDto) {
        ordersRepository.save(ordersConverter.toEntity(ordersDto));
    }

    @Override
    public void deleteOrdersById(Integer orderId) {
        ordersRepository.deleteById(orderId);
    }
}
