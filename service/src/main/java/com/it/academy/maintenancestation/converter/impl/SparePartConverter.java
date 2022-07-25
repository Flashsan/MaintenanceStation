package com.it.academy.maintenancestation.converter.impl;

import com.it.academy.maintenancestation.converter.Converter;
import com.it.academy.maintenancestation.dto.SparePartDto;
import com.it.academy.maintenancestation.entity.SparePart;
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
public class SparePartConverter implements Converter<SparePart, SparePartDto> {

    /**
     *
     */
    private final ModelMapper modelMapper;

    /**
     * SparePart convert to SparePartDto
     * @param entity
     * @return
     */
    @Override
    public SparePartDto entityToDto(SparePart entity) {
        SparePartDto sparePartDto = modelMapper.map(entity, SparePartDto.class);
        return sparePartDto;
    }

    /**
     * SparePartDto convert to SparePart
     * @param dto
     * @return
     */
    @Override
    public SparePart dtoToEntity(SparePartDto dto) {
        SparePart sparePart = modelMapper.map(dto, SparePart.class);
        return sparePart;
    }


}
