package com.it.academy.maintenancestation.controller;

import com.it.academy.maintenancestation.dto.MechanicDto;
import com.it.academy.maintenancestation.dto.SparePartDto;
import com.it.academy.maintenancestation.dto.WorkListDto;
import com.it.academy.maintenancestation.entity.WorkList;
import com.it.academy.maintenancestation.service.MechanicService;
import com.it.academy.maintenancestation.service.SparePartService;
import com.it.academy.maintenancestation.service.WorkListService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
    public static final String PAGE_NO = "pageNo";
    public static final String CURRENT_PAGE = "currentPage";
    public static final String TOTAL_PAGES = "totalPages";
    public static final String TOTAL_ITEMS = "totalItems";
    public static final String SORT_FIELD = "sortField";
    public static final String SORT_DIR = "sortDir";
    public static final String WORK_LIST_NAME = "workListName";
    public static final String ASC = "asc";

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

//    /**
//     * @param model
//     * @return
//     */
//    @GetMapping("/")
//    public String listWorkList(Model model) {
//        model.addAttribute(WORK_LIST_DTOS_LIST, workListService.listAllWorkList());
//        return WORK_LIST;
//    }

    /**
     * @param model
     * @return
     */
    @GetMapping("/")
    public String listWorkList(Model model) {
        return findPaginated(1, WORK_LIST_NAME, ASC, model);
    }

    /**
     * @param pageNo
     * @param model
     * @return
     */
    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = PAGE_NO) int pageNo,
                                @RequestParam(SORT_FIELD) String sortField,
                                @RequestParam(SORT_DIR) String sortDir,
                                Model model) {
        int pageSize = 5;

//        Page<WorkList> page = workListService.findPaginated();
//        List<WorkList> listWorkList = page.getContent();

        model.addAttribute(CURRENT_PAGE, pageNo);
//        model.addAttribute(TOTAL_PAGES, page.getTotalPages());
//        model.addAttribute(TOTAL_ITEMS, page.getTotalElements());
        model.addAttribute(SORT_FIELD, sortField);
        model.addAttribute(SORT_DIR, sortDir);
        model.addAttribute(WORK_LIST_DTOS_LIST, workListService.listAllWorkList(pageNo, pageSize, sortField, sortDir));
//
        return WORK_LIST;
    }

    /**
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
     * @param workListDto
     * @param mechanicsList
     * @param sparePartsList
     * @return
     */
    @PostMapping(value = "/saveWorkList")
    public String saveWorkList(@ModelAttribute(WORK_LIST_DTO) WorkListDto workListDto,
                               @RequestParam("mechanicsList") Integer[] mechanicsList,
                               @RequestParam("sparePartsList") Integer[] sparePartsList) {

        List<Integer> mechanics = new ArrayList<>();
        Collections.addAll(mechanics, mechanicsList);


        List<MechanicDto> mechanicsDtoList = mechanics.stream()
                .map(mechanicService::findMechanicById)
                .collect(Collectors.toList());


        List<Integer> spareParts = new ArrayList<>();
        Collections.addAll(spareParts, sparePartsList);

        List<SparePartDto> sparePartsDtoList = spareParts.stream()
                .map(sparePartService::findSparePartById)
                .collect(Collectors.toList());

        workListDto.setMechanic(mechanicsDtoList);
        workListDto.setSparePart(sparePartsDtoList);
        workListService.addWorkList(workListDto);
        return REDIRECT_WORK_LIST;
    }

    /**
     * @param workListId
     * @param model
     * @return
     */
    @GetMapping("/editWorkList/{id}")
    public String showEditFormWorkList(@PathVariable(name = ID) Integer workListId,
                                       Model model) {
        List<MechanicDto> mechanicDtoList = mechanicService.listAllMechanics();
        List<SparePartDto> sparePartDtoList = sparePartService.listAllSparePart();
        model.addAttribute(MECHANIC_DTO_LIST, mechanicDtoList);
        model.addAttribute(SPARE_PART_DTO_LIST, sparePartDtoList);
        model.addAttribute(WORK_LIST_DTO, workListService.findWorkListById(workListId));
        return WORK_LIST_ADD_EDIT;
    }

    /**
     * @param workListId
     * @return
     */
    @GetMapping(value = "/deleteWorkList/{id}")
    public String deleteWorkList(@PathVariable(ID) Integer workListId) {
        workListService.deleteWorkListById(workListId);
        return REDIRECT_WORK_LIST;
    }

}


