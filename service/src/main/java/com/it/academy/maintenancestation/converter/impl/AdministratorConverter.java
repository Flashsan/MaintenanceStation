package com.it.academy.maintenancestation.converter.impl;


import com.it.academy.maintenancestation.converter.Converter;
import com.it.academy.maintenancestation.dto.AdministratorDto;
import com.it.academy.maintenancestation.entity.Administrator;
import com.it.academy.maintenancestation.entity.AdministratorDetails;
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
public class AdministratorConverter implements Converter<Administrator, AdministratorDto> {

    /**
     *
     */
    private final ModelMapper modelMapper;

    /**
     *
     */
    private final AdministratorDetailsConverter administratorDetailsConverter;

    /**
     * Administrator convert to AdministratorDto
     *
     * @param entity
     * @return
     */
    @Override
    public AdministratorDto entityToDto(Administrator entity) {
        AdministratorDto administratorDto = modelMapper.map(entity, AdministratorDto.class);
        administratorDto
                .setAdministratorDetails(administratorDetailsConverter
                        .entityToDto(entity.getAdministratorDetails()));
        return administratorDto;
    }

    /**
     *AdministratorDto convert to Administrator
     * @param dto
     * @return
     */
    @Override
    public Administrator dtoToEntity(AdministratorDto dto) {
        Administrator administrator = modelMapper.map(dto, Administrator.class);
        AdministratorDetails administratorDetails = administratorDetailsConverter
                .dtoToEntity(dto.getAdministratorDetails());
        administrator.setAdministratorDetails(administratorDetails);
        administratorDetails.setAdministrator(administrator);
        administratorDetails.setAdministratorDetailsId(administrator.getAdministratorId());
        return administrator;
    }


}
