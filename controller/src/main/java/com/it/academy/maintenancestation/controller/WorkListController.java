package com.it.academy.maintenancestation.controller;

import com.it.academy.maintenancestation.dto.MechanicDto;
import com.it.academy.maintenancestation.dto.WorkListDto;
import com.it.academy.maintenancestation.service.MechanicService;
import com.it.academy.maintenancestation.service.WorkListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/workList")
//@SessionAttributes("workList")
public class WorkListController {

    public static final String WORK_LIST_DTOS_LIST = "workListDtosList";
    public static final String WORK_LIST = "workList";
    public static final String REDIRECT_TO_WORK_LIST = "redirect:/workList/";


    @Autowired
    private WorkListService workListService;

    @Autowired
    private MechanicService mechanicService;

    @GetMapping("/")
    public String workList(@RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
                           @RequestParam(value = "size", required = false, defaultValue = "5") int size, Model model) {
        model.addAttribute(WORK_LIST_DTOS_LIST, workListService.getPage(pageNumber, size));
        return WORK_LIST;
    }

//    @GetMapping("/")
//    public String listWorkList(Model model) {
//        model.addAttribute(WORK_LIST_DTOS_LIST, workListService.listAllWorkList());
//        return WORK_LIST;
//    }

    @GetMapping("/addFormWorkList")
    public String showCreateNewWorkListForm(Model model) {
        List<MechanicDto> mechanicList = mechanicService.listAllMechanics();
        model.addAttribute("mechanicListDtosList", mechanicList);
        model.addAttribute("workListDto", new WorkListDto());
        return "workListAddEdit";
    }


    @PostMapping(value = "/addWorkList")
    public String addWorkList(@ModelAttribute("workListDto") @Valid WorkListDto workListDto) {
        workListService.addWorkList(workListDto);
        return REDIRECT_TO_WORK_LIST;
    }

    @RequestMapping("/editWorkList/{id}")
    public String editWorkList(@PathVariable("id") Integer id, Model model) {
        WorkListDto workListDto = workListService.findById(id);
        model.addAttribute("workListDto", workListDto);
        List<MechanicDto> mechanicList = mechanicService.listAllMechanics();
        model.addAttribute("mechanicListDtosList", mechanicList);
        return "workListAddEdit";
    }

    @RequestMapping(value = "/deleteWorkList/{id}")
    public String deleteWorkList(@PathVariable("id") Integer workListId) {
        workListService.deleteWorkListById(workListId);
        return REDIRECT_TO_WORK_LIST;
    }

}


