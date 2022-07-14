package com.it.academy.maintenancestation.service;

import com.it.academy.maintenancestation.dto.AdministratorDetailsDto;
import com.it.academy.maintenancestation.dto.AdministratorDto;

import java.util.List;

/**
 * AdministratorService
 *
 * @author Alexander Grigorovich
 * @version 22.05.2022
 */
public interface AdministratorDetailsService {

    /**
     * service - show all administratorsDetails
     *
     * @return all administratorsDetails
     */
    List<AdministratorDetailsDto> listAllAdministratorDetails();

    /**
     * service - find administrator by id
     *
     * @param administratorDetailsId
     * @return administratorDetails by id
     */
    AdministratorDetailsDto findAdministratorDetailsById(Integer administratorDetailsId);

    /**
     * service - create administrator
     *
     * @param administratorDetailsDto
     */
    void addAdministratorDetails(AdministratorDetailsDto administratorDetailsDto);

    /**
     * service - delete administratorDetails by id
     *
     * @param administratorDetailsId
     */
    void deleteAdministratorDetailsById(Integer administratorDetailsId);
}
