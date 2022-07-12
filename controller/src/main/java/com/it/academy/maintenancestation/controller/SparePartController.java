package com.it.academy.maintenancestation.controller;

import com.it.academy.maintenancestation.dto.MechanicDto;
import com.it.academy.maintenancestation.dto.WorkListDto;
import com.it.academy.maintenancestation.service.MechanicService;
import com.it.academy.maintenancestation.service.SparePartService;
import com.it.academy.maintenancestation.service.WorkListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/sparePart")
//@SessionAttributes("workList")
public class SparePartController {

    @Autowired
    private SparePartService sparePartService;

    @GetMapping("/")
    public String listSparePart(Model model) {
        model.addAttribute("sparePartDtosList", sparePartService.listAllSparePart());
        return "sparePart";
    }
//
//    @GetMapping("/addFormWorkList")
//    public String showCreateNewWorkListForm(Model model) {
//        List<MechanicDto> mechanicList = mechanicService.listAllMechanics();
//        model.addAttribute("mechanicListDtosList", mechanicList);
//        model.addAttribute("workListDto", new WorkListDto());
//        return "workListAddEdit";
//    }
//
//
//    @PostMapping(value = "/addWorkList")
//    public String addWorkList(@ModelAttribute("workListDto") @Valid WorkListDto workListDto) {
//        workListService.addWorkList(workListDto);
//        return REDIRECT_TO_WORK_LIST;
//    }
//
//    @RequestMapping("/editWorkList/{id}")
//    public String editWorkList(@PathVariable("id") Integer id, Model model) {
//        WorkListDto workListDto = workListService.findById(id);
//        model.addAttribute("workListDto", workListDto);
//        List<MechanicDto> mechanicList = mechanicService.listAllMechanics();
//        model.addAttribute("mechanicListDtosList", mechanicList);
//        return "workListAddEdit";
//    }
//
//    @RequestMapping(value = "/deleteWorkList/{id}")
//    public String deleteWorkList(@PathVariable("id") Integer workListId) {
//        workListService.deleteWorkListById(workListId);
//        return REDIRECT_TO_WORK_LIST;
//    }

}


