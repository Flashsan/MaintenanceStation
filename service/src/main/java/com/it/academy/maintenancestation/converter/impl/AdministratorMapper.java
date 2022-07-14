package com.it.academy.maintenancestation.converter.impl;

import com.it.academy.maintenancestation.dto.AdministratorDto;
import com.it.academy.maintenancestation.entity.Administrator;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class AdministratorMapper
        extends AbstractMapper<Administrator, AdministratorDto> {

    public AdministratorMapper() {
        super(Administrator.class, AdministratorDto.class);
    }

//    @Override
//    public E toEntity(D dto) {
//        return Objects.isNull(dto) ? null : modelMapper.map(dto, entityClass);
//    }
//
//    @Override
//    public D toDto(E entity) {
//        return Objects.isNull(entity) ? null : modelMapper.map(entity, dtoClass);
//    }

}
