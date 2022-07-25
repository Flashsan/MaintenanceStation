package com.it.academy.maintenancestation.converter.impl;

import com.it.academy.maintenancestation.converter.Converter;
import com.it.academy.maintenancestation.dto.CarDto;
import com.it.academy.maintenancestation.entity.Car;
import com.it.academy.maintenancestation.entity.CarDetails;
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
public class CarConverter implements Converter<Car, CarDto> {

    /**
     *
     */
    private final ModelMapper modelMapper;

    /**
     *
     */
    private final CarDetailsConverter carDetailsConverter;

    /**
     * Car convert to carDto
     *
     * @param entity
     * @return
     */
    @Override
    public CarDto entityToDto(Car entity) {
        CarDto carDto = modelMapper.map(entity, CarDto.class);
        carDto.setCarDetails(carDetailsConverter.entityToDto(entity.getCarDetails()));
        return carDto;
    }

    /**
     * CarDto convert to Car
     *
     * @param dto
     * @return
     */
    @Override
    public Car dtoToEntity(CarDto dto) {
        Car car = modelMapper.map(dto, Car.class);
        CarDetails carDetails = carDetailsConverter.dtoToEntity(dto.getCarDetails());
        car.setCarDetails(carDetails);
        carDetails.setCar(car);
        carDetails.setCarDetailsId(car.getCarId());
        return car;
    }


}
