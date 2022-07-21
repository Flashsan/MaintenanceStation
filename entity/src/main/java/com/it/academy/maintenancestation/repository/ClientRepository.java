package com.it.academy.maintenancestation.repository;

import com.it.academy.maintenancestation.entity.Car;
import com.it.academy.maintenancestation.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ClientRepository
 *
 * @author Alexander Grigorovich
 * @version 12.07.2022
 */

@Repository
public interface ClientRepository
        extends JpaRepository<Client, Integer> {
    /**
     * list cars clients
     *
     * @param clientId
     * @return
     */
    @Query("select e.car from Client e where e.clientId = ?1")
    List<Car> getMyCars(Integer clientId);
}
