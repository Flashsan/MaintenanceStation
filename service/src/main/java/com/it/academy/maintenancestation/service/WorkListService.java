package com.it.academy.maintenancestation.service;

import com.it.academy.maintenancestation.dto.WorkListDto;

import java.util.List;

/**
 * interface WorkListService
 *
 * @author Alexander Grigorovich
 * @version 12.07.2022
 */

public interface WorkListService {

    /**
     * service - show all WorkList
     *
     * @return all administrators
     */

    List<WorkListDto> listAllWorkList();

    /**
     * service - find workList by id
     *
     * @param workListId
     * @return workList by id
     */
    WorkListDto findWorkListById(Integer workListId);

    /**
     * service - create workList
     *
     * @param workListDto
     */
    void addWorkList(WorkListDto workListDto);

    /**
     * service - delete workList by id
     *
     * @param workListId
     */
    void deleteWorkListById(Integer workListId);
}
