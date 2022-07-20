package com.it.academy.maintenancestation.controller;


import com.it.academy.maintenancestation.dto.CarDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.it.academy.maintenancestation.service.СarService;

/**
 * CarController
 *
 * @author Alexander Grigorovich
 * @version 12.07.2022
 */

@Controller
@RequestMapping("/car")
@RequiredArgsConstructor
public class CarController {

    /**
     * Constant(CarController)
     */
    public static final String CAR = "car";
    public static final String CAR_DTO_LIST = "carDtoList";
    public static final String CAR_DTO = "carDto";
    public static final String CAR_ADD_EDIT = "carAddEdit";
    public static final String REDIRECT_CAR = "redirect:/car/";
    public static final String ID = "id";
    /**
     *
     */
    private final СarService carService;

    /**
     *
     * @param model
     * @return
     */
    @GetMapping("/")
    public String listCars(Model model) {
        model.addAttribute(CAR_DTO_LIST, carService.listAllCars());
        return CAR;
    }

    /**
     *
     * @param model
     * @param carDto
     * @return
     */
    @GetMapping("/saveCar")
    public String showCreateEditFormNewCar(Model model,
                                           CarDto carDto) {
        model.addAttribute(CAR_DTO, carDto);
        return CAR_ADD_EDIT;
    }

    /**
     *
     * @param carDto
     * @return
     */
    @PostMapping("/saveCar")
    public String saveCar(@ModelAttribute(CAR_DTO)
                                  CarDto carDto) {
        carService.addCar(carDto);
        return REDIRECT_CAR;
    }

    /**
     *
     * @param carId
     * @param model
     * @return
     */
    @GetMapping("/editCar/{id}")
    public String showEditFormCar(@PathVariable(name = ID) Integer carId,
                                            Model model) {
        CarDto carDto = carService.findCarById(carId);
        model.addAttribute(CAR_DTO, carService.findCarById(carId));
        return CAR_ADD_EDIT;
    }

    /**
     *
     * @param carId
     * @return
     */
    @GetMapping("/deleteCar/{id}")
    public String deleteCar(@PathVariable(name = ID) Integer carId) {
        carService.deleteCarById(carId);
        return REDIRECT_CAR;
    }
}


