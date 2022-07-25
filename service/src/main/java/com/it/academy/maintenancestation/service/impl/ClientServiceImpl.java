package com.it.academy.maintenancestation.service.impl;

import com.it.academy.maintenancestation.converter.MapperConfiguration;
import com.it.academy.maintenancestation.converter.impl.CarConverter;
import com.it.academy.maintenancestation.converter.impl.ClientConverter;
import com.it.academy.maintenancestation.dto.*;
import com.it.academy.maintenancestation.entity.*;
import com.it.academy.maintenancestation.repository.ClientRepository;
import com.it.academy.maintenancestation.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * ClientService
 *
 * @author Alexander Grigorovich
 * @version 12.07.2022
 */

@Service
@RequiredArgsConstructor
public class ClientServiceImpl
        implements ClientService {

    /**
     * Client repository.
     */
    private final ClientRepository clientRepository;

    /**
     *
     */
    private final ClientConverter clientConverter;

    /**
     *
     */
    private final CarConverter carConverter;

    /**
     * service - show all clientsDto
     *
     * @return all clientsDto
     */
    @Override
    public List<ClientDto> listAllClients() {
        List<Client> clientList = clientRepository.findAll();
        return MapperConfiguration.convertList(clientList, clientConverter::entityToDto);
    }

    /**
     * method -  find client by id from db
     *
     * @param clientId
     * @return clientDto by id
     */
    @Override
    public ClientDto findClientById(Integer clientId) {
        return clientConverter.entityToDto(clientRepository.findById(clientId).orElse(null));
    }

    /**
     * method - add client in db
     *
     * @param clientDto
     */
    @Override
    public void addClient(ClientDto clientDto) {
        clientRepository.save(clientConverter.dtoToEntity(clientDto));
    }

    /**
     * method - delete client from db by id
     *
     * @param clientId
     */
    @Override
    public void deleteClientById(Integer clientId) {
        clientRepository.deleteById(clientId);
    }

    /**
     * method - show list own cars
     *
     * @param byClientId
     * @return list
     */
    @Override
    public List<CarDto> listOwnCars(Integer byClientId) {
        List<Car> carList = clientRepository.getMyCars(byClientId);
        return carList.stream()
                .map(carConverter::entityToDto)
                .collect(Collectors.toList());
    }

}

