package com.it.academy.maintenancestation.service;

import com.it.academy.maintenancestation.dto.SparePartDto;

import java.util.List;

/**
 * AdministratorService
 *
 * @author Alexander Grigorovich
 * @version 22.05.2022
 */
public interface SparePartService {
    List<SparePartDto> listAllSparePart();

}