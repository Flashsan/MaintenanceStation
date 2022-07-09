package com.it.academy.maintenancestation.service;

import com.it.academy.maintenancestation.dto.MechanicDto;
import com.it.academy.maintenancestation.entity.Mechanic;

import java.util.List;
import java.util.Optional;

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

    MechanicDto findById(Integer mechanicId);

//    MechanicDto addMechanic(MechanicDto mechanicDto);
//    public MechanicDto updateMechanic(Integer mechanicId, MechanicDto mechanicDto);

}
