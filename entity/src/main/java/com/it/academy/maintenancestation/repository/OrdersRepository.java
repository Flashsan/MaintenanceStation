package com.it.academy.maintenancestation.repository;


import com.it.academy.maintenancestation.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * OrdersRepository
 *
 * @author Alexander Grigorovich
 * @version 12.07.2022
 */

@Repository
public interface OrdersRepository
        extends JpaRepository<Orders, Integer> {

}
