package com.it.academy.maintenancestation.converter.impl;


import com.it.academy.maintenancestation.converter.Converter;
import com.it.academy.maintenancestation.dto.ClientDto;
import com.it.academy.maintenancestation.entity.Client;
import com.it.academy.maintenancestation.entity.ClientDetails;
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
public class ClientConverter implements Converter<Client, ClientDto> {
    /**
     *
     */
    private final ModelMapper modelMapper;

    /**
     *
     */
    private final ClientDetailsConverter clientDetailsConverter;

    /**
     *
     */
    private final CarConverter carConverter;


    /**
     * Client convert to ClientDto
     *
     * @param entity
     * @return
     */
    @Override
    public ClientDto entityToDto(Client entity) {
        ClientDto clientDto = modelMapper.map(entity, ClientDto.class);
        clientDto.setClientDetails(clientDetailsConverter.entityToDto(entity.getClientDetails()));
        return clientDto;
    }

    /**
     * ClientDto convert to Client
     *
     * @param dto
     * @return
     */
    @Override
    public Client dtoToEntity(ClientDto dto) {
        Client client = modelMapper.map(dto, Client.class);
        ClientDetails clientDetails = clientDetailsConverter.dtoToEntity(dto.getClientDetails());
        client.setClientDetails(clientDetails);
        clientDetails.setClient(client);
        clientDetails.setClientDetailsId(client.getClientId());
        return client;
    }
}
