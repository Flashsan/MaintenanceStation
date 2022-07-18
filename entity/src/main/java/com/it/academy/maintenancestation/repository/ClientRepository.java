package com.it.academy.maintenancestation.repository;

import com.it.academy.maintenancestation.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ClientRepository
 *
 * @author Alexander Grigorovich
 * @version 12.07.2022
 */

@Repository
public interface ClientRepository
        extends JpaRepository<Client, Integer> {
}
