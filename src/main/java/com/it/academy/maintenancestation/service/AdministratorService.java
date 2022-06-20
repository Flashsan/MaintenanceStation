package com.it.academy.maintenancestation.service;

import com.it.academy.maintenancestation.entity.Administrator;

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
    List<Administrator> showAllAdministrators();

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
     * @param name
     * @param lastName
     */
    void saveAdministrator(
            String name,
            String lastName);

    /**
     * service - update information about administrator
     *
     * @param administratorId
     * @param name
     * @param lastName
     */
    void updateAdministrator(Integer administratorId,
                                      String name,
                                      String lastName);

    /**
     * service - delete administrator by id
     *
     * @param administratorId
     */
    void deleteAdministratorById(Integer administratorId);
}
