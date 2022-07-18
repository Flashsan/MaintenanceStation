package com.it.academy.maintenancestation.repository;

import com.it.academy.maintenancestation.entity.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * AdministratorRepository
 *
 * @author Alexander Grigorovich
 * @version 12.07.2022
 */

@Repository
public interface AdministratorRepository
        extends JpaRepository<Administrator, Integer> {

//    @Query("select e.orders from Administrator e where e.administratorId = ?1")
//    List<Orders> getAdministratorsOrders(Integer administratorId);
}
