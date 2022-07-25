package com.it.academy.maintenancestation.converter.impl;

import com.it.academy.maintenancestation.converter.Converter;
import com.it.academy.maintenancestation.dto.MechanicDto;
import com.it.academy.maintenancestation.entity.Mechanic;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MechanicConverter implements Converter<Mechanic, MechanicDto> {

    private final ModelMapper modelMapper;

    @Override
    public MechanicDto entityToDto(Mechanic entity) {
        MechanicDto mechanicDto = modelMapper.map(entity, MechanicDto.class);
        return mechanicDto;
    }

    @Override
    public Mechanic dtoToEntity(MechanicDto dto) {
        Mechanic mechanic = modelMapper.map(dto, Mechanic.class);
        return mechanic;
    }
}
