package com.it.academy.maintenancestation.converter.impl;

import com.it.academy.maintenancestation.converter.Converter;
import com.it.academy.maintenancestation.dto.ClientDetailsDto;
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
public class ClientDetailsConverter implements Converter<ClientDetails, ClientDetailsDto> {

    /**
     *
     */
    private final ModelMapper modelMapper;

    /**
     * ClientDetails convert to ClientDetailsDto
     * @param entity
     * @return
     */
    @Override
    public ClientDetailsDto entityToDto(ClientDetails entity) {
        ClientDetailsDto clientDetailsDto = modelMapper.map(entity, ClientDetailsDto.class);
        return clientDetailsDto;
    }

    /**
     * ClientDetailsDto convert to ClientDetails
     * @param dto
     * @return
     */
    @Override
    public ClientDetails dtoToEntity(ClientDetailsDto dto) {
        ClientDetails clientDetails = modelMapper.map(dto, ClientDetails.class);
        return clientDetails;
    }

}
