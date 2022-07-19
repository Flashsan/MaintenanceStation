package com.it.academy.maintenancestation.service;

import com.it.academy.maintenancestation.dto.SparePartDto;

import java.util.List;

/**
 * interface SparePartService
 *
 * @author Alexander Grigorovich
 * @version 12.07.2022
 */

public interface SparePartService {

    /**
     * service - show all sparePart
     *
     * @return all sparePart
     */
    List<SparePartDto> listAllSparePart();

    /**
     * service - find sparePart by id
     *
     * @param sparePareId
     * @return sparePart by id
     */
    SparePartDto findSparePartById(Integer sparePareId);

    /**
     * service - create sparePart
     *
     * @param sparePartDto
     */
    void addSparePart(SparePartDto sparePartDto);

    /**
     * service - delete sparePart by id
     *
     * @param sparePartId
     */
    void deleteSparePartById(Integer sparePartId);
}