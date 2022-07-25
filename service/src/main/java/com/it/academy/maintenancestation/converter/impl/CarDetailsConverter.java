package com.it.academy.maintenancestation.converter.impl;

import com.it.academy.maintenancestation.converter.Converter;
import com.it.academy.maintenancestation.dto.CarDetailsDto;
import com.it.academy.maintenancestation.entity.CarDetails;
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
public class CarDetailsConverter implements Converter<CarDetails, CarDetailsDto> {

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
    public CarDetailsDto entityToDto(CarDetails entity) {
        CarDetailsDto carDetailsDto = modelMapper.map(entity, CarDetailsDto.class);
        return carDetailsDto;
    }

    /**
     * CarDetailsDto convert to CarDetails
     * @param dto
     * @return
     */
    @Override
    public CarDetails dtoToEntity(CarDetailsDto dto) {
        CarDetails carDetails = modelMapper.map(dto, CarDetails.class);
        return carDetails;
    }
}
