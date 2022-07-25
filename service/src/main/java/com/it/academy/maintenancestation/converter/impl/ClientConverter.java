package com.it.academy.maintenancestation.converter.impl;


import com.it.academy.maintenancestation.converter.Converter;
import com.it.academy.maintenancestation.dto.ClientDto;
import com.it.academy.maintenancestation.entity.Client;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClientConverter implements Converter<Client, ClientDto> {

    private final ModelMapper modelMapper;

    @Override
    public ClientDto entityToDto(Client entity) {
        ClientDto clientDto = modelMapper.map(entity, ClientDto.class);
        return clientDto;
    }

    @Override
    public Client dtoToEntity(ClientDto dto) {
        Client client = modelMapper.map(dto, Client.class);
        return client;
    }
}
