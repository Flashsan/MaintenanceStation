package com.it.academy.maintenancestation.service.impl;

import com.it.academy.maintenancestation.converter.MapperConfiguration;
import com.it.academy.maintenancestation.converter.impl.AdministratorConverter;
import com.it.academy.maintenancestation.converter.impl.OrdersConverter;
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

    /**
     * Administrator repository.
     */
    private final AdministratorRepository administratorRepository;

    /**
     *
     */
    private final AdministratorConverter administratorConverter;

    /**
     *
     */
    private final OrdersConverter ordersConverter;

    /**
     * service - show all administratorsDto
     *
     * @return all administratorsDto
     */
    @Override
    public List<AdministratorDto> listAllAdministrators() {
        List<Administrator> administratorList = administratorRepository.findAll();
        return MapperConfiguration.convertList(administratorList, administratorConverter::entityToDto);
    }

    /**
     * method -  find administrator by id from db
     *
     * @param administratorId
     * @return administratorDto by id
     */
    @Override
    public AdministratorDto findAdministratorById(Integer administratorId) {
        return administratorConverter.entityToDto(administratorRepository.findById(administratorId).orElse(null));
    }

    /**
     * method - add administrator in db
     *
     * @param administratorDto
     */
    @Override
    public void addAdministrator(AdministratorDto administratorDto) {
        administratorRepository.save(administratorConverter.dtoToEntity(administratorDto));
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
     *
     * @param byAdministratorId
     * @return
     */
    @Override
    public List<OrdersDto> listAcceptedOrdersByAdministrator(Integer byAdministratorId) {
        List<Orders> ordersList = administratorRepository.getAdministratorsOrders(byAdministratorId);
        return MapperConfiguration.convertList(ordersList, ordersConverter::entityToDto);
    }

}
