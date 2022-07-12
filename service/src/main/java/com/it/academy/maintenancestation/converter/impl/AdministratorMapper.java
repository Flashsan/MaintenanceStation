package com.it.academy.maintenancestation.converter.impl;

import com.it.academy.maintenancestation.dto.AdministratorDto;
import com.it.academy.maintenancestation.entity.Administrator;
import org.springframework.stereotype.Component;

@Component
public class AdministratorMapper
        extends AbstractMapper<Administrator, AdministratorDto> {

    public AdministratorMapper() {
        super(Administrator.class, AdministratorDto.class);
    }
}
