package com.it.academy.maintenancestation.repository;

import com.it.academy.maintenancestation.entity.Administrator;
import com.it.academy.maintenancestation.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * AdministratorRepository
 *
 * @author Alexander Grigorovich
 * @version 12.07.2022
 */

@Repository
public interface AdministratorRepository
        extends JpaRepository<Administrator, Integer> {

    /**
     * list accepted orders by administrator
     * @param administratorId
     * @return
     */
    @Query("select e.orders from Administrator e where e.administratorId = ?1")
    List<Orders> getAdministratorsOrders(Integer administratorId);
}
