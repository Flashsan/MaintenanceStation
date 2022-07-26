package com.it.academy.maintenancestation.controller;

import com.it.academy.maintenancestation.dto.*;
import com.it.academy.maintenancestation.entity.WorkList;
import com.it.academy.maintenancestation.service.MechanicService;
import com.it.academy.maintenancestation.service.OrdersService;
import com.it.academy.maintenancestation.service.SparePartService;
import com.it.academy.maintenancestation.service.WorkListService;
import com.it.academy.maintenancestation.service.impl.WorkListServiceImpl;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.it.academy.maintenancestation.controller.constant.AllControllerConstant.*;

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
     */
    private final OrdersService ordersService;

    /**
     * @param model
     * @return
     */
    @GetMapping("/")
    public String listWorkList(Model model) {
        return findPaginated(1, "workListName", ASC, model);
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = PAGE_NO) int pageNo,
                                @RequestParam(SORT_FIELD) String sortField,
                                @RequestParam(SORT_DIR) String sortDir,
                                Model model) {
        int pageSize = PAGE_SIZE;
        Page<WorkList> page = workListService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<WorkList> list = page.getContent();


        model.addAttribute(PAGE_TITLE, WORK_LIST);
        model.addAttribute(CURRENT_PAGE, pageNo);
        model.addAttribute(TOTAL_PAGES, page.getTotalPages());
        model.addAttribute(TOTAL_ITEMS, page.getTotalElements());

        model.addAttribute(SORT_FIELD, sortField);
        model.addAttribute(SORT_DIR, sortDir);
        model.addAttribute(REVERSE_SORT_DIR, sortDir.equals(ASC) ? DESC : ASC);
        model.addAttribute(WORK_LIST_DTOS_LIST, list);
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
        List<OrdersDto> ordersDtoList = ordersService.listAllOrders();

        model.addAttribute(MECHANIC_DTO_LIST, mechanicDtoList);
        model.addAttribute(SPARE_PART_DTO_LIST, sparePartDtoList);
        model.addAttribute(ORDERS_DTO_LIST, ordersDtoList);
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
                               @RequestParam(
                                       value = MECHANICS_LIST,
                                       required = false,
                                       defaultValue = "0") Integer[] mechanicsList,
                               @RequestParam(
                                       value = SPARE_PARTS_LIST,
                                       required = false,
                                       defaultValue = "0") Integer[] sparePartsList,
                               @RequestParam(ORDER_ID) Integer orderId) {

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

        OrdersDto ordersDto = ordersService.findOrderById(orderId);

        workListDto.setMechanic(mechanicsDtoList);
        workListDto.setSparePart(sparePartsDtoList);
        workListDto.setOrders(ordersDto);
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
        List<OrdersDto> ordersDtoList = ordersService.listAllOrders();

        model.addAttribute(MECHANIC_DTO_LIST, mechanicDtoList);
        model.addAttribute(SPARE_PART_DTO_LIST, sparePartDtoList);
        model.addAttribute(ORDERS_DTO_LIST, ordersDtoList);
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


