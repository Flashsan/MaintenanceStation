package com.it.academy.maintenancestation.service.impl;

import com.it.academy.maintenancestation.converter.MapperConfiguration;
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

    ModelMapper modelMapper = new ModelMapper();

    /**
     * Car repository.
     */
    private final CarRepository carRepository;

    /**
     * service - show all carsDto
     *
     * @return all carsDto
     */
    @Override
    public List<CarDto> listAllCars() {
        List<Car> carsList = carRepository.findAll();
        return MapperConfiguration.convertList(carsList, this::convertToCarDto);
    }

    /**
     * method -  find car by id from db
     *
     * @param carId
     * @return carDto by id
     */
    @Override
    public CarDto findCarById(Integer carId) {
        return convertToCarDto(carRepository.findById(carId).orElse(null));

    }

    /**
     * method - add car in db
     *
     * @param carDto
     */
    @Override
    public void addCar(CarDto carDto) {
        carRepository.save(convertDtoToEntityCar(carDto));
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


    //entity to dto
    public CarDto convertToCarDto(Car car) {
        CarDto carDto = modelMapper.map(car, CarDto.class);
        carDto.setCarDetails(convertToCarDetailsDto(car.getCarDetails()));
        return carDto;
    }

    public CarDetailsDto convertToCarDetailsDto(CarDetails carDetails) {
        CarDetailsDto carDetailsDto = modelMapper.map(carDetails, CarDetailsDto.class);
        return carDetailsDto;
    }
    //end entity to dto

    //dto to entity
    public Car convertDtoToEntityCar(CarDto carDto) {
        Car car = modelMapper.map(carDto, Car.class);
        CarDetails carDetails = convertDtoToEntityCarDetails(carDto.getCarDetails());
        car.setCarDetails(carDetails);
        carDetails.setCar(car);
        carDetails.setCarDetailsId(car.getCarId());
        return car;
    }

    public CarDetails convertDtoToEntityCarDetails(CarDetailsDto carDetailsDto) {
        CarDetails carDetails = modelMapper.map(carDetailsDto, CarDetails.class);
        return carDetails;
    }
    //end dto to entity

}

