package com.it.academy.maintenancestation.service.impl;

import com.it.academy.maintenancestation.converter.MapperConfiguration;
import com.it.academy.maintenancestation.dto.AdministratorDetailsDto;
import com.it.academy.maintenancestation.dto.AdministratorDto;
import com.it.academy.maintenancestation.dto.OrdersDto;
import com.it.academy.maintenancestation.entity.Administrator;
import com.it.academy.maintenancestation.entity.AdministratorDetails;
import com.it.academy.maintenancestation.entity.Orders;
import com.it.academy.maintenancestation.repository.AdministratorRepository;
import com.it.academy.maintenancestation.service.AdministratorService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * AdministratorService
 *
 * @author Alexander Grigorovich
 * @version 12.07.2022
 */

@Service
@RequiredArgsConstructor
public class AdministratorServiceImpl
        implements AdministratorService {

    ModelMapper modelMapper = new ModelMapper();

    /**
     * Administrator repository.
     */
    private final AdministratorRepository administratorRepository;

    /**
     * service - show all administratorsDto
     *
     * @return all administratorsDto
     */
    @Override
    public List<AdministratorDto> listAllAdministrators() {
        List<Administrator> administratorList = administratorRepository.findAll();
        return MapperConfiguration.convertList(administratorList, this::convertToAdministratorDto);
    }

    /**
     * method -  find administrator by id from db
     *
     * @param administratorId
     * @return administratorDto by id
     */
    @Override
    public AdministratorDto findAdministratorById(Integer administratorId) {
        return convertToAdministratorDto(administratorRepository.findById(administratorId).orElse(null));
    }

    /**
     * method - add administrator in db
     *
     * @param administratorDto
     */
    @Override
    public void addAdministrator(AdministratorDto administratorDto) {
        administratorRepository.save(convertDtoToEntityAdministrator(administratorDto));
    }

    /**
     * method - delete administrator from db by id
     *
     * @param administratorId
     */
    @Override
    public void deleteAdministratorById(Integer administratorId) {
        administratorRepository.deleteById(administratorId);
    }

    /**
     * method - show list accepted orders byAdministrator
     * @param byAdministratorId
     * @return
     */
    @Override
    public List<OrdersDto> listAcceptedOrdersByAdministrator(Integer byAdministratorId) {
        List<Orders> ordersList = administratorRepository.getAdministratorsOrders(byAdministratorId);
        return MapperConfiguration.convertList(ordersList, this::convertToOrdersDto);
    }

    //entity to dto
    public AdministratorDto convertToAdministratorDto(Administrator administrator) {
        AdministratorDto administratorDto = modelMapper.map(administrator, AdministratorDto.class);
        administratorDto.setAdministratorDetails(convertToAdministratorDetailsDto(administrator.getAdministratorDetails()));
        return administratorDto;
    }

    public AdministratorDetailsDto convertToAdministratorDetailsDto(AdministratorDetails administratorDetails) {
        AdministratorDetailsDto administratorDetailsDto = modelMapper.map(administratorDetails, AdministratorDetailsDto.class);
        return administratorDetailsDto;
    }
    //end entity to dto

    //dto to entity
    public Administrator convertDtoToEntityAdministrator(AdministratorDto administratorDto) {
        Administrator administrator = modelMapper.map(administratorDto, Administrator.class);
        AdministratorDetails administratorDetails = convertDtoToEntityAdministratorDetails(administratorDto.getAdministratorDetails());
        administrator.setAdministratorDetails(administratorDetails);
        administratorDetails.setAdministrator(administrator);
        administratorDetails.setAdministratorDetailsId(administrator.getAdministratorId());
        return administrator;
    }

    public AdministratorDetails convertDtoToEntityAdministratorDetails(AdministratorDetailsDto administratorDetailsDto) {
        AdministratorDetails administratorDetails = modelMapper.map(administratorDetailsDto, AdministratorDetails.class);
        return administratorDetails;
    }
    //end dto to entity

    //entity to dto
    public OrdersDto convertToOrdersDto(Orders orders) {
        OrdersDto ordersDto = modelMapper.map(orders, OrdersDto.class);
        ordersDto.setAdministrator(convertToAdministratorDto(orders.getAdministrator()));
        return ordersDto;
    }
    //end entity to dto

    //dto to entity
    public Orders convertDtoToEntityOrders(OrdersDto ordersDto) {
        Orders orders = modelMapper.map(ordersDto, Orders.class);
        orders.setAdministrator(convertDtoToEntityAdministrator(ordersDto.getAdministrator()));
        return orders;
    }
//end dto to entity

}
