package com.it.academy.maintenancestation.service;

import com.it.academy.maintenancestation.entity.Administrator;

import java.util.List;
import java.util.Optional;

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
    List<Administrator> listAllAdministrators();

    /**
     * service - find administrator by id
     *
     * @param administratorId
     * @return administrator by id
     */
    Optional<Administrator> findAdministratorById(Integer administratorId);

    /**
     * service - create administrator
     *
     * @param administrator
     */
    void saveAdministrator(Administrator administrator);

    /**
     * service - delete administrator by id
     *
     * @param administratorId
     */
    void deleteAdministratorById(Integer administratorId);
}
