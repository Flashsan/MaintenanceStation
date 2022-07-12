package com.it.academy.maintenancestation.service;

import com.it.academy.maintenancestation.dto.MechanicDto;
import com.it.academy.maintenancestation.dto.WorkListDto;
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

    List<MechanicDto> listAllMechanics();

    MechanicDto findById(Integer mechanicId);

    void addMechanic(MechanicDto mechanicDto);

    void deleteMechanicById(Integer mechanicId);

}
