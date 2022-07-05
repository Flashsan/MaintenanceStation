package com.it.academy.maintenancestation.converter;

import com.it.academy.maintenancestation.dto.MechanicDto;
import com.it.academy.maintenancestation.entity.Mechanic;
import org.springframework.stereotype.Component;

@Component
public class MechanicConverter
        extends AbstractConverter<Mechanic, MechanicDto> {
    public MechanicConverter() {
        super(Mechanic.class, MechanicDto.class);
    }
}
