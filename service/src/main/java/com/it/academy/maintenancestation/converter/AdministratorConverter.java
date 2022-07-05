package com.it.academy.maintenancestation.converter;


import com.it.academy.maintenancestation.dto.AdministratorDto;
import com.it.academy.maintenancestation.entity.Administrator;
import org.springframework.stereotype.Component;

@Component
public class AdministratorConverter
        extends AbstractConverter<Administrator, AdministratorDto> {
    public AdministratorConverter() {
        super(Administrator.class, AdministratorDto.class);
    }
}
