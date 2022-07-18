package com.it.academy.maintenancestation.service;

import com.it.academy.maintenancestation.dto.SparePartDto;

import java.util.List;

/**
 * SparePartService
 *
 * @author Alexander Grigorovich
 * @version 12.07.2022
 */

public interface SparePartService {
    List<SparePartDto> listAllSparePart();

}