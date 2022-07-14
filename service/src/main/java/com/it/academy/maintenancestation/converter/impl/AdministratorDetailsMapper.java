package com.it.academy.maintenancestation.converter.impl;

import com.it.academy.maintenancestation.dto.AdministratorDetailsDto;
import com.it.academy.maintenancestation.dto.AdministratorDto;
import com.it.academy.maintenancestation.entity.Administrator;
import com.it.academy.maintenancestation.entity.AdministratorDetails;
import org.springframework.stereotype.Component;

@Component
public class AdministratorDetailsMapper
        extends AbstractMapper<AdministratorDetails, AdministratorDetailsDto> {

    public AdministratorDetailsMapper() {
        super(AdministratorDetails.class, AdministratorDetailsDto.class);
    }
}
