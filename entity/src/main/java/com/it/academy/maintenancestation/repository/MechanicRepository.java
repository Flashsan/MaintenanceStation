package com.it.academy.maintenancestation.repository;


import com.it.academy.maintenancestation.entity.Mechanic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * MechanicRepository
 *
 * @author Alexander Grigorovich
 * @version 12.07.2022
 */

@Repository
public interface MechanicRepository
        extends JpaRepository<Mechanic, Integer> {

}
