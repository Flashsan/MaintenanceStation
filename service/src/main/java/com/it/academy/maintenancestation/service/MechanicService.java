package com.it.academy.maintenancestation.service;

import com.it.academy.maintenancestation.dto.MechanicDto;
import com.it.academy.maintenancestation.dto.OrdersDto;
import com.it.academy.maintenancestation.dto.WorkListDto;

import java.util.List;

/**
 * interface MechanicService
 *
 * @author Alexander Grigorovich
 * @version 12.07.2022
 */

public interface MechanicService {

    /**
     * service - show all mechanics
     *
     * @return all mechanics
     */
    List<MechanicDto> listAllMechanics();

    /**
     * service - find mechanic by id
     *
     * @param mechanicId
     * @return administrator by id
     */
    MechanicDto findMechanicById(Integer mechanicId);

    /**
     * service - create mechanic
     *
     * @param mechanicDto
     */
    void addMechanic(MechanicDto mechanicDto);

    /**
     * service - delete mechanic by id
     *
     * @param mechanicId
     */
    void deleteMechanicById(Integer mechanicId);

    /**
     * service - show pinned workList
     *
     * @return list workList which pinned to the mechanic.
     */
    List<WorkListDto> listPinnedWorkList(Integer byMechanicId);
}
