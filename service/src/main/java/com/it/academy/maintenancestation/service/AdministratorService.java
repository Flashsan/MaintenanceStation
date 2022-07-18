package com.it.academy.maintenancestation.service;

import com.it.academy.maintenancestation.dto.AdministratorDto;

import java.util.List;

/**
 * interface AdministratorService
 *
 * @author Alexander Grigorovich
 * @version 12.07.2022
 */

public interface AdministratorService {

    /**
     * service - show all administrators
     *
     * @return all administrators
     */
    List<AdministratorDto> listAllAdministrators();

    /**
     * service - find administrator by id
     *
     * @param administratorId
     * @return administrator by id
     */
    AdministratorDto findAdministratorById(Integer administratorId);

    /**
     * service - create administrator
     *
     * @param administratorDto
     */
    void addAdministrator(AdministratorDto administratorDto);

    /**
     * service - delete administrator by id
     *
     * @param administratorId
     */
    void deleteAdministratorById(Integer administratorId);
}
