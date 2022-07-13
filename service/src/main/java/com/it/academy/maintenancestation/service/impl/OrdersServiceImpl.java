package com.it.academy.maintenancestation.service.impl;


import com.it.academy.maintenancestation.converter.impl.OrderConverter;
import com.it.academy.maintenancestation.dto.OrdersDto;
import com.it.academy.maintenancestation.entity.Orders;
import com.it.academy.maintenancestation.entity.SparePart;
import com.it.academy.maintenancestation.repository.OrderRepository;
import com.it.academy.maintenancestation.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrdersServiceImpl
        implements OrdersService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderConverter orderConverter;

    @Override
    public List<OrdersDto> listAllOrders() {
        List<Orders> odersDtoList =
                orderRepository.findAll();
        return odersDtoList.stream()
                .map(orderConverter::toDto)
                .collect(Collectors.toList());
    }
}//
//    @Override
//    public Administrator findAdministratorById(Integer administratorId) {
//        return null;
//    }
//
//    @Override
//    public void newAdministrator(AdministratorDto administratorDto) {
//
//    }
//
//    @Override
//    public void deleteAdministratorById(Integer administratorId) {
//
//    }
