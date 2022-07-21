package com.it.academy.maintenancestation.service.impl;

import com.it.academy.maintenancestation.converter.MapperConfiguration;
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

    ModelMapper modelMapper = new ModelMapper();

    /**
     * Client repository.
     */
    private final ClientRepository clientRepository;

    /**
     * service - show all clientsDto
     *
     * @return all clientsDto
     */
    @Override
    public List<ClientDto> listAllClients() {
        List<Client> clientList = clientRepository.findAll();
        return MapperConfiguration.convertList(clientList, this::convertToClientDto);
    }

    /**
     * method -  find client by id from db
     *
     * @param clientId
     * @return clientDto by id
     */
    @Override
    public ClientDto findClientById(Integer clientId) {
        return convertToClientDto(clientRepository.findById(clientId).orElse(null));
    }

    /**
     * method - add client in db
     *
     * @param clientDto
     */
    @Override
    public void addClient(ClientDto clientDto) {
        clientRepository.save(convertDtoToEntityClient(clientDto));

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
                .map(this::convertToCarDto)
                .collect(Collectors.toList());
    }

    //entity to dto
    public CarDto convertToCarDto(Car car) {
        CarDto carDto = modelMapper.map(car, CarDto.class);
        carDto.setCarDetails(convertToCarDetailsDto(car.getCarDetails()));
        return carDto;
    }

    public CarDetailsDto convertToCarDetailsDto(CarDetails carDetails) {
        CarDetailsDto carDetailsDto = modelMapper.map(carDetails, CarDetailsDto.class);
        return carDetailsDto;
    }
    //end entity to dto



    //entity to dto
    public ClientDto convertToClientDto(Client client) {
        ClientDto clientDto = modelMapper.map(client, ClientDto.class);
        clientDto.setClientDetails(convertToClientDetailsDto(client.getClientDetails()));
        return clientDto;
    }

    public ClientDetailsDto convertToClientDetailsDto(ClientDetails clientDetails) {
        ClientDetailsDto clientDetailsDto = modelMapper.map(clientDetails, ClientDetailsDto.class);
        return clientDetailsDto;
    }
    //end entity to dto

    //dto to entity
    public Client convertDtoToEntityClient(ClientDto clientDto) {
        Client client = modelMapper.map(clientDto, Client.class);
        ClientDetails clientDetails = convertDtoToEntityClientDetails(clientDto.getClientDetails());
        client.setClientDetails(clientDetails);
        clientDetails.setClient(client);
        clientDetails.setClientDetailsId(client.getClientId());
        return client;
    }

    public ClientDetails convertDtoToEntityClientDetails(ClientDetailsDto clientDetailsDto) {
        ClientDetails clientDetails = modelMapper.map(clientDetailsDto, ClientDetails.class);
        return clientDetails;
    }
    //end dto to entity

}

