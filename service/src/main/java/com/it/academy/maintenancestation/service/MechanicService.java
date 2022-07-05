package com.it.academy.maintenancestation.service;

import com.it.academy.maintenancestation.dto.MechanicDto;

import java.util.List;

/**
 * MechanicService
 *
 * @author Alexander Grigorovich
 * @version 22.05.2022
 */
public interface MechanicService {

    /**
     * service - show all mechanic
     *
     * @return all mechanic
     */
    List<MechanicDto> listAllMechanics();
//    MechanicDto addMechanic(MechanicDto mechanicDto);
//    public MechanicDto updateMechanic(Integer mechanicId, MechanicDto mechanicDto);

}
