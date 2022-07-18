package com.it.academy.maintenancestation.repository;


import com.it.academy.maintenancestation.entity.SparePart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * SparePartRepository
 *
 * @author Alexander Grigorovich
 * @version 12.07.2022
 */

@Repository
public interface SparePartRepository
        extends JpaRepository<SparePart, Integer> {

}
