package com.it.academy.maintenancestation.service;


import com.it.academy.maintenancestation.dto.AdministratorDto;
import com.it.academy.maintenancestation.entity.Administrator;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * AdministratorService
 *
 * @author Alexander Grigorovich
 * @version 22.05.2022
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
    Administrator findAdministratorById(Integer administratorId);

    /**
     * service - create administrator
     *
     * @param administrator
     */
    void newAdministrator(Administrator administrator);

    /**
     * service - delete administrator by id
     *
     * @param administratorId
     */
    void deleteAdministratorById(Integer administratorId);

}
