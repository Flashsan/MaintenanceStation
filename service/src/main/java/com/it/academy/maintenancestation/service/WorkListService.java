package com.it.academy.maintenancestation.service;

import com.it.academy.maintenancestation.dto.WorkListDto;
import com.it.academy.maintenancestation.entity.WorkList;

import java.util.List;

/**
 * AdministratorService
 *
 * @author Alexander Grigorovich
 * @version 22.05.2022
 */
public interface WorkListService {

    /**
     * service - show all workList
     *
     * @return all workList
     */
    List<WorkListDto> listAllWorkList();

//    WorkListDto addWorkList(WorkListDto workListDto);
//
//    WorkListDto updateWorkList(Integer idWorkList, WorkListDto workListDto);
//
//    String deleteWorkList(Integer idWorkList);

}
