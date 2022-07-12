package com.it.academy.maintenancestation.converter.impl;

import com.it.academy.maintenancestation.dto.ClientDetailsDto;
import com.it.academy.maintenancestation.entity.ClientDetails;
import org.springframework.stereotype.Component;

@Component
public class ClientDetailsConverter
        extends AbstractMapper<ClientDetails, ClientDetailsDto> {
    public ClientDetailsConverter() {
        super(ClientDetails.class, ClientDetailsDto.class);
    }
}
