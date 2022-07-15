package com.it.academy.maintenancestation.converter.impl;

import com.it.academy.maintenancestation.dto.SparePartDto;
import com.it.academy.maintenancestation.entity.SparePart;
import com.it.academy.maintenancestation.repository.WorkListRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Objects;

@Component
public class SparePartMapper
        extends AbstractMapper<SparePart, SparePartDto> {

    private final ModelMapper mapper;
    private final WorkListRepository workListRepository;

    @Autowired
    public SparePartMapper(ModelMapper mapper, WorkListRepository workListRepository) {
        super(SparePart.class, SparePartDto.class);
        this.mapper = mapper;
        this.workListRepository = workListRepository;
    }

//


}
