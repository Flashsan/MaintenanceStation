package com.it.academy.maintenancestation.repository;

import com.it.academy.maintenancestation.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * CarRepository
 *
 * @author Alexander Grigorovich
 * @version 12.07.2022
 */

@Repository
public interface CarRepository
        extends JpaRepository<Car, Integer> {

}
