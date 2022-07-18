package com.it.academy.maintenancestation.controller;


import com.it.academy.maintenancestation.dto.CarDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.it.academy.maintenancestation.service.СarService;

@Controller
@RequestMapping("/car")
@RequiredArgsConstructor
public class CarController {

    private final СarService carService;

    @GetMapping("/")
    public String listCars(Model model) {
        model.addAttribute("carDtoList", carService.listAllCars());
        return "car";
    }

    @GetMapping("/saveCar")
    public String showCreateEditFormNewCar(Model model,
                                           CarDto carDto) {
        model.addAttribute("carDto", carDto);
        return "carAddEdit";
    }

    @PostMapping("/saveCar")
    public String saveCar(@ModelAttribute("carDto")
                                  CarDto carDto) {
        carService.addCar(carDto);
        return "redirect:/car/";
    }

    @GetMapping("/editCar/{id}")
    public String showEditFormCar(@PathVariable(name = "id") Integer carId,
                                            Model model) {
        CarDto carDto = carService.findCarById(carId);
        model.addAttribute("carDto", carService.findCarById(carId));
        return "carAddEdit";
    }

    @GetMapping("/deleteCar/{id}")
    public String deleteCar(@PathVariable(name = "id") Integer carId) {
        carService.deleteCarById(carId);
        return "redirect:/car/";
    }
}


