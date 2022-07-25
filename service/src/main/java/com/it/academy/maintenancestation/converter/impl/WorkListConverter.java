package com.it.academy.maintenancestation.converter.impl;

import com.it.academy.maintenancestation.converter.Converter;
import com.it.academy.maintenancestation.dto.WorkListDto;
import com.it.academy.maintenancestation.entity.WorkList;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WorkListConverter implements Converter<WorkList, WorkListDto> {

    private final ModelMapper modelMapper;

    @Override
    public WorkListDto entityToDto(WorkList entity) {
        WorkListDto workListDto = modelMapper.map(entity, WorkListDto.class);
        return workListDto;
    }

    @Override
    public WorkList dtoToEntity(WorkListDto dto) {
        WorkList workList = modelMapper.map(dto, WorkList.class);
        return workList;
    }
}
