package com.it.academy.maintenancestation.converter.impl;

import com.it.academy.maintenancestation.dto.CarDto;
import com.it.academy.maintenancestation.entity.Car;
import org.springframework.stereotype.Component;

@Component
public class CarConverter
        extends AbstractMapper<Car, CarDto> {
    public CarConverter() {
        super(Car.class, CarDto.class);
    }
}
