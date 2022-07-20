package com.it.academy.maintenancestation.controller;

import com.it.academy.maintenancestation.dto.AdministratorDto;
import com.it.academy.maintenancestation.dto.MechanicDto;
import com.it.academy.maintenancestation.dto.SparePartDto;
import com.it.academy.maintenancestation.dto.WorkListDto;
import com.it.academy.maintenancestation.service.AdministratorService;
import com.it.academy.maintenancestation.service.MechanicService;
import com.it.academy.maintenancestation.service.SparePartService;
import com.it.academy.maintenancestation.service.WorkListService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * SparePartController
 *
 * @author Alexander Grigorovich
 * @version 12.07.2022
 */

@Controller
@RequestMapping("/sparePart")
@RequiredArgsConstructor
public class SparePartController {

    /**
     * Constant(SparePartController)
     */
    public static final String SPARE_PART_DTO_LIST = "sparePartDtoList";
    public static final String SPARE_PART = "sparePart";
    public static final String SPARE_PART_DTO = "sparePartDto";
    public static final String SPARE_PART_ADD_EDIT = "sparePartAddEdit";
    public static final String REDIRECT_SPARE_PART = "redirect:/sparePart/";
    public static final String ID = "id";
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
    public String listSparePart(Model model) {
        model.addAttribute(SPARE_PART_DTO_LIST, sparePartService.listAllSparePart());
        return SPARE_PART;
    }

    /**
     *
     * @param model
     * @param sparePartDto
     * @return
     */
    @GetMapping("/saveSparePart")
    public String showCreateEditFormNewSparePart(Model model,
                                                 SparePartDto sparePartDto) {
        model.addAttribute(SPARE_PART_DTO, sparePartDto);
        return SPARE_PART_ADD_EDIT;
    }

    /**
     *
     * @param sparePartDto
     * @return
     */
    @PostMapping("/saveSparePart")
    public String saveSparePart(@ModelAttribute(SPARE_PART_DTO)
                                        SparePartDto sparePartDto) {
        sparePartService.addSparePart(sparePartDto);
        return REDIRECT_SPARE_PART;
    }

    /**
     *
     * @param sparePartId
     * @param model
     * @return
     */
    @GetMapping("/editSparePart/{id}")
    public String showEditFormSparePart(@PathVariable(name = ID) Integer sparePartId,
                                            Model model) {
        model.addAttribute(SPARE_PART_DTO, sparePartService.findSparePartById(sparePartId));
        return SPARE_PART_ADD_EDIT;
    }

    /**
     *
     * @param sparePartId
     * @return
     */
    @GetMapping("/deleteSparePart/{id}")
    public String deleteSparePart(@PathVariable(name = ID) Integer sparePartId) {
        sparePartService.deleteSparePartById(sparePartId);
        return REDIRECT_SPARE_PART;
    }
}


