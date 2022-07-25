package com.it.academy.maintenancestation.service.impl;

import com.it.academy.maintenancestation.converter.MapperConfiguration;
import com.it.academy.maintenancestation.converter.impl.CarConverter;
import com.it.academy.maintenancestation.dto.CarDetailsDto;
import com.it.academy.maintenancestation.dto.CarDto;
import com.it.academy.maintenancestation.entity.Car;
import com.it.academy.maintenancestation.entity.CarDetails;
import com.it.academy.maintenancestation.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.it.academy.maintenancestation.service.СarService;

import java.util.List;

/**
 * CarService
 *
 * @author Alexander Grigorovich
 * @version 12.07.2022
 */

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements СarService {

    /**
     * Car repository.
     */
    private final CarRepository carRepository;

    /**
     *
     */
    private final CarConverter carConverter;

    /**
     * service - show all carsDto
     *
     * @return all carsDto
     */
    @Override
    public List<CarDto> listAllCars() {
        List<Car> carsList = carRepository.findAll();
        return MapperConfiguration.convertList(carsList, carConverter::entityToDto);
    }

    /**
     * method -  find car by id from db
     *
     * @param carId
     * @return carDto by id
     */
    @Override
    public CarDto findCarById(Integer carId) {
        return carConverter.entityToDto(carRepository.findById(carId).orElse(null));
    }

    /**
     * method - add car in db
     *
     * @param carDto
     */
    @Override
    public void addCar(CarDto carDto) {
        carRepository.save(carConverter.dtoToEntity(carDto));
    }

    /**
     * method - delete car from db by id
     *
     * @param carId
     */
    @Override
    public void deleteCarById(Integer carId) {
        carRepository.deleteById(carId);
    }

}

