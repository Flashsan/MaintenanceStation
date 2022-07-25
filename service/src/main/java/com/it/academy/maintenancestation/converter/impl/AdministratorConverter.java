package com.it.academy.maintenancestation.converter.impl;


import com.it.academy.maintenancestation.converter.Converter;
import com.it.academy.maintenancestation.dto.AdministratorDto;
import com.it.academy.maintenancestation.entity.Administrator;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdministratorConverter implements Converter<Administrator, AdministratorDto> {

    private final ModelMapper modelMapper;

    @Override
    public AdministratorDto entityToDto(Administrator entity) {
        AdministratorDto administratorDto = modelMapper.map(entity, AdministratorDto.class);
        return administratorDto;
    }

    @Override
    public Administrator dtoToEntity(AdministratorDto dto) {
        Administrator administrator = modelMapper.map(dto, Administrator.class);
        return administrator;
    }


}
