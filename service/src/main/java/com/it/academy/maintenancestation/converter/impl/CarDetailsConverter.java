package com.it.academy.maintenancestation.converter.impl;

import com.it.academy.maintenancestation.dto.CarDetailsDto;
import com.it.academy.maintenancestation.entity.CarDetails;
import org.springframework.stereotype.Component;

@Component
public class CarDetailsConverter
        extends AbstractMapper<CarDetails, CarDetailsDto> {
    public CarDetailsConverter() {
        super(CarDetails.class, CarDetailsDto.class);
    }
}
