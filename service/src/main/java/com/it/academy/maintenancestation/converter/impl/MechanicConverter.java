package com.it.academy.maintenancestation.converter.impl;

import com.it.academy.maintenancestation.converter.Converter;
import com.it.academy.maintenancestation.dto.MechanicDto;
import com.it.academy.maintenancestation.entity.Mechanic;
import com.it.academy.maintenancestation.entity.MechanicDetails;
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
public class MechanicConverter implements Converter<Mechanic, MechanicDto> {

    /**
     *
     */
    private final ModelMapper modelMapper;

    /**
     *
     */
    private final MechanicDetailsConverter mechanicDetailsConverter;

    /**
     * Mechanic convert to MechanicDto
     *
     * @param entity
     * @return
     */
    @Override
    public MechanicDto entityToDto(Mechanic entity) {
        MechanicDto mechanicDto = modelMapper.map(entity, MechanicDto.class);
        mechanicDto.setMechanicDetails(mechanicDetailsConverter.entityToDto(entity.getMechanicDetails()));
        return mechanicDto;
    }

    /**
     * MechanicDto convert to Mechanic
     *
     * @param dto
     * @return
     */
    @Override
    public Mechanic dtoToEntity(MechanicDto dto) {
        Mechanic mechanic = modelMapper.map(dto, Mechanic.class);
        MechanicDetails mechanicDetails = mechanicDetailsConverter.dtoToEntity(dto.getMechanicDetails());
        mechanic.setMechanicDetails(mechanicDetails);
        mechanicDetails.setMechanic(mechanic);
        mechanicDetails.setMechanicDetailsId(mechanic.getMechanicId());
        return mechanic;
    }
}
