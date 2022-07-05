package com.it.academy.maintenancestation.controller;


import com.it.academy.maintenancestation.dto.MechanicDto;
import com.it.academy.maintenancestation.dto.WorkListDto;
import com.it.academy.maintenancestation.entity.Mechanic;
import com.it.academy.maintenancestation.repository.MechanicRepository;
import com.it.academy.maintenancestation.service.MechanicService;
import com.it.academy.maintenancestation.service.WorkListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/workList")
public class WorkListController {

    @Autowired
    private WorkListService workListService;

    @GetMapping("/listWorkList")
    public String listWorkList(Model model) {
        model.addAttribute("workListDtoList", workListService.listAllWorkList());
        return "workList";
    }
}
//    @GetMapping("/newWorkList")
//    public String showCreateNewWorkListForm(Model model) {
//        List<MechanicDto> mechanicList = mechanicService.listAllMechanics();
//        model.addAttribute("mechanicList", mechanicList);
//        model.addAttribute("workListDto", new WorkListDto());
//        return "workList_form";
//    }
//
//    @PostMapping("/save")
//    public String saveWorkList(WorkListDto workListDto) {
//        workListService.save(workListDto);
//        return "redirect:/workList";
//    }
//
//    @GetMapping("/edit/{id}")
//    public String showEditWorkListForm(@PathVariable("id") Integer id, Model model) {
//        MechanicDto mechanicDto = workListService.findById(id).get();
//        model.addAttribute("mechanicDto", mechanicDto);
//        List<MechanicDto> mechanicList = mechanicService.listAllMechanics();
//        model.addAttribute("mechanicList", mechanicList);
//        return "workList_form";
//    }
//
//    @GetMapping("/delete/{id}")
//    public String showEditWorkListForm(@PathVariable("id") Integer id, Model model) {
//        workListService.delete(id);
//        return "redirect:/workList";
//    }
//


