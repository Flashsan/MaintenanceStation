package com.it.academy.maintenancestation.service.impl;


import com.it.academy.maintenancestation.converter.MapperConfiguration;
import com.it.academy.maintenancestation.converter.impl.OrdersConverter;
import com.it.academy.maintenancestation.dto.AdministratorDetailsDto;
import com.it.academy.maintenancestation.dto.AdministratorDto;
import com.it.academy.maintenancestation.dto.OrdersDto;
import com.it.academy.maintenancestation.dto.WorkListDto;
import com.it.academy.maintenancestation.entity.Administrator;
import com.it.academy.maintenancestation.entity.AdministratorDetails;
import com.it.academy.maintenancestation.entity.Orders;
import com.it.academy.maintenancestation.repository.OrdersRepository;
import com.it.academy.maintenancestation.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

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
    private final AdministratorServiceImpl administratorServiceImpl;

    @Override
    public List<OrdersDto> listAllOrders() {
        List<Orders> ordersList = ordersRepository.findAll();
        return MapperConfiguration.convertList(ordersList, this::convertToOrdersDto);
    }


//    @Override
//    public List<OrdersDto> listAllOrders() {
//        return (ordersRepository.findAll()).stream()
//                .map(ordersConverter::toDto)
//                .collect(Collectors.toList());
//    }

    @Override
    public OrdersDto findOrderById(Integer orderId) {
        return ordersConverter.toDto(
                ordersRepository
                        .findById(orderId)
                        .orElse(null));
    }

    @Override
    public void addOrder(OrdersDto ordersDto) {

        ordersRepository.save(convertDtoToEntityOrders(ordersDto));
//

    }

    @Override
    public void deleteOrdersById(Integer orderId) {
        ordersRepository.deleteById(orderId);
    }


    private final ModelMapper modelMapper;

    //entity to dto
    public OrdersDto convertToOrdersDto(Orders orders) {
        OrdersDto ordersDto = modelMapper.map(orders, OrdersDto.class);
        ordersDto.setAdministrator(administratorServiceImpl.convertToAdministratorDto(orders.getAdministrator()));
        return ordersDto;
    }
    //end entity to dto

    //dto to entity
    public Orders convertDtoToEntityOrders(OrdersDto ordersDto) {
        Orders orders = modelMapper.map(ordersDto, Orders.class);
        orders.setAdministrator(administratorServiceImpl.convertDtoToEntityAdministrator(ordersDto.getAdministrator()));
        return orders;
    }
//end dto to entity

}




