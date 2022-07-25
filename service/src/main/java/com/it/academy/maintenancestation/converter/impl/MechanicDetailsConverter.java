package com.it.academy.maintenancestation.converter.impl;

import com.it.academy.maintenancestation.converter.Converter;
import com.it.academy.maintenancestation.dto.ClientDetailsDto;
import com.it.academy.maintenancestation.dto.MechanicDetailsDto;
import com.it.academy.maintenancestation.entity.ClientDetails;
import com.it.academy.maintenancestation.entity.MechanicDetails;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MechanicDetailsConverter implements Converter<MechanicDetails, MechanicDetailsDto> {

    private final ModelMapper modelMapper;

    @Override
    public MechanicDetailsDto entityToDto(MechanicDetails entity) {
        MechanicDetailsDto mechanicDetailsDto = modelMapper.map(entity, MechanicDetailsDto.class);
        return mechanicDetailsDto;
    }

    @Override
    public MechanicDetails dtoToEntity(MechanicDetailsDto dto) {
        MechanicDetails mechanicDetails = modelMapper.map(dto, MechanicDetails.class);
        return mechanicDetails;
    }
}
