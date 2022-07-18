package com.it.academy.maintenancestation.service;

import com.it.academy.maintenancestation.dto.CarDto;

import java.util.List;

/**
 * interface CarService
 *
 * @author Alexander Grigorovich
 * @version 12.07.2022
 */

public interface СarService {

    /**
     * service - show all cars
     *
     * @return all cars
     */
    List<CarDto> listAllCars();

    /**
     * service - find cars by id
     *
     * @param carId
     * @return car by id
     */
    CarDto findCarById(Integer carId);

    /**
     * service - create car
     *
     * @param carDto
     */
    void addCar(CarDto carDto);

    /**
     * service - delete car by id
     *
     * @param carId
     */
    void deleteCarById(Integer carId);

}