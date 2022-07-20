package com.it.academy.maintenancestation.controller;

import com.it.academy.maintenancestation.dto.MechanicDto;
import com.it.academy.maintenancestation.dto.SparePartDto;
import com.it.academy.maintenancestation.dto.WorkListDto;
import com.it.academy.maintenancestation.service.MechanicService;
import com.it.academy.maintenancestation.service.SparePartService;
import com.it.academy.maintenancestation.service.WorkListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * WorkListController
 *
 * @author Alexander Grigorovich
 * @version 12.07.2022
 */

@Controller
@RequestMapping("/workList")
@RequiredArgsConstructor
public class WorkListController {
    /**
     * Constant(WorkListController)
     */
    public static final String REDIRECT_WORK_LIST = "redirect:/workList/";
    public static final String ID = "id";
    public static final String WORK_LIST_ADD_EDIT = "workListAddEdit";
    public static final String WORK_LIST_DTO = "workListDto";
    public static final String MECHANIC_DTO_LIST = "mechanicDtoList";
    public static final String WORK_LIST = "workList";
    public static final String WORK_LIST_DTOS_LIST = "workListDtosList";
    public static final String SPARE_PART_DTO_LIST = "sparePartDtoList";

    /**
     *
     */
    private final WorkListService workListService;

    /**
     *
     */
    private final MechanicService mechanicService;

    /**
     *
     */
    private final SparePartService sparePartService;

    /**
     *
     * @param model
     * @return
     */
    @GetMapping("/")
    public String listWorkList(Model model) {
        model.addAttribute(WORK_LIST_DTOS_LIST, workListService.listAllWorkList());
        return WORK_LIST;
    }

    /**
     *
     * @param model
     * @param workListDto
     * @return
     */
    @GetMapping("/saveWorkList")
    public String showCreateFormNewWorkList(Model model,
                                            WorkListDto workListDto) {
        List<MechanicDto> mechanicDtoList = mechanicService.listAllMechanics();
        List<SparePartDto> sparePartDtoList = sparePartService.listAllSparePart();
        model.addAttribute(MECHANIC_DTO_LIST, mechanicDtoList);
        model.addAttribute(SPARE_PART_DTO_LIST, sparePartDtoList);
        model.addAttribute(WORK_LIST_DTO, workListDto);
        return WORK_LIST_ADD_EDIT;
    }

    /**
     *
     * @param workListDto
     * @param mechanicQuantity
     * @param sparePartQuantity
     * @return
     */
//    @RequestParam(sparePartQuantity)
    @PostMapping(value = "/saveWorkList")
    public String saveWorkList(@ModelAttribute(WORK_LIST_DTO) WorkListDto workListDto,
                               List<String> mechanicQuantity,
                               List<String> sparePartQuantity) {
        workListService.addWorkList(workListDto);
        return REDIRECT_WORK_LIST;
    }

    /**
     *
     * @param workListId
     * @param model
     * @return
     */
    @GetMapping("/editWorkList/{id}")
    public String showEditFormWorkList(@PathVariable(name = ID) Integer workListId,
                                       Model model) {
        model.addAttribute(WORK_LIST_DTO, workListService.findWorkListById(workListId));
        return WORK_LIST_ADD_EDIT;
    }

    /**
     *
     * @param workListId
     * @return
     */
    @GetMapping(value = "/deleteWorkList/{id}")
    public String deleteWorkList(@PathVariable(ID) Integer workListId) {
        workListService.deleteWorkListById(workListId);
        return REDIRECT_WORK_LIST;
    }

}


