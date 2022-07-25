package com.it.academy.maintenancestation.converter.impl;

import com.it.academy.maintenancestation.converter.Converter;
import com.it.academy.maintenancestation.dto.CarDto;
import com.it.academy.maintenancestation.entity.Car;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CarConverter implements Converter<Car, CarDto> {

    private final ModelMapper modelMapper;

    @Override
    public CarDto entityToDto(Car entity) {
        CarDto carDto = modelMapper.map(entity, CarDto.class);
        return carDto;
    }

    @Override
    public Car dtoToEntity(CarDto dto) {
        Car car = modelMapper.map(dto, Car.class);
        return car;
    }


}
