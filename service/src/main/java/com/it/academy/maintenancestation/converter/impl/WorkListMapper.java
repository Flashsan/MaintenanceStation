package com.it.academy.maintenancestation.converter.impl;

import com.it.academy.maintenancestation.dto.SparePartDto;
import com.it.academy.maintenancestation.dto.WorkListDto;
import com.it.academy.maintenancestation.entity.WorkList;
import com.it.academy.maintenancestation.repository.SparePartRepository;
import org.modelmapper.Converter;
import org.modelmapper.TypeToken;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.List;

@Component
public class WorkListMapper{
//        extends AbstractMapper<WorkList, WorkListDto> {
//
//    public WorkListMapper(SparePartRepository sparePartRepository) {
//        super(WorkList.class, WorkListDto.class);
//    }
//
//
//    @Override
//    public WorkList dtoToEntity(WorkListDto dto) {
//        return null;
//    }
//
//    @Override
//    public WorkListDto entityToDto(WorkList entity) {
//        return null;
//    }
}
