package com.it.academy.maintenancestation.converter.impl;

import com.it.academy.maintenancestation.converter.Converter;
import com.it.academy.maintenancestation.dto.AdministratorDetailsDto;
import com.it.academy.maintenancestation.entity.AdministratorDetails;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdministratorDetailsConverter
        implements Converter<AdministratorDetails, AdministratorDetailsDto> {

       private final ModelMapper modelMapper;

       @Override
       public AdministratorDetailsDto entityToDto(AdministratorDetails entity) {
              AdministratorDetailsDto administratorDetailsDto = modelMapper.map(entity, AdministratorDetailsDto.class);
              return administratorDetailsDto;
       }


       @Override
       public AdministratorDetails dtoToEntity(AdministratorDetailsDto dto) {
              AdministratorDetails administratorDetails = modelMapper.map(dto, AdministratorDetails.class);
              return administratorDetails;
       }




}
