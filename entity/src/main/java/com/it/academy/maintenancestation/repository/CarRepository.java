package com.it.academy.maintenancestation.repository;

import com.it.academy.maintenancestation.entity.Car;
import com.it.academy.maintenancestation.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * CarRepository
 *
 * @author Alexander Grigorovich
 * @version 12.07.2022
 */

@Repository
public interface CarRepository
        extends JpaRepository<Car, Integer> {
    /**
     * list orders for car
     *
     * @param carId
     * @return
     */
    @Query("select e.orders from Car e where e.carId = ?1")
    List<Orders> getOrdersForCar(Integer carId);
}
