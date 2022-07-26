package com.it.academy.maintenancestation.converter.impl;

import com.it.academy.maintenancestation.converter.Converter;
import com.it.academy.maintenancestation.dto.MechanicDto;
import com.it.academy.maintenancestation.dto.SparePartDto;
import com.it.academy.maintenancestation.dto.WorkListDto;
import com.it.academy.maintenancestation.entity.Mechanic;
import com.it.academy.maintenancestation.entity.SparePart;
import com.it.academy.maintenancestation.entity.WorkList;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * WorkListConverter
 *
 * @author Alexander Grigorovich
 * @version 12.07.2022
 */

@Component
@RequiredArgsConstructor
public class WorkListConverter implements Converter<WorkList, WorkListDto> {

    /**
     *
     */
    private final ModelMapper modelMapper;

    /**
     *
     */
    private final MechanicConverter mechanicConverter;

    /**
     *
     */
    private final SparePartConverter sparePartConverter;

    /**
     *
     */
    private final OrdersConverter ordersConverter;

    /**
     * WorkList convert to WorkListDto
     *
     * @param entity
     * @return
     */
    @Override
    public WorkListDto entityToDto(WorkList entity) {
        WorkListDto workListDto = modelMapper.map(entity, WorkListDto.class);
        workListDto.setOrders(ordersConverter.entityToDto(entity.getOrders()));
        return workListDto;
    }

    /**
     * WorkListDto convert to WorkList
     *
     * @param dto
     * @return
     */
    @Override
    public WorkList dtoToEntity(WorkListDto dto) {
        WorkList workList = modelMapper.map(dto, WorkList.class);

        List<MechanicDto> mechanicDto = dto.getMechanic();
        List<Mechanic> mechanics = mechanicDto.stream()
                .map(mechanicConverter::dtoToEntity)
                .collect(Collectors.toList());

        List<SparePartDto> sparePartDto = dto.getSparePart();
        List<SparePart> spareParts = sparePartDto.stream()
                .map(sparePartConverter::dtoToEntity)
                .collect(Collectors.toList());

        workList.setMechanic(mechanics);
        workList.setSparePart(spareParts);
        workList.setOrders(ordersConverter.dtoToEntity(dto.getOrders()));

        return workList;
    }
}
