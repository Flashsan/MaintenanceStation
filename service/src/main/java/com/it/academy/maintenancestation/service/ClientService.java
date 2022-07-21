package com.it.academy.maintenancestation.service;

import com.it.academy.maintenancestation.dto.CarDto;
import com.it.academy.maintenancestation.dto.ClientDto;

import java.util.List;

/**
 * interface ClientService
 *
 * @author Alexander Grigorovich
 * @version 12.07.2022
 */

public interface ClientService {
    /**
     * service - show all clients
     *
     * @return all clients
     */
    List<ClientDto> listAllClients();

    /**
     * service - find client by id
     *
     * @param clientId
     * @return client by id
     */
    ClientDto findClientById(Integer clientId);

    /**
     * service - create client
     *
     * @param clientDto
     */
    void addClient(ClientDto clientDto);

    /**
     * service - delete client by id
     *
     * @param clientId
     */
    void deleteClientById(Integer clientId);

    /**
     * service - show own cars
     *
     * @return orders which administrator accepted.
     */
    public List<CarDto> listOwnCars(Integer byClientId);
}