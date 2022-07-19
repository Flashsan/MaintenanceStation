package com.it.academy.maintenancestation.controller;

import com.it.academy.maintenancestation.dto.AdministratorDto;
import com.it.academy.maintenancestation.dto.MechanicDto;
import com.it.academy.maintenancestation.dto.SparePartDto;
import com.it.academy.maintenancestation.dto.WorkListDto;
import com.it.academy.maintenancestation.entity.WorkList;
import com.it.academy.maintenancestation.service.MechanicService;
import com.it.academy.maintenancestation.service.SparePartService;
import com.it.academy.maintenancestation.service.WorkListService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;


@Controller
@RequestMapping("/workList")
@RequiredArgsConstructor
public class WorkListController {

//    @GetMapping("/")
//    public String workList(@RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
//                           @RequestParam(value = "size", required = false, defaultValue = "5") int size, Model model) {
//        model.addAttribute(WORK_LIST_DTOS_LIST, workListService.getPage(pageNumber, size));
//        return WORK_LIST;
//    }

    private final WorkListService workListService;
    private final MechanicService mechanicService;

    @GetMapping("/")
    public String listWorkList(Model model) {
        model.addAttribute("workListDtosList", workListService.listAllWorkList());
        return "workList";
    }

    @GetMapping("/saveWorkList")
    public String showCreateFormNewWorkList(Model model,
                                                WorkListDto workListDto) {
        List<MechanicDto> mechanicDtoList = mechanicService.listAllMechanics();
        model.addAttribute("mechanicDtoList", mechanicDtoList);
        model.addAttribute("workListDto", new WorkList());
        return "workListAddEdit";
    }

    @PostMapping(value = "/saveWorkList")
    public String saveWorkList(@ModelAttribute("workListDto") WorkListDto workListDto) {
        workListService.addWorkList(workListDto);
        return "redirect:/workList/";
    }

    @GetMapping("/editWorkList/{id}")
    public String showEditFormWorkList(@PathVariable(name = "id") Integer workListId,
                                            Model model) {
        WorkListDto workList = workListService.findWorkListById(workListId);
        model.addAttribute("workListDto", workListService.findWorkListById(workListId));
        return "workListAddEdit";
    }

    @GetMapping(value = "/deleteWorkList/{id}")
    public String deleteWorkList(@PathVariable("id") Integer workListId) {
        workListService.deleteWorkListById(workListId);
        return "redirect:/workList/";
    }

}


